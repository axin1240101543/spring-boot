DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(20) DEFAULT NULL COMMENT '号码',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`ext_fields` VARCHAR(1000) COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';

ALTER TABLE user AUTO_INCREMENT = 0;
TRUNCATE TABLE user;

INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('张三', '男', 22, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('王莹', '女', 30, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('李斯', '男', 25, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('宇凡', '男', 21, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('张毅', '男', 25, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('张丽', '女', 21, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('王芳', '女', 28, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('王路', '男', 18, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('高山', '男', 22, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('高亮', '男', 30, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('李伟', '男', 25, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('李鹏', '男', 21, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('戴维', '男', 25, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('戴分', '女', 21, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('蔡芬', '女', 28, '01234567891');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('刘峰', '男', 18, '01234567891');