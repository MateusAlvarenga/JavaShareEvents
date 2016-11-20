package br.edu.iftm.tadeventos.controllers;

import br.edu.iftm.tadeventos.DAO.DAOFactory;
import br.edu.iftm.tadeventos.model.Evento;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.iftm.tadeventos.DAO.EventoDAO;
import br.edu.iftm.tadeventos.DAO.UserDAO;
import br.edu.iftm.tadeventos.model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

public class EventosController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EventosController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();

        switch (caminho) {
            case "/eventos/publicar":
                postCadastrar(request, response);
                break;
            case "/eventos/editar":
                postEditar(request, response);
                break;
            default:
                System.out.println("404");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String caminho = request.getServletPath();

        switch (caminho) {
            case "/eventos/publicar":
                getCadastrar(request, response);
                break;
            case "/eventos/editar":
                getEditar(request, response);
                break;
            case "/eventos/remover":
                remover(request, response);
                break;
            default:
                System.out.println("404");
        }
    }

    public void getCadastrar(HttpServletRequest request, HttpServletResponse response) {
        redirect(request, response, "/views/publicarEvento.jsp");
    }

    public void postCadastrar(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            UserDAO userDAO = factory.criarUserDAO();
            Evento evento = new Evento();
            User user = userDAO.buscar(session.getAttribute("username").toString());

            evento.setTitulo(request.getParameter("titulo"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setDataFim(request.getParameter("datafim"));
            evento.setDataInicio(request.getParameter("datainicio"));
            evento.setEndereco(request.getParameter("endereco"));
            evento.setPrecoEntrada(getDoubleValue(request, "preco_entrada", 0.0));
            evento.setAnfitriao(user);
            evento.addParticipantes();

            eventoDAO.add(evento);
            factory.fecharConexao();
            response.sendRedirect(request.getContextPath() + "/busca/minhas-publicacoes");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            Evento evento = eventoDAO.buscar(getLongValue(request, "idevento", 0));
            factory.fecharConexao();

            request.setAttribute("evento", evento);
            redirect(request, response, "/views/editarEvento.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            Evento evento = eventoDAO.buscar(getLongValue(request, "idevento", 0));
            UserDAO userDAO = factory.criarUserDAO();
            User user = userDAO.buscar(session.getAttribute("username").toString());

            System.out.println("Removendo evento...");
            if (!evento.getAnfitriao().getId().equals(user.getId())) {
                System.out.println("Acesso negado");
                redirect(request, response, "/error.jsp");
                return;
            }

            eventoDAO.remover(evento);
            factory.fecharConexao();
            response.sendRedirect(request.getContextPath() + "/busca/minhas-publicacoes");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void postEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            Evento evento = eventoDAO.buscar(getLongValue(request, "idevento", 0));
            UserDAO userDAO = factory.criarUserDAO();
            User user = userDAO.buscar(session.getAttribute("username").toString());

            if (!evento.getAnfitriao().getId().equals(user.getId())) {
                redirect(request, response, "/error.jsp");
                return;
            }

            evento.setTitulo(request.getParameter("titulo"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setDataFim(request.getParameter("datafim"));
            evento.setDataInicio(request.getParameter("datainicio"));
            evento.setEndereco(request.getParameter("endereco"));
            evento.setPrecoEntrada(getDoubleValue(request, "preco_entrada", 0.0));

            eventoDAO.atualizar(evento);
            factory.fecharConexao();
            response.sendRedirect(request.getContextPath() + "/busca/minhas-publicacoes");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double getDoubleValue(ServletRequest request, String paramName, double defaultValue) {
        if (request.getParameter(paramName) != null) {
            return Double.valueOf(request.getParameter(paramName));
        } else {
            return defaultValue;
        }
    }

    public static int getIntValue(ServletRequest request, String paramName, int defaultValue) {
        if (request.getParameter(paramName) != null) {
            return Integer.valueOf(request.getParameter(paramName));
        } else {
            return defaultValue;
        }
    }

    public static Long getLongValue(ServletRequest request, String paramName, long defaultValue) {
        if (request.getParameter(paramName) != null) {
            return Long.valueOf(request.getParameter(paramName));
        } else {
            return defaultValue;
        }
    }

}
