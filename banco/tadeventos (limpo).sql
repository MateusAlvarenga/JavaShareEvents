create database TADeventos;
use TADeventos; 
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tadeventos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carteira`
--

DROP TABLE IF EXISTS `carteira`;
CREATE TABLE IF NOT EXISTS `carteira` (
  `proprietario` int(11) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE IF NOT EXISTS `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `evento_idevento` int(11) NOT NULL DEFAULT '0',
  `numero_cartao` varchar(45) DEFAULT NULL,
  `bandeira` varchar(45) DEFAULT NULL,
  `data_vencimento` varchar(45) DEFAULT NULL,
  `digito_validador` varchar(45) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `valorTotal` double DEFAULT NULL,
  `qtd` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_evento1_idx` (`evento_idevento`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `idevento` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  `Descricao` mediumtext,
  `datafim` timestamp NULL DEFAULT NULL,
  `datainicio` timestamp NULL DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `count_entradas` bigint(20) DEFAULT NULL,
  `preco_entrada` double DEFAULT NULL,
  `anfitriao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idevento`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento_has_categoria`
--

DROP TABLE IF EXISTS `evento_has_categoria`;
CREATE TABLE IF NOT EXISTS `evento_has_categoria` (
  `evento_idevento` int(11) NOT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`evento_idevento`,`Categoria_idCategoria`),
  KEY `fk_evento_has_Categoria_Categoria1_idx` (`Categoria_idCategoria`),
  KEY `fk_evento_has_Categoria_evento1_idx` (`evento_idevento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_has_evento`
--

DROP TABLE IF EXISTS `user_has_evento`;
CREATE TABLE IF NOT EXISTS `user_has_evento` (
  `user_id` int(11) DEFAULT NULL,
  `evento_idevento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_Compra_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `evento_has_categoria`
--
ALTER TABLE `evento_has_categoria`
  ADD CONSTRAINT `fk_evento_has_Categoria_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_evento_has_Categoria_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
