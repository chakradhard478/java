# ************************************************************
# Sequel Pro SQL dump
# Version 3408
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.1.48)
# Database: javatraining
# Generation Time: 2014-09-18 15:29:14 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table cd
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cd`;

CREATE TABLE `cd` (
  `cd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `artist` varchar(50) NOT NULL,
  `purchase_date` date DEFAULT NULL,
  `cd_type` varchar(50) NOT NULL,
  `newFeatures` varchar(50) DEFAULT NULL,
  `languages` varchar(50) DEFAULT NULL,
  `region` bigint(20) DEFAULT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`cd_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `cd` WRITE;
/*!40000 ALTER TABLE `cd` DISABLE KEYS */;

INSERT INTO `cd` (`cd_id`, `title`, `artist`, `purchase_date`, `cd_type`, `newFeatures`, `languages`, `region`, `cost`)
VALUES
	(1,'Grace','Peter','2014-09-17','Cd',NULL,NULL,NULL,8.44),
	(2,'PlayFul','John','2014-09-17','Special','widescreen',NULL,NULL,10.2),
	(3,'Grace Under Pressute','Rush','2014-09-17','International',NULL,'Spanish',4,9.99);

/*!40000 ALTER TABLE `cd` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`customerId`, `name`, `street`, `city`, `state`, `country`, `zipcode`)
VALUES
	(1,'Suresh','117 Princeton Rd','Parlin','NJ','US','08859'),
	(2,'Peter','120 Princeton Rd','Parlin','NJ','US','08859'),
	(3,'Chris','138 Princeton Rd','Princeton','NJ','US','08467'),
	(4,'Chris','158 Princeton Rd','Edison','NJ','US','08857'),
	(5,'Christoper','200 South drive','Jerseycity','NJ','US','08451'),
	(6,'TufanoChris','500 East drive','Jerseycity','NJ','US','08951'),
	(7,'David','80 Pequot Drive','Stamford','CT','US','06902'),
	(8,'Tony','111 East wood St','Parlin','NJ','US','08859'),
	(9,'Andrew','Pequot drive','Stratford','CT','US','06902'),
	(10,'Hari','Fountain St','New Haven','CT','US','06515'),
	(11,'menon',NULL,'Edison','NJ','US',NULL),
	(12,'Benoy',NULL,'BaskingRidge','NJ','US',NULL),
	(13,'Pheroza',NULL,'BaskingRidge','NJ','US',NULL),
	(14,'Paul',NULL,'BaskingRidge','NJ','US',NULL),
	(15,'Dan',NULL,'JerseyCity','NJ','US',NULL),
	(16,'Ramesh','Main Ave','Hartford','CT','US','06781'),
	(17,'Ram','200 Orchard St','West Haven','CT','US','06412'),
	(18,'Beth',NULL,'Somerset','NJ','US',NULL),
	(19,'Ben',NULL,'Somerville','NJ','US',NULL),
	(20,'Jenna',NULL,'Oldbridge','NJ','US',NULL),
	(21,'Jeff',NULL,'Oldbridge','NJ','US',NULL),
	(22,'Jeff','100 oldbridge ave','Oldbridge','NJ','US','12345'),
	(23,'Patrick','100 Boston Post Rd','Orange','CT','US','06512'),
	(24,'Tim','139 Boston Post Rd','Orange','CT','US','06513'),
	(25,'Steve','200 Boston Post Rd','Orange','CT','US','06542'),
	(26,'Alister','200 East Squire Dr','Rochester','NY','US','14623');

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table employee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;

INSERT INTO `employee` (`employeeId`, `name`, `designation`, `active`)
VALUES
	(1,'Harry','Manager',1);

/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table fourWheeler
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fourWheeler`;

CREATE TABLE `fourWheeler` (
  `vehicleId` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleName` varchar(25) DEFAULT NULL,
  `steeringFourWheeler` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`vehicleId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



# Dump of table ordersPlaced
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ordersPlaced`;

CREATE TABLE `ordersPlaced` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(20) DEFAULT NULL,
  `order_status` varchar(20) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_customerId` (`customerId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `ordersPlaced` WRITE;
/*!40000 ALTER TABLE `ordersPlaced` DISABLE KEYS */;

INSERT INTO `ordersPlaced` (`orderId`, `item`, `order_status`, `customerId`, `idx`)
VALUES
	(123,'Laptop','PLACED',1,0),
	(1234,'Phone','PLACED',1,1),
	(1235,'Pen','PLACED',11,0),
	(1236,'Printer','PLACED',12,0),
	(1237,'Milk','PLACED',13,0),
	(1238,'Desk','PLACED',14,0),
	(1239,'Book','PLACED',15,0),
	(1240,'Jacket','PLACED',16,NULL),
	(1241,'Coat','PLACED',17,NULL),
	(1242,'Case','PLACED',20,NULL),
	(1243,'Cake','PLACED',21,NULL);

/*!40000 ALTER TABLE `ordersPlaced` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table person
# ------------------------------------------------------------

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;

INSERT INTO `person` (`person_id`, `firstName`, `lastName`)
VALUES
	(1,'James','Patterson'),
	(2,'Gosling','opensource'),
	(3,'Parker','Mary');

/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table phoneInfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `phoneInfo`;

CREATE TABLE `phoneInfo` (
  `phoneId` int(11) NOT NULL AUTO_INCREMENT,
  `home` varchar(10) DEFAULT NULL,
  `cell` varchar(10) DEFAULT NULL,
  `work` varchar(10) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`phoneId`),
  KEY `fk_customerId` (`customerId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `phoneInfo` WRITE;
/*!40000 ALTER TABLE `phoneInfo` DISABLE KEYS */;

INSERT INTO `phoneInfo` (`phoneId`, `home`, `cell`, `work`, `customerId`)
VALUES
	(1,'5852605875','2039562625','',1),
	(2,'7324567891','','',2),
	(3,'7324567892','','',8),
	(4,'1111111111','1111111111',NULL,11),
	(5,'1111111111','1111111111',NULL,12),
	(6,'1111111111','2222222222',NULL,13),
	(7,'1111111111','2222222222',NULL,14),
	(8,'3333333333','2222222222',NULL,15),
	(9,'5555555555','4444444444',NULL,18),
	(10,'7777777777','6666666666',NULL,19),
	(11,'9999999999','8888888888',NULL,20),
	(12,'9999999999','8888888888',NULL,21);

/*!40000 ALTER TABLE `phoneInfo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reviewer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reviewer`;

CREATE TABLE `reviewer` (
  `reviewer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`reviewer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `reviewer` WRITE;
/*!40000 ALTER TABLE `reviewer` DISABLE KEYS */;

INSERT INTO `reviewer` (`reviewer_id`, `name`)
VALUES
	(1,'Tom'),
	(2,'John'),
	(4,'Robert'),
	(7,'Daniel'),
	(8,'Jeff');

/*!40000 ALTER TABLE `reviewer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reviewer_task
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reviewer_task`;

CREATE TABLE `reviewer_task` (
  `reviewer_id` int(11) DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `reviewer_task` WRITE;
/*!40000 ALTER TABLE `reviewer_task` DISABLE KEYS */;

INSERT INTO `reviewer_task` (`reviewer_id`, `task_id`)
VALUES
	(1,1),
	(1,2),
	(2,2),
	(4,4),
	(4,3),
	(7,5),
	(7,6),
	(8,7),
	(8,8);

/*!40000 ALTER TABLE `reviewer_task` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `instructor` varchar(255) DEFAULT NULL,
  `standard` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK8FFE823B961B9B25` (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;

INSERT INTO `student` (`instructor`, `standard`, `student_id`)
VALUES
	('Joshua',NULL,1),
	('Peter',NULL,3);

/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table task
# ------------------------------------------------------------

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;

INSERT INTO `task` (`task_id`, `name`)
VALUES
	(1,'Perforamance'),
	(2,'Quality'),
	(3,'Presentation'),
	(4,'Compilation'),
	(5,'Composition'),
	(6,'Printing'),
	(7,'Teaching'),
	(8,'Writing');

/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table teacher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `main_subject` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `teacher_id` bigint(20) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `FKAA31CBE28C839C1E` (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;

INSERT INTO `teacher` (`main_subject`, `salary`, `type`, `teacher_id`)
VALUES
	('java',1000,NULL,2);

/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table twoWheeler
# ------------------------------------------------------------

DROP TABLE IF EXISTS `twoWheeler`;

CREATE TABLE `twoWheeler` (
  `vehicleId` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleName` varchar(25) DEFAULT NULL,
  `steeringTwoWheeler` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`vehicleId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



# Dump of table vehicle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `vehicleId` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`vehicleId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
