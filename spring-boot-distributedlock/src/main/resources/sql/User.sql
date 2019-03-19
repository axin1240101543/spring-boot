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

INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('张三', '男', 22, '17377879205');
INSERT INTO darren_service_center.user(name, sex, age, mobile) VALUES ('王莹', '女', 21, '18670328239');