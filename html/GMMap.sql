SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
CREATE DATABASE `fortpet2_guideme` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci;
USE `fortpet2_guideme`;

DROP TABLE IF EXISTS `Author`;
CREATE TABLE IF NOT EXISTS `Author` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `Surname` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `Email` varchar(80) COLLATE utf8_czech_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `Sex` varchar(1) COLLATE utf8_czech_ci NOT NULL DEFAULT 'm',
  `Contact` varchar(2000) COLLATE utf8_czech_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

DROP TABLE IF EXISTS `GMMap`;
CREATE TABLE IF NOT EXISTS `GMMap` (
  `Guid` varchar(64) COLLATE utf8_czech_ci NOT NULL,
  `Name` varchar(80) COLLATE utf8_czech_ci NOT NULL,
  `GpsCoords` varchar(23) COLLATE utf8_czech_ci NOT NULL,
  `Description` varchar(2000) COLLATE utf8_czech_ci DEFAULT NULL,
  `AuthorID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Guid`),
  UNIQUE KEY `Guid` (`Guid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
