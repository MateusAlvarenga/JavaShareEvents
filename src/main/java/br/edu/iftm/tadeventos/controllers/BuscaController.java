package br.edu.iftm.tadeventos.controllers;

import br.edu.iftm.tadeventos.DAO.DAOFactory;
import br.edu.iftm.tadeventos.model.Carteira;
import br.edu.iftm.tadeventos.model.Compra;
import br.edu.iftm.tadeventos.model.Evento;
import br.edu.iftm.tadeventos.model.User;
import br.edu.iftm.tadeventos.util.QueryService;
import br.edu.iftm.tadeventos.DAO.CarteiraDAO;
import br.edu.iftm.tadeventos.DAO.CompraDAO;
import br.edu.iftm.tadeventos.DAO.CompraDAO;
import br.edu.iftm.tadeventos.DAO.EventoDAO;
import br.edu.iftm.tadeventos.DAO.EventoDAO;
import br.edu.iftm.tadeventos.DAO.UserDAO;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action.equals("busca")) {
            Busca(request, response);
            return;
        }
        
        if (action.equals("detalhes")) {
            try {
                Detalhes(request, response);
            } catch (Exception e) {
            }
            return;
        }
        
        if (action.equals("compra")) {
            try {
                Comprar(request, response);
            } catch (SQLException ex) {
            }
            return;
        }
        
        if (action.equals("efetivar_compra")) {
            try {
                Efetivar_Comprar(request, response);
            } catch (SQLException ex) {
            }
            return;
        }
        
        if (action.equals("minhasCompras")) {
            try {
                MinhasCompras(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (action.equals("confirmacao")) {
            try {
                Confirmacao(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (action.equals("minhasvendas")) {
            try {
                MinhasVendas(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Busca(HttpServletRequest request, HttpServletResponse response) {
        try {
            String coluna = request.getParameter("coluna");
            String valor = request.getParameter("valor");
            QueryService qs = new QueryService();
            qs.addString(coluna, valor);
            DAOFactory factory = new DAOFactory();
            factory.abrirConexao();
            EventoDAO eventoDAO = factory.criarEventoDAO();
            List<Evento> filteredEventList = eventoDAO.Busca(qs.getWhere());
            request.setAttribute("filteredEventList", filteredEventList);

            redirect(request, response, "/views/MostraEventos.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Detalhes(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        EventoDAO eventoDAO = factory.criarEventoDAO();
        String idevento = request.getParameter("idevento");
        Evento evento = eventoDAO.GetEvento(Long.valueOf(idevento));
        List<User> presentes = eventoDAO.getPresentes(idevento);
        request.setAttribute("ObjEvento", evento);
        request.setAttribute("presentes", presentes);

        redirect(request, response, "/views/viewEvento.jsp");
    }

    public void Comprar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            redirect(request, response, "/views/login.jsp");
            return;
        }

        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        EventoDAO eventoDAO = factory.criarEventoDAO();
        String idevento = request.getParameter("idevento");
        Evento evento = eventoDAO.GetEvento(Long.valueOf(idevento));
        request.setAttribute("ObjEvento", evento);

        redirect(request, response, "/views/compra.jsp");
    }

    public void Efetivar_Comprar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Double valortotal = getDoubleValue(request, "valor_total", serialVersionUID);

        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        UserDAO userDAO = factory.criarUserDAO();
        User user = userDAO.GetUser(request.getParameter("user"));
        EventoDAO eventoDAO = factory.criarEventoDAO();
        Evento evento = eventoDAO.GetEvento(Long.valueOf(request.getParameter("idevento")));
        CarteiraDAO carteiraDAO = factory.criarCarteiraDAO();
        Carteira carteira = carteiraDAO.getCarteira(userDAO.GetUser(evento.getAnfitriao()).getId());
        carteira.atualizaSaldo(valortotal);
        carteiraDAO.AtualizaSaldo(carteira);

        System.out.println(user);
        Compra nova_compra = new Compra();
        nova_compra.setEvento_idevento(getIntValue(request, "idevento", 1));
        nova_compra.setUser(user.getId().toString());
        nova_compra.setValorTotal(getDoubleValue(request, "valor_total", serialVersionUID));
        nova_compra.setNumero_cartao(request.getParameter("card_number"));
        nova_compra.setBandeira(request.getParameter("card_type"));
        nova_compra.setData_vencimento(request.getParameter("expiration"));
        nova_compra.setDigito_validador(request.getParameter("digito_verificador"));
        nova_compra.setQtd(Integer.valueOf(request.getParameter("qtd")));

        CompraDAO compraDao = factory.criarCompraDAO();
        compraDao.AddCompra(nova_compra);
        request.setAttribute("qtd", request.getParameter("qtd"));
        request.setAttribute("idevento", request.getParameter("idevento"));
        //redirect(request, response, "/views/compra.jsp");

        Confirmacao(request, response);

        //return "redirect:/Confirmacao";
    }

    public void Confirmacao(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        QueryService qs = new QueryService();
        String idevento = request.getParameter("idevento");
        qs.addString("idevento", String.valueOf(idevento));

        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        EventoDAO eventoDao = factory.criarEventoDAO();
        Evento evento = (Evento) eventoDao.Busca(qs.getWhere()).get(0);
        request.setAttribute("qtd", request.getParameter("qtd"));
        request.setAttribute("evento", evento);

        redirect(request, response, "/views/gerarEntradas.jsp");
        //return new ModelAndView("gerarEntradas", (Map<String, ?>) model);
    }

    private void MinhasCompras(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOFactory df = new DAOFactory();
        df.abrirConexao();
        CompraDAO compraDao = df.criarCompraDAO();
        UserDAO userdao = df.criarUserDAO();
        User user = userdao.GetUser(request.getParameter("user"));
        QueryService qs = new QueryService();
        
        if (user == null) {
            redirect(request, response, "/");
            return;
        }
        
        qs.addString("user", user.getId().toString());
        List<Compra> compras = compraDao.Busca(qs.getWhere());

        request.setAttribute("compras", compras);
        redirect(request, response, "/views/minhasCompras.jsp");
    }

    private void MinhasVendas(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String user_name = request.getParameter("user");
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        UserDAO userDAO = factory.criarUserDAO();
        CarteiraDAO carteiraDAO = factory.criarCarteiraDAO();

        User user = userDAO.GetUser(user_name);
        Carteira carteira = carteiraDAO.getCarteira(user.getId());

        request.setAttribute("carteira", carteira);
        redirect(request, response, "/views/carteira.jsp");
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
