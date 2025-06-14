CREATE DATABASE  IF NOT EXISTS `db_cine2` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `db_cine2`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: db_cine2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `cine`
--

DROP TABLE IF EXISTS `cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cine` (
  `id_cine` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `empleados` varbinary(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peliculas` varbinary(255) DEFAULT NULL,
  `salas` varbinary(255) DEFAULT NULL,
  `ventas` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id_cine`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cine`
--

LOCK TABLES `cine` WRITE;
/*!40000 ALTER TABLE `cine` DISABLE KEYS */;
INSERT INTO `cine` VALUES (1,'Av. Santa Fe 3000, Palermo',NULL,'Cine Palermo',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'maria.gomez@example.com','Maria'),(2,'juani@hotmail.com','juanni'),(3,'jorgito@guaymallen.com','Jorge');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` bigint(20) NOT NULL AUTO_INCREMENT,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_cine`
--

DROP TABLE IF EXISTS `empleado_cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_cine` (
  `empleado_id` bigint(20) NOT NULL,
  `cine_id` bigint(20) NOT NULL,
  KEY `FK45djr86fa8q09d23j31s4tlj` (`cine_id`),
  KEY `FKfkolas5w1yp96ggi0ka8u2n0q` (`empleado_id`),
  CONSTRAINT `FK45djr86fa8q09d23j31s4tlj` FOREIGN KEY (`cine_id`) REFERENCES `cine` (`id_cine`),
  CONSTRAINT `FKfkolas5w1yp96ggi0ka8u2n0q` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_cine`
--

LOCK TABLES `empleado_cine` WRITE;
/*!40000 ALTER TABLE `empleado_cine` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado_cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `id_entrada` bigint(20) NOT NULL AUTO_INCREMENT,
  `asiento` varchar(255) DEFAULT NULL,
  `funciones` varbinary(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id_entrada`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,'A1',NULL,1500);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `id_funcion` bigint(20) NOT NULL AUTO_INCREMENT,
  `horario` varchar(255) DEFAULT NULL,
  `pelicula_id_pelicula` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_funcion`),
  KEY `FKpf1bww08svktyo0h80emr6wmq` (`pelicula_id_pelicula`),
  CONSTRAINT `FKpf1bww08svktyo0h80emr6wmq` FOREIGN KEY (`pelicula_id_pelicula`) REFERENCES `pelicula` (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,'18:00',1),(2,'21:00',1),(3,'15:00',1),(4,'23:00',1),(5,'21:00',2),(6,'15:00',2),(7,'23:00',2),(8,'18:00',3),(9,'21:00',3),(10,'15:00',3),(11,'23:00',3),(12,'18:00',4),(13,'21:00',4),(14,'15:00',4),(15,'23:00',4);
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion_entrada`
--

DROP TABLE IF EXISTS `funcion_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion_entrada` (
  `funcion_id` bigint(20) NOT NULL,
  `entrada_id` bigint(20) NOT NULL,
  KEY `FK6vgypb6xnbw66vghttr6042sb` (`entrada_id`),
  KEY `FKnubavht5thufhkqvq6cgv4ckp` (`funcion_id`),
  CONSTRAINT `FK6vgypb6xnbw66vghttr6042sb` FOREIGN KEY (`entrada_id`) REFERENCES `entrada` (`id_entrada`),
  CONSTRAINT `FKnubavht5thufhkqvq6cgv4ckp` FOREIGN KEY (`funcion_id`) REFERENCES `funcion` (`id_funcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion_entrada`
--

LOCK TABLES `funcion_entrada` WRITE;
/*!40000 ALTER TABLE `funcion_entrada` DISABLE KEYS */;
INSERT INTO `funcion_entrada` VALUES (1,1);
/*!40000 ALTER TABLE `funcion_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumo` (
  `id_insumo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_compra` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_insumo`),
  KEY `FKdx2yw0rj0gemjb1feshbgqenr` (`id_compra`),
  CONSTRAINT `FKdx2yw0rj0gemjb1feshbgqenr` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id_pago` bigint(20) NOT NULL AUTO_INCREMENT,
  `monto` double DEFAULT NULL,
  `tipo` enum('EFECTIVO','TARJETA') DEFAULT NULL,
  `ventas` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,250,'EFECTIVO',NULL),(2,250,'TARJETA',NULL);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id_pelicula` bigint(20) NOT NULL AUTO_INCREMENT,
  `genero` enum('ACCION','COMEDIA','DRAMA','SUSPENSO') DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'ACCION','Guardianes de la Galaxia Vol. 3'),(2,'ACCION','Depredador'),(3,'ACCION','El laberinto del Fauno'),(4,'ACCION','Arma letal 2');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id_proveedor` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_compra` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `FKlnw7va21x2q4dqrwphcw6vyb2` (`id_compra`),
  CONSTRAINT `FKlnw7va21x2q4dqrwphcw6vyb2` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `id_sala` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacidad` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala_funcion`
--

DROP TABLE IF EXISTS `sala_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala_funcion` (
  `sala_id` bigint(20) NOT NULL,
  `funcion_id` bigint(20) NOT NULL,
  KEY `FKombd6475c9xcrlbstmsi88gb0` (`funcion_id`),
  KEY `FKi7olf5ara3389sekc60yd3jyc` (`sala_id`),
  CONSTRAINT `FKi7olf5ara3389sekc60yd3jyc` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id_sala`),
  CONSTRAINT `FKombd6475c9xcrlbstmsi88gb0` FOREIGN KEY (`funcion_id`) REFERENCES `funcion` (`id_funcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala_funcion`
--

LOCK TABLES `sala_funcion` WRITE;
/*!40000 ALTER TABLE `sala_funcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `sala_funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(255) DEFAULT NULL,
  `pago_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `FKkygkw890hif50pl2879u946kw` (`pago_id`),
  CONSTRAINT `FKkygkw890hif50pl2879u946kw` FOREIGN KEY (`pago_id`) REFERENCES `pago` (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (2,'2025-06-11',1),(3,'2025-06-17',1),(4,'2025-06-24',1),(5,'2025-06-10',1),(6,'2025-06-24',2);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_cliente`
--

DROP TABLE IF EXISTS `venta_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_cliente` (
  `venta_id` bigint(20) NOT NULL,
  `cliente_id` bigint(20) NOT NULL,
  KEY `FKjhnj3muatinpufvyy4us2s7tt` (`cliente_id`),
  KEY `FKjh7wmr10s1uq4m20o2giww2c6` (`venta_id`),
  CONSTRAINT `FKjh7wmr10s1uq4m20o2giww2c6` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id_venta`),
  CONSTRAINT `FKjhnj3muatinpufvyy4us2s7tt` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_cliente`
--

LOCK TABLES `venta_cliente` WRITE;
/*!40000 ALTER TABLE `venta_cliente` DISABLE KEYS */;
INSERT INTO `venta_cliente` VALUES (2,1),(3,1),(4,1),(5,2),(6,3);
/*!40000 ALTER TABLE `venta_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_funcion`
--

DROP TABLE IF EXISTS `venta_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_funcion` (
  `venta_id` bigint(20) NOT NULL,
  `funcion_id` bigint(20) NOT NULL,
  KEY `FKike4ktajsd6h5mbveyg9oysa7` (`funcion_id`),
  KEY `FK9y4m6ejsr5xnppj8kv87s185v` (`venta_id`),
  CONSTRAINT `FK9y4m6ejsr5xnppj8kv87s185v` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id_venta`),
  CONSTRAINT `FKike4ktajsd6h5mbveyg9oysa7` FOREIGN KEY (`funcion_id`) REFERENCES `funcion` (`id_funcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_funcion`
--

LOCK TABLES `venta_funcion` WRITE;
/*!40000 ALTER TABLE `venta_funcion` DISABLE KEYS */;
INSERT INTO `venta_funcion` VALUES (2,1),(3,1),(4,1),(5,1),(6,10);
/*!40000 ALTER TABLE `venta_funcion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-13 23:01:47
