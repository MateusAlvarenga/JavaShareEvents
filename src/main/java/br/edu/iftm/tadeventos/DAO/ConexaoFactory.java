package br.edu.iftm.tadeventos.DAO;

import br.edu.iftm.tadeventos.util.Seed;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private ConexaoFactory() {
    }

    public static Connection getConexao() throws SQLException {
        return getConexaoNormal();
    }

    private static Connection getConexaoNormal() throws SQLException {

        String caminho = "jdbc:mysql";
        String host = "localhost";
        String porta = "3306";
        String bd = "TADeventos";
        String login = "root"; //mat
        String senha = "123456";
        String url = caminho + "://" + host + ":" + porta + "/" + bd;

        Connection conexao = null;
        try {
            System.out.println("Conectando com o banco de dados.");
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        }
        return conexao;
    }

    private static Connection getConexaoH2() throws SQLException {
        String bd = "TADeventos";
        String url = "jdbc:h2:~/test" + bd;
        String login = "sa"; //mat
        String senha = "";
        boolean criarBD = false;
        Connection conexao = null;

        try {
            Class.forName("org.h2.Driver");

            File arquivoBD = new File(System.getProperty("user.dir") 
                    + System.getProperty("file.separator") + bd + ".mv.db");
            
            if (!arquivoBD.exists()) {  // O arquivo do BD ainda não existe. 

                System.out.println("O arquivo do BD ainda não existe");
                criarBD = true;
            }
            
            System.out.println("flag 3");
            conexao = DriverManager.getConnection(url, login, senha);

            if (criarBD) {  //Cria as tabelas e insere os dados iniciais no BD.

                System.out.println("O banco de dados da aplicação não existe.");
                Seed seed = new Seed(conexao);
                seed.criaTabelas();
                seed.inserirDadosIniciais();

                System.out.println("Banco de dados criado: " + bd + ".mv.db");
            }
            
            System.out.println("Banco de dados utilizado: " + bd + ".mv.db");
        } catch (SQLException e) {
            System.out.println("Não foi possível estabelecer a conexão com o banco selecionado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível carregar o driver JDBC do BD.");
        }

        return conexao;
    }
    
}