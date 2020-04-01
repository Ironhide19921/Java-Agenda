CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `localidades`
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);
CREATE TABLE `tiposContacto`
(
  `idTipoContacto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoContacto`)
);
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
  `loc` varchar(50) NULL,
  `tipo` varchar(50) NULL,
  `CodPostal` varchar(20) NOT NULL,
  `EquipoPref` varchar(50) NOT NULL,
  PRIMARY KEY (`idPersona`)
 );
