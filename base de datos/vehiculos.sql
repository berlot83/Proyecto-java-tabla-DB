-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-09-2016 a las 15:00:38
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vehiculos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE IF NOT EXISTS `aviones` (
  `id` int(11) DEFAULT NULL,
  `modelo` text,
  `tiempo_de_utilidad` int(11) DEFAULT NULL,
  `alias` text,
  `nacionalidad` text,
  `autonomia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`id`, `modelo`, `tiempo_de_utilidad`, `alias`, `nacionalidad`, `autonomia`) VALUES
(1, 'F-16', 30, 'Figthing Falcon', 'EEUU', 111),
(2, 'F-18', 35, 'Hornet', 'EEUU', 111),
(3, 'F-22', 35, 'Raptor', 'EEUU', 111),
(4, 'F-15', 35, 'Strike Eagle', 'EEUU', 111),
(5, 'SU-27', 35, 'Flanker', 'Russia', 250),
(6, 'SU-29', 35, 'Flanker2', 'Russia', 250),
(7, 'Su-31', 55, 'Super Flanker', 'Russia', 250),
(9, 'IA-53', 40, 'Pucará', 'Arg', 250),
(10, 'F-1', 30, 'Mirage', 'Fra', 250),
(11, 'Saab-39', 30, 'JAS-Gripen', 'Sue', 250),
(12, 'Dassault Rafale', 25, 'Rafale', 'Fra', 250),
(13, 'F-14', 45, 'Tomcat', 'EEUU', 111),
(14, 'MIG-21', 35, 'Mikoyan', 'Russia', 250),
(15, 'MIG-23', 40, 'Mikoyan', 'Russia', 250),
(17, 'Mirage-2000', 30, 'Mirage-2000', 'Fra', NULL),
(18, 'SU-30MKI', 35, 'Super Flanker 30', 'Russia', NULL),
(19, 'F-117', 40, 'Knight Hawk', 'EEUU', 111),
(20, 'MIG-29', 35, 'Mikoyan', 'Russia', NULL),
(21, 'F-111', 30, 'Prowler', 'EEUU', 111),
(8, 'Boeing 737', 50, 'Being737', 'EEUU', 111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `helicopteros`
--

CREATE TABLE IF NOT EXISTS `helicopteros` (
  `id` int(11) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `armamento` varchar(50) DEFAULT NULL,
  `autonomia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `helicopteros`
--

INSERT INTO `helicopteros` (`id`, `modelo`, `armamento`, `autonomia`) VALUES
(1, 'Apache', 'Hellfire misiles', 120),
(2, 'Huey H1', 'Rockets', 160),
(3, 'Puma', 'Exocet', 150),
(4, 'UH-60 BlackHawk', 'Hellfire Rockets', 200),
(5, 'H1 Cobra', 'Hellfire Rockets', 100),
(6, 'Augusta 109', 'Ninguno', 100),
(7, 'Chinook', 'Ninguno', 250);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `navios`
--

CREATE TABLE IF NOT EXISTS `navios` (
  `id` int(11) NOT NULL,
  `Nombre` text CHARACTER SET latin1,
  `Tipo` text CHARACTER SET latin1,
  `Antiguedad` int(11) DEFAULT NULL,
  `Nacionalidad` text CHARACTER SET latin1
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `navios`
--

INSERT INTO `navios` (`id`, `Nombre`, `Tipo`, `Antiguedad`, `Nacionalidad`) VALUES
(1, 'invincible', 'Portaviones', 50, 'EEUU'),
(2, 'Belgrano', 'Crucero', 100, 'Argentina'),
(3, 'Roosvelt', 'Portaviones', 50, 'EEUU'),
(4, 'Principe de Asturias', 'Portaviones', 50, 'España'),
(5, 'Hercules', 'Destructor', 50, 'Inglaterra'),
(6, 'Conqueror', 'Destructor', 50, 'EEUU'),
(16, 'Emperador', 'Destructor', 60, 'EspaÃ±a'),
(17, 'USS Abraham Lincoln', 'Portaviones', 40, 'EEUU'),
(18, 'USS Nimitz', 'Portaviones', 40, 'EEUU'),
(19, 'USS Washington', 'Portaviones', 50, 'EEUU'),
(20, 'Vikrant', 'Portaviones', 2, 'India'),
(21, 'Charles De Gaulle', 'Portaviones', 10, 'Francia'),
(22, 'Hyuga', 'Portaviones', 10, 'Japon'),
(23, 'Vladimir Monomaj', 'Submarino', 20, 'Rusia'),
(24, 'Boiki', 'Fragata', 10, 'Rusia'),
(25, 'USS Litoral', 'Fragata', 5, 'EEUU'),
(26, 'USS Gerald Ford', 'Portaviones', 40, 'EEUU'),
(27, '', '', 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `usuarios` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Nombre`, `usuarios`, `password`, `email`) VALUES
(1, '', 'axel', 'berlot', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `navios`
--
ALTER TABLE `navios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `navios`
--
ALTER TABLE `navios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=361;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
