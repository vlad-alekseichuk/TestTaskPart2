-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: stest
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `row`
--
git remote add origin https://vlad-alekseichuk:Apps19216801@github.com/vlad-alekseichuk/TestTaskPart1.git
DROP TABLE IF EXISTS `row`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `row` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `row`
--

LOCK TABLES `row` WRITE;
/*!40000 ALTER TABLE `row` DISABLE KEYS */;
INSERT INTO `row` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `row` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `row_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdi0ritgi9llxrfh0l35slxtfv` (`row_id`),
  CONSTRAINT `FKdi0ritgi9llxrfh0l35slxtfv` FOREIGN KEY (`row_id`) REFERENCES `row` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'',4,1),(2,'',2,1),(3,'',5,1),(4,'',1,1),(5,'',3,1),(6,'\0',8,1),(7,'\0',6,1),(8,'',7,1),(9,'',9,1),(10,'\0',10,1),(11,'',1,2),(12,'\0',6,2),(13,'',4,2),(14,'',5,2),(15,'\0',10,2),(16,'',3,2),(17,'\0',7,2),(18,'',8,2),(19,'',2,2),(20,'',9,2),(21,'\0',2,3),(22,'',4,3),(23,'\0',6,3),(24,'',10,3),(25,'\0',5,3),(26,'',8,3),(27,'\0',3,3),(28,'\0',7,3),(29,'',9,3),(30,'',1,3),(31,'\0',2,4),(32,'',9,4),(33,'\0',8,4),(34,'\0',10,4),(35,'\0',1,4),(36,'\0',3,4),(37,'',4,4),(38,'',5,4),(39,'',7,4),(40,'',6,4),(41,'\0',5,5),(42,'\0',1,5),(43,'',4,5),(44,'\0',3,5),(45,'',7,5),(46,'',6,5),(47,'\0',2,5),(48,'',8,5),(49,'\0',10,5),(50,'',9,5),(51,'',6,6),(52,'',7,6),(53,'\0',5,6),(54,'\0',2,6),(55,'\0',10,6),(56,'\0',8,6),(57,'',4,6),(58,'',9,6),(59,'',1,6),(60,'',3,6),(61,'',9,7),(62,'\0',8,7),(63,'',3,7),(64,'\0',7,7),(65,'\0',6,7),(66,'\0',4,7),(67,'\0',1,7),(68,'',10,7),(69,'',2,7),(70,'',5,7),(71,'',3,8),(72,'',9,8),(73,'',10,8),(74,'',4,8),(75,'',5,8),(76,'\0',7,8),(77,'',1,8),(78,'\0',6,8),(79,'',8,8),(80,'',2,8),(81,'',8,9),(82,'\0',2,9),(83,'',7,9),(84,'',9,9),(85,'',4,9),(86,'\0',10,9),(87,'\0',6,9),(88,'\0',1,9),(89,'\0',5,9),(90,'',3,9),(91,'',7,10),(92,'\0',5,10),(93,'',8,10),(94,'',3,10),(95,'\0',9,10),(96,'\0',4,10),(97,'',1,10),(98,'\0',2,10),(99,'',6,10),(100,'\0',10,10);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$vTFRjgqxZ4jlOxpG3S3C3uKw5zQ5rVGrnaJ.LZQ/hHuGOQTSLt2We',0,'admin'),(2,'$2a$10$qp3UZEIUK4nttkj9c1XUv.dgcSQGmR/ssTmTGGRt0Tvesssx7XB16',1,'user1'),(3,'$2a$10$kwDP69Wh1WkSdwMSqgsyROR.Dtg9hSSmZzdlal7bM5.L9euZpRjx6',1,'user2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 11:57:27
