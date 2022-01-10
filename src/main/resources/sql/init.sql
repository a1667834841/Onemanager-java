-- 用户表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `name` varchar(255) DEFAULT NULL COMMENT '用户名',
                          `mic_code` varchar(255) DEFAULT NULL COMMENT 'Microsoft凭证',
                          `github_code` varchar(255) DEFAULT NULL COMMENT 'github凭证',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`)
) ;
