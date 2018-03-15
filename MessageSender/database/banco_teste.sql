CREATE DATABASE  IF NOT EXISTS `banco_teste` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco_teste`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_teste
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
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `numero` bigint(20) NOT NULL,
  `tipo` int(11) NOT NULL,
  `usuario` bigint(20) NOT NULL,
  `senha` longtext NOT NULL,
  `usa_biometria` tinyint(4) NOT NULL,
  `biometria1` longtext NOT NULL,
  `biometria2` longtext NOT NULL,
  `ativa` tinyint(4) NOT NULL,
  `saldo` double NOT NULL,
  `limite_saque_diario` double NOT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_conta_usuario_idx` (`usuario`),
  CONSTRAINT `fk_conta_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cpf` bigint(20) NOT NULL,
  `nome` varchar(145) NOT NULL,
  `rg` bigint(20) NOT NULL,
  `email` varchar(75) NOT NULL,
  `telefone` bigint(20) NOT NULL,
  `endereco` varchar(145) NOT NULL,
  `numero` varchar(15) DEFAULT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(3) NOT NULL,
  `cep` bigint(20) NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `rg_UNIQUE` (`rg`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefone_UNIQUE` (`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (8468331406,'Douglas Fernandes da Silva Filho',7898636,'douglasf.filho@gmail.com',81996729491,'Rua teste','s/n','Bairro teste','Cidade teste','TT',54470250);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'banco_teste'
--

--
-- Dumping routines for database 'banco_teste'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-11  0:03:48
