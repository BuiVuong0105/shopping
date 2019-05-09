-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 09, 2019 lúc 05:19 CH
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopping`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_execution`
--

CREATE TABLE `batch_job_execution` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EXIT_CODE` varchar(2500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL,
  `JOB_CONFIGURATION_LOCATION` varchar(2500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_execution`
--

INSERT INTO `batch_job_execution` (`JOB_EXECUTION_ID`, `VERSION`, `JOB_INSTANCE_ID`, `CREATE_TIME`, `START_TIME`, `END_TIME`, `STATUS`, `EXIT_CODE`, `EXIT_MESSAGE`, `LAST_UPDATED`, `JOB_CONFIGURATION_LOCATION`) VALUES
(1, 2, 1, '2019-03-23 18:44:18', '2019-03-23 18:44:18', '2019-03-23 18:44:19', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:44:19', NULL),
(2, 2, 2, '2019-03-23 18:46:33', '2019-03-23 18:46:33', '2019-03-23 18:46:34', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:46:34', NULL),
(3, 2, 3, '2019-03-23 18:47:02', '2019-03-23 18:47:03', '2019-03-23 18:47:03', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:47:03', NULL),
(4, 2, 4, '2019-03-23 18:49:34', '2019-03-23 18:49:34', '2019-03-23 18:49:35', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:49:35', NULL),
(5, 2, 5, '2019-03-23 18:54:34', '2019-03-23 18:54:35', '2019-03-23 18:54:36', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:54:36', NULL),
(6, 2, 6, '2019-03-23 18:55:06', '2019-03-23 18:55:06', '2019-03-23 18:55:07', 'COMPLETED', 'COMPLETED', '', '2019-03-23 18:55:07', NULL),
(7, 2, 7, '2019-03-25 09:43:16', '2019-03-25 09:43:17', '2019-03-25 09:43:18', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:43:18', NULL),
(8, 2, 8, '2019-03-25 09:46:33', '2019-03-25 09:46:34', '2019-03-25 09:46:34', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:46:34', NULL),
(9, 2, 9, '2019-03-25 09:46:52', '2019-03-25 09:46:53', '2019-03-25 09:46:53', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:46:53', NULL),
(10, 2, 10, '2019-03-25 09:50:07', '2019-03-25 09:50:07', '2019-03-25 09:50:08', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:50:08', NULL),
(11, 2, 11, '2019-03-25 09:52:24', '2019-03-25 09:52:24', '2019-03-25 09:52:25', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:52:25', NULL),
(12, 2, 12, '2019-03-25 09:52:33', '2019-03-25 09:52:33', '2019-03-25 09:52:34', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:52:34', NULL),
(13, 2, 13, '2019-03-25 09:54:06', '2019-03-25 09:54:06', '2019-03-25 09:54:07', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:54:07', NULL),
(14, 2, 14, '2019-03-25 09:54:59', '2019-03-25 09:54:59', '2019-03-25 09:55:00', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:55:00', NULL),
(15, 2, 15, '2019-03-25 09:56:21', '2019-03-25 09:56:21', '2019-03-25 09:56:22', 'COMPLETED', 'COMPLETED', '', '2019-03-25 09:56:22', NULL),
(16, 2, 16, '2019-03-25 10:11:28', '2019-03-25 10:11:29', '2019-03-25 10:11:29', 'COMPLETED', 'COMPLETED', '', '2019-03-25 10:11:29', NULL),
(17, 2, 17, '2019-03-25 10:13:14', '2019-03-25 10:13:15', '2019-03-25 10:13:16', 'COMPLETED', 'COMPLETED', '', '2019-03-25 10:13:16', NULL),
(18, 2, 18, '2019-03-25 20:25:34', '2019-03-25 20:25:34', '2019-03-25 20:25:50', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:25:51', NULL),
(19, 2, 19, '2019-03-25 20:27:21', '2019-03-25 20:27:22', '2019-03-25 20:27:37', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:27:37', NULL),
(20, 2, 20, '2019-03-25 20:27:50', '2019-03-25 20:27:50', '2019-03-25 20:28:06', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:28:06', NULL),
(21, 2, 21, '2019-03-25 20:30:46', '2019-03-25 20:30:46', '2019-03-25 20:31:02', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:31:02', NULL),
(22, 2, 22, '2019-03-25 20:33:48', '2019-03-25 20:33:49', '2019-03-25 20:34:04', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:34:04', NULL),
(23, 2, 23, '2019-03-25 20:34:23', '2019-03-25 20:34:23', '2019-03-25 20:34:39', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:34:39', NULL),
(24, 2, 24, '2019-03-25 20:37:26', '2019-03-25 20:37:26', '2019-03-25 20:37:41', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:37:41', NULL),
(25, 2, 25, '2019-03-25 20:37:54', '2019-03-25 20:37:54', '2019-03-25 20:38:10', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:38:10', NULL),
(26, 2, 26, '2019-03-25 20:43:36', '2019-03-25 20:43:36', '2019-03-25 20:43:52', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:43:52', NULL),
(27, 2, 27, '2019-03-25 20:45:15', '2019-03-25 20:45:16', '2019-03-25 20:45:31', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:45:31', NULL),
(28, 2, 28, '2019-03-25 20:48:32', '2019-03-25 20:48:32', '2019-03-25 20:48:48', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:48:48', NULL),
(29, 2, 29, '2019-03-25 20:53:12', '2019-03-25 20:53:12', '2019-03-25 20:53:28', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:53:28', NULL),
(30, 2, 30, '2019-03-25 20:56:29', '2019-03-25 20:56:30', '2019-03-25 20:56:46', 'COMPLETED', 'COMPLETED', '', '2019-03-25 20:56:46', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_execution_context`
--

CREATE TABLE `batch_job_execution_context` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) COLLATE utf8_unicode_ci NOT NULL,
  `SERIALIZED_CONTEXT` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_execution_context`
--

INSERT INTO `batch_job_execution_context` (`JOB_EXECUTION_ID`, `SHORT_CONTEXT`, `SERIALIZED_CONTEXT`) VALUES
(1, '{\"jobId\":[\"java.lang.Long\",1]}', NULL),
(2, '{\"jobId\":[\"java.lang.Long\",2]}', NULL),
(3, '{\"jobId\":[\"java.lang.Long\",3]}', NULL),
(4, '{\"jobId\":[\"java.lang.Long\",4]}', NULL),
(5, '{\"jobId\":[\"java.lang.Long\",5]}', NULL),
(6, '{\"jobId\":[\"java.lang.Long\",6]}', NULL),
(7, '{\"jobId\":[\"java.lang.Long\",7]}', NULL),
(8, '{\"jobId\":[\"java.lang.Long\",8]}', NULL),
(9, '{\"jobId\":[\"java.lang.Long\",9]}', NULL),
(10, '{\"jobId\":[\"java.lang.Long\",10]}', NULL),
(11, '{\"jobId\":[\"java.lang.Long\",11]}', NULL),
(12, '{\"jobId\":[\"java.lang.Long\",12]}', NULL),
(13, '{\"jobId\":[\"java.lang.Long\",13]}', NULL),
(14, '{\"jobId\":[\"java.lang.Long\",14]}', NULL),
(15, '{\"jobId\":[\"java.lang.Long\",15]}', NULL),
(16, '{\"jobId\":[\"java.lang.Long\",16]}', NULL),
(17, '{\"jobId\":[\"java.lang.Long\",17]}', NULL),
(18, '{\"jobId\":[\"java.lang.Long\",18]}', NULL),
(19, '{\"jobId\":[\"java.lang.Long\",19]}', NULL),
(20, '{\"jobId\":[\"java.lang.Long\",20]}', NULL),
(21, '{\"jobId\":[\"java.lang.Long\",21]}', NULL),
(22, '{\"jobId\":[\"java.lang.Long\",22]}', NULL),
(23, '{\"jobId\":[\"java.lang.Long\",23]}', NULL),
(24, '{\"jobId\":[\"java.lang.Long\",24]}', NULL),
(25, '{\"jobId\":[\"java.lang.Long\",25]}', NULL),
(26, '{\"jobId\":[\"java.lang.Long\",26]}', NULL),
(27, '{\"jobId\":[\"java.lang.Long\",27]}', NULL),
(28, '{\"jobId\":[\"java.lang.Long\",28]}', NULL),
(29, '{\"jobId\":[\"java.lang.Long\",29]}', NULL),
(30, '{\"jobId\":[\"java.lang.Long\",30]}', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_execution_params`
--

CREATE TABLE `batch_job_execution_params` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `TYPE_CD` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `KEY_NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `STRING_VAL` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_VAL` datetime DEFAULT NULL,
  `LONG_VAL` bigint(20) DEFAULT NULL,
  `DOUBLE_VAL` double DEFAULT NULL,
  `IDENTIFYING` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_execution_params`
--

INSERT INTO `batch_job_execution_params` (`JOB_EXECUTION_ID`, `TYPE_CD`, `KEY_NAME`, `STRING_VAL`, `DATE_VAL`, `LONG_VAL`, `DOUBLE_VAL`, `IDENTIFYING`) VALUES
(1, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(2, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 2, 0, 'Y'),
(3, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 3, 0, 'Y'),
(4, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 4, 0, 'Y'),
(5, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 5, 0, 'Y'),
(6, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553342106144, 0, 'Y'),
(7, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(7, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553342106144, 0, 'Y'),
(8, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 2, 0, 'Y'),
(8, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553342106144, 0, 'Y'),
(9, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482012851, 0, 'Y'),
(10, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(10, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482012851, 0, 'Y'),
(11, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 2, 0, 'Y'),
(11, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482012851, 0, 'Y'),
(12, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(13, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(13, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(14, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 2, 0, 'Y'),
(14, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(15, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 3, 0, 'Y'),
(15, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(16, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 4, 0, 'Y'),
(16, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(17, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 5, 0, 'Y'),
(17, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(18, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 6, 0, 'Y'),
(18, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(19, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 7, 0, 'Y'),
(19, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553482353556, 0, 'Y'),
(20, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553520470336, 0, 'Y'),
(21, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(21, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553520470336, 0, 'Y'),
(22, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 2, 0, 'Y'),
(22, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553520470336, 0, 'Y'),
(23, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553520863294, 0, 'Y'),
(24, 'LONG', 'run.id', '', '1970-01-01 07:00:00', 1, 0, 'Y'),
(24, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553520863294, 0, 'Y'),
(25, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553521074424, 0, 'Y'),
(26, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553521416324, 0, 'Y'),
(27, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553521515754, 0, 'Y'),
(28, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553521712066, 0, 'Y'),
(29, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553521992141, 0, 'Y'),
(30, 'LONG', 'time', '', '1970-01-01 07:00:00', 1553522189092, 0, 'Y');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_execution_seq`
--

CREATE TABLE `batch_job_execution_seq` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_execution_seq`
--

INSERT INTO `batch_job_execution_seq` (`ID`, `UNIQUE_KEY`) VALUES
(30, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_instance`
--

CREATE TABLE `batch_job_instance` (
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_KEY` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_instance`
--

INSERT INTO `batch_job_instance` (`JOB_INSTANCE_ID`, `VERSION`, `JOB_NAME`, `JOB_KEY`) VALUES
(1, 0, 'processJob', '853d3449e311f40366811cbefb3d93d7'),
(2, 0, 'processJob', 'e070bff4379694c0210a51d9f6c6a564'),
(3, 0, 'processJob', 'a3364faf893276dea0caacefbf618db5'),
(4, 0, 'processJob', '47c0a8118b74165a864b66d37c7b6cf5'),
(5, 0, 'processJob', 'ce148f5f9c2bf4dc9bd44a7a5f64204c'),
(6, 0, 'processJob', '012d9e7859cfd492a19319eb3f7d44ec'),
(7, 0, 'processJob', 'e00dab4a38322fc66f1dc0e494db64eb'),
(8, 0, 'processJob', '35a02a7bec2a60a0d17799186b4fbf54'),
(9, 0, 'processJob', '01985058f0bab1f97acb0429f88a1b38'),
(10, 0, 'processJob', '619039993169d06cccd4cbc1ace74b58'),
(11, 0, 'processJob', '7ed061815d41368c7ac7ca3fa14a715f'),
(12, 0, 'processJob', 'fd9fff2977e28ed698dd4449cda16a47'),
(13, 0, 'processJob', '065e213bac5e13a1cb9b5b6f1527dda8'),
(14, 0, 'processJob', '6c5129a333c5fc919eacc7c2fda70cb0'),
(15, 0, 'processJob', '9b914e50ee4c5f8ed9a816d48b7f6251'),
(16, 0, 'processJob', '2a9cfacac82fa4de803401c4ecac4a2b'),
(17, 0, 'processJob', '45467f0fdca71349ac6bfe61e040aaf0'),
(18, 0, 'processJob', 'dceec364b593b238764eb334f88cb4d0'),
(19, 0, 'processJob', '55ece8fd1fc84c1f686d589f04d82a99'),
(20, 0, 'processJob', '17b5689ec34371bdeff2c11718a39ee9'),
(21, 0, 'processJob', '664ae5c38177c32db57adc914108b598'),
(22, 0, 'processJob', 'd965a9a74d23e44ca9f0fb6cc0a7ec36'),
(23, 0, 'processJob', '5848478c3004a5469bb277de131af589'),
(24, 0, 'processJob', '1a000762a695c83e765368ccf01d2f5a'),
(25, 0, 'processJob', '72de621e89abc3b4f8f5eda3aabcc439'),
(26, 0, 'processJob', 'afb244952e0cd0ace4a32fff8f40a912'),
(27, 0, 'processJob', 'bdb4b980840b0f52017233a3e75ba5be'),
(28, 0, 'processJob', 'b011087b7aefd133484bb127a5802c9c'),
(29, 0, 'processJob', 'e7c7217d66efb0cb67cfad9509950d58'),
(30, 0, 'processJob', '3e05bad98fe46cad3eec7c8b713cbb72');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_job_seq`
--

CREATE TABLE `batch_job_seq` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_job_seq`
--

INSERT INTO `batch_job_seq` (`ID`, `UNIQUE_KEY`) VALUES
(30, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_step_execution`
--

CREATE TABLE `batch_step_execution` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) NOT NULL,
  `STEP_NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `START_TIME` datetime NOT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `COMMIT_COUNT` bigint(20) DEFAULT NULL,
  `READ_COUNT` bigint(20) DEFAULT NULL,
  `FILTER_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_COUNT` bigint(20) DEFAULT NULL,
  `READ_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `PROCESS_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `ROLLBACK_COUNT` bigint(20) DEFAULT NULL,
  `EXIT_CODE` varchar(2500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_step_execution`
--

INSERT INTO `batch_step_execution` (`STEP_EXECUTION_ID`, `VERSION`, `STEP_NAME`, `JOB_EXECUTION_ID`, `START_TIME`, `END_TIME`, `STATUS`, `COMMIT_COUNT`, `READ_COUNT`, `FILTER_COUNT`, `WRITE_COUNT`, `READ_SKIP_COUNT`, `WRITE_SKIP_COUNT`, `PROCESS_SKIP_COUNT`, `ROLLBACK_COUNT`, `EXIT_CODE`, `EXIT_MESSAGE`, `LAST_UPDATED`) VALUES
(1, 6, 'orderStep1', 1, '2019-03-23 18:44:18', '2019-03-23 18:44:19', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:44:19'),
(2, 6, 'orderStep1', 2, '2019-03-23 18:46:33', '2019-03-23 18:46:34', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:46:34'),
(3, 6, 'orderStep1', 3, '2019-03-23 18:47:03', '2019-03-23 18:47:03', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:47:03'),
(4, 6, 'orderStep1', 4, '2019-03-23 18:49:34', '2019-03-23 18:49:35', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:49:35'),
(5, 6, 'orderStep1', 5, '2019-03-23 18:54:35', '2019-03-23 18:54:35', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:54:35'),
(6, 6, 'orderStep1', 6, '2019-03-23 18:55:06', '2019-03-23 18:55:07', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-23 18:55:07'),
(7, 6, 'orderStep1', 7, '2019-03-25 09:43:17', '2019-03-25 09:43:18', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:43:18'),
(8, 6, 'orderStep1', 8, '2019-03-25 09:46:34', '2019-03-25 09:46:34', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:46:34'),
(9, 6, 'orderStep1', 9, '2019-03-25 09:46:53', '2019-03-25 09:46:53', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:46:53'),
(10, 6, 'orderStep1', 10, '2019-03-25 09:50:08', '2019-03-25 09:50:08', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:50:08'),
(11, 6, 'orderStep1', 11, '2019-03-25 09:52:25', '2019-03-25 09:52:25', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:52:25'),
(12, 6, 'orderStep1', 12, '2019-03-25 09:52:34', '2019-03-25 09:52:34', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:52:34'),
(13, 6, 'orderStep1', 13, '2019-03-25 09:54:06', '2019-03-25 09:54:07', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:54:07'),
(14, 6, 'orderStep1', 14, '2019-03-25 09:54:59', '2019-03-25 09:55:00', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:55:00'),
(15, 6, 'orderStep1', 15, '2019-03-25 09:56:22', '2019-03-25 09:56:22', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 09:56:22'),
(16, 6, 'orderStep1', 16, '2019-03-25 10:11:29', '2019-03-25 10:11:29', 'COMPLETED', 4, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 10:11:29'),
(17, 4, 'orderStep1', 17, '2019-03-25 10:13:15', '2019-03-25 10:13:16', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 10:13:16'),
(18, 4, 'orderStep1', 18, '2019-03-25 20:25:35', '2019-03-25 20:25:50', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:25:50'),
(19, 4, 'orderStep1', 19, '2019-03-25 20:27:22', '2019-03-25 20:27:37', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:27:37'),
(20, 4, 'orderStep1', 20, '2019-03-25 20:27:51', '2019-03-25 20:28:06', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:28:06'),
(21, 4, 'orderStep1', 21, '2019-03-25 20:30:47', '2019-03-25 20:31:02', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:31:02'),
(22, 4, 'orderStep1', 22, '2019-03-25 20:33:49', '2019-03-25 20:34:04', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:34:04'),
(23, 4, 'orderStep1', 23, '2019-03-25 20:34:24', '2019-03-25 20:34:39', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:34:39'),
(24, 4, 'orderStep1', 24, '2019-03-25 20:37:26', '2019-03-25 20:37:41', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:37:41'),
(25, 4, 'orderStep1', 25, '2019-03-25 20:37:55', '2019-03-25 20:38:10', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:38:10'),
(26, 4, 'orderStep1', 26, '2019-03-25 20:43:37', '2019-03-25 20:43:52', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:43:52'),
(27, 4, 'orderStep1', 27, '2019-03-25 20:45:16', '2019-03-25 20:45:31', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:45:31'),
(28, 4, 'orderStep1', 28, '2019-03-25 20:48:32', '2019-03-25 20:48:48', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:48:48'),
(29, 4, 'orderStep1', 29, '2019-03-25 20:53:12', '2019-03-25 20:53:28', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:53:28'),
(30, 4, 'orderStep1', 30, '2019-03-25 20:56:30', '2019-03-25 20:56:46', 'COMPLETED', 2, 3, 0, 3, 0, 0, 0, 0, 'COMPLETED', '', '2019-03-25 20:56:46');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_step_execution_context`
--

CREATE TABLE `batch_step_execution_context` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) COLLATE utf8_unicode_ci NOT NULL,
  `SERIALIZED_CONTEXT` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_step_execution_context`
--

INSERT INTO `batch_step_execution_context` (`STEP_EXECUTION_ID`, `SHORT_CONTEXT`, `SERIALIZED_CONTEXT`) VALUES
(1, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(2, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(3, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(4, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(5, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(6, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(7, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(8, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(9, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(10, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(11, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(12, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(13, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(14, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(15, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(16, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(17, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(18, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(19, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(20, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(21, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(22, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(23, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(24, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(25, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(26, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(27, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(28, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(29, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL),
(30, '{\"batch.taskletType\":\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\",\"username\":\"vuongbv\"}', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `batch_step_execution_seq`
--

CREATE TABLE `batch_step_execution_seq` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `batch_step_execution_seq`
--

INSERT INTO `batch_step_execution_seq` (`ID`, `UNIQUE_KEY`) VALUES
(30, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category_parent_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `code`, `name`, `category_parent_id`) VALUES
(17, 'T001', 'Mac', NULL),
(18, 'T002', 'IPhone', NULL),
(19, 'T003', 'IPad', NULL),
(20, 'T004', 'Watch', NULL),
(21, 'S001', 'MacBook', 17),
(22, 'S002', 'MacBook Air', 17),
(23, 'S003', 'MacBook Pro', 17),
(24, 'S004', 'iMac', 17),
(25, 'S005', 'iMac Pro', 17),
(26, 'S006', 'Mac Pro', 17),
(27, 'S007', 'Mac mini', 17),
(28, 'S008', 'IPhone7', 18),
(29, 'S009', 'IPhone8', 18),
(30, 'S010', 'IPhone Xs', 18),
(31, 'S011', 'IPhone Xr', 18),
(32, 'S012', 'iPad Pro', 19),
(33, 'S013', 'iPad Air', 19),
(34, 'S014', 'iPad', 19),
(35, 'S015', 'iPad mini', 19),
(36, 'S016', 'Apple Watch Series 4', 20),
(37, 'S017', 'Apple Watch Nike+', 20),
(38, 'S018', 'Apple Watch Hermès', 20),
(39, 'S019', 'Apple Watch Series 3', 20),
(40, 'S020', 'watchOS', 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `item_sub_type_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `supplier_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `item_sub_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item_sub_type`
--

CREATE TABLE `item_sub_type` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `item_type_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `item_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `item_sub_type`
--

INSERT INTO `item_sub_type` (`id`, `code`, `name`, `item_type_name`, `item_type_id`) VALUES
(1, 'S001', 'IPhone7', 'IPhone', 75),
(2, 'S002', 'IPhone8', 'IPhone', 75),
(4, 'S003', 'IPhone Xs', 'IPhone', 75),
(5, 'S004', 'IPhone Xr', 'IPhone', 75),
(6, 'S005', 'MacBook', 'Mac', 74),
(7, 'S006', 'MacBook Air', 'Mac', 74),
(8, 'S007', 'MacBook Pro', 'Mac', 74),
(9, 'S008', 'iMac', 'Mac', 74),
(10, 'S009', 'iMac Pro', 'Mac', 74),
(11, 'S010', 'Mac Pro', 'Mac', 74),
(12, 'S011', 'Mac mini', 'Mac', 74),
(13, 'S012', 'iPad Pro', 'IPad', 76),
(14, 'S013', 'iPad Air', 'IPad', 76),
(15, 'S014', 'iPad', 'IPad', 76),
(16, 'S015', 'iPad mini', 'IPad', 76),
(17, 'S016', 'Apple Watch Series 4', 'Watch', 78),
(18, 'S017', 'Apple Watch Nike+', 'Watch', 78),
(19, 'S018', 'Apple Watch Hermès', 'Watch', 78),
(20, 'S019', 'Apple Watch Series 3', 'Watch', 78),
(21, 'S020', 'watchOS', 'Watch', 78);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item_type`
--

CREATE TABLE `item_type` (
  `id` bigint(11) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `item_type`
--

INSERT INTO `item_type` (`id`, `code`, `name`) VALUES
(74, 'T001', 'Mac'),
(75, 'T002', 'IPhone'),
(76, 'T003', 'IPad'),
(78, 'T004', 'Watch');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `category_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_blob_triggers`
--

CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `BLOB_DATA` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_calendars`
--

CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `CALENDAR_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `CALENDAR` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_cron_triggers`
--

CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_fired_triggers`
--

CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `ENTRY_ID` varchar(95) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_job_details`
--

CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `IS_DURABLE` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_DATA` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_locks`
--

CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `LOCK_NAME` varchar(40) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `qrtz_locks`
--

INSERT INTO `qrtz_locks` (`SCHED_NAME`, `LOCK_NAME`) VALUES
('schedulerFactoryBean', 'TRIGGER_ACCESS');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_paused_trigger_grps`
--

CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_scheduler_state`
--

CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_simple_triggers`
--

CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_simprop_triggers`
--

CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `STR_PROP_1` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STR_PROP_2` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STR_PROP_3` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qrtz_triggers`
--

CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL,
  `code` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `code`, `name`) VALUES
(1, 'S001', 'Vues'),
(2, 'S002', 'KTC-S');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `t_exception_job`
--

CREATE TABLE `t_exception_job` (
  `id` int(11) NOT NULL,
  `job_key` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `occurred_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exception_content` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ware_house`
--

CREATE TABLE `ware_house` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ware_house`
--

INSERT INTO `ware_house` (`id`, `code`, `name`) VALUES
(1, 'T100', 'Nhà Kho T100'),
(2, 'T200', 'Nhà Kho T200');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `batch_job_execution`
--
ALTER TABLE `batch_job_execution`
  ADD PRIMARY KEY (`JOB_EXECUTION_ID`),
  ADD KEY `JOB_INST_EXEC_FK` (`JOB_INSTANCE_ID`);

--
-- Chỉ mục cho bảng `batch_job_execution_context`
--
ALTER TABLE `batch_job_execution_context`
  ADD PRIMARY KEY (`JOB_EXECUTION_ID`);

--
-- Chỉ mục cho bảng `batch_job_execution_params`
--
ALTER TABLE `batch_job_execution_params`
  ADD KEY `JOB_EXEC_PARAMS_FK` (`JOB_EXECUTION_ID`);

--
-- Chỉ mục cho bảng `batch_job_execution_seq`
--
ALTER TABLE `batch_job_execution_seq`
  ADD UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`);

--
-- Chỉ mục cho bảng `batch_job_instance`
--
ALTER TABLE `batch_job_instance`
  ADD PRIMARY KEY (`JOB_INSTANCE_ID`),
  ADD UNIQUE KEY `JOB_INST_UN` (`JOB_NAME`,`JOB_KEY`);

--
-- Chỉ mục cho bảng `batch_job_seq`
--
ALTER TABLE `batch_job_seq`
  ADD UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`);

--
-- Chỉ mục cho bảng `batch_step_execution`
--
ALTER TABLE `batch_step_execution`
  ADD PRIMARY KEY (`STEP_EXECUTION_ID`),
  ADD KEY `JOB_EXEC_STEP_FK` (`JOB_EXECUTION_ID`);

--
-- Chỉ mục cho bảng `batch_step_execution_context`
--
ALTER TABLE `batch_step_execution_context`
  ADD PRIMARY KEY (`STEP_EXECUTION_ID`);

--
-- Chỉ mục cho bảng `batch_step_execution_seq`
--
ALTER TABLE `batch_step_execution_seq`
  ADD UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_parent` (`category_parent_id`);

--
-- Chỉ mục cho bảng `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_item_itemtype` (`item_sub_type_id`);

--
-- Chỉ mục cho bảng `item_sub_type`
--
ALTER TABLE `item_sub_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_subtype_type` (`item_type_id`);

--
-- Chỉ mục cho bảng `item_type`
--
ALTER TABLE `item_type`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `qrtz_blob_triggers`
--
ALTER TABLE `qrtz_blob_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  ADD KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_calendars`
--
ALTER TABLE `qrtz_calendars`
  ADD PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`);

--
-- Chỉ mục cho bảng `qrtz_cron_triggers`
--
ALTER TABLE `qrtz_cron_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_fired_triggers`
--
ALTER TABLE `qrtz_fired_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  ADD KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  ADD KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  ADD KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  ADD KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  ADD KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  ADD KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_job_details`
--
ALTER TABLE `qrtz_job_details`
  ADD PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  ADD KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  ADD KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_locks`
--
ALTER TABLE `qrtz_locks`
  ADD PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`);

--
-- Chỉ mục cho bảng `qrtz_paused_trigger_grps`
--
ALTER TABLE `qrtz_paused_trigger_grps`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_scheduler_state`
--
ALTER TABLE `qrtz_scheduler_state`
  ADD PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`);

--
-- Chỉ mục cho bảng `qrtz_simple_triggers`
--
ALTER TABLE `qrtz_simple_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_simprop_triggers`
--
ALTER TABLE `qrtz_simprop_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`);

--
-- Chỉ mục cho bảng `qrtz_triggers`
--
ALTER TABLE `qrtz_triggers`
  ADD PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  ADD KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  ADD KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  ADD KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  ADD KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  ADD KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  ADD KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  ADD KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  ADD KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  ADD KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  ADD KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  ADD KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  ADD KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `t_exception_job`
--
ALTER TABLE `t_exception_job`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ware_house`
--
ALTER TABLE `ware_house`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT cho bảng `item`
--
ALTER TABLE `item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `item_sub_type`
--
ALTER TABLE `item_sub_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT cho bảng `item_type`
--
ALTER TABLE `item_type`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `t_exception_job`
--
ALTER TABLE `t_exception_job`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `ware_house`
--
ALTER TABLE `ware_house`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `batch_job_execution`
--
ALTER TABLE `batch_job_execution`
  ADD CONSTRAINT `JOB_INST_EXEC_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `batch_job_instance` (`JOB_INSTANCE_ID`);

--
-- Các ràng buộc cho bảng `batch_job_execution_context`
--
ALTER TABLE `batch_job_execution_context`
  ADD CONSTRAINT `JOB_EXEC_CTX_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`);

--
-- Các ràng buộc cho bảng `batch_job_execution_params`
--
ALTER TABLE `batch_job_execution_params`
  ADD CONSTRAINT `JOB_EXEC_PARAMS_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`);

--
-- Các ràng buộc cho bảng `batch_step_execution`
--
ALTER TABLE `batch_step_execution`
  ADD CONSTRAINT `JOB_EXEC_STEP_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`);

--
-- Các ràng buộc cho bảng `batch_step_execution_context`
--
ALTER TABLE `batch_step_execution_context`
  ADD CONSTRAINT `STEP_EXEC_CTX_FK` FOREIGN KEY (`STEP_EXECUTION_ID`) REFERENCES `batch_step_execution` (`STEP_EXECUTION_ID`);

--
-- Các ràng buộc cho bảng `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`category_parent_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`item_sub_type_id`) REFERENCES `item_sub_type` (`id`);

--
-- Các ràng buộc cho bảng `item_sub_type`
--
ALTER TABLE `item_sub_type`
  ADD CONSTRAINT `item_sub_type_ibfk_1` FOREIGN KEY (`item_type_id`) REFERENCES `item_type` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `qrtz_blob_triggers`
--
ALTER TABLE `qrtz_blob_triggers`
  ADD CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`);

--
-- Các ràng buộc cho bảng `qrtz_cron_triggers`
--
ALTER TABLE `qrtz_cron_triggers`
  ADD CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`);

--
-- Các ràng buộc cho bảng `qrtz_simple_triggers`
--
ALTER TABLE `qrtz_simple_triggers`
  ADD CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`);

--
-- Các ràng buộc cho bảng `qrtz_simprop_triggers`
--
ALTER TABLE `qrtz_simprop_triggers`
  ADD CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`);

--
-- Các ràng buộc cho bảng `qrtz_triggers`
--
ALTER TABLE `qrtz_triggers`
  ADD CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
