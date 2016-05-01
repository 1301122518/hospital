/*
Navicat MySQL Data Transfer

Source Server         : hospital
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-05-01 20:02:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `idCardNo` varchar(20) DEFAULT NULL,
  `applyItem` varchar(20) DEFAULT NULL,
  `signDoctor` varchar(20) DEFAULT NULL,
  `applyDepartment` varchar(20) DEFAULT NULL,
  `applyTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `examAddress` varchar(56) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', '51018419880821006X', '胸部正位', '吴静', '体检部', '2016-01-05 08:51:00', 'C区1楼放射科');

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` int(11) NOT NULL,
  `idCardNo` varchar(255) DEFAULT NULL,
  `examDepartment` varchar(30) DEFAULT NULL,
  `examAddress` varchar(255) DEFAULT NULL,
  `examItem` varchar(30) DEFAULT NULL,
  `admin` varchar(30) DEFAULT NULL,
  `applyDepartment` varchar(255) DEFAULT NULL,
  `applyItem` varchar(255) DEFAULT NULL,
  `applyTime` datetime DEFAULT NULL,
  `signDoctor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('1', '51018419880821006X', '体检部-外科检查', 'A区一楼门诊部外科2诊室', '外科检查', '陈长', null, null, null, null);
INSERT INTO `examination` VALUES ('2', '51018419880821006X', '体检部-内科检查', 'A区一楼门诊部外科1诊室', '内科检查', '', null, null, null, null);
INSERT INTO `examination` VALUES ('3', '51018419880821006X', '体检部-眼耳鼻喉检查室', 'A区一楼门诊部', '眼科检查', null, null, null, null, null);
INSERT INTO `examination` VALUES ('4', '51018419880821006X', '体检部-口腔检查检查室', 'A区一楼门诊部', '口腔检查', null, null, null, null, null);
INSERT INTO `examination` VALUES ('5', '51018419880821006X', '妇科检查', 'C区1楼体检部', '妇检', null, null, null, null, null);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCardNo` varchar(20) DEFAULT NULL,
  `organisation` varchar(36) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `marryStatus` varchar(20) DEFAULT NULL,
  `examID` varchar(36) DEFAULT NULL,
  `examImage` varchar(36) DEFAULT NULL,
  `applyID` varchar(36) DEFAULT NULL,
  `applyImage` varchar(36) NOT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `allCost` decimal(10,0) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`applyImage`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '51018419880821006X', '四川化工职业技术学院', '陈张', '男', '34', '15228461257', '已婚', '1600234012', null, '1600234012', '', '199', '3000', null);
INSERT INTO `person` VALUES ('2', 'Ling', 'Liang', null, null, null, null, null, null, null, null, '', null, null, null);

-- ----------------------------
-- Table structure for play_evolutions
-- ----------------------------
DROP TABLE IF EXISTS `play_evolutions`;
CREATE TABLE `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of play_evolutions
-- ----------------------------
INSERT INTO `play_evolutions` VALUES ('1', 'da39a3ee5e6b4b0d3255bfef95601890afd80709', '2016-03-30 14:04:10', '', '', 'applied', '');
