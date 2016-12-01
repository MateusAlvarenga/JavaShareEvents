-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tadeventos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tadeventos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tadeventos` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema accounts
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema accounts
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `accounts` ;
USE `tadeventos` ;

-- -----------------------------------------------------
-- Table `tadeventos`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadeventos`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tadeventos`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadeventos`.`evento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `descricao` MEDIUMTEXT NULL DEFAULT NULL,
  `datafim` VARCHAR(20) NULL DEFAULT NULL,
  `datainicio` VARCHAR(20) NULL DEFAULT NULL,
  `endereco` VARCHAR(500) NULL DEFAULT NULL,
  `participantes` INT(11) NULL DEFAULT NULL,
  `preco_entrada` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_evento_user1_idx` (`id_user` ASC),
  CONSTRAINT `fk_evento_user1`
    FOREIGN KEY (`id_user`)
    REFERENCES `tadeventos`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tadeventos`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadeventos`.`compra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_evento` INT(11) NOT NULL DEFAULT '0',
  `id_user` INT(11) NOT NULL,
  `quantidade` INT(11) NULL DEFAULT 0,
  `total` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_Compra_evento1_idx` (`id_evento` ASC),
  INDEX `fk_compra_user1_idx` (`id_user` ASC),
  CONSTRAINT `fk_Compra_evento1`
    FOREIGN KEY (`id_evento`)
    REFERENCES `tadeventos`.`evento` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_compra_user1`
    FOREIGN KEY (`id_user`)
    REFERENCES `tadeventos`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

USE `accounts` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
