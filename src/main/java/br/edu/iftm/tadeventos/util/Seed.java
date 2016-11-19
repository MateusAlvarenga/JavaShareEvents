package br.edu.iftm.tadeventos.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Seed {

    private Connection conexao = null;

    public Seed(Connection conexao) {
        this.conexao = conexao;
    }

    private void run(String create) throws SQLException {
        try (Statement stmt = conexao.createStatement()) {
            int resultado = stmt.executeUpdate(create);
        }
    }

    @Deprecated
    public void criaTabelas() throws SQLException {

        System.out.println("Criando tabelas do banco...");
        run("CREATE TABLE `Categoria` (\n"
                + "  `idCategoria` int(11) NOT NULL,\n"
                + "  `Categoria` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idCategoria`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `Compra` (\n"
                + "  `idCompra` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `evento_idevento` int(11) NOT NULL DEFAULT '0',\n"
                + "  `numero_cartao` varchar(45) DEFAULT NULL,\n"
                + "  `bandeira` varchar(45) DEFAULT NULL,\n"
                + "  `data_vencimento` varchar(45) DEFAULT NULL,\n"
                + "  `digito_validador` varchar(45) DEFAULT NULL,\n"
                + "  `user` varchar(45) DEFAULT NULL,\n"
                + "  `valorTotal` double DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idCompra`),\n"
                + "  KEY `fk_Compra_evento1_idx` (`evento_idevento`),\n"
                + "  CONSTRAINT `fk_Compra_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `evento` (\n"
                + "  `idevento` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `titulo` varchar(45) NOT NULL,\n"
                + "  `cidade` varchar(45) DEFAULT NULL,\n"
                + "  `estado` varchar(20) DEFAULT NULL,\n"
                + "  `Pais` varchar(45) DEFAULT NULL,\n"
                + "  `Descricao` mediumtext,\n"
                + "  `datafim` timestamp NULL DEFAULT NULL,\n"
                + "  `datainicio` timestamp NULL DEFAULT NULL,\n"
                + "  `endereco` varchar(60) DEFAULT NULL,\n"
                + "  `count_entradas` bigint(20) DEFAULT NULL,\n"
                + "  `preco_entrada` double DEFAULT NULL,\n"
                + "  `anfitriao` varchar(100) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idevento`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `evento_has_Categoria` (\n"
                + "  `evento_idevento` int(11) NOT NULL,\n"
                + "  `Categoria_idCategoria` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`evento_idevento`,`Categoria_idCategoria`),\n"
                + "  KEY `fk_evento_has_Categoria_Categoria1_idx` (`Categoria_idCategoria`),\n"
                + "  KEY `fk_evento_has_Categoria_evento1_idx` (`evento_idevento`),\n"
                + "  CONSTRAINT `fk_evento_has_Categoria_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `Categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_evento_has_Categoria_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `role` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `user` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `username` varchar(255) NOT NULL,\n"
                + "  `password` varchar(255) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`,`username`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `user_has_evento` (\n"
                + "  `user_id` int(11) DEFAULT NULL,\n"
                + "  `evento_idevento` int(11) DEFAULT NULL\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        run("CREATE TABLE `user_role` (\n"
                + "  `user_id` int(11) NOT NULL,\n"
                + "  `role_id` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`user_id`,`role_id`),\n"
                + "  KEY `fk_user_role_roleid_idx` (`role_id`),\n"
                + "  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + "  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

    }

    public void inserirDadosIniciais() throws SQLException {
        run("INSERT INTO `role` VALUES (1,'ROLE_USER');");
        run("INSERT INTO `user` VALUES (11,'josue123','12345678'),(12,'12106672667','12345678');");
        run("INSERT INTO `user_role` VALUES (11,1),(12,1);");
    }

}
