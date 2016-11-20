package br.edu.iftm.tadeventos.controllers;

import br.edu.iftm.tadeventos.DAO.DAOFactory;
import br.edu.iftm.tadeventos.model.Compra;
import br.edu.iftm.tadeventos.model.Evento;
import br.edu.iftm.tadeventos.model.User;
import br.edu.iftm.tadeventos.DAO.CompraDAO;
import br.edu.iftm.tadeventos.DAO.EventoDAO;
import br.edu.iftm.tadeventos.DAO.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

public class BuscaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BuscaController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String caminho = request.getServletPath();

        try {
            switch (caminho) {
                case "/busca/evento":
                    busca(request, response);
                    break;
                case "/busca/detalhes":
                    detalhes(request, response);
                    break;
                case "/busca/compra":
                    comprar(request, response);
                    break;
                case "/busca/minhas-compras":
                    minhasCompras(request, response);
                    break;
                case "/busca/minhas-publicacoes":
                    minhasPublicacoes(request, response);
                    break;
                default:
                    System.out.println("404");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busca(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cidade = request.getParameter("cidade");
        
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        EventoDAO eventoDAO = factory.criarEventoDAO();
        List<Evento> filteredEventList = eventoDAO.buscarTodos(cidade);
        
        request.setAttribute("filteredEventList", filteredEventList);
        redirect(request, response, "/views/eventos.jsp");
    }

    public void detalhes(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        EventoDAO eventoDAO = factory.criarEventoDAO();
        String idevento = request.getParameter("idevento");
        Evento evento = eventoDAO.buscar(Long.valueOf(idevento));
        
        request.setAttribute("ObjEvento", evento);
        redirect(request, response, "/views/detalhesEvento.jsp");
    }

    public void comprar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            redirect(request, response, "/views/login.jsp");
        }

        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        UserDAO userDAO = factory.criarUserDAO();
        EventoDAO eventoDAO = factory.criarEventoDAO();
        CompraDAO compraDAO = factory.criarCompraDAO();

        User user = userDAO.buscar(session.getAttribute("username").toString());
        Evento evento = eventoDAO.buscar(Long.parseLong(request.getParameter("idevento")));
        Compra compra = compraDAO.buscar(user, evento);

        if (compra == null) {
            compra = new Compra();
            compra.setEvento(evento);
            compra.setUser(user);
            compra.setQuantidade(1);
            compra.setTotal(evento.getPrecoEntrada());            
            compraDAO.add(compra);
        } else {
            compra.addQuantidade();
            compraDAO.atualizar(compra);
        }

        request.setAttribute("message", "Compra efetuada com sucesso!");
        redirect(request, response, "/busca/detalhes?idevento=" + request.getParameter("idevento"));
    }

    private void minhasCompras(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        DAOFactory df = new DAOFactory();
        df.abrirConexao();
        CompraDAO compraDao = df.criarCompraDAO();
        UserDAO userDAO = df.criarUserDAO();
        User user = userDAO.buscar(session.getAttribute("username").toString());
        
        if (user == null) {
            redirect(request, response, "/");
            return;
        }
        
        List<Compra> compras = compraDao.buscarTodos(user);
        System.out.println(compras);

        request.setAttribute("compras", compras);
        redirect(request, response, "/views/minhasCompras.jsp");
    }

    private void minhasPublicacoes(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        DAOFactory df = new DAOFactory();
        df.abrirConexao();
        EventoDAO eventoDAO = df.criarEventoDAO();
        UserDAO userDAO = df.criarUserDAO();
        User user = userDAO.buscar(session.getAttribute("username").toString());

        if (user == null) {
            redirect(request, response, "/");
            return;
        }
        
        List<Evento> eventos = eventoDAO.buscarTodos(user);

        request.setAttribute("eventos", eventos);
        redirect(request, response, "/views/minhasPublicacoes.jsp");
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
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

}
