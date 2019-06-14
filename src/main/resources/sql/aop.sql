/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : aop

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 14/06/2019 10:42:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for operatelog
-- ----------------------------
DROP TABLE IF EXISTS `operatelog`;
CREATE TABLE `operatelog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块标题',
  `method` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `oper_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `oper_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 主机Ip',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  `status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作结果',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误信息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `os` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
  `oper_action` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operatelog
-- ----------------------------
INSERT INTO `operatelog` VALUES (1, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:36:47', 'Windows 10', 'Chrome', 'LIST');
INSERT INTO `operatelog` VALUES (2, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:37:17', 'Windows 10', 'Chrome', 'LIST');
INSERT INTO `operatelog` VALUES (3, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:37:38', 'Windows 10', 'Chrome', 'LIST');
INSERT INTO `operatelog` VALUES (4, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:37:49', 'Windows 10', 'Chrome', 'LIST');
INSERT INTO `operatelog` VALUES (5, '添加用户', 'com.lick.controller.UserController.add()', 'admin', '/user/add', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:37:52', 'Windows 10', 'Chrome', 'INSERT');
INSERT INTO `operatelog` VALUES (6, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:37:52', 'Windows 10', 'Chrome', 'LIST');
INSERT INTO `operatelog` VALUES (7, '查询用户列表', 'com.lick.controller.UserController.listUser()', 'admin', '/user/list', '192.168.1.113', NULL, 'SUCCESS', NULL, '2019-06-14 10:38:11', 'Windows 10', 'Chrome', 'LIST');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名 ',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `createdTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatedTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin123', '139999999', '9999999@qq.com', '男', '2019-06-14 10:35:37', '2019-06-14 10:35:40');
INSERT INTO `user` VALUES (2, 'admin', 'admin123', '1399999999', '99999999@qq.com', NULL, '2019-06-14 10:37:52', '2019-06-14 10:37:52');

SET FOREIGN_KEY_CHECKS = 1;
