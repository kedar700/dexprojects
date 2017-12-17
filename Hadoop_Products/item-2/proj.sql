CREATE DATABASE weblog;
USE weblog;

CREATE TABLE `weblog`.`smalllog` (
  `idlog` INT NOT NULL AUTO_INCREMENT,
  `date1` VARCHAR(45) NOT NULL,
  `date2` VARCHAR(45) NOT NULL,
  `URL` VARCHAR(100) NOT NULL,
  `method` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlog`));
  
  CREATE TABLE `weblog`.`largelog` (
  `idlog` INT NOT NULL AUTO_INCREMENT,
  `date1` VARCHAR(45) NOT NULL,
  `date2` VARCHAR(45) NOT NULL,
  `URL` VARCHAR(100) NOT NULL,
  `method` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlog`));
  
select date1, URL, count(URL) from smalllog where URL!="/index.*"  group by date1;
select date2, URL, count(URL) from smalllog where URL!="/index.*"  group by date2;
select date1, URL, count(URL) from largelog where URL!="/index.*"  group by date1;
select date2, URL, count(URL) from largelog  where URL!="/index.*"  group by date2;

