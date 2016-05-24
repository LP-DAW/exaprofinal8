-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-05-2016 a las 17:20:23
-- Versión del servidor: 5.5.49-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.16


-- $ mysql -f -p -u <admin_user> < exaprgfinal8.sql

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

DROP DATABASE exaprofinal8;
CREATE DATABASE if not exists exaprofinal8;
USE exaprofinal8;

--
-- Base de datos: `exaprofinal8`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `idp` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

CREATE TABLE IF NOT EXISTS `telefono` (
  `idt` int(3) NOT NULL AUTO_INCREMENT,
  `numero` varchar(15) NOT NULL,
  `idp` int(3) NULL,
   FOREIGN KEY (idp)
            REFERENCES persona(idp)
            ON DELETE CASCADE,
  PRIMARY KEY (`idt`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;






--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idp`, `nombre`) VALUES
(1,'Paco'),(2,'Juan');

INSERT INTO `telefono` (`idt`, `numero`, `idp`) VALUES
(1,'123',1),(2,'456',2);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


CREATE USER 'alumno'@'localhost' IDENTIFIED BY 'alumno';
GRANT ALL PRIVILEGES ON exaprofinal8.* TO 'alumno'@'localhost';
FLUSH PRIVILEGES;

