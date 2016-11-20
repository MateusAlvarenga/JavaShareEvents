package br.edu.iftm.tadeventos.util;

import br.edu.iftm.tadeventos.DAO.DAOFactory;
import br.edu.iftm.tadeventos.model.User;
import br.edu.iftm.tadeventos.DAO.UserDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author mateus
 */
public class Authenticator {

    public String authenticate(String username, String password) {
        String response = "failure";
        
        try {
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            UserDAO userdao = factory.criarUserDAO();
            User user = userdao.buscar(username);
            factory.fecharConexao();
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            
            if (user != null) {
                if (user.getUsername().equals(username) && passwordEncryptor.checkPassword(password, user.getPassword())) {
                    response = "success";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
}
