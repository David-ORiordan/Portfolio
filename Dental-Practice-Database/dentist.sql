-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2022 at 08:44 PM
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
-- Database: `dentist`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `Appointment_ID` int(11) NOT NULL,
  `Patient_ID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Charge_name` varchar(255) DEFAULT NULL,
  `Mode_of_booking` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`Appointment_ID`, `Patient_ID`, `Time`, `Date`, `Charge_name`, `Mode_of_booking`) VALUES
(598, 522, '15:00:00', '2022-10-08', 'Check-up', 'Phone'),
(599, 515, '10:00:00', '2022-02-28', 'Scale and Polish', 'In person'),
(600, 502, '14:00:00', '2023-02-22', 'Scale and Polish', 'Phone'),
(601, 509, '09:00:00', '2023-01-04', 'Check-up', 'Phone'),
(602, 506, '09:30:00', '2023-01-06', 'Scale and Polish', 'Phone'),
(603, 508, '10:30:00', '2023-01-04', 'Check-up', 'Phone'),
(604, 507, '11:00:00', '2023-01-17', 'Extraction', 'Phone'),
(605, 501, '14:00:00', '2023-01-06', 'Check-up', 'In person'),
(606, 510, '11:00:00', '2023-01-05', 'Scale and Polish', 'Phone'),
(607, 505, '15:30:00', '2023-01-25', 'Check-up', 'Phone'),
(609, 504, '16:00:00', '2023-01-22', 'Dentures (plastic)', 'Post'),
(610, 520, '11:00:00', '2023-01-19', 'White Filling (Regular)', 'In person');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` int(11) NOT NULL,
  `Patient_ID` int(11) DEFAULT NULL,
  `Charge_name` varchar(255) DEFAULT NULL,
  `Payment_due_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Patient_ID`, `Charge_name`, `Payment_due_date`) VALUES
(1, 511, 'Scale and Polish', '2023-01-19'),
(2, 512, 'Check-up', '2023-01-20'),
(3, 513, 'Late Cancellation', '2023-01-21'),
(4, 503, 'Dentures (plastic)', '2023-01-19'),
(5, 515, 'Scale and Polish', '2023-01-25'),
(6, 516, 'Teeth Whitening', '2022-12-20'),
(7, 517, 'Late Cancellation', '2022-12-28'),
(8, 519, 'Teeth Whitening', '2022-11-22'),
(9, 520, 'Dentures (metal)', '2022-12-22');

-- --------------------------------------------------------

--
-- Table structure for table `charge`
--

CREATE TABLE `charge` (
  `Charge_name` varchar(255) NOT NULL,
  `Fee` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `charge`
--

INSERT INTO `charge` (`Charge_name`, `Fee`) VALUES
('Check-up', '50.00'),
('Dentures (metal)', '1500.00'),
('Dentures (plastic)', '600.00'),
('Extraction', '110.00'),
('Late Cancellation', '10.00'),
('Scale and Polish', '85.00'),
('Teeth Whitening', '300.00'),
('White Filling (Large)', '150.00'),
('White Filling (Regular)', '120.00'),
('White Filling (Small)', '100.00');

-- --------------------------------------------------------

--
-- Stand-in structure for view `excessive_outstanding_fee`
-- (See below for the actual view)
--
CREATE TABLE `excessive_outstanding_fee` (
`Patient_ID` int(11)
,`first_name` varchar(50)
,`last_name` varchar(50)
,`outstanding_fee` decimal(8,2)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `overdue_payment`
-- (See below for the actual view)
--
CREATE TABLE `overdue_payment` (
`Patient_ID` int(11)
,`first_name` varchar(50)
,`last_name` varchar(50)
,`bill_ID` int(11)
,`charge_name` varchar(255)
,`Payment_due_date` date
);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `Patient_ID` int(11) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone_Number` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Patient_ID`, `First_Name`, `Last_Name`, `Address`, `Phone_Number`) VALUES
(501, 'Mary', 'Reeve', '7 Duffy Road', 0876437583),
(502, 'Lucy', 'Sampson', '12 Glenview Street', 0860285629),
(503, 'Antonio', 'Pattison', '75 Main Street', 0850582659),
(504, 'Henry', 'Ellis', '3 Fair Lane', 0852752533),
(505, 'Jay', 'Graves', '11 Bishop Street', 0875738300),
(506, 'Carol', 'Roper', '7 Lower Catherine Street', 0856477513),
(507, 'Sandra', 'Ahmed', '5 Queen Street', 0892372392),
(508, 'Jodie', 'Horner', '1 Park Avenue', 0865238211),
(509, 'Glenda', 'Perry', '12 Shrewsbury Road', 0852744109),
(510, 'Frank', 'Mooney', '6 Henry Street', 0864224131),
(511, 'Mary', 'Walsh', '33 Brick Road', 0891583930),
(512, 'Sammy', 'Jones', '1 Sea View', 0872589243),
(513, 'Frank', 'O’Shea', '41 Park Avenue', 0866317199),
(514, 'Raymond', 'Brown', '24 Graham Way', 0873843754),
(515, 'Anna', 'May', '5 Mill Street', 0855585009),
(516, 'Jan', 'Muller', '12 Sharp Lane', 0891143990),
(517, 'Alan', 'Brown', '15 Bird View', 0875574312),
(518, 'Manuel', 'Rossi', '7 Bakers Way', 0858686550),
(519, 'Roger', 'Bell', '6 Barrack Street', 0873421800),
(520, 'Natasha', 'Rodriguez', '51 Tower Heights', 0869192030),
(521, 'John', 'Smith', '23 Boggsbridge', 0855578534),
(522, 'Franziska', 'Olsen', '32 Gerhard Square', 0872954011);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_ID` int(11) NOT NULL,
  `Patient_ID` int(11) DEFAULT NULL,
  `Bill_ID` int(11) DEFAULT NULL,
  `Amount_paid` decimal(8,2) DEFAULT NULL,
  `Outstanding_fee` decimal(8,2) DEFAULT NULL,
  `Date_of_payment` date DEFAULT NULL,
  `Instalment_number` int(11) DEFAULT NULL,
  `Total_number_of_instalments` int(11) DEFAULT NULL,
  `Method_of_payment` varchar(255) DEFAULT NULL,
  `Mode_of_payment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_ID`, `Patient_ID`, `Bill_ID`, `Amount_paid`, `Outstanding_fee`, `Date_of_payment`, `Instalment_number`, `Total_number_of_instalments`, `Method_of_payment`, `Mode_of_payment`) VALUES
(10, 503, 4, '200.00', '400.00', '2022-12-27', 1, 3, 'Cash', 'In person'),
(11, 505, 3, '10.00', '0.00', '2022-12-30', 1, 1, 'Cash', 'In person'),
(12, 515, 5, '85.00', '0.00', '2022-12-29', 1, 1, 'Cheque', 'In person'),
(13, 519, 8, '100.00', '200.00', '2022-11-25', 1, 3, 'Credit Card', 'In person'),
(14, 520, 9, '500.00', '500.00', '2022-12-29', 2, 3, 'Cheque', 'Post');

-- --------------------------------------------------------

--
-- Table structure for table `referral`
--

CREATE TABLE `referral` (
  `Referral_ID` int(11) NOT NULL,
  `Patient_ID` int(11) DEFAULT NULL,
  `Appointment_ID` int(11) DEFAULT NULL,
  `Reason_for_referral` varchar(255) DEFAULT NULL,
  `Specialist_practice_name` varchar(255) DEFAULT NULL,
  `Specialist_report` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `referral`
--

INSERT INTO `referral` (`Referral_ID`, `Patient_ID`, `Appointment_ID`, `Reason_for_referral`, `Specialist_practice_name`, `Specialist_report`) VALUES
(1, 515, 599, 'Veneers', 'Cork City Dental Practice', NULL),
(2, 522, 598, 'Root Canal', 'O’Sullivan’s Dentistry', 'Root canal treatment successful carried out on 2022-11-01');

-- --------------------------------------------------------

--
-- Table structure for table `specialist`
--

CREATE TABLE `specialist` (
  `Specialist_practice_name` varchar(255) NOT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Phone_number` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `Area_of_specialisation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `specialist`
--

INSERT INTO `specialist` (`Specialist_practice_name`, `Address`, `Phone_number`, `Area_of_specialisation`) VALUES
('Cork City Dental Practice', '31 Cathedral Road', 0214507590, 'Veneers'),
('O’Sullivan’s Dentistry', '21 Merchant Street', 0214508573, 'Root Canal'),
('Walsh and Sons Dental Care', '5 Union Quay', 0214502852, 'Crown');

-- --------------------------------------------------------

--
-- Stand-in structure for view `unpaid_bill`
-- (See below for the actual view)
--
CREATE TABLE `unpaid_bill` (
`Patient_ID` int(11)
,`first_name` varchar(50)
,`last_name` varchar(50)
,`address` varchar(50)
,`Bill_ID` int(11)
,`charge_name` varchar(255)
,`Outstanding_fee` decimal(8,2)
,`fee` decimal(8,2)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `weekly_appointments`
-- (See below for the actual view)
--
CREATE TABLE `weekly_appointments` (
`appointment_ID` int(11)
,`patient_ID` int(11)
,`first_name` varchar(50)
,`last_name` varchar(50)
,`address` varchar(50)
,`time` time
,`date` date
,`charge_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Structure for view `excessive_outstanding_fee`
--
DROP TABLE IF EXISTS `excessive_outstanding_fee`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `excessive_outstanding_fee`  AS SELECT `patient`.`Patient_ID` AS `Patient_ID`, `patient`.`First_Name` AS `first_name`, `patient`.`Last_Name` AS `last_name`, `payment`.`Outstanding_fee` AS `outstanding_fee` FROM (`patient` join `payment` on(`patient`.`Patient_ID` = `payment`.`Patient_ID`)) WHERE `payment`.`Outstanding_fee` >= 200 ;

-- --------------------------------------------------------

--
-- Structure for view `overdue_payment`
--
DROP TABLE IF EXISTS `overdue_payment`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `overdue_payment`  AS SELECT `patient`.`Patient_ID` AS `Patient_ID`, `patient`.`First_Name` AS `first_name`, `patient`.`Last_Name` AS `last_name`, `bill`.`Bill_ID` AS `bill_ID`, `bill`.`Charge_name` AS `charge_name`, `bill`.`Payment_due_date` AS `Payment_due_date` FROM (`patient` join `bill` on(`patient`.`Patient_ID` = `bill`.`Patient_ID`)) WHERE curdate() > `bill`.`Payment_due_date` ORDER BY `bill`.`Payment_due_date` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `unpaid_bill`
--
DROP TABLE IF EXISTS `unpaid_bill`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `unpaid_bill`  AS SELECT `bill`.`Patient_ID` AS `Patient_ID`, `patient`.`First_Name` AS `first_name`, `patient`.`Last_Name` AS `last_name`, `patient`.`Address` AS `address`, `bill`.`Bill_ID` AS `Bill_ID`, `bill`.`Charge_name` AS `charge_name`, `payment`.`Outstanding_fee` AS `Outstanding_fee`, `charge`.`Fee` AS `fee` FROM (((`bill` left join `payment` on(`bill`.`Bill_ID` = `payment`.`Bill_ID`)) join `charge` on(`bill`.`Charge_name` = `charge`.`Charge_name`)) join `patient` on(`bill`.`Patient_ID` = `patient`.`Patient_ID`)) WHERE `payment`.`Outstanding_fee` is null OR `payment`.`Outstanding_fee` > '0.00' ;

-- --------------------------------------------------------

--
-- Structure for view `weekly_appointments`
--
DROP TABLE IF EXISTS `weekly_appointments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `weekly_appointments`  AS SELECT `appointment`.`Appointment_ID` AS `appointment_ID`, `appointment`.`Patient_ID` AS `patient_ID`, `patient`.`First_Name` AS `first_name`, `patient`.`Last_Name` AS `last_name`, `patient`.`Address` AS `address`, `appointment`.`Time` AS `time`, `appointment`.`Date` AS `date`, `appointment`.`Charge_name` AS `charge_name` FROM (`appointment` join `patient` on(`appointment`.`Patient_ID` = `patient`.`Patient_ID`)) WHERE `appointment`.`Date` between '2023-01-03' and '2023-01-09' ORDER BY `appointment`.`Date` ASC ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Appointment_ID`),
  ADD KEY `appointment_fk1` (`Patient_ID`),
  ADD KEY `appointment_fk2` (`Charge_name`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_ID`),
  ADD KEY `bill_fk2` (`Patient_ID`),
  ADD KEY `bill_fk1` (`Charge_name`);

--
-- Indexes for table `charge`
--
ALTER TABLE `charge`
  ADD PRIMARY KEY (`Charge_name`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Patient_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_ID`),
  ADD KEY `payment_fk1` (`Patient_ID`),
  ADD KEY `payment_fk2` (`Bill_ID`);

--
-- Indexes for table `referral`
--
ALTER TABLE `referral`
  ADD PRIMARY KEY (`Referral_ID`),
  ADD KEY `referral_fk1` (`Patient_ID`),
  ADD KEY `referral_fk2` (`Appointment_ID`),
  ADD KEY `referral_fk3` (`Specialist_practice_name`);

--
-- Indexes for table `specialist`
--
ALTER TABLE `specialist`
  ADD PRIMARY KEY (`Specialist_practice_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_fk1` FOREIGN KEY (`Patient_ID`) REFERENCES `patient` (`Patient_ID`),
  ADD CONSTRAINT `appointment_fk2` FOREIGN KEY (`Charge_name`) REFERENCES `charge` (`Charge_name`);

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_fk1` FOREIGN KEY (`Charge_name`) REFERENCES `charge` (`Charge_name`),
  ADD CONSTRAINT `bill_fk2` FOREIGN KEY (`Patient_ID`) REFERENCES `patient` (`Patient_ID`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_fk1` FOREIGN KEY (`Patient_ID`) REFERENCES `patient` (`Patient_ID`),
  ADD CONSTRAINT `payment_fk2` FOREIGN KEY (`Bill_ID`) REFERENCES `bill` (`Bill_ID`);

--
-- Constraints for table `referral`
--
ALTER TABLE `referral`
  ADD CONSTRAINT `referral_fk1` FOREIGN KEY (`Patient_ID`) REFERENCES `patient` (`Patient_ID`),
  ADD CONSTRAINT `referral_fk2` FOREIGN KEY (`Appointment_ID`) REFERENCES `appointment` (`Appointment_ID`),
  ADD CONSTRAINT `referral_fk3` FOREIGN KEY (`Specialist_practice_name`) REFERENCES `specialist` (`Specialist_practice_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
