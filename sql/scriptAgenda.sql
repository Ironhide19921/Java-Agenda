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
  `localidad_id` int(11) NOT NULL,
  `tipo_contacto_id` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`),
  CONSTRAINT FOREIGN KEY fk_localidad (localidad_id) REFERENCES localidades (idLocalidad),
  CONSTRAINT FOREIGN KEY fk_tipo_contacto (tipo_contacto_id) REFERENCES tiposContacto (idTipoContacto)
);
