-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Des 2021 pada 11.08
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datamahasiswa`
--

CREATE TABLE `datamahasiswa` (
  `id` int(100) NOT NULL,
  `nim` varchar(16) NOT NULL,
  `nama` varchar(90) NOT NULL,
  `falkultas` varchar(90) NOT NULL,
  `jurusan` varchar(90) NOT NULL,
  `alamat` varchar(90) NOT NULL,
  `kota` varchar(90) NOT NULL,
  `hobby` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `datamahasiswa`
--

INSERT INTO `datamahasiswa` (`id`, `nim`, `nama`, `falkultas`, `jurusan`, `alamat`, `kota`, `hobby`) VALUES
(1, '202010370311128', 'Rysa Laksana', 'Teknik', 'Informatika', 'Malang', 'Malang', 'menyelam'),
(2, '2020103703111200', 'the wok', 'Ekonomi', 'sastra china', 'NY', 'NY', 'akting'),
(3, '2020103703111201', 'john xina', 'olahraga', 'tinju dibalas tinju', 'wuhan', 'china', 'petarunx');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `datamahasiswa`
--
ALTER TABLE `datamahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `datamahasiswa`
--
ALTER TABLE `datamahasiswa`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100001;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
