/*
 Navicat Premium Data Transfer

 Source Server         : IOC
 Source Server Type    : MySQL
 Source Server Version : 50539
 Source Host           : 10.60.36.95
 Source Database       : luna

 Target Server Type    : MySQL
 Target Server Version : 50539
 File Encoding         : utf-8

 Date: 07/07/2016 20:54:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `water_condition_data`
-- ----------------------------
DROP TABLE IF EXISTS `water_condition_data`;
CREATE TABLE `water_condition_data` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `day` int(11) NOT NULL,
  `hour` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `waterLevelDown` double DEFAULT NULL,
  `waterLevelUp` double DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `water_monitor` bigint(20) DEFAULT NULL,
  `waterMonitor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
