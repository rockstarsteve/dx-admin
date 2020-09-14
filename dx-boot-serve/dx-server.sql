/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : dx-server

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 14/09/2020 10:56:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'user', '$2a$10$JYtKHS090yIqfEcNczeJyO10/L6x5I0qAXUc8lXr5cvWlqhGssZuG');
INSERT INTO `t_sys_user` VALUES ('2', 'jack', '$2a$10$JYtKHS090yIqfEcNczeJyO10/L6x5I0qAXUc8lXr5cvWlqhGssZuG');

SET FOREIGN_KEY_CHECKS = 1;
