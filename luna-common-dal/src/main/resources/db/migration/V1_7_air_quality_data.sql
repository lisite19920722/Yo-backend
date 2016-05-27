/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : puck

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 05/27/2016 21:01:41 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `air_quality_data`
-- ----------------------------
DROP TABLE IF EXISTS `air_quality_data`;
CREATE TABLE `air_quality_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `airQualityLevel` int(11) DEFAULT NULL,
  `aqi` int(11) DEFAULT NULL,
  `co` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `day` int(11) NOT NULL,
  `firstElement` varchar(255) DEFAULT NULL,
  `hour` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `no2` int(11) DEFAULT NULL,
  `o3` int(11) DEFAULT NULL,
  `pm10` int(11) DEFAULT NULL,
  `pm25` int(11) DEFAULT NULL,
  `so2` int(11) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `air_monitor` bigint(20) DEFAULT NULL,
  `airMonitor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `air_quality_data`
-- ----------------------------
BEGIN;
INSERT INTO `air_quality_data` VALUES ('1', null, null, null, null, null, null, '3', null, '5', '3', null, null, null, null, null, '4', null, null), ('2', null, null, '0', '0', '0', null, '3', null, '10', '3', '0', '0', '0', '0', '0', '4', '0', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
