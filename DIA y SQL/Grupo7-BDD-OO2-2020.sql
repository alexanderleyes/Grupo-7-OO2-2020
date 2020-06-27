CREATE DATABASE  IF NOT EXISTS `grupo-7-bdd-oo2-2020`;
USE `grupo-7-bdd-oo2-2020`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-7-bdd-oo2-2020
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (21),(22),(23);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (_binary '\0','11:27','13:27','1',0,'Leyes',1),(_binary '\0','12:28','16:28','2',0,'Martinez',2),(_binary '\0','11:30','12:30','3',0,'Lescano',3),(_binary '\0','11:31','11:31','4',0,'Aguirre',4),(_binary '\0','11:32','11:32','5',0,'Jaldin',5),(_binary '\0','11:46','11:46','11',0,'Empleado11',6),(_binary '\0','11:48','11:48','22',0,'Empleado12',7),(_binary '\0','11:49','11:49','13',0,'Empleado13',8),(_binary '\0','11:50','11:51','21',0,'Empleado21',9),(_binary '\0','11:51','11:51','22',0,'Empleado22',10),(_binary '\0','12:54','12:54','23',0,'Empleado23',11),(_binary '\0','11:58','11:58','31',0,'Empleado31',12),(_binary '\0','11:58','13:58','32',0,'Empleado32',13),(_binary '\0','13:00','14:00','33',0,'Empleado33',14),(_binary '\0','11:02','12:02','41',0,'Empleado41',15),(_binary '\0','15:03','11:08','42',0,'Empleado42',16),(_binary '\0','15:04','17:04','43',0,'Empleado43',17),(_binary '\0','12:05','13:05','51',0,'Empleado51',18),(_binary '\0','12:07','12:07','52',0,'Empleado52',19),(_binary '\0','12:09','13:09','53',0,'Empleado53',20);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `estado_venta`
--

LOCK TABLES `estado_venta` WRITE;
/*!40000 ALTER TABLE `estado_venta` DISABLE KEYS */;
INSERT INTO `estado_venta` VALUES (1,'inicial','inicial'),(2,'pendiente','pendiente'),(3,'finalizado','finalizado');
/*!40000 ALTER TABLE `estado_venta` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `gerente`
--

LOCK TABLES `gerente` WRITE;
/*!40000 ALTER TABLE `gerente` DISABLE KEYS */;
INSERT INTO `gerente` VALUES ('2020-05-01',1),('2020-05-02',2),('2020-05-03',3),('2020-05-04',4),('2020-05-05',5);
/*!40000 ALTER TABLE `gerente` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `historico_comisiones`
--

LOCK TABLES `historico_comisiones` WRITE;
/*!40000 ALTER TABLE `historico_comisiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_comisiones` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,14,_binary '\0','2020-05-29',1,1),(2,50,_binary '\0','2020-05-30',4,1),(3,44,_binary '\0','2020-05-29',10,1),(4,52,_binary '\0','2020-05-30',4,2),(5,35,_binary '\0','2020-05-30',10,2),(6,65,_binary '\0','2020-05-30',6,2),(7,48,_binary '\0','2020-05-29',4,3),(8,25,_binary '\0','2020-05-30',2,3),(9,34,_binary '\0','2020-05-30',9,3),(10,34,_binary '\0','2020-05-30',6,4),(11,58,_binary '\0','2020-05-30',7,4),(12,121,_binary '\0','2020-05-29',8,4),(13,35,_binary '\0','2020-05-30',1,5),(14,32,_binary '\0','2020-05-30',5,5),(15,45,_binary '\0','2020-05-30',3,5),(16,43,_binary '\0','2020-05-30',2,3),(17,36,_binary '\0','2020-05-30',2,4),(18,67,_binary '\0','2020-05-30',1,5),(19,26,_binary '\0','2020-05-30',7,1);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES (1,'Productos','5'),(2,'Empleados','3');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Leyes',1,'2020-05-01','Alex'),(2,'Martinez',2,'2020-05-02','Carla'),(3,'Lescano',3,'2020-05-03','Solange'),(4,'Aguirre',4,'2020-05-04','Diego'),(5,'Jaldin',5,'2020-05-05','Micaela'),(6,'Empleado11',11,'2020-05-01','Empleado'),(7,'Empleado12',22,'2020-05-02','Empleado'),(8,'Empleado13',13,'2020-05-03','Empleado'),(9,'Empleado21',21,'2020-05-01','Empleado'),(10,'Empleado22',22,'2020-05-02','Empleado'),(11,'Empleado23',23,'2020-05-03','Empleado'),(12,'Empleado31',31,'2020-05-01','Empleado'),(13,'Empleado32',32,'2020-05-02','Empleado'),(14,'Empleado33',33,'2020-05-03','Empleado'),(15,'Empleado41',41,'2020-05-01','Empleado'),(16,'Empleado42',42,'2020-05-23','Empleado'),(17,'Empleado43',43,'2020-05-03','Empleado'),(18,'Empleado51',51,'2020-05-01','Empleado'),(19,'Empleado52',52,'2020-05-02','Empleado'),(20,'Empleado53',53,'2020-05-03','Empleado'),(21,'Vranic',124578,'1990-12-12','Alejandra'),(22,'Siciliano',986532,'1999-10-05','Gustavo'),(23,'Mansilla',68971,'1990-08-29','Romina');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'campera','2020-05-30',1000),(2,'Remera','2020-05-30',500),(3,'pantalon','2020-05-30',3000),(4,'zapatillas','2020-05-30',1234),(5,'Lentes','2020-05-30',3421),(6,'calza','2020-05-30',4332),(7,'gorro','2020-05-30',400),(8,'camisa','2020-05-30',4500),(9,'bufanda','2020-05-30',1456),(10,'sweter','2020-05-30',1356);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Banfield 100',-34.74471,'Banfield',-58.4041,123456789,1),(2,'Lanus 200',-58.4041,'Lanus',-58.3955,123456789,2),(3,'Guernica 300',-34.91722,'Guernica',-58.38694,123456789,3),(4,'Avellaneda 400',-34.66018,'Avellaneda',-58.36744,123456789,4),(5,'Burzaco 500',-34.82721,'Burzaco',-58.39505,123456789,5);
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2020-05-24 02:01:31.000000',_binary '','$2a$04$lL2txe9OQXcjHxLvqwPGJ.0BjmTYt0pcH0SZ9KVR8iEOH340Faufa','2020-05-24 02:01:31.000000','user'),(2,'2020-05-30 13:28:24.337000',_binary '','$2a$04$ixNrCGWArbNPtCi.HifQV.6TmNZZbdXZgKH3lpHsRVkypfYwOMZES','2020-05-30 13:28:24.338000','Leyes'),(3,'2020-05-30 13:29:01.332000',_binary '','$2a$04$Qcqj6rhwZVjcOAH2Kq7VmODgz/Ft1kHtqBx53UcB530A6Lw8in5iO','2020-05-30 13:29:01.332000','Martinez'),(4,'2020-05-30 13:30:48.104000',_binary '','$2a$04$4ELBcuT2mb3NQMUEma5qreJFRw.A2LAeSqoACZsqmrv77tvnN/2xW','2020-05-30 13:30:48.104000','Lescano'),(5,'2020-05-30 13:32:08.460000',_binary '','$2a$04$ZZ.giq33TxBdVGMMpjuZ.u6hPvHEwDEyPGx.P6xgssWSmpw9Z.K5O','2020-05-30 13:32:08.460000','Aguirre'),(6,'2020-05-30 13:32:52.973000',_binary '','$2a$04$mNzyvsLqmTBu.nE8k52t/.Ef27mCJXTlSVDclIO4HQddEL783UNCu','2020-05-30 13:32:52.974000','Jaldin'),(7,'2020-05-30 13:46:55.398000',_binary '','$2a$04$4OmzH2DnHGSWS7PkDoedN.FWT71VVkf0ZtOiIj1.PcJXTjsXUtdvK','2020-05-30 13:46:55.399000','Empleado11'),(8,'2020-05-30 13:48:21.715000',_binary '','$2a$04$LzfyJq9f/GHGNDOWxgNWWO9pt509jvwMY.ThDf4yrhOrxrXHoymxq','2020-05-30 13:48:21.715000','Empleado12'),(9,'2020-05-30 13:49:34.512000',_binary '','$2a$04$PWPrd9neKsgUlIrholfR/.1nKc9I9io8gZakJiUP06i2FY5M8d5P.','2020-05-30 13:49:34.513000','Empleado13'),(10,'2020-05-30 13:51:14.496000',_binary '','$2a$04$1mmcYx2AuN.FDR2a4rehZeeivjf2IYmgytXI/tOph2n6my.Jbnsl6','2020-05-30 13:51:14.496000','Empleado21'),(11,'2020-05-30 13:51:53.553000',_binary '','$2a$04$wT7bU3fti/p/5CfCr53U5uBx7cm1DspVDOnrGopIMiKRYu5YVonHG','2020-05-30 13:51:53.554000','Empleado22'),(12,'2020-05-30 13:55:07.034000',_binary '','$2a$04$9lAiWhKsDYjj/.RAr8s2Le1mkQae4pv2fDppPzT6TcBhdJgXrYztm','2020-05-30 13:55:07.034000','Empleado23'),(13,'2020-05-30 13:58:22.681000',_binary '','$2a$04$8i79BQ7Kqwetegc3Xxk3xOCn39eUUK3qUTarsmn8zUHtYpV2Ax2TS','2020-05-30 13:58:22.681000','Empleado31'),(14,'2020-05-30 13:59:06.420000',_binary '','$2a$04$yFOiw/BHVydMTAilVdz0FOHuxnS5effEq6tYX/MqLtc0CZUKJGHeu','2020-05-30 13:59:06.420000','Empleado32'),(15,'2020-05-30 14:00:32.318000',_binary '','$2a$04$QxKSNTCya0CUzwo2HBEIzO.HUMaAQ.9pnyMyP0yYpJq4OMtTn2Gd.','2020-05-30 14:00:32.318000','Empleado33'),(16,'2020-05-30 14:02:40.648000',_binary '','$2a$04$Urr.6AVo.Rypv1kgLVEKc.ZX5VTqCwdjHlRJowvOCetYBcqkNg9iC','2020-05-30 14:02:40.649000','Empleado41'),(17,'2020-05-30 14:03:51.146000',_binary '','$2a$04$wGNTZsr0St8OFSCH2mSoX.arLNmy4ntJHOKPZf9.8iBtL2Nx9WEfe','2020-05-30 14:03:51.146000','Empleado42'),(18,'2020-05-30 14:04:24.599000',_binary '','$2a$04$wjefHoVfe5.yPau7kJGCIO6MNwfWO3pbXB5/UPBTiUZgANis8kDSW','2020-05-30 14:04:24.599000','Empleado43'),(19,'2020-05-30 14:05:48.582000',_binary '','$2a$04$YJV1Usqc9JustJb0BFUAweilBxzmF7GUw51jyW111RpsJ9J0KzTO.','2020-05-30 14:05:48.584000','Empleado51'),(20,'2020-05-30 14:07:32.485000',_binary '','$2a$04$vhHm2rCX.PXR0e5.1IA/POTu8OQW4mxCGUU8wWTmIOBpP8JWv3x6a','2020-05-30 14:07:32.485000','Empleado52'),(21,'2020-05-30 14:09:22.163000',_binary '','$2a$04$DWix.sd3UGycwhAHz1SH1Oy6gK0kXKh53xoudO7f6eoGz2ByaMB7O','2020-05-30 14:09:22.163000','Empleado53');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'2020-05-23 00:00:00.000000','ROLE_ADMIN','2020-05-23 00:00:00.000000',1),(2,'2020-05-30 13:28:24.436000','ROLE_GERENTE','2020-05-30 13:28:24.436000',2),(3,'2020-05-30 13:29:01.366000','ROLE_GERENTE','2020-05-30 13:29:01.366000',3),(4,'2020-05-30 13:30:48.143000','ROLE_GERENTE','2020-05-30 13:30:48.143000',4),(5,'2020-05-30 13:32:08.497000','ROLE_GERENTE','2020-05-30 13:32:08.497000',5),(6,'2020-05-30 13:32:53.008000','ROLE_GERENTE','2020-05-30 13:32:53.008000',6),(7,'2020-05-30 13:46:55.439000','ROLE_VENDEDOR','2020-05-30 13:46:55.440000',7),(8,'2020-05-30 13:48:21.732000','ROLE_VENDEDOR','2020-05-30 13:48:21.732000',8),(9,'2020-05-30 13:49:34.542000','ROLE_VENDEDOR','2020-05-30 13:49:34.542000',9),(10,'2020-05-30 13:51:14.525000','ROLE_VENDEDOR','2020-05-30 13:51:14.525000',10),(11,'2020-05-30 13:51:53.567000','ROLE_VENDEDOR','2020-05-30 13:51:53.567000',11),(12,'2020-05-30 13:55:07.053000','ROLE_VENDEDOR','2020-05-30 13:55:07.053000',12),(13,'2020-05-30 13:58:22.715000','ROLE_VENDEDOR','2020-05-30 13:58:22.715000',13),(14,'2020-05-30 13:59:06.478000','ROLE_VENDEDOR','2020-05-30 13:59:06.478000',14),(15,'2020-05-30 14:00:32.330000','ROLE_VENDEDOR','2020-05-30 14:00:32.330000',15),(16,'2020-05-30 14:02:41.024000','ROLE_VENDEDOR','2020-05-30 14:02:41.024000',16),(17,'2020-05-30 14:03:51.184000','ROLE_VENDEDOR','2020-05-30 14:03:51.185000',17),(18,'2020-05-30 14:04:24.627000','ROLE_VENDEDOR','2020-05-30 14:04:24.627000',18),(19,'2020-05-30 14:05:48.652000','ROLE_VENDEDOR','2020-05-30 14:05:48.652000',19),(20,'2020-05-30 14:07:32.501000','ROLE_VENDEDOR','2020-05-30 14:07:32.501000',20),(21,'2020-05-30 14:09:22.205000','ROLE_VENDEDOR','2020-05-30 14:09:22.205000',21);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;


-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (6,1),(7,1),(8,1),(9,2),(10,2),(11,2),(12,3),(13,3),(14,3),(15,4),(16,4),(17,4),(18,5),(19,5),(20,5);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `vta_items`
--

LOCK TABLES `vta_items` WRITE;
/*!40000 ALTER TABLE `vta_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `vta_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-26 20:26:18
