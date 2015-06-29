/*
Navicat MySQL Data Transfer

Source Server         : vensli
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : tao_interest

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-06-29 10:16:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(10) NOT NULL,
  `comment` varchar(200) NOT NULL,
  `tao_id` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  `user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `tao_id` (`tao_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for following
-- ----------------------------
DROP TABLE IF EXISTS `following`;
CREATE TABLE `following` (
  `user_id1` varchar(30) DEFAULT NULL,
  `user_id2` varchar(30) DEFAULT NULL,
  KEY `user_id1` (`user_id1`(20)) USING BTREE,
  KEY `user_id2` (`user_id2`(20)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of following
-- ----------------------------
INSERT INTO `following` VALUES ('abc', '胡家煊');
INSERT INTO `following` VALUES ('刘亦菲', '胡家煊');
INSERT INTO `following` VALUES ('胡家煊', '胡家煊');

-- ----------------------------
-- Table structure for interest
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest` (
  `interest_id` int(10) NOT NULL,
  `interest` varchar(20) NOT NULL,
  PRIMARY KEY (`interest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of interest
-- ----------------------------

-- ----------------------------
-- Table structure for num
-- ----------------------------
DROP TABLE IF EXISTS `num`;
CREATE TABLE `num` (
  `user_num` int(10) NOT NULL DEFAULT '1',
  `tao_num` int(10) NOT NULL DEFAULT '1',
  `comment_num` int(10) NOT NULL DEFAULT '1',
  `interest_num` int(10) NOT NULL DEFAULT '1',
  `tag_num` int(10) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of num
-- ----------------------------
INSERT INTO `num` VALUES ('1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(10) NOT NULL,
  `tag` varchar(20) NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `tag` (`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_latvian_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_latvian_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_latvian_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_latvian_ci DEFAULT NULL,
  `register_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_latvian_ci DEFAULT NULL,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('胡家煊1435427091197', '胡家煊', 'vensli', '370403444@qq.com', '2015-06-28 01:44:51');
INSERT INTO `user` VALUES ('祝远1435503891527', '祝远', '132456', '370403444@qq.com', '2015-06-28 23:04:51');

-- ----------------------------
-- Table structure for user-tag
-- ----------------------------
DROP TABLE IF EXISTS `user-tag`;
CREATE TABLE `user-tag` (
  `user_id` int(10) NOT NULL,
  `tag_id` int(10) NOT NULL,
  PRIMARY KEY (`user_id`,`tag_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user-tag
-- ----------------------------

-- ----------------------------
-- Table structure for weibo
-- ----------------------------
DROP TABLE IF EXISTS `weibo`;
CREATE TABLE `weibo` (
  `tao_id` varchar(50) NOT NULL,
  `picture_id` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `thumb_on` int(10) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL,
  `user_id` varchar(30) NOT NULL,
  `interest_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_latvian_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_latvian_ci DEFAULT NULL,
  PRIMARY KEY (`tao_id`),
  KEY `user_id4` (`user_id`),
  KEY `interest_id` (`interest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibo
-- ----------------------------
INSERT INTO `weibo` VALUES ('胡家煊1435499889447', 'C:/', '0', '2015-06-28 21:58:09', '胡家煊', 'basketball', '啦啦啦啦啦啦啦');
INSERT INTO `weibo` VALUES ('胡家煊1435499930708', 'C:/', '0', '2015-06-28 21:58:50', '胡家煊', 'basketball', '日日日日日');
INSERT INTO `weibo` VALUES ('胡家煊1435499943066', 'C:/', '0', '2015-06-28 21:59:03', '胡家煊', 'basketball', '纯纯粹粹');
INSERT INTO `weibo` VALUES ('胡家煊1435500240783', 'C:/', '0', '2015-06-28 22:04:00', '胡家煊', 'basketball', '喀喀喀喀喀喀喀喀喀');
INSERT INTO `weibo` VALUES ('胡家煊1435500243364', 'C:/', '0', '2015-06-28 22:04:13', '刘亦菲', 'basketball', 'uuuuuuuuuu');
INSERT INTO `weibo` VALUES ('胡家煊1435500247904', 'C:/', '0', '2015-06-28 22:04:07', '胡家煊', 'basketball', '萍萍萍萍萍萍');
INSERT INTO `weibo` VALUES ('胡家煊1435500253364', 'C:/', '0', '2015-06-28 22:04:13', '胡家煊', 'basketball', 'uuuuuuuuuu');
INSERT INTO `weibo` VALUES ('胡家煊1435500253367', 'C:/', '0', '2015-06-28 22:04:13', '刘亦菲', 'basketball', 'uuuuuuuuuu');
INSERT INTO `weibo` VALUES ('胡家煊1435500258314', 'C:/', '0', '2015-06-28 22:04:18', '胡家煊', 'basketball', 'yyyyyyyyyyy');
INSERT INTO `weibo` VALUES ('胡家煊1435503810772', 'C:/', '0', '2015-06-28 23:03:30', '胡家煊', 'basketball', '就lkjlkjlkj');
