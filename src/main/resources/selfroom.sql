/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : selfroom

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 28/03/2024 10:15:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '管理员' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for deposit_log
-- ----------------------------
DROP TABLE IF EXISTS `deposit_log`;
CREATE TABLE `deposit_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `deposit_no` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '充值编号',
  `amount` double(10, 2) NULL DEFAULT NULL COMMENT '充值金额',
  `user_id` int NULL DEFAULT NULL COMMENT '充值用户',
  `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '充值记录' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of deposit_log
-- ----------------------------
INSERT INTO `deposit_log` VALUES (1, '20231112154128735077', 20.00, 5, '2023-11-12 15:41:28');
INSERT INTO `deposit_log` VALUES (2, '20240302152928336087', 1.00, 5, '2024-03-02 15:29:28');
INSERT INTO `deposit_log` VALUES (3, '20240302153717227202', 5.00, 7, '2024-03-02 15:37:17');
INSERT INTO `deposit_log` VALUES (4, '20240302154102949272', 6.00, 5, '2024-03-02 15:41:02');
INSERT INTO `deposit_log` VALUES (5, '20240302154406156058', 20.00, 5, '2024-03-02 15:44:06');
INSERT INTO `deposit_log` VALUES (6, '20240302154957822818', 20.00, 7, '2024-03-02 15:49:57');
INSERT INTO `deposit_log` VALUES (7, '20240302160335313269', 50.00, 6, '2024-03-02 16:03:35');
INSERT INTO `deposit_log` VALUES (8, '20240313194614222136', 50.00, 7, '2024-03-13 19:46:14');
INSERT INTO `deposit_log` VALUES (9, '20240325175417868156', 100.00, 7, '2024-03-25 17:54:17');

-- ----------------------------
-- Table structure for desk_info
-- ----------------------------
DROP TABLE IF EXISTS `desk_info`;
CREATE TABLE `desk_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `desk_no` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '桌号',
  `desk_status` int NULL DEFAULT NULL COMMENT '当前状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '桌子' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of desk_info
-- ----------------------------
INSERT INTO `desk_info` VALUES (1, '1号', 1);
INSERT INTO `desk_info` VALUES (2, '2号', 1);
INSERT INTO `desk_info` VALUES (3, '3号', 1);
INSERT INTO `desk_info` VALUES (7, '4号', 1);
INSERT INTO `desk_info` VALUES (11, '5号', 1);
INSERT INTO `desk_info` VALUES (12, '6号', 1);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_no` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单编号',
  `desk_id` int NULL DEFAULT NULL COMMENT '预约桌号',
  `seat_id` int NULL DEFAULT NULL COMMENT '座位id',
  `order_date` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '预约日期',
  `start_time` int NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` int NULL DEFAULT NULL COMMENT '结束时间',
  `total_hours` int NULL DEFAULT NULL COMMENT '总时长（小时）',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `total_amount` double(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  `user_id` int NULL DEFAULT NULL COMMENT '预订用户',
  `order_status` int NULL DEFAULT NULL COMMENT '预约状态',
  `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '预订时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '订单' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (63, '20240325175147344310', 1, 31, '2024-03-25', 8, 18, 10, 1.00, 10.00, 7, 2, '2024-03-25 17:51:47');
INSERT INTO `order_info` VALUES (64, '20240325175208183582', 2, 34, '2024-03-25', 8, 17, 9, 1.00, 9.00, 7, 2, '2024-03-25 17:52:08');
INSERT INTO `order_info` VALUES (65, '20240325175426446668', 1, 32, '2024-03-25', 8, 15, 7, 1.00, 7.00, 7, 2, '2024-03-25 17:54:26');
INSERT INTO `order_info` VALUES (66, '20240325175557929905', 1, 31, '2024-03-25', 8, 18, 10, 1.00, 10.00, 7, 4, '2024-03-25 17:55:57');
INSERT INTO `order_info` VALUES (67, '20240325175613961817', 1, 32, '2024-03-25', 19, 20, 1, 1.00, 1.00, 7, 1, '2024-03-25 17:56:13');
INSERT INTO `order_info` VALUES (68, '20240325175633100513', 1, 33, '2024-03-25', 8, 17, 9, 1.00, 9.00, 7, 1, '2024-03-25 17:56:33');
INSERT INTO `order_info` VALUES (69, '20240325180144520715', 1, 31, '2024-03-25', 18, 19, 1, 1.00, 1.00, 7, 3, '2024-03-25 18:01:44');

-- ----------------------------
-- Table structure for seat_info
-- ----------------------------
DROP TABLE IF EXISTS `seat_info`;
CREATE TABLE `seat_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `desk_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '房间号',
  `seat_no` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '座位号',
  `desk_status` int NULL DEFAULT NULL COMMENT '当前状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '座位' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of seat_info
-- ----------------------------
INSERT INTO `seat_info` VALUES (31, '1号', '101', 1);
INSERT INTO `seat_info` VALUES (32, '1号', '102', 2);
INSERT INTO `seat_info` VALUES (33, '1号', '103', 2);
INSERT INTO `seat_info` VALUES (34, '2号', '201', 1);
INSERT INTO `seat_info` VALUES (35, '2号', '202', 1);
INSERT INTO `seat_info` VALUES (36, '2号', '203', 1);
INSERT INTO `seat_info` VALUES (37, '3号', '301', 1);
INSERT INTO `seat_info` VALUES (38, '3号', '302', 1);
INSERT INTO `seat_info` VALUES (39, '3号', '303', 1);
INSERT INTO `seat_info` VALUES (40, '4号', '401', 1);
INSERT INTO `seat_info` VALUES (41, '4号', '402', 1);
INSERT INTO `seat_info` VALUES (42, '4号', '403', 1);
INSERT INTO `seat_info` VALUES (43, '5号', '501', 1);
INSERT INTO `seat_info` VALUES (44, '5号', '502', 1);
INSERT INTO `seat_info` VALUES (45, '5号', '503', 1);
INSERT INTO `seat_info` VALUES (46, '6号', '601', 1);
INSERT INTO `seat_info` VALUES (47, '6号', '602', 1);
INSERT INTO `seat_info` VALUES (48, '6号', '603', 1);

-- ----------------------------
-- Table structure for sys_setting_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting_info`;
CREATE TABLE `sys_setting_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `start_time` int NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` int NULL DEFAULT NULL COMMENT '结束时间',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `shop_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '店铺名',
  `shop_intro` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '简介',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '系统设置' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_setting_info
-- ----------------------------
INSERT INTO `sys_setting_info` VALUES (1, 8, 20, 1.00, '刘强的自习室', '欢迎大家来学习', '保定学院');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `cel_phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '联系电话',
  `user_account` double(10, 2) NULL DEFAULT NULL COMMENT '账号余额',
  `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '用户' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (5, 'LQ', 'LQ', '刘强', '17336323074', 133.00, '2023-11-03 14:45:33');
INSERT INTO `user_info` VALUES (6, 'liuqiang', 'liuqiang', '刘强', '17336323074', 51.00, '2024-02-04 21:37:32');
INSERT INTO `user_info` VALUES (7, 'liuqiang01', 'liuqiang01', '刘qiang', '17336323071', 108.00, '2024-03-02 15:34:27');

SET FOREIGN_KEY_CHECKS = 1;
