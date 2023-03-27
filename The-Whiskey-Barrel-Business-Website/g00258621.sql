-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2022 at 03:55 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `g00258621`
--
CREATE DATABASE IF NOT EXISTS `g00258621` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `g00258621`;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `Product_name` varchar(255) NOT NULL,
  `Price` decimal(8,2) NOT NULL,
  `Description` text NOT NULL,
  `imageURL` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `Product_name`, `Price`, `Description`, `imageURL`) VALUES
(1, 'Redbreast 12 Year Old', '63.00', 'A well-balanced single pot still Irish whiskey, Redbreast 12 Year Old has been matured in a combination of bourbon and sherry casks, creating a sweet-and-spicy character. The nose holds aromas of sweet fruit, toasted oak and warm spices, and the palate offers notes of buttery hot-cross-buns, dried fruits, baking spices and spicy oak.', 'images/Stock-Redbreast-12-Year-Old.jpg'),
(2, 'Teeling Small Batch Whiskey', '38.00', 'Since the Teelings parted company with Cooley, the company they started, we have been waiting for their return and here it is – Teeling Whiskey. Finished in rum casks and bottled at 46%, it is an excellent statement of intent. The blend contains a high proportion of first-fill bourbon cask whiskey, and a higher-than-normal ratio of malt to grain.', 'images/Stock-Teeling-Small-Batch-Whiskey.jpg'),
(3, 'Green Spot Single Pot Still', '59.00', 'This historic single pot still Irish whiskey used only to be available in Dublin grocer Mitchells, but now has spread across the world. A delightful combination of fruit, toffee and malt.', 'images/Stock-Green-Spot.jpg'),
(4, 'Yellow Spot 12 Year Old', '85.00', 'A second entry into the \"Spot\" range, aged for 12 years and made up in part from spirit matured in Malaga casks for a sweet and moreish dram.', 'images/Stock-Yellow-Spot-12-Year-Old.jpg'),
(5, 'Jameson Black Barrel', '47.00', 'A special pot still whiskey-heavy version of Jameson. Black Barrel has lots of first-fill bourbon and sherry casks in the mix, giving it a much richer flavour than regular Jameson, with a strong sherried note.', 'images/Stock-Jameson-Black-Barrel.jpg'),
(6, 'Jameson', '28.00', 'Produced at the Midleton Distillery, Jameson is the quintessential Irish blend – a classic whiskey. With a perfect balance of spicy, nutty and vanilla notes as well as hints of sweet sherry, it is as versatile as it is smooth.', 'images/Stock-Jameson-Irish-Whiskey.jpg'),
(7, 'Tullamore Dew 12 Year Old', '48.00', 'This 12yo blended Irish whiskey from duty-free favourite Tullamore Dew, offers a gentle spice flavour with a robust yet creamy body wrapped in a definite chocolaty note.', 'images/Stock-Tullamore-Dew-12-Year.jpg'),
(8, 'Tullamore Dew', '29.00', 'Tullamore Dew is a resoundingly popular Irish blend, particularly in overseas markets, where it is second only to Jameson. Very approachable.', 'images/Stock-Tullamore-Dew.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
