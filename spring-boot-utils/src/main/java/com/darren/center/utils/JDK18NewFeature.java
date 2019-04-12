package com.darren.center.utils;

import java.util.*;

/**
 * JDK1.8特性
 */
public class JDK18NewFeature {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 2, 3);

        /**
         * 流 - 过滤器
         */
        long num = list.stream().filter(a -> a > 4).count();
        System.out.println(num);

        /**
         * 截取list中的元素
         */
        list.subList(1, 5).forEach(a -> System.out.print(a + " "));//截取 2、3、4、5元素

        System.out.println();

        /**
         * 遍历list
         */
        list.forEach(a -> System.out.print(a + " "));

        System.out.println();

        //遍历map
        Map<String, String> map = new HashMap<>(10);
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");
        map.put("f", "6");
        map.put("g", "7");
        map.forEach((k,v) ->{
            System.out.print(k + ":" + v + " ");
        });

        System.out.println();

        //排序
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "8", "2", "3");
        Collections.sort(list1, (String a, String b) -> {
            return a.compareTo(b);
        });
        list1.forEach(a -> System.out.print(a + " "));

        System.out.println();

        Collections.sort(list1, (b, a) -> a.compareTo(b));
        list1.forEach(a -> System.out.print(a + " "));
    }


}
