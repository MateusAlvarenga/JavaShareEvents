package junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.iftm.tadeventos.DAO.ConexaoFactory;
import br.edu.iftm.tadeventos.DAO.DAOFactory;
import br.edu.iftm.tadeventos.util.Authenticator;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author informatica
 */
public class AutheticateTest {

    public AutheticateTest() {
    }

    @Before
    public void setup() throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        Connection conexao = ConexaoFactory.getConexao();
        
        String remocao = "DELETE FROM `tadeventos`.`user` WHERE username = 'admin'";
        
        Statement stmt = (Statement) conexao.createStatement();
        stmt.executeUpdate(remocao);

        String insercao = "INSERT INTO `tadeventos`.`user` (username, password) "
                + "VALUES ('admin', 'H+GjJE2mjtfTe+eeoUjkfn2dLRG1QCs48hCjnLiSoZQQsdurVLZc/I33BvXw0QRe')";

        stmt = (Statement) conexao.createStatement();
        stmt.executeUpdate(insercao);
    }

    @Test
    public void Test_CorrectUser() {
        String login_teste = "admin";
        String pass_teste = "123456";

        Authenticator authenticator = new Authenticator();
        String response = authenticator.authenticate(login_teste, pass_teste);
        Assert.assertEquals("success", response);
    }

    @Test
    public void Test_WrongUser() {
        String login_teste = "haudskembrithkestrobilobaldofhacasFaustaoskbatman##d";
        String pass_teste = "aieulAminoacidosfjsdlkasd@@alfafaljslidjfaklmseleniumcasdça";

        Authenticator authenticator = new Authenticator();
        String response = authenticator.authenticate(login_teste, pass_teste);
        Assert.assertEquals("failure", response);
    }

}
