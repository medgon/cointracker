--
-- Create DB and User
--

CREATE USER IF NOT EXISTS 'app_cointracker'@'localhost' IDENTIFIED BY 'app123';
GRANT SELECT, INSERT, UPDATE, DELETE ON cointracker.* TO 'app_cointracker'@'localhost';

DROP SCHEMA IF EXISTS `cointracker`;
CREATE DATABASE `cointracker`  DEFAULT CHARACTER SET utf8;
USE `cointracker`;

--
-- Done
--
select "Woohoo! All Done!";


