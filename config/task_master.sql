/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50741
 Source Schema         : task_master_prod

 Target Server Type    : MySQL
 Target Server Version : 50741
 File Encoding         : 65001

 Date: 27/03/2023 01:34:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exchanges
-- ----------------------------
DROP TABLE IF EXISTS `exchanges`;
CREATE TABLE `exchanges` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bank_id` tinyint(4) NOT NULL,
  `currency_type` tinyint(4) NOT NULL,
  `reference` decimal(10,2) DEFAULT NULL,
  `foreign_buy` decimal(10,2) DEFAULT NULL,
  `foreign_sell` decimal(10,2) DEFAULT NULL,
  `cash_buy` decimal(10,2) DEFAULT NULL,
  `cash_sell` decimal(10,2) DEFAULT NULL,
  `publish_time` datetime NOT NULL,
  `creat_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8233 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tm_role
-- ----------------------------
DROP TABLE IF EXISTS `tm_role`;
CREATE TABLE `tm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tm_user
-- ----------------------------
DROP TABLE IF EXISTS `tm_user`;
CREATE TABLE `tm_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_email` (`email`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tm_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tm_user_role`;
CREATE TABLE `tm_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
