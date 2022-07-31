/*
 Navicat Premium Data Transfer

 Source Server         : cstate
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 31/07/2022 23:33:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int NOT NULL COMMENT '分类表id',
  `parent_id` int DEFAULT NULL COMMENT '父级id',
  `name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(0) NOT NULL COMMENT '下单id(时间戳+流水号)',
  `order_num` int DEFAULT NULL COMMENT '下单数量',
  `target_address` varchar(255) DEFAULT NULL COMMENT '目的地',
  `create_time` datetime DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime DEFAULT NULL COMMENT '发货时间',
  `order_status` enum('0','1','2') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '订单状态(0:未发货，1:已发货，2:订单完成)',
  `order_price` decimal(5,2) DEFAULT NULL COMMENT '订单价格',
  `order_totalPrice` decimal(5,2) DEFAULT NULL COMMENT '订单总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for return_order
-- ----------------------------
DROP TABLE IF EXISTS `return_order`;
CREATE TABLE `return_order` (
  `id` int NOT NULL COMMENT '下单id(时间戳+流水号)',
  `original_id` int DEFAULT NULL COMMENT '原订单号',
  `order_num` int DEFAULT NULL COMMENT '退货数量',
  `target_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '回寄目的地',
  `create_time` datetime DEFAULT NULL COMMENT '生成时间',
  `update_time` datetime DEFAULT NULL COMMENT '发货时间',
  `order_status` enum('0','1','2') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '订单状态(0:未发货，1:已发货，2:订单完成)',
  `order_price` decimal(5,2) DEFAULT NULL COMMENT '订单价格',
  `order_totalPrice` decimal(5,2) DEFAULT NULL COMMENT '订单总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sale_order
-- ----------------------------
DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sale_id` int DEFAULT NULL COMMENT '销售id(时间戳+流水号)',
  `order_num` int DEFAULT NULL COMMENT '下单数量',
  `target_address` varchar(255) DEFAULT NULL COMMENT '目的地',
  `create_time` datetime DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime DEFAULT NULL COMMENT '发货时间',
  `order_status` enum('0','1','2') DEFAULT NULL COMMENT '订单状态(0:下单成功未发货，1:已发货，2:订单完成)',
  `order_price` decimal(5,2) DEFAULT NULL COMMENT '订单价格',
  `order_totalPrice` decimal(5,2) DEFAULT NULL COMMENT '订单总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int NOT NULL,
  `name` varchar(150) DEFAULT NULL COMMENT '仓库名称',
  `store_address` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `max_num` int DEFAULT NULL COMMENT '最大容量',
  `user_id` int DEFAULT NULL COMMENT '仓库负责人',
  `status` char(1) DEFAULT NULL COMMENT '仓库状态',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int NOT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `pid` int DEFAULT NULL COMMENT '父级id',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resourceName` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `requestMethod` varchar(255) DEFAULT NULL,
  `parentId` int DEFAULT NULL,
  `isAnonymous` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '管理员');
INSERT INTO `sys_role` VALUES (2, '普通用户');
INSERT INTO `sys_role` VALUES (3, '超级用户');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int DEFAULT NULL COMMENT '角色id',
  `menu_id` int DEFAULT NULL COMMENT '菜单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL COMMENT '权限id',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `password` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `sex` enum('1','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别{男:0 , 女:1}',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `flag_status` char(0) DEFAULT NULL COMMENT '逻辑删除',
  `ip_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'ip来源',
  `ip_address` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 1, '李超超', '18692442325', '8a5789ea8f62f978', NULL, NULL, '2022-07-31 21:56:01', '2022-07-31 21:56:01', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 2, '李四', '13016122390', '8a5789ea8f62f978', NULL, NULL, '2022-07-31 21:56:02', '2022-07-31 21:56:02', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 3, 'vipAdmin', '111111', '8a5789ea8f62f978', NULL, NULL, '2022-07-31 21:56:05', '2022-07-31 21:56:05', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  ` id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (` id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
