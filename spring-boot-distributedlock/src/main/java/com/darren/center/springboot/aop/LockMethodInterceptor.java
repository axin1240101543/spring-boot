package com.darren.center.springboot.aop;

import com.darren.center.springboot.annotation.CacheLock;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class LockMethodInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    private final CacheKeyGenerator cacheKeyGenerator;

    public LockMethodInterceptor(StringRedisTemplate stringRedisTemplate, CacheKeyGenerator cacheKeyGenerator) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.cacheKeyGenerator = cacheKeyGenerator;
    }

    @Around("execution(public * *(..)) && @annotation(com.darren.center.springboot.annotation.CacheLock)")
    public Object interceptor(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        CacheLock lockAnnotation = method.getAnnotation(CacheLock.class);
        if (StringUtils.isEmpty(lockAnnotation.prefix())){
            throw new RuntimeException("lock key can't be null ...");
        }
        final String lockKey = cacheKeyGenerator.getLockKey(point);
        try {
            final Boolean b = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "");
            if (b){
                stringRedisTemplate.expire(lockKey, lockAnnotation.expire(), lockAnnotation.timeUnit());
            }else {
                throw new RuntimeException("请勿重复请求");
            }
            try {
                return point.proceed();
            }catch (Throwable throwable) {
                throw new RuntimeException("系统异常");
            }
        } finally {
            stringRedisTemplate.delete(lockKey);
        }
    }
}
