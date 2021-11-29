-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2021 at 09:08 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chatapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `id` int(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `chat` varchar(255) NOT NULL,
  `waktu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `nama`, `chat`, `waktu`) VALUES
(31, 'Lani', 'hai, ini lani', '2021-11-26, 08:20 am'),
(32, 'Siti', 'halo lani, ini siti', '2021-11-26, 08:21 am'),
(33, 'Lani', 'halo, tes lagi', '2021-11-26, 08:22 am'),
(34, 'Siti', 'Halo lg', '2021-11-26, 08:22 am'),
(35, 'Siti', 'tes lagi', '2021-11-26, 09:04 am'),
(36, 'Lani', 'halo2', '2021-11-26, 09:04 am'),
(37, 'siti', 'siti', '2021-11-26, 11:50 am'),
(38, 'Siti', 'siti', '2021-11-26, 11:51 am'),
(39, 'siti', 'testlink', '2021-11-26, 11:51 am'),
(40, 'siti', 'alai', '2021-11-26, 12:34 pm'),
(41, 'siti', 'alai', '2021-11-27, 05:08 am'),
(42, 'lani', 'kok2', '2021-11-27, 05:09 am'),
(43, 'siti', 'alai33', '2021-11-27, 05:10 am'),
(44, 'siti', 'haihaiiiiiiiiii', '2021-11-27, 05:10 am'),
(45, 'siti', 'tesssslagi', '2021-11-27, 05:15 am'),
(46, 'siti', 'alai', '2021-11-27, 05:16 am'),
(47, 'siti', 'alai', '2021-11-27, 05:27 am');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
