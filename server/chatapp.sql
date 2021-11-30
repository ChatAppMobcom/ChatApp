-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2021 at 12:14 PM
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
  `waktu` varchar(20) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `nama`, `chat`, `waktu`, `token`) VALUES
(52, 'siti', 'testttttt', '2021-11-29, 04:48 am', 'emHSTF25QQuQv2BbN2z_AX:APA91bFGKFVP8hF1pUYpOOcfQaNgcNDhMR5-Pel7fTW8IyqDY2L3TivVhgxlmqiQA57GwFJPObroKUtABghmGPliOQHiWuU4iVi_XPXhZC_h_qHvc4e2iQ8Ai2C6BD1gqsBt9271QCVX'),
(53, 'siti', 'test', '2021-11-29, 04:49 am', 'emHSTF25QQuQv2BbN2z_AX:APA91bFGKFVP8hF1pUYpOOcfQaNgcNDhMR5-Pel7fTW8IyqDY2L3TivVhgxlmqiQA57GwFJPObroKUtABghmGPliOQHiWuU4iVi_XPXhZC_h_qHvc4e2iQ8Ai2C6BD1gqsBt9271QCVX'),
(54, 'lani', 'alo lani', '2021-11-29, 04:49 am', 'cjwQWWmdTk2t-zra90qIDd:APA91bHRb6NAM3YpeIZX7L-XYAXbOvncGC_kVafajQ14FqQmESzapZmnJxrF8YbVwI9C_4uY5AJH0vDPh2N6Z_x2uQYf_pjkLXk1A3Jp-AztxsGg_ja-PUyjejxagi8R_d0BgE24TSp1');

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
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
