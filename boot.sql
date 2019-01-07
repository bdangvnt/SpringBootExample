/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 100308
 Source Host           : localhost:3306
 Source Schema         : boot

 Target Server Type    : MariaDB
 Target Server Version : 100308
 File Encoding         : 65001

 Date: 08/01/2019 00:25:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Employee
-- ----------------------------
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
  `emid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  PRIMARY KEY (`emid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Employee
-- ----------------------------
BEGIN;
INSERT INTO `Employee` VALUES (1, 'Phan Bá Hải', 'Long An', '0974839283', 7000000.00);
INSERT INTO `Employee` VALUES (2, 'Phan Phú Kiệt', 'Bình Dương', '0938493849', 6500000.00);
INSERT INTO `Employee` VALUES (3, 'Trần Thanh Khang', 'Bến Tre', '0938293829', 6000000.00);
INSERT INTO `Employee` VALUES (4, 'Trần Hữu Sỹ', 'TP.HCM', '0945849586', 6500000.00);
INSERT INTO `Employee` VALUES (5, 'Nguyễn Thị Huỳnh Như', 'Quảng Bình', '0918928392', 5000000.00);
INSERT INTO `Employee` VALUES (6, 'Phan Bá Hải', 'Long An', '0974839283', 7000000.00);
INSERT INTO `Employee` VALUES (7, 'Trần Bá Đặng', 'Hưng Yên', '0987863366', 6500000.00);
INSERT INTO `Employee` VALUES (8, 'Trần Thanh Khang', 'Bến Tre', '0938293829', 6000000.00);
INSERT INTO `Employee` VALUES (9, 'Trần Hữu Sỹ', 'TP.HCM', '0945849586', 6500000.00);
INSERT INTO `Employee` VALUES (10, 'Nguyễn Thị Huỳnh Như', 'Quảng Bình', '0918928392', 5000000.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
