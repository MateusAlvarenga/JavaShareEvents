package br.edu.iftm.tadeventos.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.iftm.tadeventos.util.Authenticator;
import br.edu.iftm.tadeventos.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd;

        Authenticator authenticator = new Authenticator();
        String result = authenticator.authenticate(username, password);
        
        if (result.equals("success")) {
            rd = request.getRequestDispatcher("/");
            User user = new User(username, password);
            request.getSession().setAttribute("username", user.getUsername());
            request.setAttribute("username", user);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        
        rd.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
        redirect(request, response, "/");
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
