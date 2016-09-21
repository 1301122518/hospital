-- MySQL dump 10.13  Distrib 5.6.28, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	5.6.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `idCardNo` varchar(20) DEFAULT NULL,
  `applyItem` varchar(20) DEFAULT NULL,
  `signDoctor` varchar(20) DEFAULT NULL,
  `applyDepartment` varchar(20) DEFAULT NULL,
  `applyTime` varchar(20) DEFAULT NULL,
  `examAddress` varchar(56) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,'51018419880821006X','胸部正位','吴静','体检部','2016-01-05 08:51:00','C区1楼放射科'),(2,'51018419880821006X','胸部侧位','吴静','体检部','2016-03-18 08:34:00','C区1楼放射科'),(3,'51018419880821006X','X光照射','王心','内科','2016-03-18 08:34:00','C区1楼内科');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES (1,'51018419880821006X','体检部-外科检查','A区一楼门诊部外科2诊室','外科检查','陈长',NULL,NULL,NULL,NULL),(2,'51018419880821006X','体检部-内科检查','A区一楼门诊部外科1诊室','内科检查','',NULL,NULL,NULL,NULL),(3,'51018419880821006X','体检部-眼耳鼻喉检查室','A区一楼门诊部','眼科检查',NULL,NULL,NULL,NULL,NULL),(4,'51018419880821006X','体检部-口腔检查检查室','A区一楼门诊部','口腔检查',NULL,NULL,NULL,NULL,NULL),(5,'51018419880821006X','妇科检查','C区1楼体检部','妇检',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCardNo` varchar(20) DEFAULT NULL,
  `organization` varchar(36) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `marryStatus` varchar(20) DEFAULT NULL,
  `examID` varchar(36) DEFAULT NULL,
  `examImage` varchar(36) DEFAULT NULL,
  `applyID` varchar(36) DEFAULT NULL,
  `applyImage` varchar(36) NOT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `allCost` decimal(10,0) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `printNumber` int(11) DEFAULT '0',
  PRIMARY KEY (`id`,`applyImage`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'51018419880821006X','四川化工职业技术学院','陈张','男','34','15228461257','已婚','1600234012','1600234012','1600234012','',199,3000,NULL,1),(2,'Ling','Liang',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_evolutions`
--

DROP TABLE IF EXISTS `play_evolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_evolutions`
--

LOCK TABLES `play_evolutions` WRITE;
/*!40000 ALTER TABLE `play_evolutions` DISABLE KEYS */;
INSERT INTO `play_evolutions` VALUES (1,'da39a3ee5e6b4b0d3255bfef95601890afd80709','2016-03-30 06:04:10','','','applied','');
/*!40000 ALTER TABLE `play_evolutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_application`
--

DROP TABLE IF EXISTS `view_application`;
/*!50001 DROP VIEW IF EXISTS `view_application`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_application` AS SELECT 
 1 AS `id`,
 1 AS `idCardNo`,
 1 AS `applyItem`,
 1 AS `signDoctor`,
 1 AS `applyDepartment`,
 1 AS `applyTime`,
 1 AS `examAddress`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_examination`
--

DROP TABLE IF EXISTS `view_examination`;
/*!50001 DROP VIEW IF EXISTS `view_examination`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_examination` AS SELECT 
 1 AS `id`,
 1 AS `idCardNo`,
 1 AS `examDepartment`,
 1 AS `examAddress`,
 1 AS `examItem`,
 1 AS `admin`,
 1 AS `applyDepartment`,
 1 AS `applyItem`,
 1 AS `applyTime`,
 1 AS `signDoctor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_person`
--

DROP TABLE IF EXISTS `view_person`;
/*!50001 DROP VIEW IF EXISTS `view_person`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_person` AS SELECT 
 1 AS `id`,
 1 AS `idCardNo`,
 1 AS `organization`,
 1 AS `name`,
 1 AS `gender`,
 1 AS `age`,
 1 AS `tel`,
 1 AS `marryStatus`,
 1 AS `examID`,
 1 AS `examImage`,
 1 AS `applyID`,
 1 AS `applyImage`,
 1 AS `cost`,
 1 AS `allCost`,
 1 AS `address`,
 1 AS `printNumber`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_application`
--

/*!50001 DROP VIEW IF EXISTS `view_application`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_application` AS select `application`.`id` AS `id`,`application`.`idCardNo` AS `idCardNo`,`application`.`applyItem` AS `applyItem`,`application`.`signDoctor` AS `signDoctor`,`application`.`applyDepartment` AS `applyDepartment`,`application`.`applyTime` AS `applyTime`,`application`.`examAddress` AS `examAddress` from `application` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_examination`
--

/*!50001 DROP VIEW IF EXISTS `view_examination`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_examination` AS select `examination`.`id` AS `id`,`examination`.`idCardNo` AS `idCardNo`,`examination`.`examDepartment` AS `examDepartment`,`examination`.`examAddress` AS `examAddress`,`examination`.`examItem` AS `examItem`,`examination`.`admin` AS `admin`,`examination`.`applyDepartment` AS `applyDepartment`,`examination`.`applyItem` AS `applyItem`,`examination`.`applyTime` AS `applyTime`,`examination`.`signDoctor` AS `signDoctor` from `examination` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_person`
--

/*!50001 DROP VIEW IF EXISTS `view_person`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_person` AS select `person`.`id` AS `id`,`person`.`idCardNo` AS `idCardNo`,`person`.`organization` AS `organization`,`person`.`name` AS `name`,`person`.`gender` AS `gender`,`person`.`age` AS `age`,`person`.`tel` AS `tel`,`person`.`marryStatus` AS `marryStatus`,`person`.`examID` AS `examID`,`person`.`examImage` AS `examImage`,`person`.`applyID` AS `applyID`,`person`.`applyImage` AS `applyImage`,`person`.`cost` AS `cost`,`person`.`allCost` AS `allCost`,`person`.`address` AS `address`,`person`.`printNumber` AS `printNumber` from `person` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-21 20:16:52
