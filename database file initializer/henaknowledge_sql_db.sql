-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2021 at 11:16 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `henaknowledge_sql_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `personid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`password`, `role`, `username`, `personid`) VALUES
('$2a$10$BgX/fvu5PsRYhp8awFnO5eTbBClK3VtJR5.xFS4C61I8x1EI2OWFm', 'Admin', 'ADMIN', 9);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL,
  `comment_body` longtext DEFAULT NULL,
  `experienceid` int(11) NOT NULL,
  `personid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`commentid`, `comment_body`, `experienceid`, `personid`) VALUES
(159, 'A very competent paper, nearly free of mechanical errors but lacking the coherent development of the superior essay.  It is also occasionally repetitious and a bit unfocused at times.  (The correct title of this book is Misty of Chincoteaque.) ', 16, 133),
(160, 'I enjoyed your experience, thank you for sharing it!', 16, 42),
(161, 'not bad', 17, 42),
(163, 'hi', 18, 162),
(165, 'Me too !', 19, 7),
(167, 'Iread it it was great', 16, 133),
(168, 'I read it it was great, perfect', 16, 133);

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `experience_id` int(11) NOT NULL,
  `description` longtext DEFAULT NULL,
  `dislikes` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `personid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`experience_id`, `description`, `dislikes`, `likes`, `personid`, `title`) VALUES
(16, 'The semester has been able to turn on a more positive outlook, I feel every semester that you are going to have of college, a part of you always matures. Think of yourself being a plant or a tree that only grows and grows—your branches, leaves, roots, so much rooting indeed.\n\nThis semester, even though my mental health has not been at its best, I have been able to cope through the help of my closest friends by talking about it. I realized this semester that speaking about your problems always helps. I have been able to remain on track and that includes working two jobs, five classes, writing for the newspaper, applying for internships and summer programs, while still having time to exercise at least three times a week and have some self-care time, which may imply going out with friends to eat or simply have some alone time. \n\nIf you think the college application process is long and painful, just get yourself ready, because applying for anything, a program you’d like to do during the summer, internships, grants, scholarships, all has an application component with letters/references, résumé, cover letter or personal statements, etc. I have lost count of how many personal statements I have written and re-written over my time in college. I have lost count how many times I have surveyed and edited my résumé. I have lost count how many times I have asked somebody to write a recommendation on my behalf. It has been so many times. So, see the college application process as a tidbit\n', 1, 1, 133, 'College And Personal Experience : My Experience In College'),
(17, 'Through the ages of 8-15 I was an avid reader of pleasure books.  The majority of the books were mysteries such as Nancy Drew or the Hardy Boys.  Books about animals were avoided because they usually had a very sentimental theme, and I was very emotional when it came to animal suffering.\n\nWhen I was approximately 10 years old I read a book titled Misty & Chatlenaque.  This book was about a young horse that was stranded on an island.  It had been on a horse-trading ship when the ship wrecked on the rocks.  Misty went through several adventures where wild dogs tried to kill her, horse traders tried to capture her (and beat her in the process), and the sea tried to swallow her.\n\nA little girl who lived on the Island found Misty and tried to protect her from the wild dogs and horse traders.  The story was told from the horse\'s point view, and the agony and terror Misty went through passed on to me.  I felt as if it were me who was being chased and beat.\n\nA girl at the age of ten is influenced by the things she sees and reads.  Years after reading the book I had the notion that horse ranches were terrible to horses.  I also felt that horses were very human in the sense that they could think, feel, understand, and have emotions.\n\nWhenever I passed by a horse who was behind a fence I had to stop and feed it, talk to it, pet it, and feel sorry for it.  Every horse had that \"Misty\" look in its eyes, and I felt it was \"crying out to me\".\n\nAfter reading Misty and Chatlenaque, horses became more than just an animal to me.  They became something I could relate to and sympathize with.  I myself was a lonely child who felt neglected (even though I wasn\'t) and \"penned\".  While reading the book I felt the horse and I were one.  Years later I felt like horses and I had something in common and could relate to each other.\n\nNow, I know horses do not understand what I say to them, but I still stop and talk to them as if they were human.  I feel that if I had not read that book eleven years ago I wouldn\'t feel as attached to horses as I do now.  To this day, I refuse to read another horse book or watch a horse movie that looks like it might be \"emotional\" or \"sentimental\".\n\nMisty & Chatlenaque is still a very prominent book in my mind, and details of it are remembered frequently.  It has had the profound effect of altering my view of horses and will probably remain in my memory for life.  The book also had the effect of making me not want to read those kinds of books again.  Their emotional impact was too great on me so I only read mysteries and school books.  To this day I have my reservations about reading an emotional book, especially if it pertains to animals.\n\nComment: A very competent paper, nearly free of mechanical errors but lacking the coherent development of the superior essay.  It is also occasionally repetitious and a bit unfocused at times.  (The correct title of this book is Misty of Chincoteaque.) ', 0, 3, 133, 'Misty of Chincoteaque'),
(18, 'There are a number of career specializations in educational technology. Educational technology is a field that studies how technology can be used to enhance learning. Some specializations might involve staying in the K-12 classroom but bringing technology into lessons. Other specializations might take a person outside of the classroom. Below are five specialties under the umbrella of educational technology that a person might choose.\n\n1. Software and Applications\nWith an educational technology specialization in this area, a person would create software and applications for learners. They could be K-12 or adult learners, and the software and apps might be part of a public school curriculum, online offerings by a university or a training program for a business. People in this job might work for a school system or company, or they might even run their own startups focusing on developing this type of software and applications.\n\n2. Video Production\nVideos may be used as a complement to classroom education or for distance education. However, the field of video production is not simply limited to making videos of an instructor delivering a lecture although that can be one aspect. There are a number of innovative ways in which video can be used in education, and the video producer can be critical in making that happen. Video production may encompass webcasting, which gives students the opportunity to be onsite at any number of events. For example, NASA produced a webcast to teach school children about life in space that allowed students to submit questions.\n\n3. Web Development\nPeople who have an educational technology specialization in Web development might build the framework for online courses. They might also develop websites and online resources that can be used for education and training. One dynamic use of technology in learning is real-life simulations delivered via computer, and this could also be one aspect of web development.\n\n4. Information Science\nAnother specialization in educational technology is library work. Media specialists and school librarians may have a degree in educational technology that allows them to assist teachers in using technology in the classroom. The field of librarianship is increasingly reliant on technology, and a library professional with a specialization in this area will be able to introduce more resources that use technology to the school.\n\n5. Human Resources Management\nPeople may think of education technology specializations primarily in terms of K-12 or college and university classrooms, but educational technology is also an important element of training in the workplace. For a person working at the intersection of human resources management and educational technology, training would be the focus using much of the technology discussed above ranging from video to apps and more.\n\nRelated Resource: 30 Best Master\'s in Educational Technology Online Degrees\n\nTechnology has transformed education. From massive open online courses, or MOOCs, offered free by many universities and foundations to apps that allow people to learn languages to the rise of online education and more, educational technology has broadened the reach and methods of education. Forbes even reports technology such as games and virtual reality growing in use. The five career paths listed above are only a few of the career specializations in educational technology available, and this dynamic field is likely to continue expanding in the coming years.', 0, 0, 162, '5 Top Educational Technology Jobs'),
(19, 'I like to share new experiences!', 0, 2, 42, 'my thoughts on the new feature in henaknowledge');

-- --------------------------------------------------------

--
-- Table structure for table `experience_opinion`
--

CREATE TABLE `experience_opinion` (
  `opinionid` int(11) NOT NULL,
  `dislikes` int(11) DEFAULT NULL,
  `experienceid` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `personid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `experience_opinion`
--

INSERT INTO `experience_opinion` (`opinionid`, `dislikes`, `experienceid`, `likes`, `personid`) VALUES
(158, 0, 16, 1, 133),
(164, 0, 17, 1, 42),
(166, 0, 19, 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(169);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `personid` bigint(20) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`personid`, `date_of_birth`, `email`, `first_name`, `last_name`) VALUES
(7, '1980-07-24', 'ahmedwork@gmail.com', 'ahmed', 'harbi'),
(9, '1955-02-24', 'jama_admin@gov.om', 'Hmad', 'Jabri'),
(33, '1990-07-24', 'mmm@gmail.com', 'miiiiko', 'osun'),
(42, '2021-05-05', 'bageuo_bb@gmail.com', 'barlenn', 'bageuo'),
(66, '1977-05-28', 'm.Pesic@fontys.nl', 'Maja', 'Pesic'),
(68, '2000-03-05', 'platinumtouches@yahoo.com', 'Saeed', 'Almanthari'),
(87, '1999-06-11', 'harbignote@gmail.com', 'ASH', 'Harbi'),
(133, '2021-06-18', 'mohammedalharbi000@gmail.com', 'Mohammed Saleh', 'Alharbi'),
(162, '2021-06-13', 'mohammedalharbi0000@gmail.com', 'Khaled', 'Kamal');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `code` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `points` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `personid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`code`, `password`, `points`, `role`, `specialization`, `username`, `personid`) VALUES
('9mkqjkhanobuif4p2ujinf', 'mmm', 0, 'Student', 'software engineering (backend)', 'miko', 33),
('nonrptlpmn4e730onyhun', '$2a$10$LgfU5zwXUgYYSjEq2eykje6nOBiICLCBB9YQIb2odAn/7cOjeNzvy', 0, 'Student', 'bspecialz', 'bb', 42),
('37ajc5d3hl119axhds2wsp', 'am4g3o0v00ibatfq2acht7', 0, 'Student', 'databases management', 'owjn82v3b1sb3hsafp34b7', 66),
('2387prswfpll5t0uwpo47', 'h6f5vkk7t2tpsqu2ikl32', 0, 'Student', 'databases management', 'd2ecvdxe8hplpk0jvcwdr', 68),
('okufkremg2ftd0xvtg03en', '$2a$10$gldAGdS6hkjjyHCtf0VX1e.LP2Yz9IeK/omAuG4F4n3mw3u8kBJ9y', 0, 'Student', 'front end developer', 'snh7e5w97k9bv3eqn4jup', 87);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `code` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `points` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `personid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`code`, `password`, `points`, `role`, `specialization`, `username`, `personid`) VALUES
('LOQLK', '$2a$10$vhyQRCxgt4uW6GW4e4gAnee3pRYHPNTb24RWTyGKOs4qGJmDZIupW', 0, 'Teacher', 'databases management', 'moe', 7),
('6xeyet51jpr667paxzhwjh', '$2a$10$175rLZIbkqQgmJJL2pJ3hegjDmEd69.Z4X7qtnoxV3uzdNQ0g7eWy', 0, 'Teacher', 'front end developer', 'vd4xateuv98a4riau63wa', 133),
('g4aeyyutzcldako8te5kjk', '$2a$10$8hGkeUfhA7o9hx4fSnnBOu.PXn/mYUYz6Q5iOGmpfpK.xbH246J12', 0, 'Teacher', 'databases management', '9909b3fo5y85egjwqimad4', 162);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`personid`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentid`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`experience_id`);

--
-- Indexes for table `experience_opinion`
--
ALTER TABLE `experience_opinion`
  ADD PRIMARY KEY (`opinionid`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`personid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`personid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`personid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `experience_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FKo2p8okie9115uxbqpe6cpihtg` FOREIGN KEY (`personid`) REFERENCES `person` (`personid`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FKna331da937ni71wuswnp644o1` FOREIGN KEY (`personid`) REFERENCES `person` (`personid`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `FKt4k335wyhb0g03pm3ndhum649` FOREIGN KEY (`personid`) REFERENCES `person` (`personid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
