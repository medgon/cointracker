--
-- Create DB and User
--

CREATE USER IF NOT EXISTS 'app_cointracker'@'localhost' IDENTIFIED BY 'app123';
GRANT SELECT, INSERT, UPDATE, DELETE ON cointracker.* TO 'app_cointracker'@'localhost';

DROP SCHEMA IF EXISTS `cointracker`;
CREATE DATABASE `cointracker`  DEFAULT CHARACTER SET utf8;
USE `cointracker`;

SET unique_checks=0;
SET foreign_key_checks=0;

DROP TABLE IF EXISTS `coin` ;
CREATE TABLE IF NOT EXISTS `coin` (
  `coin_id` bigint(12) NOT NULL AUTO_INCREMENT,
  `coin_name` VARCHAR(100) NOT NULL UNIQUE,
  `coin_abbreviation` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`coin_id`)
);

LOCK TABLES `coin` WRITE;
load data local infile '[csv_files_path]coins.csv' into table coin fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
UNLOCK TABLES;

SET unique_checks=1;
SET foreign_key_checks=1;

--
-- Done
--
select "Woohoo! All Done!";


