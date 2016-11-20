package br.edu.iftm.tadeventos.controllers;

import br.edu.iftm.tadeventos.DAO.DAOFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.iftm.tadeventos.model.User;
import br.edu.iftm.tadeventos.DAO.UserDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class RegistrationController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher rd = null;

            String username = request.getParameter("username");
            String password = request.getParameter("pass");
            String pass_confirm = request.getParameter("pass-confirm");
            
            DAOFactory daof = new DAOFactory();
            daof.abrirConexao();
            UserDAO userDao = daof.criarUserDAO();

            if (userDao.buscar(username) == null && password.equals(pass_confirm)) {
                User user = new User(username, password);
                StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
                user.setPassword(encryptedPassword);
                userDao.add(user);
                user = userDao.buscar(username);

                request.getSession().setAttribute("username", user.getUsername());
                request.setAttribute("username", user);
                redirect(request, response, "/");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        redirect(request, response, "/error.jsp");
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
