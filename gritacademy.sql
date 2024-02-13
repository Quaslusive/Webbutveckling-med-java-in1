-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 13 feb 2024 kl 09:17
-- Serverversion: 10.4.32-MariaDB
-- PHP-version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `gritacademy`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `attendance`
--

CREATE TABLE `attendance` (
  `id` int(255) NOT NULL,
  `studentID` int(255) NOT NULL,
  `courseID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `attendance`
--

INSERT INTO `attendance` (`id`, `studentID`, `courseID`) VALUES
(1, 1, 4),
(2, 2, 5),
(3, 3, 1),
(4, 4, 3),
(5, 5, 2),
(6, 1, 5),
(7, 2, 1),
(8, 5, 5),
(9, 3, 3),
(10, 4, 4);

-- --------------------------------------------------------

--
-- Tabellstruktur `courses`
--

CREATE TABLE `courses` (
  `id` int(255) NOT NULL,
  `name` text NOT NULL,
  `yhp` int(11) NOT NULL,
  `info` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `courses`
--

INSERT INTO `courses` (`id`, `name`, `yhp`, `info`) VALUES
(1, 'JAVA23 | Konsultrollen', 20, 'Kursens syfte är att den studerande ska få kunskaper och färdigheter att utöva ett konsultativt arbete\r\nsamt ge den studerande förståelse för konsultrollen och affärsmannaskap i rollen som IT-utvecklare.\r\nVidare ska den studerande kunna vara en god ambassadör för den arbetsgivare som den studerande\r\nrepresenterar.'),
(2, 'JAVA23 | HTML & CSS', 20, 'Kursen syfte är att den studerande ska utveckla teoretiska och praktiska kunskaper inom HTML5 och\r\nCSS. Vidare är kursens syfte att den studerande ska få god förståelse för uppbyggnad, struktur och\r\nsäkerhet på en hemsida för att sedan själv kunna skapa hemsidor med HTML5 och CSS.'),
(3, 'JAVA23 | Javaprogrammering', 25, 'Kursens syfte är att den studerande ska utveckla fördjupade kunskaper inom programmeringsspråket\r\nJava och dess ramverk. Kursens syfte är även att den studerande ska kunna programmera\r\nändamålsenligt och enligt god programmeringskonvention.'),
(4, 'JAVA23 | Databaser och Databasdesign', 20, 'Kursens syfte är att den studerande ska utveckla specialiserade kunskaper inom databaser, SQL och\r\ndatabasdesign. Vidare är syftet att den studerande ska få god förtrogenhet med arbetet med\r\ndatabaser och databasdesign.'),
(5, 'JAVA23 | Webbutveckling med Java', 25, 'Kursens syfte är att den studerande ska utveckla specialiserade kunskaper i webbapplikationer\r\nbyggda med Java på serversidan. Vidare ska den studerande även få kunskaper inom\r\nwebbapplikationsdesign.');

-- --------------------------------------------------------

--
-- Tabellstruktur `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `city` text NOT NULL,
  `hobbies` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `students`
--

INSERT INTO `students` (`id`, `fname`, `lname`, `city`, `hobbies`) VALUES
(1, 'Carl', 'Sundberg', 'Lund', 'Shit posting on Reddit'),
(2, 'Victor', 'Vector', 'Night City ', 'Boxing'),
(3, 'Armin ', 'Meiwes', 'Wüstefeld', 'Cooking'),
(4, 'Hideaki ', 'Anno', 'Ube', 'Anime'),
(5, 'Aaron ', 'Swartz', 'Chicago', 'Classical music ');

-- --------------------------------------------------------

--
-- Tabellstruktur `users`
--

CREATE TABLE `users` (
  `id` int(255) NOT NULL,
  `studentID` int(255) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FkeyStudents` (`studentID`),
  ADD KEY `FkeyCourses` (`courseID`);

--
-- Index för tabell `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Index för tabell `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Index för tabell `users`
--
ALTER TABLE `users`
  ADD KEY `FkeyUser` (`studentID`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT för tabell `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT för tabell `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `FkeyCourses` FOREIGN KEY (`courseID`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FkeyStudents` FOREIGN KEY (`studentID`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriktioner för tabell `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FkeyUser` FOREIGN KEY (`studentID`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
