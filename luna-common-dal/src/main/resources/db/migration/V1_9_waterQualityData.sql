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

 Date: 05/27/2016 21:01:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `water_quality_data`
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_data`;
CREATE TABLE `water_quality_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `day` int(11) NOT NULL,
  `hour` int(11) NOT NULL,
  `kmno4` double DEFAULT NULL,
  `month` int(11) NOT NULL,
  `nh4n` double DEFAULT NULL,
  `o2` double DEFAULT NULL,
  `p` double DEFAULT NULL,
  `tn` double DEFAULT NULL,
  `year` int(11) NOT NULL,
  `water_monitor` bigint(20) DEFAULT NULL,
  `waterMonitor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `water_quality_data`
-- ----------------------------
BEGIN;
INSERT INTO `water_quality_data` VALUES ('1', null, null, null, '1', '1', null, '1', null, null, null, null, '1', null, null), ('2', null, null, null, '1', '2', '0', '1', '0', '0', '0', '0', '1', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
