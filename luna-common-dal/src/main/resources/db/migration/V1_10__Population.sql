SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for birthrate_data
-- ----------------------------
DROP TABLE IF EXISTS `birthrate_data`;
CREATE TABLE `birthrate_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` varchar(128) NOT NULL,
  `town` varchar(100) NOT NULL,
  `town_id` bigint(20) NOT NULL,
  `bornPopulation` double NOT NULL,
  `deadPopulation` double NOT NULL,
  `population` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `birthrate_data_ibfk_1` FOREIGN KEY (`town_id`) REFERENCES `dict_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of birthrate_data
-- ----------------------------
INSERT INTO `birthrate_data` VALUES ('1', '2016-03-04 10:24:09', '2016-03-04 10:24:11', '2016', '太仓城区', '1', '8.34', '8.12', '0.22');
INSERT INTO `birthrate_data` VALUES ('3', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '港区', '2', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('4', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '新区', '3', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('5', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '城厢镇', '4', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('6', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '沙溪镇', '5', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('7', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '浏河镇', '6', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('8', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '璜泾镇', '7', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('9', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '双凤镇', '8', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('10', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '浮桥镇', '9', '0', '0', '0');
INSERT INTO `birthrate_data` VALUES ('11', '2016-03-04 10:24:09', '2016-03-04 10:24:09', '2016', '科教新城', '10', '0', '0', '0');


-- ----------------------------
-- Table structure for birthrate_pre_data
-- ----------------------------
DROP TABLE IF EXISTS `birthrate_pre_data`;
CREATE TABLE `birthrate_pre_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `preyear` varchar(128) NOT NULL,
  `town` varchar(100) NOT NULL,
  `town_id` bigint(20) NOT NULL,
  `preBornPopulation` bigint(20) NOT NULL,
  `preDeadPopulation` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `birthrate_pre_data_ibfk_1` FOREIGN KEY (`town_id`) REFERENCES `dict_data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of birthrate_pre_data
-- ----------------------------



-- ----------------------------
-- Table structure for labor_gdp_relation_data
-- ----------------------------
DROP TABLE IF EXISTS `labor_gdp_relation_data`;
CREATE TABLE `labor_gdp_relation_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` int(11) NOT NULL,
  `laborPopulation` int(11) NOT NULL,
  `Gdp` double NOT NULL,
  `firstLaborPopulation` int(20) NOT NULL,
  `secondLaborPopulation` int(20) NOT NULL,
  `thirdLaborPopoulation` int(20) NOT NULL,
  `firstGdp` double NOT NULL,
  `secondGdp` double NOT NULL,
  `thirdGdp` double NOT NULL,
  `aveGdp` double NOT NULL,
  `localGdp` double NOT NULL,
  `retailSale` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of labor_gdp_relation_data
-- ----------------------------


-- ----------------------------
-- Table structure for labor_gdp_relation_pre_data
-- ----------------------------
DROP TABLE IF EXISTS `labor_gdp_relation_pre_data`;
CREATE TABLE `labor_gdp_relation_pre_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `preyear` int(11) NOT NULL,
  `preLaborPopulation` int(11) NOT NULL,
  `preGdp` double NOT NULL,
  `preFirstLaborPopulation` int(20) NOT NULL,
  `preSecondLaborPopulation` int(20) NOT NULL,
  `preThirdLaborPopulation` int(20) NOT NULL,
  `preFirstGdp` double NOT NULL,
  `preSecondGdp` double NOT NULL,
  `preThirdGdp` double NOT NULL,
  `preAveGdp` double NOT NULL,
  `preLocalGdp` double NOT NULL,
  `preRetailSale` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of labor_gdp_relation_pre_data
-- ----------------------------
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('1', '2016-03-09 09:58:15', '2016-03-02 10:28:21', '2016', '507046', '1165', '89342', '213112', '204592', '134.32', '494.2', '601.48', '9', '10', '11');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('2', '2016-03-07 23:51:14', '2016-03-02 21:37:46', '2017', '500908', '1243', '85243', '242344', '173321', '132.43', '503.2', '607.36', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('3', '2016-03-07 23:51:21', '2016-03-02 21:37:46', '2018', '504570', '1367.3', '84235', '223423', '196912', '143.43', '523.4', '700.46', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('4', '2016-03-07 23:51:23', '2016-03-02 21:37:46', '2019', '497963', '1504.03', '85423', '234534', '178006', '142.23', '589.6', '772.19', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('5', '2016-03-29 22:52:50', '2016-03-02 21:37:46', '2020', '501066', '1709.9', '18038', '284104', '198924', '83.6', '851.3', '775', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('6', '2016-03-13 21:40:32', '2016-03-02 21:37:46', '2021', '523863', '1819.9', '124234', '184234', '215395', '143.8', '680.6', '995.5', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('7', '2016-03-07 23:53:09', '2016-03-02 21:37:46', '2022', '536970', '1935.5', '92442', '242344', '202184', '192.2', '700.8', '1042.5', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('8', '2016-03-09 09:40:07', '2016-03-02 21:37:46', '2023', '529950', '2092.73', '90312', '254423', '185215', '245.5', '754.1', '1093.13', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('9', '2016-03-09 09:40:27', '2016-03-02 21:37:46', '2024', '542652', '2192.5', '92321', '264234', '186097', '196.2', '953.3', '1043', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('10', '2016-03-29 23:03:50', '2016-03-02 21:37:46', '2025', '565038', '2225.9', '18646', '287039', '259353', '83.5', '1004.3', '1138.1', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('11', '2016-03-07 21:32:43', '2016-03-02 21:37:46', '2026', '580300', '2393.6', '94234', '274324', '211742', '46.23', '1234.5', '1112.87', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('12', '2016-03-07 21:32:38', '2016-03-02 21:37:46', '2027', '560232', '2601.12', '92342', '279423', '188467', '48.43', '1354.4', '1198.29', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('13', '2016-03-07 21:32:35', '2016-03-02 21:37:46', '2028', '553400', '2851.5', '85425', '284234', '183741', '43.5', '1433.3', '1374.7', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('14', '2016-03-07 21:32:33', '2016-03-02 21:37:46', '2029', '569830', '2975.8', '94234', '284254', '191342', '45.3', '1534.3', '1396.2', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('15', '2016-03-29 23:03:58', '2016-03-02 21:37:46', '2030', '608730', '3105.2', '19479', '275146', '314105', '108.7', '1293.4', '1703.1', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('16', '2016-03-07 21:32:25', '2016-03-02 21:37:46', '2031', '623231', '3215.4', '92423', '304324', '226484', '43.9', '1794.7', '1376.8', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('17', '2016-03-07 21:32:21', '2016-03-02 21:37:46', '2032', '643430', '3438.3', '95435', '304325', '243670', '44.12', '1943.6', '1450.58', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('18', '2016-03-07 21:32:18', '2016-03-02 21:37:46', '2033', '687343', '3604.65', '98131', '302134', '287078', '46.23', '2032.4', '1526.02', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('19', '2016-03-07 21:32:14', '2016-03-02 21:37:46', '2034', '690432', '3883.3', '94242', '293244', '302946', '47.55', '2143.6', '1692.15', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('20', '2016-03-29 23:06:30', '2016-03-02 21:37:46', '2035', '698423', '4123.3', '22349', '288448', '387626', '149.3', '1722.9', '2251.1', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('21', '2016-03-30 19:07:13', '2016-03-02 21:37:46', '2036', '684234', '4432.2', '94242', '284234', '305758', '52.5', '1743.6', '2636.1', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('22', '2016-03-30 19:07:33', '2016-03-02 21:37:46', '2037', '693432', '5074.23', '98131', '285423', '309878', '55.6', '2734.3', '1884.3', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('23', '2016-03-30 19:07:40', '2016-03-02 21:37:46', '2038', '704242', '5432.9', '91312', '274324', '338606', '53.9', '2464.5', '2014.5', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('24', '2016-03-30 19:07:43', '2016-03-02 21:37:46', '2039', '722344', '5884.4', '94234', '274234', '353876', '56.1', '2514.3', '2213.9', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('25', '2016-03-30 19:14:53', '2016-03-02 21:37:46', '2040', '693213', '6232.7', '23569', '227373', '442271', '211.9', '2044.4', '3976.4', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('26', '2016-03-30 19:07:49', '2016-03-02 21:37:46', '2041', '659432', '6623.6', '81231', '269344', '308857', '58.5', '2643.7', '2421.4', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('27', '2016-03-30 19:07:56', '2016-03-02 21:37:46', '2042', '690043', '6833.64', '74234', '250342', '365467', '61.7', '2643.8', '2528.14', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('28', '2016-03-30 19:07:59', '2016-03-02 21:37:46', '2043', '719432', '7242.43', '74234', '230423', '414775', '64.8', '2743.9', '2533.73', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('29', '2016-03-30 19:08:03', '2016-03-02 21:37:46', '2044', '733042', '7753.23', '70324', '223423', '439295', '66.5', '2790.1', '2596.6', '0', '0', '0');
INSERT INTO `labor_gdp_relation_pre_data` VALUES ('30', '2016-03-30 19:16:17', '2016-03-02 21:37:46', '2045', '754324', '8143.34', '24138', '210456', '519730', '260.6', '2271.9', '5610.84', '0', '0', '0');




-- ----------------------------
-- Table structure for population_employ_insurance_data
-- ----------------------------
DROP TABLE IF EXISTS `population_employ_insurance_data`;
CREATE TABLE `population_employ_insurance_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` varchar(128) NOT NULL,
  `laborPopulation` int(11) NOT NULL,
  `employedPopulation` varchar(20) NOT NULL,
  `firstPopulation` int(20) NOT NULL,
  `secondPopulation` int(20) NOT NULL,
  `thirdPopoulation` int(20) NOT NULL,
  `insurance` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_employ_insurance_data
-- ----------------------------


-- ----------------------------
-- Table structure for population_employ_insurance_pre_data
-- ----------------------------
DROP TABLE IF EXISTS `population_employ_insurance_pre_data`;
CREATE TABLE `population_employ_insurance_pre_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `preyear` varchar(128) NOT NULL,
  `preLaborPopulation` varchar(11) NOT NULL,
  `preEmployedPopulation` varchar(20) NOT NULL,
  `preFirstPopulation` varchar(20) NOT NULL,
  `preSecondPopulation` varchar(20) NOT NULL,
  `preThirdPopulation` varchar(20) NOT NULL,
  `preInsurance` varchar(20) NOT NULL,
  `preOldRate` varchar(20) NOT NULL,
  `preLaborRate` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_employ_insurance_pre_data
-- ----------------------------
INSERT INTO `population_employ_insurance_pre_data` VALUES ('1', '2016-03-04 16:43:34', '2016-03-04 16:43:38', '2016', '50.7', '41.1', '3.5', '61.3', '35.2', '38.5', '31.16', '57.3');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('2', '2016-03-04 17:03:18', '2016-03-04 17:03:20', '2017', '50.1', '41.8', '3.7', '60.8', '35.5', '36.9', '31.56', '57.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('3', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2018', '50.5', '40.9', '3.6', '58.1', '38.3', '35.7', '31.74', '56.4');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('4', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2019', '49.8', '41.1', '3.4', '57.2', '39.4', '34.8', '31.92', '56.5');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('5', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2020', '50.1', '42.9', '3.6', '56.7', '39.7', '33.2', '32.08', '57.7');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('6', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2021', '52.4', '43.1', '3.2', '55.4', '41.4', '32.5', '32.15', '58.7');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('7', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2022', '53.7', '42.2', '3.3', '54.3', '42.4', '31.8', '32.54', '57.3');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('8', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2023', '53.0', '44.1', '3.1', '52.1', '44.8', '31.1', '32.89', '58.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('9', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2024', '54.3', '44.5', '3.2', '51.5', '45.3', '30.5', '33.34', '57.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('10', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2025', '56.5', '43.9', '3.3', '50.8', '45.9', '30.1', '33.66', '56.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('11', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2026', '58.0', '44.1', '3.7', '48.6', '47.7', '30.5', '33.46', '57.0');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('12', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2027', '56.0', '46.3', '3.6', '46.7', '49.7', '30.4', '33.25', '57.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('13', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2028', '55.3', '45.8', '3.5', '47.1', '49.4', '30.9', '33.68', '58.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('14', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2029', '57.0', '44.1', '3.7', '46.5', '49.8', '31.2', '33.75', '58.0');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('15', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2030', '60.9', '46.7', '3.2', '45.2', '51.6', '30.8', '33.67', '57.2');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('16', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2031', '62.3', '47.2', '3.3', '44.8', '51.9', '30.2', '33.59', '57.5');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('17', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2032', '64.3', '46.8', '3.4', '43.1', '53.5', '30.7', '33.81', '57.1');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('18', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2033', '68.7', '49.1', '3.5', '42.2', '54.3', '31.1', '33.68', '56.2');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('19', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2034', '69.0', '50.5', '3.6', '41.8', '54.6', '31.5', '33.78', '56.8');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('20', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2035', '69.8', '51.2', '3.2', '41.3', '55.5', '30.9', '33.92', '57.4');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('21', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2036', '68.4', '47.9', '3.5', '38.4', '58.1', '30.5', '33.57', '58.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('22', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2037', '69.3', '49.6', '3.1', '36.2', '60.7', '32.5', '33.28', '57.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('23', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2038', '70.4', '51.8', '3.4', '34.5', '62.1', '34.1', '33.01', '57.3');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('24', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2039', '72.2', '50.1', '3.2', '33.9', '62.9', '35.6', '32.85', '56.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('25', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2040', '69.3', '52.9', '3.4', '32.8', '63.8', '36.7', '32.05', '57.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('26', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2041', '65.9', '52.4', '3.5', '30.7', '65.8', '38.9', '32.14', '57.9');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('27', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2042', '69.0', '53.9', '3.1', '28.5', '68.4', '39.9', '31.85', '56.8');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('28', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2043', '71.9', '54.2', '3.5', '27.1', '69.4', '40.8', '31.24', '55.4');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('29', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2044', '73.3', '53.8', '3.4', '27.8', '68.8', '43.5', '30.98', '57.6');
INSERT INTO `population_employ_insurance_pre_data` VALUES ('30', '2016-03-04 17:05:40', '2016-03-04 17:05:40', '2045', '75.4', '56.2', '3.2', '27.9', '68.9', '45.8', '30.51', '56.9');



-- ----------------------------
-- Table structure for population_school_data
-- ----------------------------
DROP TABLE IF EXISTS `population_school_data`;
CREATE TABLE `population_school_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` varchar(128) NOT NULL,
  `town` varchar(100) NOT NULL,
  `town_id` bigint(20) NOT NULL,
  `primarySchool` bigint(20) NOT NULL,
  `middleSchool` bigint(20) NOT NULL,
  `highschool` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `population_school_data_ibfk_1` FOREIGN KEY (`town_id`) REFERENCES `dict_data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_school_data
-- ----------------------------


-- ----------------------------
-- Table structure for population_school_pre_data
-- ----------------------------
DROP TABLE IF EXISTS `population_school_pre_data`;
CREATE TABLE `population_school_pre_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `preyear` varchar(128) NOT NULL,
  `town` varchar(100) NOT NULL,
  `town_id` bigint(20) NOT NULL,
  `prePrimarySchool` bigint(20) NOT NULL,
  `preMiddleSchool` bigint(20) NOT NULL,
  `preHighschool` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `population_school_pre_data_ibfk_1` FOREIGN KEY (`town_id`) REFERENCES `dict_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_school_pre_data
-- ----------------------------
INSERT INTO `population_school_pre_data` VALUES ('1', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '1', '7', '4', '1');
INSERT INTO `population_school_pre_data` VALUES ('2', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '2', '5', '2', '2');
INSERT INTO `population_school_pre_data` VALUES ('3', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '3', '3', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('4', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '4', '9', '4', '1');
INSERT INTO `population_school_pre_data` VALUES ('5', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '5', '4', '2', '0');
INSERT INTO `population_school_pre_data` VALUES ('6', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '6', '8', '4', '1');
INSERT INTO `population_school_pre_data` VALUES ('7', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '7', '4', '2', '0');
INSERT INTO `population_school_pre_data` VALUES ('8', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '8', '3', '2', '0');
INSERT INTO `population_school_pre_data` VALUES ('9', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '9', '2', '1', '0');
INSERT INTO `population_school_pre_data` VALUES ('10', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2025', '', '10', '2', '2', '0');
INSERT INTO `population_school_pre_data` VALUES ('11', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '1', '8', '5', '2');
INSERT INTO `population_school_pre_data` VALUES ('12', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '2', '6', '3', '2');
INSERT INTO `population_school_pre_data` VALUES ('13', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '3', '4', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('14', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '4', '9', '4', '1');
INSERT INTO `population_school_pre_data` VALUES ('15', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '5', '5', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('16', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '6', '8', '4', '1');
INSERT INTO `population_school_pre_data` VALUES ('17', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '7', '5', '3', '1');
INSERT INTO `population_school_pre_data` VALUES ('18', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '8', '4', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('19', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '9', '3', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('20', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2035', '', '10', '3', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('21', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '1', '8', '5', '3');
INSERT INTO `population_school_pre_data` VALUES ('22', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '2', '6', '4', '2');
INSERT INTO `population_school_pre_data` VALUES ('23', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '3', '5', '3', '1');
INSERT INTO `population_school_pre_data` VALUES ('24', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '4', '9', '4', '2');
INSERT INTO `population_school_pre_data` VALUES ('25', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '5', '5', '3', '1');
INSERT INTO `population_school_pre_data` VALUES ('26', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '6', '8', '5', '2');
INSERT INTO `population_school_pre_data` VALUES ('27', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '7', '5', '3', '1');
INSERT INTO `population_school_pre_data` VALUES ('28', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '8', '4', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('29', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '9', '3', '2', '1');
INSERT INTO `population_school_pre_data` VALUES ('30', '2016-03-04 20:52:33', '2016-03-04 20:52:33', '2045', '', '10', '3', '3', '1');


-- ----------------------------
-- Table structure for population_structure_data
-- ----------------------------
DROP TABLE IF EXISTS `population_structure_data`;
CREATE TABLE `population_structure_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `ageType_id` bigint(20) NOT NULL,
  `sexType_id` bigint(20) NOT NULL,
  `residentPopulation` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_structure_data
-- ----------------------------



-- ----------------------------
-- Table structure for population_structure_pre_data
-- ----------------------------
DROP TABLE IF EXISTS `population_structure_pre_data`;
CREATE TABLE `population_structure_pre_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `preyear` int(11) DEFAULT NULL,
  `ageType_id` bigint(20) NOT NULL,
  `sexType_id` bigint(20) NOT NULL,
  `preResidentPopulation` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1415 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of population_structure_pre_data
-- ----------------------------
INSERT INTO `population_structure_pre_data` VALUES ('1', '2016-02-29 20:23:46', '2016-02-29 20:23:46', '2020', '0', '1', '1708');
INSERT INTO `population_structure_pre_data` VALUES ('2', '2016-03-01 20:23:46', '2016-02-29 20:23:46', '2020', '1', '1', '1683');
INSERT INTO `population_structure_pre_data` VALUES ('3', '2016-03-02 20:23:46', '2016-02-29 20:23:46', '2020', '2', '1', '1673');
INSERT INTO `population_structure_pre_data` VALUES ('4', '2016-03-03 20:23:46', '2016-02-29 20:23:46', '2020', '3', '1', '1624');
INSERT INTO `population_structure_pre_data` VALUES ('5', '2016-03-04 20:23:46', '2016-02-29 20:23:46', '2020', '4', '1', '1674');
INSERT INTO `population_structure_pre_data` VALUES ('6', '2016-03-05 20:23:46', '2016-02-29 20:23:46', '2020', '5', '1', '1592');
INSERT INTO `population_structure_pre_data` VALUES ('7', '2016-03-06 20:23:46', '2016-02-29 20:23:46', '2020', '6', '1', '1570');
INSERT INTO `population_structure_pre_data` VALUES ('8', '2016-03-07 20:23:46', '2016-02-29 20:23:46', '2020', '7', '1', '1548');
INSERT INTO `population_structure_pre_data` VALUES ('9', '2016-03-08 20:23:46', '2016-02-29 20:23:46', '2020', '8', '1', '1540');
INSERT INTO `population_structure_pre_data` VALUES ('10', '2016-03-09 20:23:46', '2016-02-29 20:23:46', '2020', '9', '1', '1594');
INSERT INTO `population_structure_pre_data` VALUES ('11', '2016-03-10 20:23:46', '2016-02-29 20:23:46', '2020', '10', '1', '1498');
INSERT INTO `population_structure_pre_data` VALUES ('12', '2016-03-11 20:23:46', '2016-02-29 20:23:46', '2020', '11', '1', '1398');
INSERT INTO `population_structure_pre_data` VALUES ('13', '2016-03-12 20:23:46', '2016-02-29 20:23:46', '2020', '12', '1', '1363');
INSERT INTO `population_structure_pre_data` VALUES ('14', '2016-03-13 20:23:46', '2016-02-29 20:23:46', '2020', '13', '1', '1352');
INSERT INTO `population_structure_pre_data` VALUES ('15', '2016-03-14 20:23:46', '2016-02-29 20:23:46', '2020', '14', '1', '1302');
INSERT INTO `population_structure_pre_data` VALUES ('16', '2016-03-15 20:23:46', '2016-02-29 20:23:46', '2020', '15', '1', '1447');
INSERT INTO `population_structure_pre_data` VALUES ('17', '2016-03-16 20:23:46', '2016-02-29 20:23:46', '2020', '16', '1', '1339');
INSERT INTO `population_structure_pre_data` VALUES ('18', '2016-03-17 20:23:46', '2016-02-29 20:23:46', '2020', '17', '1', '1541');
INSERT INTO `population_structure_pre_data` VALUES ('19', '2016-03-18 20:23:46', '2016-02-29 20:23:46', '2020', '18', '1', '1471');
INSERT INTO `population_structure_pre_data` VALUES ('20', '2016-03-19 20:23:46', '2016-02-29 20:23:46', '2020', '19', '1', '1813');
INSERT INTO `population_structure_pre_data` VALUES ('21', '2016-03-20 20:23:46', '2016-02-29 20:23:46', '2020', '20', '1', '1619');
INSERT INTO `population_structure_pre_data` VALUES ('22', '2016-03-21 20:23:46', '2016-02-29 20:23:46', '2020', '21', '1', '1741');
INSERT INTO `population_structure_pre_data` VALUES ('23', '2016-03-22 20:23:46', '2016-02-29 20:23:46', '2020', '22', '1', '1878');
INSERT INTO `population_structure_pre_data` VALUES ('24', '2016-03-23 20:23:46', '2016-02-29 20:23:46', '2020', '23', '1', '1842');
INSERT INTO `population_structure_pre_data` VALUES ('25', '2016-03-24 20:23:46', '2016-02-29 20:23:46', '2020', '24', '1', '1883');
INSERT INTO `population_structure_pre_data` VALUES ('26', '2016-03-25 20:23:46', '2016-02-29 20:23:46', '2020', '25', '1', '2017');
INSERT INTO `population_structure_pre_data` VALUES ('27', '2016-03-26 20:23:46', '2016-02-29 20:23:46', '2020', '26', '1', '2082');
INSERT INTO `population_structure_pre_data` VALUES ('28', '2016-03-27 20:23:46', '2016-02-29 20:23:46', '2020', '27', '1', '2243');
INSERT INTO `population_structure_pre_data` VALUES ('29', '2016-03-28 20:23:46', '2016-02-29 20:23:46', '2020', '28', '1', '2437');
INSERT INTO `population_structure_pre_data` VALUES ('30', '2016-03-29 20:23:46', '2016-02-29 20:23:46', '2020', '29', '1', '2725');
INSERT INTO `population_structure_pre_data` VALUES ('31', '2016-03-30 20:23:46', '2016-02-29 20:23:46', '2020', '30', '1', '2873');
INSERT INTO `population_structure_pre_data` VALUES ('32', '2016-03-31 20:23:46', '2016-02-29 20:23:46', '2020', '31', '1', '3209');
INSERT INTO `population_structure_pre_data` VALUES ('33', '2016-04-01 20:23:46', '2016-02-29 20:23:46', '2020', '32', '1', '3740');
INSERT INTO `population_structure_pre_data` VALUES ('34', '2016-04-02 20:23:46', '2016-02-29 20:23:46', '2020', '33', '1', '4031');
INSERT INTO `population_structure_pre_data` VALUES ('35', '2016-04-03 20:23:46', '2016-02-29 20:23:46', '2020', '34', '1', '3628');
INSERT INTO `population_structure_pre_data` VALUES ('36', '2016-04-04 20:23:46', '2016-02-29 20:23:46', '2020', '35', '1', '2996');
INSERT INTO `population_structure_pre_data` VALUES ('37', '2016-04-05 20:23:46', '2016-02-29 20:23:46', '2020', '36', '1', '2381');
INSERT INTO `population_structure_pre_data` VALUES ('38', '2016-04-06 20:23:46', '2016-02-29 20:23:46', '2020', '37', '1', '3845');
INSERT INTO `population_structure_pre_data` VALUES ('39', '2016-04-07 20:23:46', '2016-02-29 20:23:46', '2020', '38', '1', '3924');
INSERT INTO `population_structure_pre_data` VALUES ('40', '2016-04-08 20:23:46', '2016-02-29 20:23:46', '2020', '39', '1', '2457');
INSERT INTO `population_structure_pre_data` VALUES ('41', '2016-04-09 20:23:46', '2016-02-29 20:23:46', '2020', '40', '1', '3565');
INSERT INTO `population_structure_pre_data` VALUES ('42', '2016-04-10 20:23:46', '2016-02-29 20:23:46', '2020', '41', '1', '3441');
INSERT INTO `population_structure_pre_data` VALUES ('43', '2016-04-11 20:23:46', '2016-02-29 20:23:46', '2020', '42', '1', '3503');
INSERT INTO `population_structure_pre_data` VALUES ('44', '2016-04-12 20:23:46', '2016-02-29 20:23:46', '2020', '43', '1', '3491');
INSERT INTO `population_structure_pre_data` VALUES ('45', '2016-04-13 20:23:46', '2016-02-29 20:23:46', '2020', '44', '1', '3819');
INSERT INTO `population_structure_pre_data` VALUES ('46', '2016-04-14 20:23:46', '2016-02-29 20:23:46', '2020', '45', '1', '4200');
INSERT INTO `population_structure_pre_data` VALUES ('47', '2016-04-15 20:23:46', '2016-02-29 20:23:46', '2020', '46', '1', '3766');
INSERT INTO `population_structure_pre_data` VALUES ('48', '2016-04-16 20:23:46', '2016-02-29 20:23:46', '2020', '47', '1', '3465');
INSERT INTO `population_structure_pre_data` VALUES ('49', '2016-04-17 20:23:46', '2016-02-29 20:23:46', '2020', '48', '1', '3996');
INSERT INTO `population_structure_pre_data` VALUES ('50', '2016-04-18 20:23:46', '2016-02-29 20:23:46', '2020', '49', '1', '4638');
INSERT INTO `population_structure_pre_data` VALUES ('51', '2016-04-19 20:23:46', '2016-02-29 20:23:46', '2020', '50', '1', '4409');
INSERT INTO `population_structure_pre_data` VALUES ('52', '2016-04-20 20:23:46', '2016-02-29 20:23:46', '2020', '51', '1', '4606');
INSERT INTO `population_structure_pre_data` VALUES ('53', '2016-04-21 20:23:46', '2016-02-29 20:23:46', '2020', '52', '1', '3388');
INSERT INTO `population_structure_pre_data` VALUES ('54', '2016-04-22 20:23:46', '2016-02-29 20:23:46', '2020', '53', '1', '4052');
INSERT INTO `population_structure_pre_data` VALUES ('55', '2016-04-23 20:23:46', '2016-02-29 20:23:46', '2020', '54', '1', '4138');
INSERT INTO `population_structure_pre_data` VALUES ('56', '2016-04-24 20:23:46', '2016-02-29 20:23:46', '2020', '55', '1', '3968');
INSERT INTO `population_structure_pre_data` VALUES ('57', '2016-04-25 20:23:46', '2016-02-29 20:23:46', '2020', '56', '1', '5624');
INSERT INTO `population_structure_pre_data` VALUES ('58', '2016-04-26 20:23:46', '2016-02-29 20:23:46', '2020', '57', '1', '4719');
INSERT INTO `population_structure_pre_data` VALUES ('59', '2016-04-27 20:23:46', '2016-02-29 20:23:46', '2020', '58', '1', '3874');
INSERT INTO `population_structure_pre_data` VALUES ('60', '2016-04-28 20:23:46', '2016-02-29 20:23:46', '2020', '59', '1', '2844');
INSERT INTO `population_structure_pre_data` VALUES ('61', '2016-04-29 20:23:46', '2016-02-29 20:23:46', '2020', '60', '1', '2693');
INSERT INTO `population_structure_pre_data` VALUES ('62', '2016-04-30 20:23:46', '2016-02-29 20:23:46', '2020', '61', '1', '3270');
INSERT INTO `population_structure_pre_data` VALUES ('63', '2016-05-01 20:23:46', '2016-02-29 20:23:46', '2020', '62', '1', '3371');
INSERT INTO `population_structure_pre_data` VALUES ('64', '2016-05-02 20:23:46', '2016-02-29 20:23:46', '2020', '63', '1', '3856');
INSERT INTO `population_structure_pre_data` VALUES ('65', '2016-05-03 20:23:46', '2016-02-29 20:23:46', '2020', '64', '1', '3897');
INSERT INTO `population_structure_pre_data` VALUES ('66', '2016-05-04 20:23:46', '2016-02-29 20:23:46', '2020', '65', '1', '4632');
INSERT INTO `population_structure_pre_data` VALUES ('67', '2016-05-05 20:23:46', '2016-02-29 20:23:46', '2020', '66', '1', '4300');
INSERT INTO `population_structure_pre_data` VALUES ('68', '2016-05-06 20:23:46', '2016-02-29 20:23:46', '2020', '67', '1', '4838');
INSERT INTO `population_structure_pre_data` VALUES ('69', '2016-05-07 20:23:46', '2016-02-29 20:23:46', '2020', '68', '1', '3927');
INSERT INTO `population_structure_pre_data` VALUES ('70', '2016-05-08 20:23:46', '2016-02-29 20:23:46', '2020', '69', '1', '3002');
INSERT INTO `population_structure_pre_data` VALUES ('71', '2016-05-09 20:23:46', '2016-02-29 20:23:46', '2020', '70', '1', '3032');
INSERT INTO `population_structure_pre_data` VALUES ('72', '2016-05-10 20:23:46', '2016-02-29 20:23:46', '2020', '71', '1', '2887');
INSERT INTO `population_structure_pre_data` VALUES ('73', '2016-05-11 20:23:46', '2016-02-29 20:23:46', '2020', '72', '1', '2646');
INSERT INTO `population_structure_pre_data` VALUES ('74', '2016-05-12 20:23:46', '2016-02-29 20:23:46', '2020', '73', '1', '2461');
INSERT INTO `population_structure_pre_data` VALUES ('75', '2016-05-13 20:23:46', '2016-02-29 20:23:46', '2020', '74', '1', '2010');
INSERT INTO `population_structure_pre_data` VALUES ('76', '2016-05-14 20:23:46', '2016-02-29 20:23:46', '2020', '75', '1', '1901');
INSERT INTO `population_structure_pre_data` VALUES ('77', '2016-05-15 20:23:46', '2016-02-29 20:23:46', '2020', '76', '1', '1851');
INSERT INTO `population_structure_pre_data` VALUES ('78', '2016-05-16 20:23:46', '2016-02-29 20:23:46', '2020', '77', '1', '1345');
INSERT INTO `population_structure_pre_data` VALUES ('79', '2016-05-17 20:23:46', '2016-02-29 20:23:46', '2020', '78', '1', '1266');
INSERT INTO `population_structure_pre_data` VALUES ('80', '2016-05-18 20:23:46', '2016-02-29 20:23:46', '2020', '79', '1', '1250');
INSERT INTO `population_structure_pre_data` VALUES ('81', '2016-05-19 20:23:46', '2016-02-29 20:23:46', '2020', '80', '1', '1151');
INSERT INTO `population_structure_pre_data` VALUES ('82', '2016-05-20 20:23:46', '2016-02-29 20:23:46', '2020', '81', '1', '1091');
INSERT INTO `population_structure_pre_data` VALUES ('83', '2016-05-21 20:23:46', '2016-02-29 20:23:46', '2020', '82', '1', '996');
INSERT INTO `population_structure_pre_data` VALUES ('84', '2016-05-22 20:23:46', '2016-02-29 20:23:46', '2020', '83', '1', '960');
INSERT INTO `population_structure_pre_data` VALUES ('85', '2016-05-23 20:23:46', '2016-02-29 20:23:46', '2020', '84', '1', '975');
INSERT INTO `population_structure_pre_data` VALUES ('86', '2016-05-24 20:23:46', '2016-02-29 20:23:46', '2020', '85', '1', '929');
INSERT INTO `population_structure_pre_data` VALUES ('87', '2016-05-25 20:23:46', '2016-02-29 20:23:46', '2020', '86', '1', '940');
INSERT INTO `population_structure_pre_data` VALUES ('88', '2016-05-26 20:23:46', '2016-02-29 20:23:46', '2020', '87', '1', '889');
INSERT INTO `population_structure_pre_data` VALUES ('89', '2016-05-27 20:23:46', '2016-02-29 20:23:46', '2020', '88', '1', '898');
INSERT INTO `population_structure_pre_data` VALUES ('90', '2016-05-28 20:23:46', '2016-02-29 20:23:46', '2020', '89', '1', '894');
INSERT INTO `population_structure_pre_data` VALUES ('91', '2016-05-29 20:23:46', '2016-02-29 20:23:46', '2020', '90', '1', '852');
INSERT INTO `population_structure_pre_data` VALUES ('92', '2016-05-30 20:23:46', '2016-02-29 20:23:46', '2020', '91', '1', '815');
INSERT INTO `population_structure_pre_data` VALUES ('93', '2016-05-31 20:23:46', '2016-02-29 20:23:46', '2020', '92', '1', '626');
INSERT INTO `population_structure_pre_data` VALUES ('94', '2016-06-01 20:23:46', '2016-02-29 20:23:46', '2020', '93', '1', '660');
INSERT INTO `population_structure_pre_data` VALUES ('95', '2016-06-02 20:23:46', '2016-02-29 20:23:46', '2020', '94', '1', '568');
INSERT INTO `population_structure_pre_data` VALUES ('96', '2016-06-03 20:23:46', '2016-02-29 20:23:46', '2020', '95', '1', '533');
INSERT INTO `population_structure_pre_data` VALUES ('97', '2016-06-04 20:23:46', '2016-02-29 20:23:46', '2020', '96', '1', '516');
INSERT INTO `population_structure_pre_data` VALUES ('98', '2016-06-05 20:23:46', '2016-02-29 20:23:46', '2020', '97', '1', '389');
INSERT INTO `population_structure_pre_data` VALUES ('99', '2016-06-06 20:23:46', '2016-02-29 20:23:46', '2020', '98', '1', '357');
INSERT INTO `population_structure_pre_data` VALUES ('100', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '99', '1', '111');
INSERT INTO `population_structure_pre_data` VALUES ('101', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '0', '1', '2312');
INSERT INTO `population_structure_pre_data` VALUES ('102', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '1', '1', '2087');
INSERT INTO `population_structure_pre_data` VALUES ('103', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '2', '1', '1962');
INSERT INTO `population_structure_pre_data` VALUES ('104', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '3', '1', '2151');
INSERT INTO `population_structure_pre_data` VALUES ('105', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '4', '1', '2002');
INSERT INTO `population_structure_pre_data` VALUES ('106', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '5', '1', '1933');
INSERT INTO `population_structure_pre_data` VALUES ('107', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '6', '1', '1903');
INSERT INTO `population_structure_pre_data` VALUES ('108', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '7', '1', '1868');
INSERT INTO `population_structure_pre_data` VALUES ('109', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '8', '1', '1857');
INSERT INTO `population_structure_pre_data` VALUES ('110', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '9', '1', '1513');
INSERT INTO `population_structure_pre_data` VALUES ('111', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '10', '1', '1652');
INSERT INTO `population_structure_pre_data` VALUES ('112', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '11', '1', '1925');
INSERT INTO `population_structure_pre_data` VALUES ('113', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '12', '1', '1548');
INSERT INTO `population_structure_pre_data` VALUES ('114', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '13', '1', '1748');
INSERT INTO `population_structure_pre_data` VALUES ('115', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '14', '1', '1583');
INSERT INTO `population_structure_pre_data` VALUES ('116', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '15', '1', '1488');
INSERT INTO `population_structure_pre_data` VALUES ('117', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '16', '1', '1388');
INSERT INTO `population_structure_pre_data` VALUES ('118', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '17', '1', '1356');
INSERT INTO `population_structure_pre_data` VALUES ('119', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '18', '1', '1346');
INSERT INTO `population_structure_pre_data` VALUES ('120', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '19', '1', '1301');
INSERT INTO `population_structure_pre_data` VALUES ('121', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '20', '1', '1440');
INSERT INTO `population_structure_pre_data` VALUES ('122', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '21', '1', '1713');
INSERT INTO `population_structure_pre_data` VALUES ('123', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '22', '1', '1334');
INSERT INTO `population_structure_pre_data` VALUES ('124', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '23', '1', '1535');
INSERT INTO `population_structure_pre_data` VALUES ('125', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '24', '1', '1466');
INSERT INTO `population_structure_pre_data` VALUES ('126', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '25', '1', '1803');
INSERT INTO `population_structure_pre_data` VALUES ('127', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '26', '1', '1609');
INSERT INTO `population_structure_pre_data` VALUES ('128', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '27', '1', '1731');
INSERT INTO `population_structure_pre_data` VALUES ('129', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '28', '1', '1868');
INSERT INTO `population_structure_pre_data` VALUES ('130', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '29', '1', '1832');
INSERT INTO `population_structure_pre_data` VALUES ('131', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '30', '1', '1873');
INSERT INTO `population_structure_pre_data` VALUES ('132', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '31', '1', '2006');
INSERT INTO `population_structure_pre_data` VALUES ('133', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '32', '1', '2070');
INSERT INTO `population_structure_pre_data` VALUES ('134', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '33', '1', '2230');
INSERT INTO `population_structure_pre_data` VALUES ('135', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '34', '1', '2423');
INSERT INTO `population_structure_pre_data` VALUES ('136', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '35', '1', '2710');
INSERT INTO `population_structure_pre_data` VALUES ('137', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '36', '1', '2853');
INSERT INTO `population_structure_pre_data` VALUES ('138', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '37', '1', '3187');
INSERT INTO `population_structure_pre_data` VALUES ('139', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '38', '1', '3717');
INSERT INTO `population_structure_pre_data` VALUES ('140', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '39', '1', '4002');
INSERT INTO `population_structure_pre_data` VALUES ('141', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '40', '1', '3603');
INSERT INTO `population_structure_pre_data` VALUES ('142', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '41', '1', '1980');
INSERT INTO `population_structure_pre_data` VALUES ('143', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '42', '1', '2361');
INSERT INTO `population_structure_pre_data` VALUES ('144', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '43', '1', '3812');
INSERT INTO `population_structure_pre_data` VALUES ('145', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '44', '1', '3890');
INSERT INTO `population_structure_pre_data` VALUES ('146', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '45', '1', '2432');
INSERT INTO `population_structure_pre_data` VALUES ('147', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '46', '1', '3531');
INSERT INTO `population_structure_pre_data` VALUES ('148', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '47', '1', '3405');
INSERT INTO `population_structure_pre_data` VALUES ('149', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '48', '1', '3464');
INSERT INTO `population_structure_pre_data` VALUES ('150', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '49', '1', '3449');
INSERT INTO `population_structure_pre_data` VALUES ('151', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '50', '1', '3769');
INSERT INTO `population_structure_pre_data` VALUES ('152', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '51', '1', '4141');
INSERT INTO `population_structure_pre_data` VALUES ('153', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '52', '1', '3710');
INSERT INTO `population_structure_pre_data` VALUES ('154', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '53', '1', '3411');
INSERT INTO `population_structure_pre_data` VALUES ('155', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '54', '1', '3929');
INSERT INTO `population_structure_pre_data` VALUES ('156', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '55', '1', '4558');
INSERT INTO `population_structure_pre_data` VALUES ('157', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '56', '1', '4327');
INSERT INTO `population_structure_pre_data` VALUES ('158', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '57', '1', '4512');
INSERT INTO `population_structure_pre_data` VALUES ('159', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '58', '1', '3313');
INSERT INTO `population_structure_pre_data` VALUES ('160', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '59', '1', '3958');
INSERT INTO `population_structure_pre_data` VALUES ('161', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '60', '1', '4035');
INSERT INTO `population_structure_pre_data` VALUES ('162', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '61', '1', '3856');
INSERT INTO `population_structure_pre_data` VALUES ('163', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '62', '1', '5449');
INSERT INTO `population_structure_pre_data` VALUES ('164', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '63', '1', '4556');
INSERT INTO `population_structure_pre_data` VALUES ('165', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '64', '1', '2802');
INSERT INTO `population_structure_pre_data` VALUES ('166', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '65', '1', '2728');
INSERT INTO `population_structure_pre_data` VALUES ('167', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '66', '1', '2567');
INSERT INTO `population_structure_pre_data` VALUES ('168', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '67', '1', '3098');
INSERT INTO `population_structure_pre_data` VALUES ('169', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '68', '1', '3173');
INSERT INTO `population_structure_pre_data` VALUES ('170', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '69', '1', '3608');
INSERT INTO `population_structure_pre_data` VALUES ('171', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '70', '1', '3624');
INSERT INTO `population_structure_pre_data` VALUES ('172', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '71', '1', '3265');
INSERT INTO `population_structure_pre_data` VALUES ('173', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '72', '1', '2921');
INSERT INTO `population_structure_pre_data` VALUES ('174', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '73', '1', '2368');
INSERT INTO `population_structure_pre_data` VALUES ('175', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '74', '1', '2010');
INSERT INTO `population_structure_pre_data` VALUES ('176', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '75', '1', '1857');
INSERT INTO `population_structure_pre_data` VALUES ('177', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '76', '1', '2320');
INSERT INTO `population_structure_pre_data` VALUES ('178', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '77', '1', '2032');
INSERT INTO `population_structure_pre_data` VALUES ('179', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '78', '1', '1847');
INSERT INTO `population_structure_pre_data` VALUES ('180', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '79', '1', '1549');
INSERT INTO `population_structure_pre_data` VALUES ('181', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '80', '1', '1440');
INSERT INTO `population_structure_pre_data` VALUES ('182', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '81', '1', '1303');
INSERT INTO `population_structure_pre_data` VALUES ('183', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '82', '1', '1311');
INSERT INTO `population_structure_pre_data` VALUES ('184', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '83', '1', '1267');
INSERT INTO `population_structure_pre_data` VALUES ('185', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '84', '1', '1189');
INSERT INTO `population_structure_pre_data` VALUES ('186', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '85', '1', '1017');
INSERT INTO `population_structure_pre_data` VALUES ('187', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '86', '1', '839');
INSERT INTO `population_structure_pre_data` VALUES ('188', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '87', '1', '895');
INSERT INTO `population_structure_pre_data` VALUES ('189', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '88', '1', '736');
INSERT INTO `population_structure_pre_data` VALUES ('190', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '89', '1', '743');
INSERT INTO `population_structure_pre_data` VALUES ('191', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '90', '1', '607');
INSERT INTO `population_structure_pre_data` VALUES ('192', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '91', '1', '539');
INSERT INTO `population_structure_pre_data` VALUES ('193', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '92', '1', '553');
INSERT INTO `population_structure_pre_data` VALUES ('194', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '93', '1', '400');
INSERT INTO `population_structure_pre_data` VALUES ('195', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '94', '1', '291');
INSERT INTO `population_structure_pre_data` VALUES ('196', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '95', '1', '269');
INSERT INTO `population_structure_pre_data` VALUES ('197', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '96', '1', '205');
INSERT INTO `population_structure_pre_data` VALUES ('198', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '97', '1', '185');
INSERT INTO `population_structure_pre_data` VALUES ('199', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '98', '1', '112');
INSERT INTO `population_structure_pre_data` VALUES ('200', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '99', '1', '86');
INSERT INTO `population_structure_pre_data` VALUES ('201', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '0', '1', '2612');
INSERT INTO `population_structure_pre_data` VALUES ('202', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '1', '1', '2687');
INSERT INTO `population_structure_pre_data` VALUES ('203', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '2', '1', '2562');
INSERT INTO `population_structure_pre_data` VALUES ('204', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '3', '1', '2551');
INSERT INTO `population_structure_pre_data` VALUES ('205', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '4', '1', '2502');
INSERT INTO `population_structure_pre_data` VALUES ('206', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '5', '1', '2503');
INSERT INTO `population_structure_pre_data` VALUES ('207', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '6', '1', '2483');
INSERT INTO `population_structure_pre_data` VALUES ('208', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '7', '1', '2468');
INSERT INTO `population_structure_pre_data` VALUES ('209', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '8', '1', '2457');
INSERT INTO `population_structure_pre_data` VALUES ('210', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '9', '1', '2313');
INSERT INTO `population_structure_pre_data` VALUES ('211', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '10', '1', '2352');
INSERT INTO `population_structure_pre_data` VALUES ('212', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '11', '1', '2125');
INSERT INTO `population_structure_pre_data` VALUES ('213', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '12', '1', '2248');
INSERT INTO `population_structure_pre_data` VALUES ('214', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '13', '1', '2248');
INSERT INTO `population_structure_pre_data` VALUES ('215', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '14', '1', '2158');
INSERT INTO `population_structure_pre_data` VALUES ('216', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '15', '1', '2078');
INSERT INTO `population_structure_pre_data` VALUES ('217', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '16', '1', '2018');
INSERT INTO `population_structure_pre_data` VALUES ('218', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '17', '1', '2128');
INSERT INTO `population_structure_pre_data` VALUES ('219', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '18', '1', '2125');
INSERT INTO `population_structure_pre_data` VALUES ('220', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '19', '1', '2178');
INSERT INTO `population_structure_pre_data` VALUES ('221', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '20', '1', '2083');
INSERT INTO `population_structure_pre_data` VALUES ('222', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '21', '1', '1983');
INSERT INTO `population_structure_pre_data` VALUES ('223', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '22', '1', '1851');
INSERT INTO `population_structure_pre_data` VALUES ('224', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '23', '1', '1741');
INSERT INTO `population_structure_pre_data` VALUES ('225', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '24', '1', '1696');
INSERT INTO `population_structure_pre_data` VALUES ('226', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '25', '1', '1735');
INSERT INTO `population_structure_pre_data` VALUES ('227', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '26', '1', '1803');
INSERT INTO `population_structure_pre_data` VALUES ('228', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '27', '1', '2029');
INSERT INTO `population_structure_pre_data` VALUES ('229', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '28', '1', '2227');
INSERT INTO `population_structure_pre_data` VALUES ('230', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '29', '1', '2457');
INSERT INTO `population_structure_pre_data` VALUES ('231', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '30', '1', '2793');
INSERT INTO `population_structure_pre_data` VALUES ('232', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '31', '1', '2599');
INSERT INTO `population_structure_pre_data` VALUES ('233', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '32', '1', '2721');
INSERT INTO `population_structure_pre_data` VALUES ('234', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '33', '1', '2858');
INSERT INTO `population_structure_pre_data` VALUES ('235', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '34', '1', '2822');
INSERT INTO `population_structure_pre_data` VALUES ('236', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '35', '1', '2863');
INSERT INTO `population_structure_pre_data` VALUES ('237', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '36', '1', '3995');
INSERT INTO `population_structure_pre_data` VALUES ('238', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '37', '1', '2055');
INSERT INTO `population_structure_pre_data` VALUES ('239', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '38', '1', '3215');
INSERT INTO `population_structure_pre_data` VALUES ('240', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '39', '1', '3404');
INSERT INTO `population_structure_pre_data` VALUES ('241', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '40', '1', '2690');
INSERT INTO `population_structure_pre_data` VALUES ('242', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '41', '1', '3832');
INSERT INTO `population_structure_pre_data` VALUES ('243', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '42', '1', '4160');
INSERT INTO `population_structure_pre_data` VALUES ('244', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '43', '1', '3689');
INSERT INTO `population_structure_pre_data` VALUES ('245', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '44', '1', '3968');
INSERT INTO `population_structure_pre_data` VALUES ('246', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '45', '1', '4573');
INSERT INTO `population_structure_pre_data` VALUES ('247', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '46', '1', '3959');
INSERT INTO `population_structure_pre_data` VALUES ('248', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '47', '1', '3837');
INSERT INTO `population_structure_pre_data` VALUES ('249', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '48', '1', '3768');
INSERT INTO `population_structure_pre_data` VALUES ('250', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '49', '1', '3843');
INSERT INTO `population_structure_pre_data` VALUES ('251', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '50', '1', '3402');
INSERT INTO `population_structure_pre_data` VALUES ('252', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '51', '1', '3484');
INSERT INTO `population_structure_pre_data` VALUES ('253', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '52', '1', '3356');
INSERT INTO `population_structure_pre_data` VALUES ('254', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '53', '1', '3413');
INSERT INTO `population_structure_pre_data` VALUES ('255', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '54', '1', '3396');
INSERT INTO `population_structure_pre_data` VALUES ('256', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '55', '1', '3709');
INSERT INTO `population_structure_pre_data` VALUES ('257', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '56', '1', '4070');
INSERT INTO `population_structure_pre_data` VALUES ('258', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '57', '1', '3640');
INSERT INTO `population_structure_pre_data` VALUES ('259', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '58', '1', '3342');
INSERT INTO `population_structure_pre_data` VALUES ('260', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '59', '1', '3845');
INSERT INTO `population_structure_pre_data` VALUES ('261', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '60', '1', '4454');
INSERT INTO `population_structure_pre_data` VALUES ('262', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '61', '1', '4215');
INSERT INTO `population_structure_pre_data` VALUES ('263', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '62', '1', '4383');
INSERT INTO `population_structure_pre_data` VALUES ('264', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '63', '1', '3208');
INSERT INTO `population_structure_pre_data` VALUES ('265', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '64', '1', '3820');
INSERT INTO `population_structure_pre_data` VALUES ('266', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '65', '1', '3882');
INSERT INTO `population_structure_pre_data` VALUES ('267', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '66', '1', '3690');
INSERT INTO `population_structure_pre_data` VALUES ('268', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '67', '1', '5188');
INSERT INTO `population_structure_pre_data` VALUES ('269', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '68', '1', '4313');
INSERT INTO `population_structure_pre_data` VALUES ('270', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '69', '1', '1695');
INSERT INTO `population_structure_pre_data` VALUES ('271', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '70', '1', '2554');
INSERT INTO `population_structure_pre_data` VALUES ('272', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '71', '1', '2381');
INSERT INTO `population_structure_pre_data` VALUES ('273', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '72', '1', '2850');
INSERT INTO `population_structure_pre_data` VALUES ('274', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '73', '1', '2892');
INSERT INTO `population_structure_pre_data` VALUES ('275', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '74', '1', '3259');
INSERT INTO `population_structure_pre_data` VALUES ('276', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '75', '1', '3244');
INSERT INTO `population_structure_pre_data` VALUES ('277', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '76', '1', '3753');
INSERT INTO `population_structure_pre_data` VALUES ('278', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '77', '1', '3388');
INSERT INTO `population_structure_pre_data` VALUES ('279', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '78', '1', '3707');
INSERT INTO `population_structure_pre_data` VALUES ('280', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '79', '1', '2927');
INSERT INTO `population_structure_pre_data` VALUES ('281', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '80', '1', '2176');
INSERT INTO `population_structure_pre_data` VALUES ('282', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '81', '1', '2174');
INSERT INTO `population_structure_pre_data` VALUES ('283', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '82', '1', '2050');
INSERT INTO `population_structure_pre_data` VALUES ('284', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '83', '1', '1934');
INSERT INTO `population_structure_pre_data` VALUES ('285', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '84', '1', '1740');
INSERT INTO `population_structure_pre_data` VALUES ('286', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '85', '1', '1401');
INSERT INTO `population_structure_pre_data` VALUES ('287', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '86', '1', '1245');
INSERT INTO `population_structure_pre_data` VALUES ('288', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '87', '1', '935');
INSERT INTO `population_structure_pre_data` VALUES ('289', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '88', '1', '867');
INSERT INTO `population_structure_pre_data` VALUES ('290', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '89', '1', '904');
INSERT INTO `population_structure_pre_data` VALUES ('291', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '90', '1', '590');
INSERT INTO `population_structure_pre_data` VALUES ('292', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '91', '1', '454');
INSERT INTO `population_structure_pre_data` VALUES ('293', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '92', '1', '451');
INSERT INTO `population_structure_pre_data` VALUES ('294', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '93', '1', '345');
INSERT INTO `population_structure_pre_data` VALUES ('295', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '94', '1', '323');
INSERT INTO `population_structure_pre_data` VALUES ('296', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '95', '1', '246');
INSERT INTO `population_structure_pre_data` VALUES ('297', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '96', '1', '213');
INSERT INTO `population_structure_pre_data` VALUES ('298', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '97', '1', '213');
INSERT INTO `population_structure_pre_data` VALUES ('299', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '98', '1', '149');
INSERT INTO `population_structure_pre_data` VALUES ('300', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '99', '1', '105');
INSERT INTO `population_structure_pre_data` VALUES ('301', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '0', '1', '2812');
INSERT INTO `population_structure_pre_data` VALUES ('302', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '1', '1', '2887');
INSERT INTO `population_structure_pre_data` VALUES ('303', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '2', '1', '2862');
INSERT INTO `population_structure_pre_data` VALUES ('304', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '3', '1', '2751');
INSERT INTO `population_structure_pre_data` VALUES ('305', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '4', '1', '2702');
INSERT INTO `population_structure_pre_data` VALUES ('306', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '5', '1', '2803');
INSERT INTO `population_structure_pre_data` VALUES ('307', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '6', '1', '2703');
INSERT INTO `population_structure_pre_data` VALUES ('308', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '7', '1', '2668');
INSERT INTO `population_structure_pre_data` VALUES ('309', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '8', '1', '2657');
INSERT INTO `population_structure_pre_data` VALUES ('310', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '9', '1', '2513');
INSERT INTO `population_structure_pre_data` VALUES ('311', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '10', '1', '2552');
INSERT INTO `population_structure_pre_data` VALUES ('312', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '11', '1', '2525');
INSERT INTO `population_structure_pre_data` VALUES ('313', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '12', '1', '2448');
INSERT INTO `population_structure_pre_data` VALUES ('314', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '13', '1', '2348');
INSERT INTO `population_structure_pre_data` VALUES ('315', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '14', '1', '2365');
INSERT INTO `population_structure_pre_data` VALUES ('316', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '15', '1', '2283');
INSERT INTO `population_structure_pre_data` VALUES ('317', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '16', '1', '2260');
INSERT INTO `population_structure_pre_data` VALUES ('318', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '17', '1', '2152');
INSERT INTO `population_structure_pre_data` VALUES ('319', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '18', '1', '2105');
INSERT INTO `population_structure_pre_data` VALUES ('320', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '19', '1', '2277');
INSERT INTO `population_structure_pre_data` VALUES ('321', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '20', '1', '2165');
INSERT INTO `population_structure_pre_data` VALUES ('322', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '21', '1', '2033');
INSERT INTO `population_structure_pre_data` VALUES ('323', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '22', '1', '2023');
INSERT INTO `population_structure_pre_data` VALUES ('324', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '23', '1', '2017');
INSERT INTO `population_structure_pre_data` VALUES ('325', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '24', '1', '2073');
INSERT INTO `population_structure_pre_data` VALUES ('326', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '25', '1', '1978');
INSERT INTO `population_structure_pre_data` VALUES ('327', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '26', '1', '2078');
INSERT INTO `population_structure_pre_data` VALUES ('328', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '27', '1', '2246');
INSERT INTO `population_structure_pre_data` VALUES ('329', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '28', '1', '2336');
INSERT INTO `population_structure_pre_data` VALUES ('330', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '29', '1', '2391');
INSERT INTO `population_structure_pre_data` VALUES ('331', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '30', '1', '2426');
INSERT INTO `population_structure_pre_data` VALUES ('332', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '31', '1', '2493');
INSERT INTO `population_structure_pre_data` VALUES ('333', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '32', '1', '2522');
INSERT INTO `population_structure_pre_data` VALUES ('334', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '33', '1', '2617');
INSERT INTO `population_structure_pre_data` VALUES ('335', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '34', '1', '2747');
INSERT INTO `population_structure_pre_data` VALUES ('336', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '35', '1', '4583');
INSERT INTO `population_structure_pre_data` VALUES ('337', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '36', '1', '3189');
INSERT INTO `population_structure_pre_data` VALUES ('338', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '37', '1', '3209');
INSERT INTO `population_structure_pre_data` VALUES ('339', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '38', '1', '3345');
INSERT INTO `population_structure_pre_data` VALUES ('340', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '39', '1', '3408');
INSERT INTO `population_structure_pre_data` VALUES ('341', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '40', '1', '4648');
INSERT INTO `population_structure_pre_data` VALUES ('342', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '41', '1', '3980');
INSERT INTO `population_structure_pre_data` VALUES ('343', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '42', '1', '4038');
INSERT INTO `population_structure_pre_data` VALUES ('344', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '43', '1', '3997');
INSERT INTO `population_structure_pre_data` VALUES ('345', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '44', '1', '4085');
INSERT INTO `population_structure_pre_data` VALUES ('346', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '45', '1', '3665');
INSERT INTO `population_structure_pre_data` VALUES ('347', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '46', '1', '4805');
INSERT INTO `population_structure_pre_data` VALUES ('348', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '47', '1', '5329');
INSERT INTO `population_structure_pre_data` VALUES ('349', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '48', '1', '3650');
INSERT INTO `population_structure_pre_data` VALUES ('350', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '49', '1', '3926');
INSERT INTO `population_structure_pre_data` VALUES ('351', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '50', '1', '3528');
INSERT INTO `population_structure_pre_data` VALUES ('352', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '51', '1', '3933');
INSERT INTO `population_structure_pre_data` VALUES ('353', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '52', '1', '3305');
INSERT INTO `population_structure_pre_data` VALUES ('354', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '53', '1', '3717');
INSERT INTO `population_structure_pre_data` VALUES ('355', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '54', '1', '3788');
INSERT INTO `population_structure_pre_data` VALUES ('356', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '55', '1', '3367');
INSERT INTO `population_structure_pre_data` VALUES ('357', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '56', '1', '3427');
INSERT INTO `population_structure_pre_data` VALUES ('358', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '57', '1', '3296');
INSERT INTO `population_structure_pre_data` VALUES ('359', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '58', '1', '3348');
INSERT INTO `population_structure_pre_data` VALUES ('360', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '59', '1', '3326');
INSERT INTO `population_structure_pre_data` VALUES ('361', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '60', '1', '3629');
INSERT INTO `population_structure_pre_data` VALUES ('362', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '61', '1', '3970');
INSERT INTO `population_structure_pre_data` VALUES ('363', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '62', '1', '3540');
INSERT INTO `population_structure_pre_data` VALUES ('364', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '63', '1', '3240');
INSERT INTO `population_structure_pre_data` VALUES ('365', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '64', '1', '3717');
INSERT INTO `population_structure_pre_data` VALUES ('366', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '65', '1', '4294');
INSERT INTO `population_structure_pre_data` VALUES ('367', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '66', '1', '4042');
INSERT INTO `population_structure_pre_data` VALUES ('368', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '67', '1', '4182');
INSERT INTO `population_structure_pre_data` VALUES ('369', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '68', '1', '3045');
INSERT INTO `population_structure_pre_data` VALUES ('370', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '69', '1', '3608');
INSERT INTO `population_structure_pre_data` VALUES ('371', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '70', '1', '3648');
INSERT INTO `population_structure_pre_data` VALUES ('372', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '71', '1', '3437');
INSERT INTO `population_structure_pre_data` VALUES ('373', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '72', '1', '4793');
INSERT INTO `population_structure_pre_data` VALUES ('374', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '73', '1', '3949');
INSERT INTO `population_structure_pre_data` VALUES ('375', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '74', '1', '1538');
INSERT INTO `population_structure_pre_data` VALUES ('376', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '75', '1', '2299');
INSERT INTO `population_structure_pre_data` VALUES ('377', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '76', '1', '2106');
INSERT INTO `population_structure_pre_data` VALUES ('378', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '77', '1', '2481');
INSERT INTO `population_structure_pre_data` VALUES ('379', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '78', '1', '2475');
INSERT INTO `population_structure_pre_data` VALUES ('380', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '79', '1', '2743');
INSERT INTO `population_structure_pre_data` VALUES ('381', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '80', '1', '2684');
INSERT INTO `population_structure_pre_data` VALUES ('382', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '81', '1', '3034');
INSERT INTO `population_structure_pre_data` VALUES ('383', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '82', '1', '2673');
INSERT INTO `population_structure_pre_data` VALUES ('384', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '83', '1', '2857');
INSERT INTO `population_structure_pre_data` VALUES ('385', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '84', '1', '2202');
INSERT INTO `population_structure_pre_data` VALUES ('386', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '85', '1', '1598');
INSERT INTO `population_structure_pre_data` VALUES ('387', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '86', '1', '1541');
INSERT INTO `population_structure_pre_data` VALUES ('388', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '87', '1', '1401');
INSERT INTO `population_structure_pre_data` VALUES ('389', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '88', '1', '1275');
INSERT INTO `population_structure_pre_data` VALUES ('390', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '89', '1', '1107');
INSERT INTO `population_structure_pre_data` VALUES ('391', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '90', '1', '860');
INSERT INTO `population_structure_pre_data` VALUES ('392', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '91', '1', '710');
INSERT INTO `population_structure_pre_data` VALUES ('393', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '92', '1', '496');
INSERT INTO `population_structure_pre_data` VALUES ('394', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '93', '1', '428');
INSERT INTO `population_structure_pre_data` VALUES ('395', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '94', '1', '416');
INSERT INTO `population_structure_pre_data` VALUES ('396', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '95', '1', '251');
INSERT INTO `population_structure_pre_data` VALUES ('397', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '96', '1', '188');
INSERT INTO `population_structure_pre_data` VALUES ('398', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '97', '1', '182');
INSERT INTO `population_structure_pre_data` VALUES ('399', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '98', '1', '135');
INSERT INTO `population_structure_pre_data` VALUES ('400', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '99', '1', '124');
INSERT INTO `population_structure_pre_data` VALUES ('401', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '0', '1', '3056');
INSERT INTO `population_structure_pre_data` VALUES ('402', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '1', '1', '3012');
INSERT INTO `population_structure_pre_data` VALUES ('403', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '2', '1', '3046');
INSERT INTO `population_structure_pre_data` VALUES ('404', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '3', '1', '2956');
INSERT INTO `population_structure_pre_data` VALUES ('405', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '4', '1', '2946');
INSERT INTO `population_structure_pre_data` VALUES ('406', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '5', '1', '2915');
INSERT INTO `population_structure_pre_data` VALUES ('407', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '6', '1', '2888');
INSERT INTO `population_structure_pre_data` VALUES ('408', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '7', '1', '2894');
INSERT INTO `population_structure_pre_data` VALUES ('409', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '8', '1', '2853');
INSERT INTO `population_structure_pre_data` VALUES ('410', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '9', '1', '2846');
INSERT INTO `population_structure_pre_data` VALUES ('411', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '10', '1', '2759');
INSERT INTO `population_structure_pre_data` VALUES ('412', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '11', '1', '2761');
INSERT INTO `population_structure_pre_data` VALUES ('413', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '12', '1', '2596');
INSERT INTO `population_structure_pre_data` VALUES ('414', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '13', '1', '2649');
INSERT INTO `population_structure_pre_data` VALUES ('415', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '14', '1', '2596');
INSERT INTO `population_structure_pre_data` VALUES ('416', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '15', '1', '2468');
INSERT INTO `population_structure_pre_data` VALUES ('417', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '16', '1', '2398');
INSERT INTO `population_structure_pre_data` VALUES ('418', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '17', '1', '2309');
INSERT INTO `population_structure_pre_data` VALUES ('419', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '18', '1', '2286');
INSERT INTO `population_structure_pre_data` VALUES ('420', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '19', '1', '2246');
INSERT INTO `population_structure_pre_data` VALUES ('421', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '20', '1', '2398');
INSERT INTO `population_structure_pre_data` VALUES ('422', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '21', '1', '2468');
INSERT INTO `population_structure_pre_data` VALUES ('423', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '22', '1', '2689');
INSERT INTO `population_structure_pre_data` VALUES ('424', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '23', '1', '2848');
INSERT INTO `population_structure_pre_data` VALUES ('425', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '24', '1', '3046');
INSERT INTO `population_structure_pre_data` VALUES ('426', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '25', '1', '3456');
INSERT INTO `population_structure_pre_data` VALUES ('427', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '26', '1', '2984');
INSERT INTO `population_structure_pre_data` VALUES ('428', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '27', '1', '3459');
INSERT INTO `population_structure_pre_data` VALUES ('429', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '28', '1', '3049');
INSERT INTO `population_structure_pre_data` VALUES ('430', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '29', '1', '3291');
INSERT INTO `population_structure_pre_data` VALUES ('431', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '30', '1', '3019');
INSERT INTO `population_structure_pre_data` VALUES ('432', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '31', '1', '3772');
INSERT INTO `population_structure_pre_data` VALUES ('433', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '32', '1', '3639');
INSERT INTO `population_structure_pre_data` VALUES ('434', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '33', '1', '3528');
INSERT INTO `population_structure_pre_data` VALUES ('435', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '34', '1', '3182');
INSERT INTO `population_structure_pre_data` VALUES ('436', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '35', '1', '4516');
INSERT INTO `population_structure_pre_data` VALUES ('437', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '36', '1', '4282');
INSERT INTO `population_structure_pre_data` VALUES ('438', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '37', '1', '4016');
INSERT INTO `population_structure_pre_data` VALUES ('439', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '38', '1', '4056');
INSERT INTO `population_structure_pre_data` VALUES ('440', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '39', '1', '3849');
INSERT INTO `population_structure_pre_data` VALUES ('441', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '40', '1', '4589');
INSERT INTO `population_structure_pre_data` VALUES ('442', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '41', '1', '4228');
INSERT INTO `population_structure_pre_data` VALUES ('443', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '42', '1', '3981');
INSERT INTO `population_structure_pre_data` VALUES ('444', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '43', '1', '3689');
INSERT INTO `population_structure_pre_data` VALUES ('445', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '44', '1', '3159');
INSERT INTO `population_structure_pre_data` VALUES ('446', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '45', '1', '3892');
INSERT INTO `population_structure_pre_data` VALUES ('447', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '46', '1', '3591');
INSERT INTO `population_structure_pre_data` VALUES ('448', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '47', '1', '4068');
INSERT INTO `population_structure_pre_data` VALUES ('449', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '48', '1', '3359');
INSERT INTO `population_structure_pre_data` VALUES ('450', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '49', '1', '3891');
INSERT INTO `population_structure_pre_data` VALUES ('451', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '50', '1', '3891');
INSERT INTO `population_structure_pre_data` VALUES ('452', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '51', '1', '3165');
INSERT INTO `population_structure_pre_data` VALUES ('453', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '52', '1', '3090');
INSERT INTO `population_structure_pre_data` VALUES ('454', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '53', '1', '3603');
INSERT INTO `population_structure_pre_data` VALUES ('455', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '54', '1', '3873');
INSERT INTO `population_structure_pre_data` VALUES ('456', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '55', '1', '3478');
INSERT INTO `population_structure_pre_data` VALUES ('457', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '56', '1', '3901');
INSERT INTO `population_structure_pre_data` VALUES ('458', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '57', '1', '3264');
INSERT INTO `population_structure_pre_data` VALUES ('459', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '58', '1', '3649');
INSERT INTO `population_structure_pre_data` VALUES ('460', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '59', '1', '3713');
INSERT INTO `population_structure_pre_data` VALUES ('461', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '60', '1', '2317');
INSERT INTO `population_structure_pre_data` VALUES ('462', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '61', '1', '3347');
INSERT INTO `population_structure_pre_data` VALUES ('463', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '62', '1', '3208');
INSERT INTO `population_structure_pre_data` VALUES ('464', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '63', '1', '3251');
INSERT INTO `population_structure_pre_data` VALUES ('465', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '64', '1', '3220');
INSERT INTO `population_structure_pre_data` VALUES ('466', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '65', '1', '3503');
INSERT INTO `population_structure_pre_data` VALUES ('467', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '66', '1', '3814');
INSERT INTO `population_structure_pre_data` VALUES ('468', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '67', '1', '3383');
INSERT INTO `population_structure_pre_data` VALUES ('469', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '68', '1', '3081');
INSERT INTO `population_structure_pre_data` VALUES ('470', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '69', '1', '3519');
INSERT INTO `population_structure_pre_data` VALUES ('471', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '70', '1', '4045');
INSERT INTO `population_structure_pre_data` VALUES ('472', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '71', '1', '3777');
INSERT INTO `population_structure_pre_data` VALUES ('473', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '72', '1', '3874');
INSERT INTO `population_structure_pre_data` VALUES ('474', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '73', '1', '2798');
INSERT INTO `population_structure_pre_data` VALUES ('475', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '74', '1', '3288');
INSERT INTO `population_structure_pre_data` VALUES ('476', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '75', '1', '3298');
INSERT INTO `population_structure_pre_data` VALUES ('477', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '76', '1', '3057');
INSERT INTO `population_structure_pre_data` VALUES ('478', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '77', '1', '3195');
INSERT INTO `population_structure_pre_data` VALUES ('479', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '78', '1', '3402');
INSERT INTO `population_structure_pre_data` VALUES ('480', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '79', '1', '2303');
INSERT INTO `population_structure_pre_data` VALUES ('481', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '80', '1', '2917');
INSERT INTO `population_structure_pre_data` VALUES ('482', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '81', '1', '2015');
INSERT INTO `population_structure_pre_data` VALUES ('483', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '82', '1', '1976');
INSERT INTO `population_structure_pre_data` VALUES ('484', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '83', '1', '1927');
INSERT INTO `population_structure_pre_data` VALUES ('485', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '84', '1', '2088');
INSERT INTO `population_structure_pre_data` VALUES ('486', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '85', '1', '1997');
INSERT INTO `population_structure_pre_data` VALUES ('487', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '86', '1', '2171');
INSERT INTO `population_structure_pre_data` VALUES ('488', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '87', '1', '1839');
INSERT INTO `population_structure_pre_data` VALUES ('489', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '88', '1', '1891');
INSERT INTO `population_structure_pre_data` VALUES ('490', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '89', '1', '1400');
INSERT INTO `population_structure_pre_data` VALUES ('491', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '90', '1', '977');
INSERT INTO `population_structure_pre_data` VALUES ('492', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '91', '1', '883');
INSERT INTO `population_structure_pre_data` VALUES ('493', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '92', '1', '754');
INSERT INTO `population_structure_pre_data` VALUES ('494', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '93', '1', '643');
INSERT INTO `population_structure_pre_data` VALUES ('495', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '94', '1', '523');
INSERT INTO `population_structure_pre_data` VALUES ('496', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '95', '1', '381');
INSERT INTO `population_structure_pre_data` VALUES ('497', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '96', '1', '306');
INSERT INTO `population_structure_pre_data` VALUES ('498', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '97', '1', '209');
INSERT INTO `population_structure_pre_data` VALUES ('499', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '98', '1', '176');
INSERT INTO `population_structure_pre_data` VALUES ('500', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '99', '1', '166');
INSERT INTO `population_structure_pre_data` VALUES ('501', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '0', '1', '3298');
INSERT INTO `population_structure_pre_data` VALUES ('502', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '1', '1', '3245');
INSERT INTO `population_structure_pre_data` VALUES ('503', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '2', '1', '3210');
INSERT INTO `population_structure_pre_data` VALUES ('504', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '3', '1', '3195');
INSERT INTO `population_structure_pre_data` VALUES ('505', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '4', '1', '3142');
INSERT INTO `population_structure_pre_data` VALUES ('506', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '5', '1', '3089');
INSERT INTO `population_structure_pre_data` VALUES ('507', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '6', '1', '3016');
INSERT INTO `population_structure_pre_data` VALUES ('508', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '7', '1', '2998');
INSERT INTO `population_structure_pre_data` VALUES ('509', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '8', '1', '2945');
INSERT INTO `population_structure_pre_data` VALUES ('510', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '9', '1', '2916');
INSERT INTO `population_structure_pre_data` VALUES ('511', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '10', '1', '2984');
INSERT INTO `population_structure_pre_data` VALUES ('512', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '11', '1', '2895');
INSERT INTO `population_structure_pre_data` VALUES ('513', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '12', '1', '2810');
INSERT INTO `population_structure_pre_data` VALUES ('514', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '13', '1', '2749');
INSERT INTO `population_structure_pre_data` VALUES ('515', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '14', '1', '2701');
INSERT INTO `population_structure_pre_data` VALUES ('516', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '15', '1', '2688');
INSERT INTO `population_structure_pre_data` VALUES ('517', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '16', '1', '2619');
INSERT INTO `population_structure_pre_data` VALUES ('518', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '17', '1', '2588');
INSERT INTO `population_structure_pre_data` VALUES ('519', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '18', '1', '2537');
INSERT INTO `population_structure_pre_data` VALUES ('520', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '19', '1', '2501');
INSERT INTO `population_structure_pre_data` VALUES ('521', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '20', '1', '2489');
INSERT INTO `population_structure_pre_data` VALUES ('522', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '21', '1', '2456');
INSERT INTO `population_structure_pre_data` VALUES ('523', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '22', '1', '2389');
INSERT INTO `population_structure_pre_data` VALUES ('524', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '23', '1', '2356');
INSERT INTO `population_structure_pre_data` VALUES ('525', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '24', '1', '2396');
INSERT INTO `population_structure_pre_data` VALUES ('526', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '25', '1', '2459');
INSERT INTO `population_structure_pre_data` VALUES ('527', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '26', '1', '2550');
INSERT INTO `population_structure_pre_data` VALUES ('528', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '27', '1', '2689');
INSERT INTO `population_structure_pre_data` VALUES ('529', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '28', '1', '2879');
INSERT INTO `population_structure_pre_data` VALUES ('530', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '29', '1', '3046');
INSERT INTO `population_structure_pre_data` VALUES ('531', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '30', '1', '3218');
INSERT INTO `population_structure_pre_data` VALUES ('532', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '31', '1', '3019');
INSERT INTO `population_structure_pre_data` VALUES ('533', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '32', '1', '3156');
INSERT INTO `population_structure_pre_data` VALUES ('534', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '33', '1', '3333');
INSERT INTO `population_structure_pre_data` VALUES ('535', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '34', '1', '3156');
INSERT INTO `population_structure_pre_data` VALUES ('536', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '35', '1', '3563');
INSERT INTO `population_structure_pre_data` VALUES ('537', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '36', '1', '3691');
INSERT INTO `population_structure_pre_data` VALUES ('538', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '37', '1', '3891');
INSERT INTO `population_structure_pre_data` VALUES ('539', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '38', '1', '4059');
INSERT INTO `population_structure_pre_data` VALUES ('540', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '39', '1', '4256');
INSERT INTO `population_structure_pre_data` VALUES ('541', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '40', '1', '4895');
INSERT INTO `population_structure_pre_data` VALUES ('542', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '41', '1', '5162');
INSERT INTO `population_structure_pre_data` VALUES ('543', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '42', '1', '4510');
INSERT INTO `population_structure_pre_data` VALUES ('544', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '43', '1', '3981');
INSERT INTO `population_structure_pre_data` VALUES ('545', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '44', '1', '3462');
INSERT INTO `population_structure_pre_data` VALUES ('546', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '45', '1', '4089');
INSERT INTO `population_structure_pre_data` VALUES ('547', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '46', '1', '3489');
INSERT INTO `population_structure_pre_data` VALUES ('548', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '47', '1', '3951');
INSERT INTO `population_structure_pre_data` VALUES ('549', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '48', '1', '4385');
INSERT INTO `population_structure_pre_data` VALUES ('550', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '49', '1', '3656');
INSERT INTO `population_structure_pre_data` VALUES ('551', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '50', '1', '3978');
INSERT INTO `population_structure_pre_data` VALUES ('552', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '51', '1', '3515');
INSERT INTO `population_structure_pre_data` VALUES ('553', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '52', '1', '3992');
INSERT INTO `population_structure_pre_data` VALUES ('554', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '53', '1', '4146');
INSERT INTO `population_structure_pre_data` VALUES ('555', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '54', '1', '4724');
INSERT INTO `population_structure_pre_data` VALUES ('556', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '55', '1', '3597');
INSERT INTO `population_structure_pre_data` VALUES ('557', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '56', '1', '3726');
INSERT INTO `population_structure_pre_data` VALUES ('558', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '57', '1', '3537');
INSERT INTO `population_structure_pre_data` VALUES ('559', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '58', '1', '3539');
INSERT INTO `population_structure_pre_data` VALUES ('560', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '59', '1', '3798');
INSERT INTO `population_structure_pre_data` VALUES ('561', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '60', '1', '3408');
INSERT INTO `population_structure_pre_data` VALUES ('562', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '61', '1', '2856');
INSERT INTO `population_structure_pre_data` VALUES ('563', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '62', '1', '2207');
INSERT INTO `population_structure_pre_data` VALUES ('564', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '63', '1', '3545');
INSERT INTO `population_structure_pre_data` VALUES ('565', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '64', '1', '3598');
INSERT INTO `population_structure_pre_data` VALUES ('566', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '65', '1', '2237');
INSERT INTO `population_structure_pre_data` VALUES ('567', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '66', '1', '3218');
INSERT INTO `population_structure_pre_data` VALUES ('568', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '67', '1', '3070');
INSERT INTO `population_structure_pre_data` VALUES ('569', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '68', '1', '3097');
INSERT INTO `population_structure_pre_data` VALUES ('570', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '69', '1', '3052');
INSERT INTO `population_structure_pre_data` VALUES ('571', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '70', '1', '3305');
INSERT INTO `population_structure_pre_data` VALUES ('572', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '71', '1', '3571');
INSERT INTO `population_structure_pre_data` VALUES ('573', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '72', '1', '3142');
INSERT INTO `population_structure_pre_data` VALUES ('574', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '73', '1', '2838');
INSERT INTO `population_structure_pre_data` VALUES ('575', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '74', '1', '3215');
INSERT INTO `population_structure_pre_data` VALUES ('576', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '75', '1', '3668');
INSERT INTO `population_structure_pre_data` VALUES ('577', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '76', '1', '3372');
INSERT INTO `population_structure_pre_data` VALUES ('578', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '77', '1', '3405');
INSERT INTO `population_structure_pre_data` VALUES ('579', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '78', '1', '2421');
INSERT INTO `population_structure_pre_data` VALUES ('580', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '79', '1', '2801');
INSERT INTO `population_structure_pre_data` VALUES ('581', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '80', '1', '2766');
INSERT INTO `population_structure_pre_data` VALUES ('582', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '81', '1', '2507');
INSERT INTO `population_structure_pre_data` VALUES ('583', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '82', '1', '3366');
INSERT INTO `population_structure_pre_data` VALUES ('584', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '83', '1', '2669');
INSERT INTO `population_structure_pre_data` VALUES ('585', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '84', '1', '1000');
INSERT INTO `population_structure_pre_data` VALUES ('586', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '85', '1', '1439');
INSERT INTO `population_structure_pre_data` VALUES ('587', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '86', '1', '1239');
INSERT INTO `population_structure_pre_data` VALUES ('588', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '87', '1', '1376');
INSERT INTO `population_structure_pre_data` VALUES ('589', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '88', '1', '1290');
INSERT INTO `population_structure_pre_data` VALUES ('590', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '89', '1', '1347');
INSERT INTO `population_structure_pre_data` VALUES ('591', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '90', '1', '1241');
INSERT INTO `population_structure_pre_data` VALUES ('592', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '91', '1', '1268');
INSERT INTO `population_structure_pre_data` VALUES ('593', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '92', '1', '1009');
INSERT INTO `population_structure_pre_data` VALUES ('594', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '93', '1', '976');
INSERT INTO `population_structure_pre_data` VALUES ('595', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '94', '1', '679');
INSERT INTO `population_structure_pre_data` VALUES ('596', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '95', '1', '444');
INSERT INTO `population_structure_pre_data` VALUES ('597', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '96', '1', '393');
INSERT INTO `population_structure_pre_data` VALUES ('598', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '97', '1', '327');
INSERT INTO `population_structure_pre_data` VALUES ('599', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '98', '1', '272');
INSERT INTO `population_structure_pre_data` VALUES ('600', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '99', '1', '216');
INSERT INTO `population_structure_pre_data` VALUES ('601', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '0', '1', '20');
INSERT INTO `population_structure_pre_data` VALUES ('602', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '1', '1', '1450');
INSERT INTO `population_structure_pre_data` VALUES ('603', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '2', '1', '1664');
INSERT INTO `population_structure_pre_data` VALUES ('604', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '3', '1', '1904');
INSERT INTO `population_structure_pre_data` VALUES ('605', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '4', '1', '1612');
INSERT INTO `population_structure_pre_data` VALUES ('606', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '5', '1', '1588');
INSERT INTO `population_structure_pre_data` VALUES ('607', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '6', '1', '1434');
INSERT INTO `population_structure_pre_data` VALUES ('608', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '7', '1', '1331');
INSERT INTO `population_structure_pre_data` VALUES ('609', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '8', '1', '1490');
INSERT INTO `population_structure_pre_data` VALUES ('610', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '9', '1', '1406');
INSERT INTO `population_structure_pre_data` VALUES ('611', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '10', '1', '1561');
INSERT INTO `population_structure_pre_data` VALUES ('612', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '11', '1', '1766');
INSERT INTO `population_structure_pre_data` VALUES ('613', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '12', '1', '1405');
INSERT INTO `population_structure_pre_data` VALUES ('614', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '13', '1', '1658');
INSERT INTO `population_structure_pre_data` VALUES ('615', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '14', '1', '1689');
INSERT INTO `population_structure_pre_data` VALUES ('616', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '15', '1', '1814');
INSERT INTO `population_structure_pre_data` VALUES ('617', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '16', '1', '1739');
INSERT INTO `population_structure_pre_data` VALUES ('618', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '17', '1', '1886');
INSERT INTO `population_structure_pre_data` VALUES ('619', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '18', '1', '2011');
INSERT INTO `population_structure_pre_data` VALUES ('620', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '19', '1', '2071');
INSERT INTO `population_structure_pre_data` VALUES ('621', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '20', '1', '2020');
INSERT INTO `population_structure_pre_data` VALUES ('622', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '21', '1', '2238');
INSERT INTO `population_structure_pre_data` VALUES ('623', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '22', '1', '2339');
INSERT INTO `population_structure_pre_data` VALUES ('624', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '23', '1', '2349');
INSERT INTO `population_structure_pre_data` VALUES ('625', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '24', '1', '2359');
INSERT INTO `population_structure_pre_data` VALUES ('626', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '25', '1', '2767');
INSERT INTO `population_structure_pre_data` VALUES ('627', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '26', '1', '2966');
INSERT INTO `population_structure_pre_data` VALUES ('628', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '27', '1', '3070');
INSERT INTO `population_structure_pre_data` VALUES ('629', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '28', '1', '3684');
INSERT INTO `population_structure_pre_data` VALUES ('630', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '29', '1', '3817');
INSERT INTO `population_structure_pre_data` VALUES ('631', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '30', '1', '3396');
INSERT INTO `population_structure_pre_data` VALUES ('632', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '31', '1', '1739');
INSERT INTO `population_structure_pre_data` VALUES ('633', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '32', '1', '2145');
INSERT INTO `population_structure_pre_data` VALUES ('634', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '33', '1', '3762');
INSERT INTO `population_structure_pre_data` VALUES ('635', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '34', '1', '3916');
INSERT INTO `population_structure_pre_data` VALUES ('636', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '35', '1', '2589');
INSERT INTO `population_structure_pre_data` VALUES ('637', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '36', '1', '3694');
INSERT INTO `population_structure_pre_data` VALUES ('638', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '37', '1', '3493');
INSERT INTO `population_structure_pre_data` VALUES ('639', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '38', '1', '3425');
INSERT INTO `population_structure_pre_data` VALUES ('640', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '39', '1', '3347');
INSERT INTO `population_structure_pre_data` VALUES ('641', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '40', '1', '3597');
INSERT INTO `population_structure_pre_data` VALUES ('642', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '41', '1', '4095');
INSERT INTO `population_structure_pre_data` VALUES ('643', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '42', '1', '3774');
INSERT INTO `population_structure_pre_data` VALUES ('644', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '43', '1', '3345');
INSERT INTO `population_structure_pre_data` VALUES ('645', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '44', '1', '4006');
INSERT INTO `population_structure_pre_data` VALUES ('646', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '45', '1', '4721');
INSERT INTO `population_structure_pre_data` VALUES ('647', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '46', '1', '4470');
INSERT INTO `population_structure_pre_data` VALUES ('648', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '47', '1', '4837');
INSERT INTO `population_structure_pre_data` VALUES ('649', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '48', '1', '3585');
INSERT INTO `population_structure_pre_data` VALUES ('650', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '49', '1', '4375');
INSERT INTO `population_structure_pre_data` VALUES ('651', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '50', '1', '4341');
INSERT INTO `population_structure_pre_data` VALUES ('652', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '51', '1', '4327');
INSERT INTO `population_structure_pre_data` VALUES ('653', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '52', '1', '5926');
INSERT INTO `population_structure_pre_data` VALUES ('654', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '53', '1', '4938');
INSERT INTO `population_structure_pre_data` VALUES ('655', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '54', '1', '2103');
INSERT INTO `population_structure_pre_data` VALUES ('656', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '55', '1', '3217');
INSERT INTO `population_structure_pre_data` VALUES ('657', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '56', '1', '3098');
INSERT INTO `population_structure_pre_data` VALUES ('658', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '57', '1', '3795');
INSERT INTO `population_structure_pre_data` VALUES ('659', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '58', '1', '3992');
INSERT INTO `population_structure_pre_data` VALUES ('660', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '59', '1', '4374');
INSERT INTO `population_structure_pre_data` VALUES ('661', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '60', '1', '4499');
INSERT INTO `population_structure_pre_data` VALUES ('662', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '61', '1', '5514');
INSERT INTO `population_structure_pre_data` VALUES ('663', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '62', '1', '4937');
INSERT INTO `population_structure_pre_data` VALUES ('664', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '63', '1', '5720');
INSERT INTO `population_structure_pre_data` VALUES ('665', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '64', '1', '4594');
INSERT INTO `population_structure_pre_data` VALUES ('666', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '65', '1', '3568');
INSERT INTO `population_structure_pre_data` VALUES ('667', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '66', '1', '3743');
INSERT INTO `population_structure_pre_data` VALUES ('668', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '67', '1', '3537');
INSERT INTO `population_structure_pre_data` VALUES ('669', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '68', '1', '3368');
INSERT INTO `population_structure_pre_data` VALUES ('670', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '69', '1', '3670');
INSERT INTO `population_structure_pre_data` VALUES ('671', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '70', '1', '3168');
INSERT INTO `population_structure_pre_data` VALUES ('672', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '71', '1', '2885');
INSERT INTO `population_structure_pre_data` VALUES ('673', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '72', '1', '2455');
INSERT INTO `population_structure_pre_data` VALUES ('674', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '73', '1', '2286');
INSERT INTO `population_structure_pre_data` VALUES ('675', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '74', '1', '2019');
INSERT INTO `population_structure_pre_data` VALUES ('676', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '75', '1', '1824');
INSERT INTO `population_structure_pre_data` VALUES ('677', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '76', '1', '1749');
INSERT INTO `population_structure_pre_data` VALUES ('678', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '77', '1', '1596');
INSERT INTO `population_structure_pre_data` VALUES ('679', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '78', '1', '1260');
INSERT INTO `population_structure_pre_data` VALUES ('680', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '79', '1', '1155');
INSERT INTO `population_structure_pre_data` VALUES ('681', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '80', '1', '1075');
INSERT INTO `population_structure_pre_data` VALUES ('682', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '81', '1', '1078');
INSERT INTO `population_structure_pre_data` VALUES ('683', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '82', '1', '1168');
INSERT INTO `population_structure_pre_data` VALUES ('684', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '83', '1', '1216');
INSERT INTO `population_structure_pre_data` VALUES ('685', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '84', '1', '1146');
INSERT INTO `population_structure_pre_data` VALUES ('686', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '85', '1', '1186');
INSERT INTO `population_structure_pre_data` VALUES ('687', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '86', '1', '1027');
INSERT INTO `population_structure_pre_data` VALUES ('688', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '87', '1', '1090');
INSERT INTO `population_structure_pre_data` VALUES ('689', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '88', '1', '878');
INSERT INTO `population_structure_pre_data` VALUES ('690', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '89', '1', '780');
INSERT INTO `population_structure_pre_data` VALUES ('691', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '90', '1', '745');
INSERT INTO `population_structure_pre_data` VALUES ('692', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '91', '1', '562');
INSERT INTO `population_structure_pre_data` VALUES ('693', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '92', '1', '527');
INSERT INTO `population_structure_pre_data` VALUES ('694', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '93', '1', '529');
INSERT INTO `population_structure_pre_data` VALUES ('695', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '94', '1', '442');
INSERT INTO `population_structure_pre_data` VALUES ('696', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '95', '1', '434');
INSERT INTO `population_structure_pre_data` VALUES ('697', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '96', '1', '316');
INSERT INTO `population_structure_pre_data` VALUES ('698', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '97', '1', '364');
INSERT INTO `population_structure_pre_data` VALUES ('699', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '98', '1', '391');
INSERT INTO `population_structure_pre_data` VALUES ('700', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '99', '1', '221');
INSERT INTO `population_structure_pre_data` VALUES ('701', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '0', '2', '19');
INSERT INTO `population_structure_pre_data` VALUES ('702', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '1', '2', '1437');
INSERT INTO `population_structure_pre_data` VALUES ('703', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '2', '2', '1546');
INSERT INTO `population_structure_pre_data` VALUES ('704', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '3', '2', '1852');
INSERT INTO `population_structure_pre_data` VALUES ('705', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '4', '2', '1596');
INSERT INTO `population_structure_pre_data` VALUES ('706', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '5', '2', '1517');
INSERT INTO `population_structure_pre_data` VALUES ('707', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '6', '2', '1425');
INSERT INTO `population_structure_pre_data` VALUES ('708', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '7', '2', '1377');
INSERT INTO `population_structure_pre_data` VALUES ('709', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '8', '2', '1379');
INSERT INTO `population_structure_pre_data` VALUES ('710', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '9', '2', '1338');
INSERT INTO `population_structure_pre_data` VALUES ('711', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '10', '2', '1485');
INSERT INTO `population_structure_pre_data` VALUES ('712', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '11', '2', '1752');
INSERT INTO `population_structure_pre_data` VALUES ('713', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '12', '2', '1364');
INSERT INTO `population_structure_pre_data` VALUES ('714', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '13', '2', '1586');
INSERT INTO `population_structure_pre_data` VALUES ('715', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '14', '2', '1520');
INSERT INTO `population_structure_pre_data` VALUES ('716', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '15', '2', '1876');
INSERT INTO `population_structure_pre_data` VALUES ('717', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '16', '2', '1697');
INSERT INTO `population_structure_pre_data` VALUES ('718', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '17', '2', '1808');
INSERT INTO `population_structure_pre_data` VALUES ('719', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '18', '2', '1961');
INSERT INTO `population_structure_pre_data` VALUES ('720', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '19', '2', '1945');
INSERT INTO `population_structure_pre_data` VALUES ('721', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '20', '2', '2010');
INSERT INTO `population_structure_pre_data` VALUES ('722', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '21', '2', '2149');
INSERT INTO `population_structure_pre_data` VALUES ('723', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '22', '2', '2206');
INSERT INTO `population_structure_pre_data` VALUES ('724', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '23', '2', '2368');
INSERT INTO `population_structure_pre_data` VALUES ('725', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '24', '2', '2572');
INSERT INTO `population_structure_pre_data` VALUES ('726', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '25', '2', '2936');
INSERT INTO `population_structure_pre_data` VALUES ('727', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '26', '2', '3155');
INSERT INTO `population_structure_pre_data` VALUES ('728', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '27', '2', '3581');
INSERT INTO `population_structure_pre_data` VALUES ('729', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '28', '2', '4113');
INSERT INTO `population_structure_pre_data` VALUES ('730', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '29', '2', '4296');
INSERT INTO `population_structure_pre_data` VALUES ('731', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '30', '2', '3852');
INSERT INTO `population_structure_pre_data` VALUES ('732', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '31', '2', '2162');
INSERT INTO `population_structure_pre_data` VALUES ('733', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '32', '2', '2647');
INSERT INTO `population_structure_pre_data` VALUES ('734', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '33', '2', '4232');
INSERT INTO `population_structure_pre_data` VALUES ('735', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '34', '2', '4470');
INSERT INTO `population_structure_pre_data` VALUES ('736', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '35', '2', '2851');
INSERT INTO `population_structure_pre_data` VALUES ('737', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '36', '2', '4186');
INSERT INTO `population_structure_pre_data` VALUES ('738', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '37', '2', '3834');
INSERT INTO `population_structure_pre_data` VALUES ('739', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '38', '2', '3871');
INSERT INTO `population_structure_pre_data` VALUES ('740', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '39', '2', '3802');
INSERT INTO `population_structure_pre_data` VALUES ('741', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '40', '2', '4059');
INSERT INTO `population_structure_pre_data` VALUES ('742', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '41', '2', '4431');
INSERT INTO `population_structure_pre_data` VALUES ('743', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '42', '2', '3983');
INSERT INTO `population_structure_pre_data` VALUES ('744', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '43', '2', '3684');
INSERT INTO `population_structure_pre_data` VALUES ('745', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '44', '2', '4227');
INSERT INTO `population_structure_pre_data` VALUES ('746', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '45', '2', '4908');
INSERT INTO `population_structure_pre_data` VALUES ('747', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '46', '2', '4654');
INSERT INTO `population_structure_pre_data` VALUES ('748', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '47', '2', '4832');
INSERT INTO `population_structure_pre_data` VALUES ('749', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '48', '2', '3571');
INSERT INTO `population_structure_pre_data` VALUES ('750', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '49', '2', '4276');
INSERT INTO `population_structure_pre_data` VALUES ('751', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '50', '2', '4369');
INSERT INTO `population_structure_pre_data` VALUES ('752', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '51', '2', '4194');
INSERT INTO `population_structure_pre_data` VALUES ('753', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '52', '2', '5930');
INSERT INTO `population_structure_pre_data` VALUES ('754', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '53', '2', '4967');
INSERT INTO `population_structure_pre_data` VALUES ('755', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '54', '2', '1983');
INSERT INTO `population_structure_pre_data` VALUES ('756', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '55', '2', '3017');
INSERT INTO `population_structure_pre_data` VALUES ('757', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '56', '2', '2892');
INSERT INTO `population_structure_pre_data` VALUES ('758', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '57', '2', '3533');
INSERT INTO `population_structure_pre_data` VALUES ('759', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '58', '2', '3663');
INSERT INTO `population_structure_pre_data` VALUES ('760', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '59', '2', '4217');
INSERT INTO `population_structure_pre_data` VALUES ('761', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '60', '2', '4292');
INSERT INTO `population_structure_pre_data` VALUES ('762', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '61', '2', '5209');
INSERT INTO `population_structure_pre_data` VALUES ('763', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '62', '2', '4971');
INSERT INTO `population_structure_pre_data` VALUES ('764', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '63', '2', '5642');
INSERT INTO `population_structure_pre_data` VALUES ('765', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '64', '2', '4657');
INSERT INTO `population_structure_pre_data` VALUES ('766', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '65', '2', '3567');
INSERT INTO `population_structure_pre_data` VALUES ('767', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '66', '2', '3796');
INSERT INTO `population_structure_pre_data` VALUES ('768', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '67', '2', '3780');
INSERT INTO `population_structure_pre_data` VALUES ('769', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '68', '2', '3763');
INSERT INTO `population_structure_pre_data` VALUES ('770', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '69', '2', '3601');
INSERT INTO `population_structure_pre_data` VALUES ('771', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '70', '2', '3097');
INSERT INTO `population_structure_pre_data` VALUES ('772', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '71', '2', '2744');
INSERT INTO `population_structure_pre_data` VALUES ('773', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '72', '2', '2408');
INSERT INTO `population_structure_pre_data` VALUES ('774', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '73', '2', '2196');
INSERT INTO `population_structure_pre_data` VALUES ('775', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '74', '2', '2030');
INSERT INTO `population_structure_pre_data` VALUES ('776', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '75', '2', '1775');
INSERT INTO `population_structure_pre_data` VALUES ('777', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '76', '2', '1657');
INSERT INTO `population_structure_pre_data` VALUES ('778', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '77', '2', '1470');
INSERT INTO `population_structure_pre_data` VALUES ('779', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '78', '2', '1236');
INSERT INTO `population_structure_pre_data` VALUES ('780', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '79', '2', '1178');
INSERT INTO `population_structure_pre_data` VALUES ('781', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '80', '2', '1047');
INSERT INTO `population_structure_pre_data` VALUES ('782', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '81', '2', '1050');
INSERT INTO `population_structure_pre_data` VALUES ('783', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '82', '2', '1069');
INSERT INTO `population_structure_pre_data` VALUES ('784', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '83', '2', '1153');
INSERT INTO `population_structure_pre_data` VALUES ('785', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '84', '2', '1067');
INSERT INTO `population_structure_pre_data` VALUES ('786', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '85', '2', '1091');
INSERT INTO `population_structure_pre_data` VALUES ('787', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '86', '2', '910');
INSERT INTO `population_structure_pre_data` VALUES ('788', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '87', '2', '869');
INSERT INTO `population_structure_pre_data` VALUES ('789', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '88', '2', '811');
INSERT INTO `population_structure_pre_data` VALUES ('790', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '89', '2', '890');
INSERT INTO `population_structure_pre_data` VALUES ('791', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '90', '2', '743');
INSERT INTO `population_structure_pre_data` VALUES ('792', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '91', '2', '654');
INSERT INTO `population_structure_pre_data` VALUES ('793', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '92', '2', '698');
INSERT INTO `population_structure_pre_data` VALUES ('794', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '93', '2', '577');
INSERT INTO `population_structure_pre_data` VALUES ('795', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '94', '2', '544');
INSERT INTO `population_structure_pre_data` VALUES ('796', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '95', '2', '559');
INSERT INTO `population_structure_pre_data` VALUES ('797', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '96', '2', '545');
INSERT INTO `population_structure_pre_data` VALUES ('798', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '97', '2', '346');
INSERT INTO `population_structure_pre_data` VALUES ('799', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '98', '2', '231');
INSERT INTO `population_structure_pre_data` VALUES ('800', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2015', '99', '2', '164');
INSERT INTO `population_structure_pre_data` VALUES ('801', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '0', '2', '1796');
INSERT INTO `population_structure_pre_data` VALUES ('802', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '1', '2', '1688');
INSERT INTO `population_structure_pre_data` VALUES ('803', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '2', '2', '1688');
INSERT INTO `population_structure_pre_data` VALUES ('804', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '3', '2', '1903');
INSERT INTO `population_structure_pre_data` VALUES ('805', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '4', '2', '1599');
INSERT INTO `population_structure_pre_data` VALUES ('806', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '5', '2', '1576');
INSERT INTO `population_structure_pre_data` VALUES ('807', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '6', '2', '1424');
INSERT INTO `population_structure_pre_data` VALUES ('808', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '7', '2', '1317');
INSERT INTO `population_structure_pre_data` VALUES ('809', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '8', '2', '1472');
INSERT INTO `population_structure_pre_data` VALUES ('810', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '9', '2', '1384');
INSERT INTO `population_structure_pre_data` VALUES ('811', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '10', '2', '1566');
INSERT INTO `population_structure_pre_data` VALUES ('812', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '11', '2', '1735');
INSERT INTO `population_structure_pre_data` VALUES ('813', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '12', '2', '1371');
INSERT INTO `population_structure_pre_data` VALUES ('814', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '13', '2', '1618');
INSERT INTO `population_structure_pre_data` VALUES ('815', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '14', '2', '1376');
INSERT INTO `population_structure_pre_data` VALUES ('816', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '15', '2', '1531');
INSERT INTO `population_structure_pre_data` VALUES ('817', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '16', '2', '1728');
INSERT INTO `population_structure_pre_data` VALUES ('818', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '17', '2', '1364');
INSERT INTO `population_structure_pre_data` VALUES ('819', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '18', '2', '1611');
INSERT INTO `population_structure_pre_data` VALUES ('820', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '19', '2', '1635');
INSERT INTO `population_structure_pre_data` VALUES ('821', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '20', '2', '1736');
INSERT INTO `population_structure_pre_data` VALUES ('822', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '21', '2', '1665');
INSERT INTO `population_structure_pre_data` VALUES ('823', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '22', '2', '1818');
INSERT INTO `population_structure_pre_data` VALUES ('824', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '23', '2', '1926');
INSERT INTO `population_structure_pre_data` VALUES ('825', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '24', '2', '1939');
INSERT INTO `population_structure_pre_data` VALUES ('826', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '25', '2', '1840');
INSERT INTO `population_structure_pre_data` VALUES ('827', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '26', '2', '2056');
INSERT INTO `population_structure_pre_data` VALUES ('828', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '27', '2', '2169');
INSERT INTO `population_structure_pre_data` VALUES ('829', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '28', '2', '2208');
INSERT INTO `population_structure_pre_data` VALUES ('830', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '29', '2', '2207');
INSERT INTO `population_structure_pre_data` VALUES ('831', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '30', '2', '2496');
INSERT INTO `population_structure_pre_data` VALUES ('832', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '31', '2', '2617');
INSERT INTO `population_structure_pre_data` VALUES ('833', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '32', '2', '2685');
INSERT INTO `population_structure_pre_data` VALUES ('834', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '33', '2', '3286');
INSERT INTO `population_structure_pre_data` VALUES ('835', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '34', '2', '3538');
INSERT INTO `population_structure_pre_data` VALUES ('836', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '35', '2', '3126');
INSERT INTO `population_structure_pre_data` VALUES ('837', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '36', '2', '3542');
INSERT INTO `population_structure_pre_data` VALUES ('838', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '37', '2', '3860');
INSERT INTO `population_structure_pre_data` VALUES ('839', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '38', '2', '3383');
INSERT INTO `population_structure_pre_data` VALUES ('840', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '39', '2', '3434');
INSERT INTO `population_structure_pre_data` VALUES ('841', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '40', '2', '2265');
INSERT INTO `population_structure_pre_data` VALUES ('842', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '41', '2', '3190');
INSERT INTO `population_structure_pre_data` VALUES ('843', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '42', '2', '3151');
INSERT INTO `population_structure_pre_data` VALUES ('844', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '43', '2', '3110');
INSERT INTO `population_structure_pre_data` VALUES ('845', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '44', '2', '3068');
INSERT INTO `population_structure_pre_data` VALUES ('846', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '45', '2', '3395');
INSERT INTO `population_structure_pre_data` VALUES ('847', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '46', '2', '3888');
INSERT INTO `population_structure_pre_data` VALUES ('848', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '47', '2', '3604');
INSERT INTO `population_structure_pre_data` VALUES ('849', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '48', '2', '3170');
INSERT INTO `population_structure_pre_data` VALUES ('850', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '49', '2', '3787');
INSERT INTO `population_structure_pre_data` VALUES ('851', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '50', '2', '4511');
INSERT INTO `population_structure_pre_data` VALUES ('852', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '51', '2', '4236');
INSERT INTO `population_structure_pre_data` VALUES ('853', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '52', '2', '4590');
INSERT INTO `population_structure_pre_data` VALUES ('854', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '53', '2', '3409');
INSERT INTO `population_structure_pre_data` VALUES ('855', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '54', '2', '4138');
INSERT INTO `population_structure_pre_data` VALUES ('856', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '55', '2', '4112');
INSERT INTO `population_structure_pre_data` VALUES ('857', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '56', '2', '4072');
INSERT INTO `population_structure_pre_data` VALUES ('858', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '57', '2', '5549');
INSERT INTO `population_structure_pre_data` VALUES ('859', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '58', '2', '4620');
INSERT INTO `population_structure_pre_data` VALUES ('860', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '59', '2', '3947');
INSERT INTO `population_structure_pre_data` VALUES ('861', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '60', '2', '2946');
INSERT INTO `population_structure_pre_data` VALUES ('862', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '61', '2', '2823');
INSERT INTO `population_structure_pre_data` VALUES ('863', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '62', '2', '3471');
INSERT INTO `population_structure_pre_data` VALUES ('864', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '63', '2', '3592');
INSERT INTO `population_structure_pre_data` VALUES ('865', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '64', '2', '3909');
INSERT INTO `population_structure_pre_data` VALUES ('866', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '65', '2', '4007');
INSERT INTO `population_structure_pre_data` VALUES ('867', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '66', '2', '4813');
INSERT INTO `population_structure_pre_data` VALUES ('868', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '67', '2', '4240');
INSERT INTO `population_structure_pre_data` VALUES ('869', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '68', '2', '4824');
INSERT INTO `population_structure_pre_data` VALUES ('870', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '69', '2', '3798');
INSERT INTO `population_structure_pre_data` VALUES ('871', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '70', '2', '2946');
INSERT INTO `population_structure_pre_data` VALUES ('872', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '71', '2', '2939');
INSERT INTO `population_structure_pre_data` VALUES ('873', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '72', '2', '2749');
INSERT INTO `population_structure_pre_data` VALUES ('874', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '73', '2', '2813');
INSERT INTO `population_structure_pre_data` VALUES ('875', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '74', '2', '2773');
INSERT INTO `population_structure_pre_data` VALUES ('876', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '75', '2', '2330');
INSERT INTO `population_structure_pre_data` VALUES ('877', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '76', '2', '2138');
INSERT INTO `population_structure_pre_data` VALUES ('878', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '77', '2', '1756');
INSERT INTO `population_structure_pre_data` VALUES ('879', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '78', '2', '1724');
INSERT INTO `population_structure_pre_data` VALUES ('880', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '79', '2', '1703');
INSERT INTO `population_structure_pre_data` VALUES ('881', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '80', '2', '1590');
INSERT INTO `population_structure_pre_data` VALUES ('882', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '81', '2', '1286');
INSERT INTO `population_structure_pre_data` VALUES ('883', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '82', '2', '1213');
INSERT INTO `population_structure_pre_data` VALUES ('884', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '83', '2', '1180');
INSERT INTO `population_structure_pre_data` VALUES ('885', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '84', '2', '1053');
INSERT INTO `population_structure_pre_data` VALUES ('886', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '85', '2', '1064');
INSERT INTO `population_structure_pre_data` VALUES ('887', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '86', '2', '980');
INSERT INTO `population_structure_pre_data` VALUES ('888', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '87', '2', '898');
INSERT INTO `population_structure_pre_data` VALUES ('889', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '88', '2', '835');
INSERT INTO `population_structure_pre_data` VALUES ('890', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '89', '2', '853');
INSERT INTO `population_structure_pre_data` VALUES ('891', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '90', '2', '833');
INSERT INTO `population_structure_pre_data` VALUES ('892', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '91', '2', '818');
INSERT INTO `population_structure_pre_data` VALUES ('893', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '92', '2', '778');
INSERT INTO `population_structure_pre_data` VALUES ('894', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '93', '2', '571');
INSERT INTO `population_structure_pre_data` VALUES ('895', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '94', '2', '623');
INSERT INTO `population_structure_pre_data` VALUES ('896', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '95', '2', '583');
INSERT INTO `population_structure_pre_data` VALUES ('897', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '96', '2', '557');
INSERT INTO `population_structure_pre_data` VALUES ('898', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '97', '2', '344');
INSERT INTO `population_structure_pre_data` VALUES ('899', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '98', '2', '328');
INSERT INTO `population_structure_pre_data` VALUES ('900', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2020', '99', '2', '121');
INSERT INTO `population_structure_pre_data` VALUES ('901', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '0', '2', '2296');
INSERT INTO `population_structure_pre_data` VALUES ('902', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '1', '2', '2088');
INSERT INTO `population_structure_pre_data` VALUES ('903', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '2', '2', '1988');
INSERT INTO `population_structure_pre_data` VALUES ('904', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '3', '2', '2003');
INSERT INTO `population_structure_pre_data` VALUES ('905', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '4', '2', '1999');
INSERT INTO `population_structure_pre_data` VALUES ('906', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '5', '2', '1776');
INSERT INTO `population_structure_pre_data` VALUES ('907', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '6', '2', '1624');
INSERT INTO `population_structure_pre_data` VALUES ('908', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '7', '2', '1617');
INSERT INTO `population_structure_pre_data` VALUES ('909', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '8', '2', '1572');
INSERT INTO `population_structure_pre_data` VALUES ('910', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '9', '2', '1584');
INSERT INTO `population_structure_pre_data` VALUES ('911', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '10', '2', '1536');
INSERT INTO `population_structure_pre_data` VALUES ('912', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '11', '2', '1735');
INSERT INTO `population_structure_pre_data` VALUES ('913', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '12', '2', '1671');
INSERT INTO `population_structure_pre_data` VALUES ('914', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '13', '2', '1618');
INSERT INTO `population_structure_pre_data` VALUES ('915', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '14', '2', '1581');
INSERT INTO `population_structure_pre_data` VALUES ('916', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '15', '2', '1561');
INSERT INTO `population_structure_pre_data` VALUES ('917', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '16', '2', '1407');
INSERT INTO `population_structure_pre_data` VALUES ('918', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '17', '2', '1302');
INSERT INTO `population_structure_pre_data` VALUES ('919', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '18', '2', '1459');
INSERT INTO `population_structure_pre_data` VALUES ('920', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '19', '2', '1371');
INSERT INTO `population_structure_pre_data` VALUES ('921', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '20', '2', '1526');
INSERT INTO `population_structure_pre_data` VALUES ('922', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '21', '2', '1722');
INSERT INTO `population_structure_pre_data` VALUES ('923', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '22', '2', '1359');
INSERT INTO `population_structure_pre_data` VALUES ('924', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '23', '2', '1603');
INSERT INTO `population_structure_pre_data` VALUES ('925', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '24', '2', '1626');
INSERT INTO `population_structure_pre_data` VALUES ('926', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '25', '2', '1726');
INSERT INTO `population_structure_pre_data` VALUES ('927', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '26', '2', '1655');
INSERT INTO `population_structure_pre_data` VALUES ('928', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '27', '2', '1808');
INSERT INTO `population_structure_pre_data` VALUES ('929', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '28', '2', '1916');
INSERT INTO `population_structure_pre_data` VALUES ('930', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '29', '2', '1929');
INSERT INTO `population_structure_pre_data` VALUES ('931', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '30', '2', '1830');
INSERT INTO `population_structure_pre_data` VALUES ('932', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '31', '2', '2045');
INSERT INTO `population_structure_pre_data` VALUES ('933', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '32', '2', '2157');
INSERT INTO `population_structure_pre_data` VALUES ('934', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '33', '2', '2195');
INSERT INTO `population_structure_pre_data` VALUES ('935', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '34', '2', '2193');
INSERT INTO `population_structure_pre_data` VALUES ('936', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '35', '2', '2481');
INSERT INTO `population_structure_pre_data` VALUES ('937', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '36', '2', '2601');
INSERT INTO `population_structure_pre_data` VALUES ('938', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '37', '2', '2668');
INSERT INTO `population_structure_pre_data` VALUES ('939', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '38', '2', '3263');
INSERT INTO `population_structure_pre_data` VALUES ('940', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '39', '2', '3514');
INSERT INTO `population_structure_pre_data` VALUES ('941', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '40', '2', '3101');
INSERT INTO `population_structure_pre_data` VALUES ('942', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '41', '2', '1527');
INSERT INTO `population_structure_pre_data` VALUES ('943', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '42', '2', '1843');
INSERT INTO `population_structure_pre_data` VALUES ('944', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '43', '2', '3355');
INSERT INTO `population_structure_pre_data` VALUES ('945', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '44', '2', '3405');
INSERT INTO `population_structure_pre_data` VALUES ('946', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '45', '2', '2245');
INSERT INTO `population_structure_pre_data` VALUES ('947', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '46', '2', '3157');
INSERT INTO `population_structure_pre_data` VALUES ('948', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '47', '2', '3115');
INSERT INTO `population_structure_pre_data` VALUES ('949', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '48', '2', '3074');
INSERT INTO `population_structure_pre_data` VALUES ('950', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '49', '2', '3030');
INSERT INTO `population_structure_pre_data` VALUES ('951', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '50', '2', '3350');
INSERT INTO `population_structure_pre_data` VALUES ('952', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '51', '2', '3834');
INSERT INTO `population_structure_pre_data` VALUES ('953', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '52', '2', '3548');
INSERT INTO `population_structure_pre_data` VALUES ('954', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '53', '2', '3119');
INSERT INTO `population_structure_pre_data` VALUES ('955', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '54', '2', '3725');
INSERT INTO `population_structure_pre_data` VALUES ('956', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '55', '2', '4431');
INSERT INTO `population_structure_pre_data` VALUES ('957', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '56', '2', '4155');
INSERT INTO `population_structure_pre_data` VALUES ('958', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '57', '2', '4496');
INSERT INTO `population_structure_pre_data` VALUES ('959', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '58', '2', '3334');
INSERT INTO `population_structure_pre_data` VALUES ('960', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '59', '2', '4041');
INSERT INTO `population_structure_pre_data` VALUES ('961', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '60', '2', '4010');
INSERT INTO `population_structure_pre_data` VALUES ('962', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '61', '2', '3959');
INSERT INTO `population_structure_pre_data` VALUES ('963', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '62', '2', '4376');
INSERT INTO `population_structure_pre_data` VALUES ('964', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '63', '2', '4462');
INSERT INTO `population_structure_pre_data` VALUES ('965', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '64', '2', '1873');
INSERT INTO `population_structure_pre_data` VALUES ('966', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '65', '2', '2825');
INSERT INTO `population_structure_pre_data` VALUES ('967', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '66', '2', '2690');
INSERT INTO `population_structure_pre_data` VALUES ('968', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '67', '2', '3288');
INSERT INTO `population_structure_pre_data` VALUES ('969', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '68', '2', '3381');
INSERT INTO `population_structure_pre_data` VALUES ('970', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '69', '2', '3658');
INSERT INTO `population_structure_pre_data` VALUES ('971', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '70', '2', '3726');
INSERT INTO `population_structure_pre_data` VALUES ('972', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '71', '2', '3434');
INSERT INTO `population_structure_pre_data` VALUES ('973', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '72', '2', '3567');
INSERT INTO `population_structure_pre_data` VALUES ('974', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '73', '2', '3357');
INSERT INTO `population_structure_pre_data` VALUES ('975', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '74', '2', '2995');
INSERT INTO `population_structure_pre_data` VALUES ('976', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '75', '2', '2607');
INSERT INTO `population_structure_pre_data` VALUES ('977', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '76', '2', '2352');
INSERT INTO `population_structure_pre_data` VALUES ('978', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '77', '2', '2043');
INSERT INTO `population_structure_pre_data` VALUES ('979', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '78', '2', '1753');
INSERT INTO `population_structure_pre_data` VALUES ('980', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '79', '2', '1576');
INSERT INTO `population_structure_pre_data` VALUES ('981', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '80', '2', '1376');
INSERT INTO `population_structure_pre_data` VALUES ('982', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '81', '2', '1274');
INSERT INTO `population_structure_pre_data` VALUES ('983', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '82', '2', '1238');
INSERT INTO `population_structure_pre_data` VALUES ('984', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '83', '2', '1178');
INSERT INTO `population_structure_pre_data` VALUES ('985', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '84', '2', '1172');
INSERT INTO `population_structure_pre_data` VALUES ('986', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '85', '2', '903');
INSERT INTO `population_structure_pre_data` VALUES ('987', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '86', '2', '796');
INSERT INTO `population_structure_pre_data` VALUES ('988', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '87', '2', '845');
INSERT INTO `population_structure_pre_data` VALUES ('989', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '88', '2', '665');
INSERT INTO `population_structure_pre_data` VALUES ('990', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '89', '2', '562');
INSERT INTO `population_structure_pre_data` VALUES ('991', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '90', '2', '489');
INSERT INTO `population_structure_pre_data` VALUES ('992', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '91', '2', '409');
INSERT INTO `population_structure_pre_data` VALUES ('993', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '92', '2', '387');
INSERT INTO `population_structure_pre_data` VALUES ('994', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '93', '2', '286');
INSERT INTO `population_structure_pre_data` VALUES ('995', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '94', '2', '188');
INSERT INTO `population_structure_pre_data` VALUES ('996', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '95', '2', '167');
INSERT INTO `population_structure_pre_data` VALUES ('997', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '96', '2', '118');
INSERT INTO `population_structure_pre_data` VALUES ('998', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '97', '2', '99');
INSERT INTO `population_structure_pre_data` VALUES ('999', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '98', '2', '58');
INSERT INTO `population_structure_pre_data` VALUES ('1000', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2025', '99', '2', '39');
INSERT INTO `population_structure_pre_data` VALUES ('1001', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '0', '2', '2696');
INSERT INTO `population_structure_pre_data` VALUES ('1002', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '1', '2', '2688');
INSERT INTO `population_structure_pre_data` VALUES ('1003', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '2', '2', '2658');
INSERT INTO `population_structure_pre_data` VALUES ('1004', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '3', '2', '2603');
INSERT INTO `population_structure_pre_data` VALUES ('1005', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '4', '2', '2599');
INSERT INTO `population_structure_pre_data` VALUES ('1006', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '5', '2', '2576');
INSERT INTO `population_structure_pre_data` VALUES ('1007', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '6', '2', '2524');
INSERT INTO `population_structure_pre_data` VALUES ('1008', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '7', '2', '2517');
INSERT INTO `population_structure_pre_data` VALUES ('1009', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '8', '2', '2572');
INSERT INTO `population_structure_pre_data` VALUES ('1010', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '9', '2', '2584');
INSERT INTO `population_structure_pre_data` VALUES ('1011', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '10', '2', '2536');
INSERT INTO `population_structure_pre_data` VALUES ('1012', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '11', '2', '2485');
INSERT INTO `population_structure_pre_data` VALUES ('1013', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '12', '2', '2371');
INSERT INTO `population_structure_pre_data` VALUES ('1014', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '13', '2', '2318');
INSERT INTO `population_structure_pre_data` VALUES ('1015', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '14', '2', '2203');
INSERT INTO `population_structure_pre_data` VALUES ('1016', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '15', '2', '2106');
INSERT INTO `population_structure_pre_data` VALUES ('1017', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '16', '2', '2061');
INSERT INTO `population_structure_pre_data` VALUES ('1018', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '17', '2', '2030');
INSERT INTO `population_structure_pre_data` VALUES ('1019', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '18', '2', '1975');
INSERT INTO `population_structure_pre_data` VALUES ('1020', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '19', '2', '1876');
INSERT INTO `population_structure_pre_data` VALUES ('1021', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '20', '2', '1856');
INSERT INTO `population_structure_pre_data` VALUES ('1022', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '21', '2', '1802');
INSERT INTO `population_structure_pre_data` VALUES ('1023', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '22', '2', '1797');
INSERT INTO `population_structure_pre_data` VALUES ('1024', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '23', '2', '1754');
INSERT INTO `population_structure_pre_data` VALUES ('1025', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '24', '2', '1866');
INSERT INTO `population_structure_pre_data` VALUES ('1026', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '25', '2', '1721');
INSERT INTO `population_structure_pre_data` VALUES ('1027', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '26', '2', '1812');
INSERT INTO `population_structure_pre_data` VALUES ('1028', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '27', '2', '2052');
INSERT INTO `population_structure_pre_data` VALUES ('1029', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '28', '2', '2295');
INSERT INTO `population_structure_pre_data` VALUES ('1030', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '29', '2', '2417');
INSERT INTO `population_structure_pre_data` VALUES ('1031', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '30', '2', '2516');
INSERT INTO `population_structure_pre_data` VALUES ('1032', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '31', '2', '2645');
INSERT INTO `population_structure_pre_data` VALUES ('1033', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '32', '2', '2798');
INSERT INTO `population_structure_pre_data` VALUES ('1034', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '33', '2', '3006');
INSERT INTO `population_structure_pre_data` VALUES ('1035', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '34', '2', '2919');
INSERT INTO `population_structure_pre_data` VALUES ('1036', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '35', '2', '3020');
INSERT INTO `population_structure_pre_data` VALUES ('1037', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '36', '2', '3934');
INSERT INTO `population_structure_pre_data` VALUES ('1038', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '37', '2', '2342');
INSERT INTO `population_structure_pre_data` VALUES ('1039', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '38', '2', '3380');
INSERT INTO `population_structure_pre_data` VALUES ('1040', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '39', '2', '3478');
INSERT INTO `population_structure_pre_data` VALUES ('1041', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '40', '2', '3561');
INSERT INTO `population_structure_pre_data` VALUES ('1042', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '41', '2', '3680');
INSERT INTO `population_structure_pre_data` VALUES ('1043', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '42', '2', '3846');
INSERT INTO `population_structure_pre_data` VALUES ('1044', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '43', '2', '4235');
INSERT INTO `population_structure_pre_data` VALUES ('1045', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '44', '2', '4485');
INSERT INTO `population_structure_pre_data` VALUES ('1046', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '45', '2', '4476');
INSERT INTO `population_structure_pre_data` VALUES ('1047', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '46', '2', '4511');
INSERT INTO `population_structure_pre_data` VALUES ('1048', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '47', '2', '4824');
INSERT INTO `population_structure_pre_data` VALUES ('1049', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '48', '2', '4319');
INSERT INTO `population_structure_pre_data` VALUES ('1050', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '49', '2', '5263');
INSERT INTO `population_structure_pre_data` VALUES ('1051', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '50', '2', '3815');
INSERT INTO `population_structure_pre_data` VALUES ('1052', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '51', '2', '3715');
INSERT INTO `population_structure_pre_data` VALUES ('1053', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '52', '2', '3771');
INSERT INTO `population_structure_pre_data` VALUES ('1054', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '53', '2', '3628');
INSERT INTO `population_structure_pre_data` VALUES ('1055', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '54', '2', '3582');
INSERT INTO `population_structure_pre_data` VALUES ('1056', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '55', '2', '3495');
INSERT INTO `population_structure_pre_data` VALUES ('1057', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '56', '2', '3769');
INSERT INTO `population_structure_pre_data` VALUES ('1058', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '57', '2', '3483');
INSERT INTO `population_structure_pre_data` VALUES ('1059', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '58', '2', '3057');
INSERT INTO `population_structure_pre_data` VALUES ('1060', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '59', '2', '3645');
INSERT INTO `population_structure_pre_data` VALUES ('1061', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '60', '2', '4331');
INSERT INTO `population_structure_pre_data` VALUES ('1062', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '61', '2', '4048');
INSERT INTO `population_structure_pre_data` VALUES ('1063', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '62', '2', '4367');
INSERT INTO `population_structure_pre_data` VALUES ('1064', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '63', '2', '3229');
INSERT INTO `population_structure_pre_data` VALUES ('1065', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '64', '2', '3901');
INSERT INTO `population_structure_pre_data` VALUES ('1066', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '65', '2', '3858');
INSERT INTO `population_structure_pre_data` VALUES ('1067', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '66', '2', '3789');
INSERT INTO `population_structure_pre_data` VALUES ('1068', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '67', '2', '5118');
INSERT INTO `population_structure_pre_data` VALUES ('1069', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '68', '2', '4225');
INSERT INTO `population_structure_pre_data` VALUES ('1070', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '69', '2', '1762');
INSERT INTO `population_structure_pre_data` VALUES ('1071', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '70', '2', '2645');
INSERT INTO `population_structure_pre_data` VALUES ('1072', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '71', '2', '2496');
INSERT INTO `population_structure_pre_data` VALUES ('1073', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '72', '2', '3024');
INSERT INTO `population_structure_pre_data` VALUES ('1074', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '73', '2', '3081');
INSERT INTO `population_structure_pre_data` VALUES ('1075', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '74', '2', '3304');
INSERT INTO `population_structure_pre_data` VALUES ('1076', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '75', '2', '3335');
INSERT INTO `population_structure_pre_data` VALUES ('1077', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '76', '2', '3900');
INSERT INTO `population_structure_pre_data` VALUES ('1078', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '77', '2', '3341');
INSERT INTO `population_structure_pre_data` VALUES ('1079', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '78', '2', '3700');
INSERT INTO `population_structure_pre_data` VALUES ('1080', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '79', '2', '2831');
INSERT INTO `population_structure_pre_data` VALUES ('1081', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '80', '2', '2136');
INSERT INTO `population_structure_pre_data` VALUES ('1082', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '81', '2', '2038');
INSERT INTO `population_structure_pre_data` VALUES ('1083', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '82', '2', '1824');
INSERT INTO `population_structure_pre_data` VALUES ('1084', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '83', '2', '1788');
INSERT INTO `population_structure_pre_data` VALUES ('1085', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '84', '2', '1686');
INSERT INTO `population_structure_pre_data` VALUES ('1086', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '85', '2', '1355');
INSERT INTO `population_structure_pre_data` VALUES ('1087', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '86', '2', '1157');
INSERT INTO `population_structure_pre_data` VALUES ('1088', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '87', '2', '886');
INSERT INTO `population_structure_pre_data` VALUES ('1089', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '88', '2', '810');
INSERT INTO `population_structure_pre_data` VALUES ('1090', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '89', '2', '833');
INSERT INTO `population_structure_pre_data` VALUES ('1091', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '90', '2', '525');
INSERT INTO `population_structure_pre_data` VALUES ('1092', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '91', '2', '430');
INSERT INTO `population_structure_pre_data` VALUES ('1093', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '92', '2', '426');
INSERT INTO `population_structure_pre_data` VALUES ('1094', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '93', '2', '311');
INSERT INTO `population_structure_pre_data` VALUES ('1095', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '94', '2', '245');
INSERT INTO `population_structure_pre_data` VALUES ('1096', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '95', '2', '199');
INSERT INTO `population_structure_pre_data` VALUES ('1097', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '96', '2', '162');
INSERT INTO `population_structure_pre_data` VALUES ('1098', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '97', '2', '149');
INSERT INTO `population_structure_pre_data` VALUES ('1099', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '98', '2', '106');
INSERT INTO `population_structure_pre_data` VALUES ('1100', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2030', '99', '2', '67');
INSERT INTO `population_structure_pre_data` VALUES ('1101', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '0', '2', '2896');
INSERT INTO `population_structure_pre_data` VALUES ('1102', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '1', '2', '2888');
INSERT INTO `population_structure_pre_data` VALUES ('1103', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '2', '2', '2868');
INSERT INTO `population_structure_pre_data` VALUES ('1104', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '3', '2', '2803');
INSERT INTO `population_structure_pre_data` VALUES ('1105', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '4', '2', '2799');
INSERT INTO `population_structure_pre_data` VALUES ('1106', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '5', '2', '2676');
INSERT INTO `population_structure_pre_data` VALUES ('1107', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '6', '2', '2624');
INSERT INTO `population_structure_pre_data` VALUES ('1108', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '7', '2', '2617');
INSERT INTO `population_structure_pre_data` VALUES ('1109', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '8', '2', '2572');
INSERT INTO `population_structure_pre_data` VALUES ('1110', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '9', '2', '2584');
INSERT INTO `population_structure_pre_data` VALUES ('1111', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '10', '2', '2536');
INSERT INTO `population_structure_pre_data` VALUES ('1112', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '11', '2', '2485');
INSERT INTO `population_structure_pre_data` VALUES ('1113', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '12', '2', '2471');
INSERT INTO `population_structure_pre_data` VALUES ('1114', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '13', '2', '2418');
INSERT INTO `population_structure_pre_data` VALUES ('1115', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '14', '2', '2303');
INSERT INTO `population_structure_pre_data` VALUES ('1116', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '15', '2', '2306');
INSERT INTO `population_structure_pre_data` VALUES ('1117', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '16', '2', '2282');
INSERT INTO `population_structure_pre_data` VALUES ('1118', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '17', '2', '2261');
INSERT INTO `population_structure_pre_data` VALUES ('1119', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '18', '2', '2249');
INSERT INTO `population_structure_pre_data` VALUES ('1120', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '19', '2', '2164');
INSERT INTO `population_structure_pre_data` VALUES ('1121', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '20', '2', '2157');
INSERT INTO `population_structure_pre_data` VALUES ('1122', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '21', '2', '2104');
INSERT INTO `population_structure_pre_data` VALUES ('1123', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '22', '2', '2025');
INSERT INTO `population_structure_pre_data` VALUES ('1124', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '23', '2', '2067');
INSERT INTO `population_structure_pre_data` VALUES ('1125', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '24', '2', '2071');
INSERT INTO `population_structure_pre_data` VALUES ('1126', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '25', '2', '1951');
INSERT INTO `population_structure_pre_data` VALUES ('1127', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '26', '2', '2097');
INSERT INTO `population_structure_pre_data` VALUES ('1128', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '27', '2', '2192');
INSERT INTO `population_structure_pre_data` VALUES ('1129', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '28', '2', '2146');
INSERT INTO `population_structure_pre_data` VALUES ('1130', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '29', '2', '2261');
INSERT INTO `population_structure_pre_data` VALUES ('1131', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '30', '2', '2211');
INSERT INTO `population_structure_pre_data` VALUES ('1132', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '31', '2', '2302');
INSERT INTO `population_structure_pre_data` VALUES ('1133', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '32', '2', '2345');
INSERT INTO `population_structure_pre_data` VALUES ('1134', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '33', '2', '2585');
INSERT INTO `population_structure_pre_data` VALUES ('1135', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '34', '2', '2607');
INSERT INTO `population_structure_pre_data` VALUES ('1136', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '35', '2', '3706');
INSERT INTO `population_structure_pre_data` VALUES ('1137', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '36', '2', '3334');
INSERT INTO `population_structure_pre_data` VALUES ('1138', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '37', '2', '3086');
INSERT INTO `population_structure_pre_data` VALUES ('1139', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '38', '2', '2893');
INSERT INTO `population_structure_pre_data` VALUES ('1140', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '39', '2', '3205');
INSERT INTO `population_structure_pre_data` VALUES ('1141', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '40', '2', '4005');
INSERT INTO `population_structure_pre_data` VALUES ('1142', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '41', '2', '3118');
INSERT INTO `population_structure_pre_data` VALUES ('1143', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '42', '2', '3725');
INSERT INTO `population_structure_pre_data` VALUES ('1144', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '43', '2', '4062');
INSERT INTO `population_structure_pre_data` VALUES ('1145', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '44', '2', '3359');
INSERT INTO `population_structure_pre_data` VALUES ('1146', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '45', '2', '3841');
INSERT INTO `population_structure_pre_data` VALUES ('1147', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '46', '2', '5258');
INSERT INTO `population_structure_pre_data` VALUES ('1148', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '47', '2', '3222');
INSERT INTO `population_structure_pre_data` VALUES ('1149', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '48', '2', '4501');
INSERT INTO `population_structure_pre_data` VALUES ('1150', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '49', '2', '3447');
INSERT INTO `population_structure_pre_data` VALUES ('1151', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '50', '2', '3041');
INSERT INTO `population_structure_pre_data` VALUES ('1152', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '51', '2', '3490');
INSERT INTO `population_structure_pre_data` VALUES ('1153', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '52', '2', '3797');
INSERT INTO `population_structure_pre_data` VALUES ('1154', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '53', '2', '3273');
INSERT INTO `population_structure_pre_data` VALUES ('1155', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '54', '2', '3315');
INSERT INTO `population_structure_pre_data` VALUES ('1156', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '55', '2', '3180');
INSERT INTO `population_structure_pre_data` VALUES ('1157', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '56', '2', '3065');
INSERT INTO `population_structure_pre_data` VALUES ('1158', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '57', '2', '3018');
INSERT INTO `population_structure_pre_data` VALUES ('1159', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '58', '2', '3171');
INSERT INTO `population_structure_pre_data` VALUES ('1160', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '59', '2', '3221');
INSERT INTO `population_structure_pre_data` VALUES ('1161', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '60', '2', '3225');
INSERT INTO `population_structure_pre_data` VALUES ('1162', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '61', '2', '3678');
INSERT INTO `population_structure_pre_data` VALUES ('1163', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '62', '2', '3388');
INSERT INTO `population_structure_pre_data` VALUES ('1164', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '63', '2', '2965');
INSERT INTO `population_structure_pre_data` VALUES ('1165', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '64', '2', '3524');
INSERT INTO `population_structure_pre_data` VALUES ('1166', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '65', '2', '4175');
INSERT INTO `population_structure_pre_data` VALUES ('1167', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '66', '2', '3882');
INSERT INTO `population_structure_pre_data` VALUES ('1168', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '67', '2', '4167');
INSERT INTO `population_structure_pre_data` VALUES ('1169', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '68', '2', '3064');
INSERT INTO `population_structure_pre_data` VALUES ('1170', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '69', '2', '3684');
INSERT INTO `population_structure_pre_data` VALUES ('1171', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '70', '2', '3625');
INSERT INTO `population_structure_pre_data` VALUES ('1172', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '71', '2', '3530');
INSERT INTO `population_structure_pre_data` VALUES ('1173', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '72', '2', '4728');
INSERT INTO `population_structure_pre_data` VALUES ('1174', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '73', '2', '3869');
INSERT INTO `population_structure_pre_data` VALUES ('1175', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '74', '2', '1598');
INSERT INTO `population_structure_pre_data` VALUES ('1176', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '75', '2', '2380');
INSERT INTO `population_structure_pre_data` VALUES ('1177', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '76', '2', '2209');
INSERT INTO `population_structure_pre_data` VALUES ('1178', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '77', '2', '2632');
INSERT INTO `population_structure_pre_data` VALUES ('1179', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '78', '2', '2636');
INSERT INTO `population_structure_pre_data` VALUES ('1180', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '79', '2', '2781');
INSERT INTO `population_structure_pre_data` VALUES ('1181', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '80', '2', '2760');
INSERT INTO `population_structure_pre_data` VALUES ('1182', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '81', '2', '3153');
INSERT INTO `population_structure_pre_data` VALUES ('1183', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '82', '2', '2637');
INSERT INTO `population_structure_pre_data` VALUES ('1184', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '83', '2', '2852');
INSERT INTO `population_structure_pre_data` VALUES ('1185', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '84', '2', '2130');
INSERT INTO `population_structure_pre_data` VALUES ('1186', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '85', '2', '1569');
INSERT INTO `population_structure_pre_data` VALUES ('1187', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '86', '2', '1444');
INSERT INTO `population_structure_pre_data` VALUES ('1188', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '87', '2', '1246');
INSERT INTO `population_structure_pre_data` VALUES ('1189', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '88', '2', '1179');
INSERT INTO `population_structure_pre_data` VALUES ('1190', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '89', '2', '1072');
INSERT INTO `population_structure_pre_data` VALUES ('1191', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '90', '2', '831');
INSERT INTO `population_structure_pre_data` VALUES ('1192', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '91', '2', '660');
INSERT INTO `population_structure_pre_data` VALUES ('1193', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '92', '2', '470');
INSERT INTO `population_structure_pre_data` VALUES ('1194', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '93', '2', '399');
INSERT INTO `population_structure_pre_data` VALUES ('1195', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '94', '2', '382');
INSERT INTO `population_structure_pre_data` VALUES ('1196', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '95', '2', '223');
INSERT INTO `population_structure_pre_data` VALUES ('1197', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '96', '2', '178');
INSERT INTO `population_structure_pre_data` VALUES ('1198', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '97', '2', '172');
INSERT INTO `population_structure_pre_data` VALUES ('1199', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '98', '2', '122');
INSERT INTO `population_structure_pre_data` VALUES ('1200', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2035', '99', '2', '93');
INSERT INTO `population_structure_pre_data` VALUES ('1201', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '0', '2', '3089');
INSERT INTO `population_structure_pre_data` VALUES ('1202', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '1', '2', '3051');
INSERT INTO `population_structure_pre_data` VALUES ('1203', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '2', '2', '3066');
INSERT INTO `population_structure_pre_data` VALUES ('1204', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '3', '2', '3077');
INSERT INTO `population_structure_pre_data` VALUES ('1205', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '4', '2', '2955');
INSERT INTO `population_structure_pre_data` VALUES ('1206', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '5', '2', '2996');
INSERT INTO `population_structure_pre_data` VALUES ('1207', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '6', '2', '2865');
INSERT INTO `population_structure_pre_data` VALUES ('1208', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '7', '2', '2798');
INSERT INTO `population_structure_pre_data` VALUES ('1209', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '8', '2', '2738');
INSERT INTO `population_structure_pre_data` VALUES ('1210', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '9', '2', '2663');
INSERT INTO `population_structure_pre_data` VALUES ('1211', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '10', '2', '2655');
INSERT INTO `population_structure_pre_data` VALUES ('1212', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '11', '2', '2542');
INSERT INTO `population_structure_pre_data` VALUES ('1213', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '12', '2', '2585');
INSERT INTO `population_structure_pre_data` VALUES ('1214', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '13', '2', '2481');
INSERT INTO `population_structure_pre_data` VALUES ('1215', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '14', '2', '2407');
INSERT INTO `population_structure_pre_data` VALUES ('1216', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '15', '2', '2423');
INSERT INTO `population_structure_pre_data` VALUES ('1217', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '16', '2', '2310');
INSERT INTO `population_structure_pre_data` VALUES ('1218', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '17', '2', '2324');
INSERT INTO `population_structure_pre_data` VALUES ('1219', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '18', '2', '2286');
INSERT INTO `population_structure_pre_data` VALUES ('1220', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '19', '2', '2313');
INSERT INTO `population_structure_pre_data` VALUES ('1221', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '20', '2', '2405');
INSERT INTO `population_structure_pre_data` VALUES ('1222', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '21', '2', '2575');
INSERT INTO `population_structure_pre_data` VALUES ('1223', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '22', '2', '2689');
INSERT INTO `population_structure_pre_data` VALUES ('1224', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '23', '2', '2816');
INSERT INTO `population_structure_pre_data` VALUES ('1225', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '24', '2', '3013');
INSERT INTO `population_structure_pre_data` VALUES ('1226', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '25', '2', '2852');
INSERT INTO `population_structure_pre_data` VALUES ('1227', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '26', '2', '2656');
INSERT INTO `population_structure_pre_data` VALUES ('1228', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '27', '2', '2998');
INSERT INTO `population_structure_pre_data` VALUES ('1229', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '28', '2', '2857');
INSERT INTO `population_structure_pre_data` VALUES ('1230', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '29', '2', '2846');
INSERT INTO `population_structure_pre_data` VALUES ('1231', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '30', '2', '2946');
INSERT INTO `population_structure_pre_data` VALUES ('1232', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '31', '2', '3015');
INSERT INTO `population_structure_pre_data` VALUES ('1233', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '32', '2', '3125');
INSERT INTO `population_structure_pre_data` VALUES ('1234', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '33', '2', '3145');
INSERT INTO `population_structure_pre_data` VALUES ('1235', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '34', '2', '4002');
INSERT INTO `population_structure_pre_data` VALUES ('1236', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '35', '2', '3549');
INSERT INTO `population_structure_pre_data` VALUES ('1237', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '36', '2', '3365');
INSERT INTO `population_structure_pre_data` VALUES ('1238', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '37', '2', '3285');
INSERT INTO `population_structure_pre_data` VALUES ('1239', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '38', '2', '3075');
INSERT INTO `population_structure_pre_data` VALUES ('1240', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '39', '2', '3197');
INSERT INTO `population_structure_pre_data` VALUES ('1241', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '40', '2', '3289');
INSERT INTO `population_structure_pre_data` VALUES ('1242', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '41', '2', '3025');
INSERT INTO `population_structure_pre_data` VALUES ('1243', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '42', '2', '3184');
INSERT INTO `population_structure_pre_data` VALUES ('1244', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '43', '2', '3551');
INSERT INTO `population_structure_pre_data` VALUES ('1245', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '44', '2', '3415');
INSERT INTO `population_structure_pre_data` VALUES ('1246', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '45', '2', '4216');
INSERT INTO `population_structure_pre_data` VALUES ('1247', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '46', '2', '3801');
INSERT INTO `population_structure_pre_data` VALUES ('1248', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '47', '2', '3403');
INSERT INTO `population_structure_pre_data` VALUES ('1249', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '48', '2', '3039');
INSERT INTO `population_structure_pre_data` VALUES ('1250', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '49', '2', '3035');
INSERT INTO `population_structure_pre_data` VALUES ('1251', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '50', '2', '3111');
INSERT INTO `population_structure_pre_data` VALUES ('1252', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '51', '2', '3227');
INSERT INTO `population_structure_pre_data` VALUES ('1253', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '52', '2', '3388');
INSERT INTO `population_structure_pre_data` VALUES ('1254', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '53', '2', '3360');
INSERT INTO `population_structure_pre_data` VALUES ('1255', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '54', '2', '3399');
INSERT INTO `population_structure_pre_data` VALUES ('1256', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '55', '2', '3396');
INSERT INTO `population_structure_pre_data` VALUES ('1257', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '56', '2', '3464');
INSERT INTO `population_structure_pre_data` VALUES ('1258', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '57', '2', '3566');
INSERT INTO `population_structure_pre_data` VALUES ('1259', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '58', '2', '3211');
INSERT INTO `population_structure_pre_data` VALUES ('1260', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '59', '2', '3249');
INSERT INTO `population_structure_pre_data` VALUES ('1261', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '60', '2', '2135');
INSERT INTO `population_structure_pre_data` VALUES ('1262', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '61', '2', '2992');
INSERT INTO `population_structure_pre_data` VALUES ('1263', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '62', '2', '2937');
INSERT INTO `population_structure_pre_data` VALUES ('1264', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '63', '2', '3082');
INSERT INTO `population_structure_pre_data` VALUES ('1265', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '64', '2', '2928');
INSERT INTO `population_structure_pre_data` VALUES ('1266', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '65', '2', '3113');
INSERT INTO `population_structure_pre_data` VALUES ('1267', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '66', '2', '3533');
INSERT INTO `population_structure_pre_data` VALUES ('1268', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '67', '2', '3238');
INSERT INTO `population_structure_pre_data` VALUES ('1269', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '68', '2', '2820');
INSERT INTO `population_structure_pre_data` VALUES ('1270', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '69', '2', '3335');
INSERT INTO `population_structure_pre_data` VALUES ('1271', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '70', '2', '3933');
INSERT INTO `population_structure_pre_data` VALUES ('1272', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '71', '2', '3626');
INSERT INTO `population_structure_pre_data` VALUES ('1273', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '72', '2', '3861');
INSERT INTO `population_structure_pre_data` VALUES ('1274', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '73', '2', '2814');
INSERT INTO `population_structure_pre_data` VALUES ('1275', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '74', '2', '3357');
INSERT INTO `population_structure_pre_data` VALUES ('1276', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '75', '2', '3277');
INSERT INTO `population_structure_pre_data` VALUES ('1277', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '76', '2', '3140');
INSERT INTO `population_structure_pre_data` VALUES ('1278', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '77', '2', '4139');
INSERT INTO `population_structure_pre_data` VALUES ('1279', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '78', '2', '3333');
INSERT INTO `population_structure_pre_data` VALUES ('1280', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '79', '2', '1354');
INSERT INTO `population_structure_pre_data` VALUES ('1281', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '80', '2', '1984');
INSERT INTO `population_structure_pre_data` VALUES ('1282', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '81', '2', '1800');
INSERT INTO `population_structure_pre_data` VALUES ('1283', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '82', '2', '2096');
INSERT INTO `population_structure_pre_data` VALUES ('1284', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '83', '2', '2052');
INSERT INTO `population_structure_pre_data` VALUES ('1285', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '84', '2', '2117');
INSERT INTO `population_structure_pre_data` VALUES ('1286', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '85', '2', '2053');
INSERT INTO `population_structure_pre_data` VALUES ('1287', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '86', '2', '2255');
INSERT INTO `population_structure_pre_data` VALUES ('1288', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '87', '2', '1814');
INSERT INTO `population_structure_pre_data` VALUES ('1289', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '88', '2', '1887');
INSERT INTO `population_structure_pre_data` VALUES ('1290', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '89', '2', '1356');
INSERT INTO `population_structure_pre_data` VALUES ('1291', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '90', '2', '959');
INSERT INTO `population_structure_pre_data` VALUES ('1292', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '91', '2', '828');
INSERT INTO `population_structure_pre_data` VALUES ('1293', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '92', '2', '670');
INSERT INTO `population_structure_pre_data` VALUES ('1294', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '93', '2', '595');
INSERT INTO `population_structure_pre_data` VALUES ('1295', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '94', '2', '506');
INSERT INTO `population_structure_pre_data` VALUES ('1296', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '95', '2', '368');
INSERT INTO `population_structure_pre_data` VALUES ('1297', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '96', '2', '285');
INSERT INTO `population_structure_pre_data` VALUES ('1298', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '97', '2', '198');
INSERT INTO `population_structure_pre_data` VALUES ('1299', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '98', '2', '164');
INSERT INTO `population_structure_pre_data` VALUES ('1300', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2040', '99', '2', '153');
INSERT INTO `population_structure_pre_data` VALUES ('1301', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '0', '2', '3289');
INSERT INTO `population_structure_pre_data` VALUES ('1302', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '1', '2', '3245');
INSERT INTO `population_structure_pre_data` VALUES ('1303', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '2', '2', '3206');
INSERT INTO `population_structure_pre_data` VALUES ('1304', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '3', '2', '3189');
INSERT INTO `population_structure_pre_data` VALUES ('1305', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '4', '2', '3155');
INSERT INTO `population_structure_pre_data` VALUES ('1306', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '5', '2', '3124');
INSERT INTO `population_structure_pre_data` VALUES ('1307', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '6', '2', '3056');
INSERT INTO `population_structure_pre_data` VALUES ('1308', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '7', '2', '3019');
INSERT INTO `population_structure_pre_data` VALUES ('1309', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '8', '2', '2956');
INSERT INTO `population_structure_pre_data` VALUES ('1310', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '9', '2', '2981');
INSERT INTO `population_structure_pre_data` VALUES ('1311', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '10', '2', '2910');
INSERT INTO `population_structure_pre_data` VALUES ('1312', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '11', '2', '2856');
INSERT INTO `population_structure_pre_data` VALUES ('1313', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '12', '2', '2851');
INSERT INTO `population_structure_pre_data` VALUES ('1314', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '13', '2', '2796');
INSERT INTO `population_structure_pre_data` VALUES ('1315', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '14', '2', '2745');
INSERT INTO `population_structure_pre_data` VALUES ('1316', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '15', '2', '2659');
INSERT INTO `population_structure_pre_data` VALUES ('1317', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '16', '2', '2602');
INSERT INTO `population_structure_pre_data` VALUES ('1318', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '17', '2', '2589');
INSERT INTO `population_structure_pre_data` VALUES ('1319', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '18', '2', '2516');
INSERT INTO `population_structure_pre_data` VALUES ('1320', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '19', '2', '2489');
INSERT INTO `population_structure_pre_data` VALUES ('1321', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '20', '2', '2406');
INSERT INTO `population_structure_pre_data` VALUES ('1322', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '21', '2', '2378');
INSERT INTO `population_structure_pre_data` VALUES ('1323', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '22', '2', '2359');
INSERT INTO `population_structure_pre_data` VALUES ('1324', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '23', '2', '2419');
INSERT INTO `population_structure_pre_data` VALUES ('1325', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '24', '2', '2506');
INSERT INTO `population_structure_pre_data` VALUES ('1326', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '25', '2', '2694');
INSERT INTO `population_structure_pre_data` VALUES ('1327', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '26', '2', '2622');
INSERT INTO `population_structure_pre_data` VALUES ('1328', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '27', '2', '2638');
INSERT INTO `population_structure_pre_data` VALUES ('1329', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '28', '2', '2891');
INSERT INTO `population_structure_pre_data` VALUES ('1330', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '29', '2', '2961');
INSERT INTO `population_structure_pre_data` VALUES ('1331', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '30', '2', '2961');
INSERT INTO `population_structure_pre_data` VALUES ('1332', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '31', '2', '3016');
INSERT INTO `population_structure_pre_data` VALUES ('1333', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '32', '2', '3989');
INSERT INTO `population_structure_pre_data` VALUES ('1334', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '33', '2', '3849');
INSERT INTO `population_structure_pre_data` VALUES ('1335', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '34', '2', '3212');
INSERT INTO `population_structure_pre_data` VALUES ('1336', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '35', '2', '3638');
INSERT INTO `population_structure_pre_data` VALUES ('1337', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '36', '2', '4516');
INSERT INTO `population_structure_pre_data` VALUES ('1338', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '37', '2', '3189');
INSERT INTO `population_structure_pre_data` VALUES ('1339', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '38', '2', '3216');
INSERT INTO `population_structure_pre_data` VALUES ('1340', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '39', '2', '3312');
INSERT INTO `population_structure_pre_data` VALUES ('1341', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '40', '2', '3389');
INSERT INTO `population_structure_pre_data` VALUES ('1342', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '41', '2', '3412');
INSERT INTO `population_structure_pre_data` VALUES ('1343', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '42', '2', '3456');
INSERT INTO `population_structure_pre_data` VALUES ('1344', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '43', '2', '3562');
INSERT INTO `population_structure_pre_data` VALUES ('1345', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '44', '2', '3789');
INSERT INTO `population_structure_pre_data` VALUES ('1346', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '45', '2', '4921');
INSERT INTO `population_structure_pre_data` VALUES ('1347', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '46', '2', '3607');
INSERT INTO `population_structure_pre_data` VALUES ('1348', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '47', '2', '3895');
INSERT INTO `population_structure_pre_data` VALUES ('1349', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '48', '2', '3856');
INSERT INTO `population_structure_pre_data` VALUES ('1350', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '49', '2', '3514');
INSERT INTO `population_structure_pre_data` VALUES ('1351', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '50', '2', '3323');
INSERT INTO `population_structure_pre_data` VALUES ('1352', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '51', '2', '3589');
INSERT INTO `population_structure_pre_data` VALUES ('1353', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '52', '2', '3484');
INSERT INTO `population_structure_pre_data` VALUES ('1354', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '53', '2', '3649');
INSERT INTO `population_structure_pre_data` VALUES ('1355', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '54', '2', '3588');
INSERT INTO `population_structure_pre_data` VALUES ('1356', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '55', '2', '3325');
INSERT INTO `population_structure_pre_data` VALUES ('1357', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '56', '2', '3089');
INSERT INTO `population_structure_pre_data` VALUES ('1358', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '57', '2', '3045');
INSERT INTO `population_structure_pre_data` VALUES ('1359', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '58', '2', '3103');
INSERT INTO `population_structure_pre_data` VALUES ('1360', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '59', '2', '3333');
INSERT INTO `population_structure_pre_data` VALUES ('1361', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '60', '2', '2936');
INSERT INTO `population_structure_pre_data` VALUES ('1362', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '61', '2', '2430');
INSERT INTO `population_structure_pre_data` VALUES ('1363', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '62', '2', '1721');
INSERT INTO `population_structure_pre_data` VALUES ('1364', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '63', '2', '3119');
INSERT INTO `population_structure_pre_data` VALUES ('1365', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '64', '2', '3148');
INSERT INTO `population_structure_pre_data` VALUES ('1366', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '65', '2', '2062');
INSERT INTO `population_structure_pre_data` VALUES ('1367', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '66', '2', '2877');
INSERT INTO `population_structure_pre_data` VALUES ('1368', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '67', '2', '2811');
INSERT INTO `population_structure_pre_data` VALUES ('1369', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '68', '2', '2744');
INSERT INTO `population_structure_pre_data` VALUES ('1370', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '69', '2', '2681');
INSERT INTO `population_structure_pre_data` VALUES ('1371', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '70', '2', '2937');
INSERT INTO `population_structure_pre_data` VALUES ('1372', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '71', '2', '3308');
INSERT INTO `population_structure_pre_data` VALUES ('1373', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '72', '2', '3006');
INSERT INTO `population_structure_pre_data` VALUES ('1374', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '73', '2', '2596');
INSERT INTO `population_structure_pre_data` VALUES ('1375', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '74', '2', '3047');
INSERT INTO `population_structure_pre_data` VALUES ('1376', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '75', '2', '3566');
INSERT INTO `population_structure_pre_data` VALUES ('1377', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '76', '2', '3237');
INSERT INTO `population_structure_pre_data` VALUES ('1378', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '77', '2', '3394');
INSERT INTO `population_structure_pre_data` VALUES ('1379', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '78', '2', '2434');
INSERT INTO `population_structure_pre_data` VALUES ('1380', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '79', '2', '2860');
INSERT INTO `population_structure_pre_data` VALUES ('1381', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '80', '2', '2749');
INSERT INTO `population_structure_pre_data` VALUES ('1382', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '81', '2', '2575');
INSERT INTO `population_structure_pre_data` VALUES ('1383', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '82', '2', '3322');
INSERT INTO `population_structure_pre_data` VALUES ('1384', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '83', '2', '2617');
INSERT INTO `population_structure_pre_data` VALUES ('1385', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '84', '2', '1038');
INSERT INTO `population_structure_pre_data` VALUES ('1386', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '85', '2', '1488');
INSERT INTO `population_structure_pre_data` VALUES ('1387', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '86', '2', '1300');
INSERT INTO `population_structure_pre_data` VALUES ('1388', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '87', '2', '1459');
INSERT INTO `population_structure_pre_data` VALUES ('1389', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '88', '2', '1376');
INSERT INTO `population_structure_pre_data` VALUES ('1390', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '89', '2', '1366');
INSERT INTO `population_structure_pre_data` VALUES ('1391', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '90', '2', '1275');
INSERT INTO `population_structure_pre_data` VALUES ('1392', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '91', '2', '1317');
INSERT INTO `population_structure_pre_data` VALUES ('1393', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '92', '2', '996');
INSERT INTO `population_structure_pre_data` VALUES ('1394', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '93', '2', '973');
INSERT INTO `population_structure_pre_data` VALUES ('1395', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '94', '2', '658');
INSERT INTO `population_structure_pre_data` VALUES ('1396', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '95', '2', '436');
INSERT INTO `population_structure_pre_data` VALUES ('1397', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '96', '2', '368');
INSERT INTO `population_structure_pre_data` VALUES ('1398', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '97', '2', '291');
INSERT INTO `population_structure_pre_data` VALUES ('1399', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '98', '2', '252');
INSERT INTO `population_structure_pre_data` VALUES ('1400', '2016-06-06 20:23:46', '2016-06-06 20:23:46', '2045', '99', '2', '209');



-- ----------------------------
-- Table structure for sumPopulation_Data
-- ----------------------------
DROP TABLE IF EXISTS `sumPopulation_Data`;
CREATE TABLE `sumPopulation_Data` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `year` int(11) NOT NULL,
  `sumPopulation` double NOT NULL,
  `popRate` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sumPopulation_Data
-- ----------------------------
INSERT INTO `sumPopulation_Data` VALUES ('1', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2016', '710046', '0.25');
INSERT INTO `sumPopulation_Data` VALUES ('2', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2017', '712008', '0.3');
INSERT INTO `sumPopulation_Data` VALUES ('3', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2018', '714570', '0.23');
INSERT INTO `sumPopulation_Data` VALUES ('4', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2019', '716963', '0.27');
INSERT INTO `sumPopulation_Data` VALUES ('5', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2020', '719066', '0.25');
INSERT INTO `sumPopulation_Data` VALUES ('6', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2021', '721863', '0.29');
INSERT INTO `sumPopulation_Data` VALUES ('7', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2022', '723970', '0.29');
INSERT INTO `sumPopulation_Data` VALUES ('8', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2023', '725050', '0.3');
INSERT INTO `sumPopulation_Data` VALUES ('9', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2024', '727652', '0.28');
INSERT INTO `sumPopulation_Data` VALUES ('10', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2025', '728138', '0.23');
INSERT INTO `sumPopulation_Data` VALUES ('11', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2026', '730463', '0.19');
INSERT INTO `sumPopulation_Data` VALUES ('12', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2027', '732465', '0.27');
INSERT INTO `sumPopulation_Data` VALUES ('13', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2028', '733319', '0.12');
INSERT INTO `sumPopulation_Data` VALUES ('14', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2029', '735001', '0.23');
INSERT INTO `sumPopulation_Data` VALUES ('15', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2030', '737475', '0.37');
INSERT INTO `sumPopulation_Data` VALUES ('16', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2031', '740754', '0.3');
INSERT INTO `sumPopulation_Data` VALUES ('17', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2032', '741951', '0.2');
INSERT INTO `sumPopulation_Data` VALUES ('18', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2033', '743567', '0.3');
INSERT INTO `sumPopulation_Data` VALUES ('19', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2034', '745655', '0.28');
INSERT INTO `sumPopulation_Data` VALUES ('20', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2035', '746482', '0.11');
INSERT INTO `sumPopulation_Data` VALUES ('21', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2036', '747441', '0.13');
INSERT INTO `sumPopulation_Data` VALUES ('22', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2037', '749081', '0.22');
INSERT INTO `sumPopulation_Data` VALUES ('23', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2038', '751654', '0.34');
INSERT INTO `sumPopulation_Data` VALUES ('24', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2039', '753106', '0.19');
INSERT INTO `sumPopulation_Data` VALUES ('25', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2040', '754420', '0.17');
INSERT INTO `sumPopulation_Data` VALUES ('26', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2041', '756676', '0.3');
INSERT INTO `sumPopulation_Data` VALUES ('27', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2042', '757804', '0.15');
INSERT INTO `sumPopulation_Data` VALUES ('28', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2043', '758418', '0.1');
INSERT INTO `sumPopulation_Data` VALUES ('29', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2044', '759579', '0.15');
INSERT INTO `sumPopulation_Data` VALUES ('30', '2016-03-05 22:13:36', '2016-03-05 22:13:36', '2045', '760577', '0.13');

SET FOREIGN_KEY_CHECKS = 1;






















