-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: TADeventos
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.18-MariaDB

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
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `idCategoria` int(11) NOT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compra`
--

DROP TABLE IF EXISTS `Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `evento_idevento` int(11) NOT NULL DEFAULT '0',
  `numero_cartao` varchar(45) DEFAULT NULL,
  `bandeira` varchar(45) DEFAULT NULL,
  `data_vencimento` varchar(45) DEFAULT NULL,
  `digito_validador` varchar(45) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `valorTotal` double DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_evento1_idx` (`evento_idevento`),
  CONSTRAINT `fk_Compra_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compra`
--

LOCK TABLES `Compra` WRITE;
/*!40000 ALTER TABLE `Compra` DISABLE KEYS */;
INSERT INTO `Compra` VALUES (1,17,'1111 1111 1111 1111','Visa','11/1111','111','12106672667',12.9),(2,16,'5555 5555 5555 5555','Visa','55/5555','555','12106672667',12.9),(3,19,'1111 1111 1111 1111','Visa','11/1111','111','12106672667',8),(4,17,'1111 1111 1111 1111','Visa','11/1111','111','12106672667',12.9),(5,17,'1111 1111 1111 1111','Visa','11/1111','111','12106672667',12.9);
/*!40000 ALTER TABLE `Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idevento` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  `Descricao` mediumtext,
  `datafim` timestamp NULL DEFAULT NULL,
  `datainicio` timestamp NULL DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `count_entradas` bigint(20) DEFAULT NULL,
  `preco_entrada` double DEFAULT NULL,
  `anfitriao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idevento`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (16,'eventoX','Uberaba','Minas Gerais','Brasil','eventoX','2016-12-21 02:00:00','2016-10-21 02:00:00','Uberaba - MG, Brasil',5,12.9,'josue123'),(17,'teste','Uberaba','Minas Gerais','Brasil','teste','2016-10-29 07:00:00','2016-10-12 04:00:00','Uberaba - MG, Brasil',20,12.9,'josue123'),(18,'eeeee','Uberlândia','Minas Gerais','Brasil','eeeeee','2016-10-25 15:35:00','2016-10-06 03:00:00','Uberlândia - MG, Brasil',611,19.12,'12106672667'),(19,'asdfasd','Uberaba','Minas Gerais','Brasil','asdfa','2016-10-22 02:00:00','2016-10-22 02:00:00','Uberaba - MG, Brasil',3,4,'12106672667'),(20,'Corrida Naruto','São Paulo','São Paulo','Brasil','Corrida Naruto: \r\n\r\nNão vale usar kunai','2016-10-26 16:00:00','2016-10-19 16:00:00','São Paulo - SP, Brasil',108,20,'12106672667'),(21,'gg','Uberaba','Minas Gerais','Brasil','gg','2016-10-29 00:04:30','2016-10-25 02:00:00','Uberaba - MG, Brasil',100,30,'12106672667');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_has_Categoria`
--

DROP TABLE IF EXISTS `evento_has_Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_has_Categoria` (
  `evento_idevento` int(11) NOT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`evento_idevento`,`Categoria_idCategoria`),
  KEY `fk_evento_has_Categoria_Categoria1_idx` (`Categoria_idCategoria`),
  KEY `fk_evento_has_Categoria_evento1_idx` (`evento_idevento`),
  CONSTRAINT `fk_evento_has_Categoria_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `Categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_Categoria_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_has_Categoria`
--

LOCK TABLES `evento_has_Categoria` WRITE;
/*!40000 ALTER TABLE `evento_has_Categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_has_Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (11,'josue123','$2a$11$nK6ZJsSu/nlvR.z.683iqeSveaMCaCoRcnJ7DbpjcBnOS3Yi74XAu'),(12,'12106672667','$2a$11$VHvHZDbP3deeG9lJJLgNIOKYh.8c2g4z9bEl09UPUsIcNTDktuRuy');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_evento`
--

DROP TABLE IF EXISTS `user_has_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_evento` (
  `user_id` int(11) DEFAULT NULL,
  `evento_idevento` int(11) DEFAULT NULL,
  KEY `fk_user_has_evento_evento1_idx` (`evento_idevento`),
  KEY `fk_user_has_evento_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_evento_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_evento_user1` FOREIGN KEY (`user_id`) REFERENCES `accounts`.`user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_evento`
--

LOCK TABLES `user_has_evento` WRITE;
/*!40000 ALTER TABLE `user_has_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (11,1),(12,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-23 19:04:56
