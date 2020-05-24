create database if not exists self_service_ordering;

use self_service_ordering;
/*
 Navicat Premium Data Transfer

 Source Server         : local Mysql57
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : self_service_ordering

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 25/05/2020 07:35:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`
(
    `id`   int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '活动'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity`
VALUES (1, '晚上消费送妹子');
INSERT INTO `activity`
VALUES (3, '测试活动2');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`        int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `cate_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '种类名称',
    `img`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '菜的种类'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category`
VALUES (1, '肉类', NULL);
INSERT INTO `category`
VALUES (2, '蔬菜', NULL);
INSERT INTO `category`
VALUES (3, '饮品', NULL);
INSERT INTO `category`
VALUES (4, '海鲜测试', '1');
INSERT INTO `category`
VALUES (6, '测试', NULL);

-- ----------------------------
-- Table structure for desk
-- ----------------------------
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk`
(
    `id`      int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `desk_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '编号',
    `status`  int(11)                                                       NOT NULL DEFAULT 0 COMMENT '状态，0、未占用 1、已占用',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '餐桌'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of desk
-- ----------------------------
INSERT INTO `desk`
VALUES (1, '大厅10人桌', 1);
INSERT INTO `desk`
VALUES (2, '包间8人桌', 1);
INSERT INTO `desk`
VALUES (3, '包间5人桌', 1);
INSERT INTO `desk`
VALUES (4, '包间情侣位', 0);
INSERT INTO `desk`
VALUES (5, '测试餐桌123', 0);

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`
(
    `id`       int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `cate_id`  int(11)                                                       NOT NULL COMMENT '种类id',
    `size`     int(11)                                                       NOT NULL COMMENT '分量',
    `price`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单价',
    `quantity` int(11)                                                       NOT NULL DEFAULT 0 COMMENT '数量',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '菜的数量'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish`
VALUES (1, 1, 1, '20', 10);
INSERT INTO `dish`
VALUES (2, 1, 2, '30', 10);
INSERT INTO `dish`
VALUES (3, 1, 3, '50', 10);
INSERT INTO `dish`
VALUES (4, 2, 1, '9', 10);
INSERT INTO `dish`
VALUES (5, 2, 2, '11', 10);
INSERT INTO `dish`
VALUES (6, 2, 3, '15', 10);
INSERT INTO `dish`
VALUES (7, 3, 1, '2', 10);
INSERT INTO `dish`
VALUES (8, 3, 2, '5', 10);
INSERT INTO `dish`
VALUES (9, 3, 3, '8', 10);
INSERT INTO `dish`
VALUES (10, 4, 1, '100', 2);
INSERT INTO `dish`
VALUES (11, 4, 2, '200', 10);
INSERT INTO `dish`
VALUES (12, 4, 3, '300', 20);
INSERT INTO `dish`
VALUES (16, 6, 1, '8', 100);
INSERT INTO `dish`
VALUES (17, 6, 2, '9', 10);
INSERT INTO `dish`
VALUES (18, 6, 3, '100', 200);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`          int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `user_id`     int(11)                                                       NULL     DEFAULT NULL COMMENT '用户id',
    `desk_id`     int(11)                                                       NULL     DEFAULT NULL COMMENT '餐桌id',
    `address`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '外送地点',
    `cate_id`     int(11)                                                       NULL     DEFAULT NULL COMMENT '菜品分类id',
    `size`        int(11)                                                       NULL     DEFAULT NULL COMMENT '分量',
    `num`         int(11)                                                       NULL     DEFAULT NULL COMMENT '数量',
    `price`       int(11)                                                       NULL     DEFAULT NULL COMMENT '单价',
    `amount`      int(11)                                                       NULL     DEFAULT NULL COMMENT '总价',
    `pay_type`    int(11)                                                       NULL     DEFAULT NULL COMMENT '支付方式',
    `status`      int(11)                                                       NULL     DEFAULT NULL COMMENT '支付状态 0、未支付 1、已支付',
    `create_time` datetime(0)                                                   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '订单'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order`
VALUES (1, 5, 1, '', 1, 3, 50, 50, 2500, NULL, NULL, '2020-05-25 00:02:08');
INSERT INTO `order`
VALUES (3, 6, 3, '', 2, 3, 20, 15, 300, 3, 1, '2020-05-25 00:04:45');

-- ----------------------------
-- Table structure for score_rule
-- ----------------------------
DROP TABLE IF EXISTS `score_rule`;
CREATE TABLE `score_rule`
(
    `id`        int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `rule_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '积分规则',
    `use_score` int(11)                                                       NULL DEFAULT NULL COMMENT '消耗积分',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '积分规则'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_rule
-- ----------------------------
INSERT INTO `score_rule`
VALUES (1, '100积分换一瓶饮料', 100);
INSERT INTO `score_rule`
VALUES (2, '600积分换个小炒肉', 600);
INSERT INTO `score_rule`
VALUES (3, '1000积分妹子微信', 1000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '用户名',
    `phone`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '电话',
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '密码',
    `score`    int(11)                                                       NOT NULL DEFAULT 0 COMMENT '积分',
    `role_id`  int(11)                                                       NOT NULL COMMENT '角色，1、用户 2、商家',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'admin', '13314441555', '123', 1000000, 1);
INSERT INTO `user`
VALUES (2, 'user', '14415551666', '123', 99999058, 2);
INSERT INTO `user`
VALUES (5, 'user1', '13314441555', '123', 100000058, 2);
INSERT INTO `user`
VALUES (6, 'user2', '13314415555', '123', 100000058, 2);

SET FOREIGN_KEY_CHECKS = 1;





