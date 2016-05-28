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

 Date: 05/27/2016 21:01:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `water_pollution_data`
-- ----------------------------
DROP TABLE IF EXISTS `water_pollution_data`;
CREATE TABLE `water_pollution_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `cod` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `day` int(11) NOT NULL,
  `discharge` double DEFAULT NULL,
  `month` int(11) NOT NULL,
  `nh4n` double DEFAULT NULL,
  `p` double DEFAULT NULL,
  `year` int(11) NOT NULL,
  `water_pollution_source` bigint(20) DEFAULT NULL,
  `waterPollutionSource_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `water_pollution_data`
-- ----------------------------
BEGIN;
INSERT INTO `water_pollution_data` VALUES ('1', null, null, null, null, '3', null, '3', null, null, '4', null, null), ('2', null, null, '0', null, '6', '0', '3', '0', '0', '4', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
