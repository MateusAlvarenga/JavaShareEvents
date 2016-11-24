package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.edu.iftm.tadeventos.DAO.*;
import br.edu.iftm.tadeventos.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.testng.annotations.*;

public class DaoTest {

    private final UserDAO userDao;
    private final EventoDAO eventoDao;
    private final CompraDAO compraDao;
    private User user;
    private Evento evento;
    private Compra compra;
    String nomeuserTeste = "rose";

    public DaoTest() throws SQLException {
        DAOFactory df = new DAOFactory();
        df.abrirConexao();
        userDao = df.criarUserDAO();
        eventoDao = df.criarEventoDAO();
        compraDao = df.criarCompraDAO();
    }

    @BeforeClass
    public static void setup() throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        Connection conexao = ConexaoFactory.getConexao();

        String remocao = "DELETE FROM `tadeventos`.`user` WHERE username = 'rose'";

        Statement stmt = (Statement) conexao.createStatement();
        stmt.executeUpdate(remocao);
    }

    @Test
    public void test() {
        user = new User(nomeuserTeste, "123456");
        userDao.add(user);
        user = userDao.buscar(nomeuserTeste);
        assertNotEquals(null, nomeuserTeste);

        evento = new Evento(user, "EventoDAOTest", "EventoDAOTest", "EventoDAOTest", "EventoDAOTest", "Uberaba", 100.0, 100);
        eventoDao.add(evento);
        evento = (Evento) eventoDao.buscarTodos(user).get(0);
        assertNotEquals(null, eventoDao.buscarTodos(user));

        compra = new Compra(evento, user, 100, 500.00);
        compra.addQuantidade();
        compra.addQuantidade();
        compraDao.add(compra);

        assertNotEquals(null, compraDao.buscar(user, evento));

    }

}
