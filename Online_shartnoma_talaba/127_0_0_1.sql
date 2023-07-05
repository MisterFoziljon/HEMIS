-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2022 at 09:53 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Table structure for table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Table structure for table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"talaba_shartnoma\",\"table\":\"talaba\"},{\"db\":\"talaba_shartnoma\",\"table\":\"shartnoma_tarixi\"},{\"db\":\"talaba_shartnoma\",\"table\":\"shartnoma_summasi\"},{\"db\":\"talaba_shartnoma\",\"table\":\"shartnoma\"},{\"db\":\"talaba_shartnoma\",\"table\":\"tabaqa\"},{\"db\":\"talaba_shartnoma\",\"table\":\"uquv_yili\"},{\"db\":\"talaba_shartnoma\",\"table\":\"yunalishlar\"},{\"db\":\"talaba_shartnoma\",\"table\":\"fakultet\"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'talaba_shartnoma', 'talaba', '{\"sorted_col\":\"`talaba`.`Passport_seriya` ASC\"}', '2022-06-06 09:58:04');

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2022-06-15 07:52:58', '{\"Console\\/Mode\":\"collapse\"}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Table structure for table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Database: `talaba_shartnoma`
--
CREATE DATABASE IF NOT EXISTS `talaba_shartnoma` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `talaba_shartnoma`;

-- --------------------------------------------------------

--
-- Table structure for table `fakultet`
--

CREATE TABLE `fakultet` (
  `id_fakultet` bigint(20) NOT NULL,
  `nomi` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fakultet`
--

INSERT INTO `fakultet` (`id_fakultet`, `nomi`) VALUES
(1, 'Matematika'),
(2, 'Fizika'),
(3, 'Kimyo');

-- --------------------------------------------------------

--
-- Table structure for table `shartnoma`
--

CREATE TABLE `shartnoma` (
  `id_shartnoma` bigint(20) NOT NULL,
  `Kontrakt_summasi` double NOT NULL,
  `id_talaba` bigint(20) NOT NULL,
  `id_yunalish` bigint(20) NOT NULL,
  `id_fakultet` bigint(20) NOT NULL,
  `id_uquv_yili` bigint(20) NOT NULL,
  `id_tabaqa` bigint(20) NOT NULL,
  `Shartnoma_kodi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shartnoma`
--

INSERT INTO `shartnoma` (`id_shartnoma`, `Kontrakt_summasi`, `id_talaba`, `id_yunalish`, `id_fakultet`, `id_uquv_yili`, `id_tabaqa`, `Shartnoma_kodi`) VALUES
(3, 11399000, 2, 2, 1, 1, 1, 'PA22586370'),
(6, 5736000, 3, 3, 2, 1, 2, 'PB25586970'),
(7, 9399000, 3, 3, 2, 3, 1, 'PK22006370'),
(8, 8736000, 5, 7, 3, 2, 2, 'PF96586370'),
(10, 100000000, 56, 4, 2, 3, 1, 'pppppppp'),
(25, 1200000, 76, 1, 1, 2, 1, 'AV5544778'),
(26, 12000000, 6, 3, 2, 2, 2, 'PI887556');

-- --------------------------------------------------------

--
-- Table structure for table `shartnoma_summasi`
--

CREATE TABLE `shartnoma_summasi` (
  `id_shartnoma_summa` bigint(20) NOT NULL,
  `id_uquv_yili` bigint(20) NOT NULL,
  `id_tabaqa` bigint(20) NOT NULL,
  `id_yunalish` bigint(20) NOT NULL,
  `id_fakultet` bigint(20) NOT NULL,
  `summa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shartnoma_summasi`
--

INSERT INTO `shartnoma_summasi` (`id_shartnoma_summa`, `id_uquv_yili`, `id_tabaqa`, `id_yunalish`, `id_fakultet`, `summa`) VALUES
(1, 1, 1, 1, 1, 10399000),
(2, 1, 2, 1, 1, 6736000),
(3, 1, 1, 2, 1, 11399000),
(4, 1, 2, 2, 1, 7736000),
(5, 1, 1, 3, 2, 9399000),
(6, 1, 2, 3, 2, 5736000),
(7, 1, 1, 4, 2, 10099000),
(8, 1, 2, 4, 2, 6036000),
(9, 1, 1, 7, 3, 12399000),
(10, 1, 2, 7, 3, 8736000),
(11, 1, 1, 8, 3, 8399000),
(12, 1, 2, 8, 3, 5736000),
(13, 2, 1, 1, 1, 12499000),
(14, 2, 2, 1, 1, 8436000),
(15, 2, 1, 2, 1, 12299000),
(16, 2, 2, 2, 1, 8036000),
(17, 2, 1, 3, 2, 9899000),
(18, 2, 2, 3, 2, 6036000),
(19, 2, 1, 4, 2, 11099000),
(20, 2, 2, 4, 2, 8936000),
(21, 2, 1, 7, 3, 13499000),
(22, 2, 2, 7, 3, 9036000),
(23, 2, 1, 8, 3, 9799000),
(24, 2, 2, 8, 3, 6536000);

-- --------------------------------------------------------

--
-- Table structure for table `shartnoma_tarixi`
--

CREATE TABLE `shartnoma_tarixi` (
  `id_shartnoma_tarixi` bigint(20) NOT NULL,
  `sana` date NOT NULL,
  `tulangan_summa` double NOT NULL,
  `id_shartnoma` bigint(20) NOT NULL,
  `id_talaba` bigint(20) NOT NULL,
  `id_yunalish` bigint(20) NOT NULL,
  `id_fakultet` bigint(20) NOT NULL,
  `id_uquv_yili` bigint(20) NOT NULL,
  `id_tabaqa` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shartnoma_tarixi`
--

INSERT INTO `shartnoma_tarixi` (`id_shartnoma_tarixi`, `sana`, `tulangan_summa`, `id_shartnoma`, `id_talaba`, `id_yunalish`, `id_fakultet`, `id_uquv_yili`, `id_tabaqa`) VALUES
(1, '2019-09-05', 4500000, 3, 2, 2, 1, 1, 1),
(2, '2019-12-05', 3700000, 3, 2, 2, 1, 1, 1),
(5, '2019-09-24', 3200000, 6, 3, 3, 2, 1, 2),
(6, '2019-12-24', 1000000, 6, 3, 3, 2, 1, 2),
(7, '2020-02-24', 1000000, 6, 3, 3, 2, 1, 2),
(8, '2020-09-02', 1000000, 8, 5, 7, 3, 2, 2),
(9, '2020-10-02', 2400000, 8, 5, 7, 3, 2, 2),
(10, '2021-02-02', 2400000, 8, 5, 7, 3, 2, 2),
(11, '2021-04-02', 1000000, 8, 5, 7, 3, 2, 2),
(13, '2021-12-17', 2000000, 7, 3, 3, 2, 3, 1),
(16, '2021-10-20', 15000000, 10, 56, 4, 2, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tabaqa`
--

CREATE TABLE `tabaqa` (
  `id_tabaqa` bigint(20) NOT NULL,
  `tabaqa_nomi` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabaqa`
--

INSERT INTO `tabaqa` (`id_tabaqa`, `tabaqa_nomi`) VALUES
(1, 'Stipendiyali'),
(2, 'Stipendiyasiz');

-- --------------------------------------------------------

--
-- Table structure for table `talaba`
--

CREATE TABLE `talaba` (
  `id_talaba` bigint(20) NOT NULL,
  `Ism` char(20) NOT NULL,
  `Familiya` char(20) NOT NULL,
  `Sharif` char(20) NOT NULL,
  `id_yunalish` bigint(20) NOT NULL,
  `id_fakultet` bigint(20) NOT NULL,
  `Kurs` int(11) NOT NULL,
  `Passport_seriya` char(2) NOT NULL,
  `Passport_raqami` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `talaba`
--

INSERT INTO `talaba` (`id_talaba`, `Ism`, `Familiya`, `Sharif`, `id_yunalish`, `id_fakultet`, `Kurs`, `Passport_seriya`, `Passport_raqami`) VALUES
(2, 'Malika', 'Abdullayeva', 'Komilovna', 2, 1, 1, 'AC', '8794512'),
(3, 'Sodiqjon', 'Muhammadiyev', 'Sunnatillayevich', 3, 2, 2, 'AB', '3214570'),
(5, 'Foziljon', 'Tolqinov', 'Shavkatovich', 7, 3, 3, 'AB', '9856326'),
(6, 'Ismoil', 'Odilov', 'Ilhomovich', 3, 2, 2, 'AA', '4785417'),
(56, 'Muhammadjon', 'Usmonov', 'Jalilovich', 4, 2, 3, 'AQ', '1234567'),
(76, 'Bekzodjon', 'Usmonov', 'Numonjonovich', 1, 1, 3, 'AB', '9986652'),
(77, 'Turdibayev', 'Pochcha', 'Togayevich', 2, 1, 4, 'AA', '1122336'),
(78, 'Azizov', 'Laziz', 'Sharifovich', 4, 2, 4, 'AA', '4564545'),
(79, 'Aliyev', 'Vali', 'Salimov', 1, 1, 3, 'AA', '5665544');

-- --------------------------------------------------------

--
-- Table structure for table `uquv_yili`
--

CREATE TABLE `uquv_yili` (
  `id_uquv_yili` bigint(20) NOT NULL,
  `uquv_yili_nomi` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `uquv_yili`
--

INSERT INTO `uquv_yili` (`id_uquv_yili`, `uquv_yili_nomi`) VALUES
(1, '2019-2020'),
(2, '2020-2021'),
(3, '2021-2022'),
(4, '2022-2023');

-- --------------------------------------------------------

--
-- Table structure for table `yunalishlar`
--

CREATE TABLE `yunalishlar` (
  `id_yunalish` bigint(20) NOT NULL,
  `yunalish_nomi` char(50) NOT NULL,
  `kodi` int(11) NOT NULL,
  `id_fakultet` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `yunalishlar`
--

INSERT INTO `yunalishlar` (`id_yunalish`, `yunalish_nomi`, `kodi`, `id_fakultet`) VALUES
(1, 'Mexanika', 51301150, 1),
(2, 'Nazariy matematika', 51301100, 1),
(3, 'Astronomiya', 50010020, 2),
(4, 'Geofizika', 50010030, 2),
(7, 'Neft va gaz kimyosi', 60111700, 3),
(8, 'Biokimyo', 60111720, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fakultet`
--
ALTER TABLE `fakultet`
  ADD PRIMARY KEY (`id_fakultet`);

--
-- Indexes for table `shartnoma`
--
ALTER TABLE `shartnoma`
  ADD PRIMARY KEY (`id_shartnoma`,`id_talaba`,`id_yunalish`,`id_fakultet`,`id_uquv_yili`,`id_tabaqa`),
  ADD KEY `Relationship9` (`id_talaba`,`id_yunalish`,`id_fakultet`),
  ADD KEY `Relationship12` (`id_uquv_yili`),
  ADD KEY `Relationship14` (`id_tabaqa`);

--
-- Indexes for table `shartnoma_summasi`
--
ALTER TABLE `shartnoma_summasi`
  ADD PRIMARY KEY (`id_shartnoma_summa`,`id_uquv_yili`,`id_tabaqa`,`id_yunalish`,`id_fakultet`),
  ADD KEY `Relationship10` (`id_uquv_yili`),
  ADD KEY `Relationship11` (`id_tabaqa`),
  ADD KEY `Relationship13` (`id_yunalish`,`id_fakultet`);

--
-- Indexes for table `shartnoma_tarixi`
--
ALTER TABLE `shartnoma_tarixi`
  ADD PRIMARY KEY (`id_shartnoma_tarixi`,`id_shartnoma`,`id_talaba`,`id_yunalish`,`id_fakultet`,`id_uquv_yili`,`id_tabaqa`),
  ADD KEY `Relationship8` (`id_shartnoma`,`id_talaba`,`id_yunalish`,`id_fakultet`,`id_uquv_yili`,`id_tabaqa`);

--
-- Indexes for table `tabaqa`
--
ALTER TABLE `tabaqa`
  ADD PRIMARY KEY (`id_tabaqa`);

--
-- Indexes for table `talaba`
--
ALTER TABLE `talaba`
  ADD PRIMARY KEY (`id_talaba`,`id_yunalish`,`id_fakultet`),
  ADD KEY `Relationship4` (`id_yunalish`,`id_fakultet`);

--
-- Indexes for table `uquv_yili`
--
ALTER TABLE `uquv_yili`
  ADD PRIMARY KEY (`id_uquv_yili`);

--
-- Indexes for table `yunalishlar`
--
ALTER TABLE `yunalishlar`
  ADD PRIMARY KEY (`id_yunalish`,`id_fakultet`),
  ADD KEY `Relationship3` (`id_fakultet`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fakultet`
--
ALTER TABLE `fakultet`
  MODIFY `id_fakultet` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `shartnoma`
--
ALTER TABLE `shartnoma`
  MODIFY `id_shartnoma` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `shartnoma_summasi`
--
ALTER TABLE `shartnoma_summasi`
  MODIFY `id_shartnoma_summa` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `shartnoma_tarixi`
--
ALTER TABLE `shartnoma_tarixi`
  MODIFY `id_shartnoma_tarixi` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tabaqa`
--
ALTER TABLE `tabaqa`
  MODIFY `id_tabaqa` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `talaba`
--
ALTER TABLE `talaba`
  MODIFY `id_talaba` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `uquv_yili`
--
ALTER TABLE `uquv_yili`
  MODIFY `id_uquv_yili` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `yunalishlar`
--
ALTER TABLE `yunalishlar`
  MODIFY `id_yunalish` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `shartnoma`
--
ALTER TABLE `shartnoma`
  ADD CONSTRAINT `Relationship12` FOREIGN KEY (`id_uquv_yili`) REFERENCES `uquv_yili` (`id_uquv_yili`),
  ADD CONSTRAINT `Relationship14` FOREIGN KEY (`id_tabaqa`) REFERENCES `tabaqa` (`id_tabaqa`),
  ADD CONSTRAINT `Relationship9` FOREIGN KEY (`id_talaba`,`id_yunalish`,`id_fakultet`) REFERENCES `talaba` (`id_talaba`, `id_yunalish`, `id_fakultet`);

--
-- Constraints for table `shartnoma_summasi`
--
ALTER TABLE `shartnoma_summasi`
  ADD CONSTRAINT `Relationship10` FOREIGN KEY (`id_uquv_yili`) REFERENCES `uquv_yili` (`id_uquv_yili`),
  ADD CONSTRAINT `Relationship11` FOREIGN KEY (`id_tabaqa`) REFERENCES `tabaqa` (`id_tabaqa`),
  ADD CONSTRAINT `Relationship13` FOREIGN KEY (`id_yunalish`,`id_fakultet`) REFERENCES `yunalishlar` (`id_yunalish`, `id_fakultet`);

--
-- Constraints for table `shartnoma_tarixi`
--
ALTER TABLE `shartnoma_tarixi`
  ADD CONSTRAINT `Relationship8` FOREIGN KEY (`id_shartnoma`,`id_talaba`,`id_yunalish`,`id_fakultet`,`id_uquv_yili`,`id_tabaqa`) REFERENCES `shartnoma` (`id_shartnoma`, `id_talaba`, `id_yunalish`, `id_fakultet`, `id_uquv_yili`, `id_tabaqa`);

--
-- Constraints for table `talaba`
--
ALTER TABLE `talaba`
  ADD CONSTRAINT `Relationship4` FOREIGN KEY (`id_yunalish`,`id_fakultet`) REFERENCES `yunalishlar` (`id_yunalish`, `id_fakultet`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `yunalishlar`
--
ALTER TABLE `yunalishlar`
  ADD CONSTRAINT `Relationship3` FOREIGN KEY (`id_fakultet`) REFERENCES `fakultet` (`id_fakultet`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
