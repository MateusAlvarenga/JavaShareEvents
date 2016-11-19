package com.iftm.tadeventos.model;

import br.edu.iftm.upt.ads.daw2.contatossimples.modelo.dao.DAOFactory;
import com.tadeventos.DAO.UserDAO;
import com.tadeventos.DAO.UserDAOImp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author mateus
 */
public class Authenticator {
 
	public String authenticate(String username, String password)  {
           String response = "failure";
            try {
                DAOFactory factory = new DAOFactory();
                factory.abrirConexao();
                UserDAOImp userdao = factory.criarUserDAO();
                User user = userdao.GetUser(username);
                factory.fecharConexao();                
                StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                
                if(user != null)
                    if(user.getUsername().equals(username) && passwordEncryptor.checkPassword(password, user.getPassword()))
                        response = "success";
                
                
               
            } catch (SQLException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
             return response;
	}
}