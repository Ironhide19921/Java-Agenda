CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Cumpleanios` varchar(100) NULL,
  `Calle` varchar(70) NOT NULL,
  `Altura` varchar(25) NOT NULL,
  `Piso` varchar(10) NULL,
  `Depto` varchar(10) NULL,
  PRIMARY KEY (`idPersona`)
);
CREATE TABLE `localidades`
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);