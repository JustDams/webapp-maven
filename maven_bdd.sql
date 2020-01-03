-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 03 jan. 2020 à 13:33
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `maven_bdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(30) NOT NULL,
  `title` varchar(40) NOT NULL,
  `description` text NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id`, `author`, `title`, `description`, `content`, `date`) VALUES
(3, 'Unknown', 'Dolor sit amet consectetur adipiscing.', 'Sed viverra tellus in hac habitasse. Sit amet venenatis urna cursus eget nunc scelerisque. Sed tempus urna et pharetra pharetra. Eget arcu dictum varius duis at consectetur lorem donec massa. Nam aliquam sem et tortor consequat id. Nisi vitae suscipit tellus mauris.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2020-01-03'),
(4, 'test', 'Lorem ipsum ', 'Facilisis gravida neque convallis a.tellus molestie nunc non blandit. In est ante in nibh mauris cursus mattis molestie a. Pulvinar elementum integer enim neque volutpat. Amet venenatis urna', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus mauris a diam maecenas. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Orci eu lobortis elementum nibh tellus molestie nunc non blandit. Ut placerat orci nulla pellentesque dignissim enim sit amet. Mi quis hendrerit dolor magna eget est lorem. Sit amet consectetur adipiscing elit pellentesque habitant morbi. In mollis nunc sed id semper risus in hendrerit gravida. Amet luctus venenatis lectus magna fringilla urna porttitor rhoncus. Pharetra massa massa ultricies mi. Facilisis gravida neque convallis a. Elementum nibh tellus molestie nunc non blandit. In est ante in nibh mauris cursus mattis molestie a. Pulvinar elementum integer enim neque volutpat. Amet venenatis urna cursus eget nunc scelerisque.', '2020-01-03'),
(5, 'Nunc aliquet ', 'Vestibulum lectus mauris ultrices eros. ', 'Nunc aliquet bibendum enim facilisis. Penatibus et magnis dis parturient montes nascetur ridiculus. A cras semper auctor neque vitae. Mattis pellentesque id nibh tortor id aliquet.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Quis enim lobortis scelerisque fermentum. Posuere ac ut consequat semper. Ac tortor vitae purus faucibus ornare suspendisse sed nisi. Est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus. Senectus et netus et malesuada fames ac turpis egestas integer. Porttitor rhoncus dolor purus non. Urna cursus eget nunc scelerisque viverra mauris in aliquam sem. Erat imperdiet sed euismod nisi porta. Interdum velit euismod in pellentesque massa placerat duis. Massa tincidunt dui ut ornare lectus sit amet est. Accumsan lacus vel facilisis volutpat est velit egestas dui id. Nunc aliquet bibendum enim facilisis. Penatibus et magnis dis parturient montes nascetur ridiculus. A cras semper auctor neque vitae. Mattis pellentesque id nibh tortor id aliquet.', '2020-01-03'),
(6, 'test', 'Nulla facilisi cras fermentum', 'At augue eget arcu dictum varius duis. Ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. At augue eget arcu dictum varius duis. Ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi. Pharetra diam sit amet nisl. Id volutpat lacus laoreet non curabitur gravida. Et netus et malesuada fames ac. Sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra. Id nibh tortor id aliquet lectus. Et netus et malesuada fames ac. Habitant morbi tristique senectus et netus et malesuada. Rhoncus est pellentesque elit ullamcorper. Tincidunt augue interdum velit euismod in. Facilisi morbi tempus iaculis urna. Tempor orci eu lobortis elementum nibh. Viverra accumsan in nisl nisi scelerisque eu ultrices vitae auctor. Nulla facilisi cras fermentum odio eu feugiat. Eget sit amet tellus cras.', '2020-01-03');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08'),
(2, 'test2', '259201780764eda880b73becb40c17039ecbec2fcee43ecbbb610b63a0dde56d');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
