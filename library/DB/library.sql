-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2024-05-11 15:09:48
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `library`
--

-- --------------------------------------------------------

--
-- 資料表結構 `book`
--

CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `introduction` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `book`
--

INSERT INTO `book` (`isbn`, `author`, `introduction`, `name`) VALUES
('ABC12345', ' 王樹生', '作為全球備受矚目的圈子，金融圈一直是富人的標籤。而作為推進Web技術成熟的框架，Java Web也一致備受寵愛。但是你可能不知道，Java Web技術一直備受金融圈推崇。', '遙遙領先：使用Java開發Web新手轉高手之路'),
('ABC23567', '數位新知', '本書以Java程式語言為實作對象，以圖像解說呈現資料結構的概念與運作，藉由Java程式語言的特色和語法來豐富資料結構的內涵，是學習資料結構最佳入門書。', '資料結構：使用Java'),
('ABC34625', '陳明', '密集式範例學習最有效，關鍵語法與物件導向觀念解說！', 'Java 程式設計寶典'),
('ABC77433', '余顯強', '扎實的Java程式語言基礎。包含Java最新的語法規則介紹，並有相關系統開發的觀念，搭配圖形解說，快速掌握物件導向Java程式設計的概念與技巧。', '圖解Java物件導向程式語言'),
('ABC98764', 'Kathy Sierra, Bert Bates, Trisha Gee ', '《深入淺出Java程式設計》是Java和物件導向程式設計的完整學習體驗。', '深入淺出Java程式設計');

-- --------------------------------------------------------

--
-- 資料表結構 `borrowingrecord`
--

CREATE TABLE `borrowingrecord` (
  `borrowing_time` datetime(6) DEFAULT NULL,
  `return_time` datetime(6) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `inventory_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `last_login_time` datetime(6) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `registration_time` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`);

--
-- 資料表索引 `borrowingrecord`
--
ALTER TABLE `borrowingrecord`
  ADD PRIMARY KEY (`inventory_id`,`user_id`),
  ADD UNIQUE KEY `UK_tglxhdpfgm7hbnnt3910a5gq4` (`inventory_id`),
  ADD KEY `FKqkuki8cblm8q0o15ni9v1aaob` (`user_id`);

--
-- 資料表索引 `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventory_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `borrowingrecord`
--
ALTER TABLE `borrowingrecord`
  ADD CONSTRAINT `FKlflh1aqt71ua91f2459ud6yc6` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`inventory_id`),
  ADD CONSTRAINT `FKqkuki8cblm8q0o15ni9v1aaob` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
