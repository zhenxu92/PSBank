/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - market
*********************************************************************
*/



CREATE DATABASE /*!32312 IF NOT EXISTS*/`psbankdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `psbankdb`;

/*Table structure for table `ausertable` */

DROP TABLE IF EXISTS `account`;

create table `account` (
	`accountNo` int(11) NOT NULL,
    `accountHolderName` varchar(45),
    `balance` int(11),
    `accountType` varchar(45),
    `dateOfBirth` datetime,
    `psCode` varchar(45)
) engine=InnoDB default charset=utf8;

