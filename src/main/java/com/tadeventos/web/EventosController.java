package com.tadeventos.web;

import br.edu.iftm.upt.ads.daw2.contatossimples.modelo.dao.DAOFactory;
import com.tadeventos.DAO.EventoDAOImp;
import com.tadeventos.model.Evento;
import com.tadeventos.service.QueryService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"userPrincipal"})
@Controller
public class EventosController {

    @Autowired
    private UserDetailsService userDetailsService;

    EventoDAOImp eventoDAO;

    @RequestMapping(value = {"/GravarEvento"}, method = RequestMethod.POST)
    public String GravarEvento(@ModelAttribute Evento evento) throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        eventoDAO = factory.criarEventoDAO();
        eventoDAO.AddEvento(evento);
        factory.fecharConexao();
        return "redirect:/";
    }

    @RequestMapping(value = "/PublicarEvento", method = RequestMethod.GET)
    public String registration(ModelMap model) {

        model.put("eventoForm", new Evento());
        return "publicar_evento";

    }



   @RequestMapping(value = {"/Eventos","/MeusEventos"})
    public ModelAndView BuscarEventos(@RequestParam("coluna") String coluna, @RequestParam("valor") String valor/* ModelMap model*/) throws SQLException {
        QueryService qs = new QueryService();
        qs.addString(coluna, valor);
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        eventoDAO = factory.criarEventoDAO();
        List<Evento> filteredEventList = eventoDAO.Busca(qs.getWhere());

        return new ModelAndView("MostraEventos", "filteredEventList", filteredEventList );
    }

    @RequestMapping(value = {"/Detalhes","/ComprarEvento"})
    public ModelAndView MostraEvento(@RequestParam("idevento") String idevento) throws SQLException{
      DAOFactory factory = new DAOFactory();
      factory.abrirConexao();
      eventoDAO = factory.criarEventoDAO();
      Evento evento = eventoDAO.GetEvento(Long.valueOf(idevento));

      return new ModelAndView("viewEvento", "ObjEvento", evento );
    }


    @RequestMapping(value = "/DeleteEvento")
    public String DeleteEvento(@RequestParam("u") String id) {
        return "home";
    }
}
