-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: busbooking
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `busseat`
--

DROP TABLE IF EXISTS `busseat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busseat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `busno` varchar(255) NOT NULL,
  `seats` int NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busseat`
--

LOCK TABLES `busseat` WRITE;
/*!40000 ALTER TABLE `busseat` DISABLE KEYS */;
INSERT INTO `busseat` VALUES (406,'Sài Gòn -> Nha Trang',1,'12/10/2020','14:00','unbooked'),(407,'Sài Gòn -> Nha Trang',2,'12/10/2020','14:00','unbooked'),(408,'Sài Gòn -> Nha Trang',3,'12/10/2020','14:00','unbooked'),(409,'Sài Gòn -> Nha Trang',4,'12/10/2020','14:00','unbooked'),(410,'Sài Gòn -> Nha Trang',5,'12/10/2020','14:00','unbooked'),(411,'Sài Gòn -> Nha Trang',6,'12/10/2020','14:00','unbooked'),(412,'Sài Gòn -> Nha Trang',7,'12/10/2020','14:00','unbooked'),(413,'Sài Gòn -> Nha Trang',8,'12/10/2020','14:00','unbooked'),(414,'Sài Gòn -> Nha Trang',9,'12/10/2020','14:00','booked'),(415,'Sài Gòn -> Nha Trang',10,'12/10/2020','14:00','unbooked'),(416,'Sài Gòn -> Nha Trang',11,'12/10/2020','14:00','unbooked'),(417,'Sài Gòn -> Nha Trang',12,'12/10/2020','14:00','unbooked'),(418,'Sài Gòn -> Nha Trang',13,'12/10/2020','14:00','unbooked'),(419,'Sài Gòn -> Nha Trang',14,'12/10/2020','14:00','unbooked'),(420,'Sài Gòn -> Nha Trang',15,'12/10/2020','14:00','unbooked'),(421,'Sài Gòn -> Nha Trang',16,'12/10/2020','14:00','unbooked'),(422,'Sài Gòn -> Nha Trang',17,'12/10/2020','14:00','unbooked'),(423,'Sài Gòn -> Nha Trang',18,'12/10/2020','14:00','unbooked'),(424,'Sài Gòn -> Nha Trang',19,'12/10/2020','14:00','unbooked'),(425,'Sài Gòn -> Nha Trang',20,'12/10/2020','14:00','unbooked'),(426,'Sài Gòn -> Nha Trang',21,'12/10/2020','14:00','unbooked'),(427,'Sài Gòn -> Nha Trang',22,'12/10/2020','14:00','unbooked'),(428,'Sài Gòn -> Nha Trang',23,'12/10/2020','14:00','unbooked'),(429,'Sài Gòn -> Nha Trang',24,'12/10/2020','14:00','unbooked'),(430,'Sài Gòn -> Nha Trang',25,'12/10/2020','14:00','unbooked'),(431,'Sài Gòn -> Nha Trang',26,'12/10/2020','14:00','unbooked'),(432,'Sài Gòn -> Nha Trang',27,'12/10/2020','14:00','unbooked'),(433,'Sài Gòn -> Nha Trang',28,'12/10/2020','14:00','unbooked'),(434,'Sài Gòn -> Nha Trang',29,'12/10/2020','14:00','unbooked'),(435,'Sài Gòn -> Nha Trang',30,'12/10/2020','14:00','unbooked'),(436,'Sài Gòn -> Nha Trang',31,'12/10/2020','14:00','unbooked'),(437,'Sài Gòn -> Nha Trang',32,'12/10/2020','14:00','unbooked'),(438,'Sài Gòn -> Nha Trang',33,'12/10/2020','14:00','unbooked'),(439,'Sài Gòn -> Nha Trang',34,'12/10/2020','14:00','unbooked'),(440,'Sài Gòn -> Nha Trang',35,'12/10/2020','14:00','unbooked'),(441,'Sài Gòn -> Nha Trang',36,'12/10/2020','14:00','unbooked'),(442,'Sài Gòn -> Nha Trang',37,'12/10/2020','14:00','unbooked'),(443,'Sài Gòn -> Nha Trang',38,'12/10/2020','14:00','unbooked'),(444,'Sài Gòn -> Nha Trang',39,'12/10/2020','14:00','unbooked'),(445,'Sài Gòn -> Nha Trang',40,'12/10/2020','14:00','unbooked'),(446,'Sài Gòn -> Nha Trang',41,'12/10/2020','14:00','unbooked'),(447,'Sài Gòn -> Nha Trang',42,'12/10/2020','14:00','unbooked'),(448,'Sài Gòn -> Nha Trang',43,'12/10/2020','14:00','unbooked'),(449,'Sài Gòn -> Nha Trang',44,'12/10/2020','14:00','unbooked'),(450,'Sài Gòn -> Nha Trang',45,'12/10/2020','14:00','unbooked');
/*!40000 ALTER TABLE `busseat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 17:18:32
