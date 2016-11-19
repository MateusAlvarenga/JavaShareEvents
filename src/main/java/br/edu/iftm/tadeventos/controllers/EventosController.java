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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;

public class EventosController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EventosController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            Evento evento = new Evento();

            evento.setTitulo(request.getParameter("titulo"));
            evento.setCidade(request.getParameter("cidade"));
            evento.setEstado(request.getParameter("estado"));
            evento.setPais(request.getParameter("pais"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setDatafim(request.getParameter("datafim"));
            evento.setDatainicio(request.getParameter("datainicio"));
            evento.setEndereco(request.getParameter("endereco"));
            evento.setCount_entradas(getIntValue(request, "count_entradas", 100));
            evento.setPreco_entrada(getDoubleValue(request, "preco_entrada", 20.00));
            evento.setAnfitriao(request.getParameter("anfitriao"));

            eventoDAO.AddEvento(evento);
            factory.fecharConexao();
            redirect(request, response, "/");
        } catch (SQLException ex) {
            Logger.getLogger(EventosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        redirect(request, response, "/views/publicar_evento.jsp");
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

}
