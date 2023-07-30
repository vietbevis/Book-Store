-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.34 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bookstoredb
CREATE DATABASE IF NOT EXISTS `bookstoredb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookstoredb`;

-- Dumping structure for table bookstoredb.donhang
CREATE TABLE IF NOT EXISTS `donhang` (
  `madonhang` int NOT NULL AUTO_INCREMENT,
  `makhachhang` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `manhanvien` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `masach` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tongtien` double DEFAULT NULL,
  `trangthai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`madonhang`),
  KEY `FK__khachhang` (`makhachhang`),
  KEY `FK_donhang_nhanvien` (`manhanvien`) USING BTREE,
  CONSTRAINT `FK__khachhang` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`),
  CONSTRAINT `FK_donhang_nhanvien` FOREIGN KEY (`manhanvien`) REFERENCES `nhanvien` (`manhanvien`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.donhang: ~5 rows (approximately)
REPLACE INTO `donhang` (`madonhang`, `makhachhang`, `manhanvien`, `masach`, `tongtien`, `trangthai`, `soluong`) VALUES
	(10, 'KH02', 'NV01', 'SP01', 300000, 'Chờ xử lý', 20),
	(12, 'KH02', 'NV01', 'SP03', 60000, 'Đã giao', 4),
	(15, 'KH01', 'NV01', 'SP03', 60000, 'Đã giao', 4),
	(18, 'KH01', 'NV01', 'SP05', 90000, 'Chờ xử lý', 6),
	(19, 'KH01', 'NV01', 'SP01', 45000, 'Chờ xử lý', 3);

-- Dumping structure for table bookstoredb.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makhachhang` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `hovaten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `diachi` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sodienthoai` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diemthuong` int DEFAULT NULL,
  `manhanvien` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`makhachhang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.khachhang: ~6 rows (approximately)
REPLACE INTO `khachhang` (`makhachhang`, `hovaten`, `ngaysinh`, `diachi`, `sodienthoai`, `email`, `diemthuong`, `manhanvien`) VALUES
	('KH01', 'Nguyen Van A', '2023-07-27', 'Gia Binh', '0987654321', 'kh01@gmail.com', 0, 'NV01'),
	('KH02', 'Nguyen Van Viet', '2002-02-02', 'Gia Binh', '0987654321', 'kh02@gmail.com', 0, 'NV01'),
	('KH03', 'Tran Kim Huyen', '2000-10-02', 'Bac Ninh', '0987656789', 'kh03@gmail.com', 0, 'NV01'),
	('KH04', 'Nguyen Thi Ngoc Diep', '2012-11-07', 'Lang Ngam', '0111111111', 'kh04@gmail.com', 0, 'NV01'),
	('KH05', 'Nguyen Van Bon', '2001-09-03', 'Dap Cau', '0787878787', 'kh05@gmail.com', 0, 'NV01'),
	('KH06', 'Trinh Quoc Dat', '2008-01-01', 'Quang Nam', '0121212121', 'kh06@gmail.com', 0, 'NV02');

-- Dumping structure for table bookstoredb.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manhanvien` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `hovaten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `diachi` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sodienthoai` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sodonbanduoc` int DEFAULT NULL,
  PRIMARY KEY (`manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.nhanvien: ~2 rows (approximately)
REPLACE INTO `nhanvien` (`manhanvien`, `hovaten`, `ngaysinh`, `diachi`, `sodienthoai`, `email`, `sodonbanduoc`) VALUES
	('NV01', 'Nguyen Van A', '2023-07-27', 'Ngam Luong', '0999999999', 'nv01@gmail.com', 2),
	('NV02', 'Tran Kim Huyen', '2023-07-27', 'Dong Binh', '0987654321', 'nv02@gmail.com', 0),
	('NV03', 'Tran Y Ham', '2001-02-02', 'Dai Loan', '0987890890', 'nv03@gmail.com', 0);

-- Dumping structure for table bookstoredb.sach
CREATE TABLE IF NOT EXISTS `sach` (
  `masach` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tensach` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `matacgia` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `namxuatban` int DEFAULT NULL,
  `matheloai` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `ngonngu` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mota` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gianhap` double DEFAULT NULL,
  `giaban` double DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`masach`),
  KEY `FK_sach_tacgia` (`matacgia`),
  KEY `FK_sach_theloai` (`matheloai`),
  CONSTRAINT `FK_sach_tacgia` FOREIGN KEY (`matacgia`) REFERENCES `tacgia` (`matacgia`),
  CONSTRAINT `FK_sach_theloai` FOREIGN KEY (`matheloai`) REFERENCES `theloai` (`matheloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.sach: ~5 rows (approximately)
REPLACE INTO `sach` (`masach`, `tensach`, `matacgia`, `namxuatban`, `matheloai`, `ngonngu`, `mota`, `gianhap`, `giaban`, `soluong`) VALUES
	('SP01', 'Java', 'TG01', 2001, 'CT', 'Viet', NULL, 10000, 15000, 96),
	('SP02', 'C++', 'TG02', 2000, 'TT', 'Viet', NULL, 10000, 15000, 96),
	('SP03', 'Python', 'TG03', 1999, 'KT', 'Anh', NULL, 10000, 15000, 98),
	('SP04', 'Html', 'TG04', 1989, 'PL', 'Anh', NULL, 10000, 15000, 95),
	('SP05', 'Css', 'TG05', 2004, 'CT', 'Viet', NULL, 10000, 15000, 94);

-- Dumping structure for table bookstoredb.tacgia
CREATE TABLE IF NOT EXISTS `tacgia` (
  `matacgia` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `tentacgia` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `tieusu` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`matacgia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.tacgia: ~5 rows (approximately)
REPLACE INTO `tacgia` (`matacgia`, `tentacgia`, `ngaysinh`, `tieusu`) VALUES
	('TG01', 'Nguyen Van A', '2001-11-11', NULL),
	('TG02', 'Dao Trinh Trong', '1990-02-02', NULL),
	('TG03', 'Tran Kim Huyen', '1989-03-03', NULL),
	('TG04', 'Tran My Hanh', '2000-01-01', NULL),
	('TG05', 'Nguyen Van Viet', '2001-04-04', NULL);

-- Dumping structure for table bookstoredb.theloai
CREATE TABLE IF NOT EXISTS `theloai` (
  `matheloai` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `tentheloai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`matheloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bookstoredb.theloai: ~4 rows (approximately)
REPLACE INTO `theloai` (`matheloai`, `tentheloai`) VALUES
	('CT', 'Chinh Tri'),
	('KT', 'Kinh Te'),
	('PL', 'Phap Luat'),
	('TT', 'Trinh Tham');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
