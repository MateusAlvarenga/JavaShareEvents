package com.tadeventos.web;

import br.edu.iftm.upt.ads.daw2.contatossimples.modelo.dao.DAOFactory;
import com.tadeventos.DAO.EventoDAOImp;
import com.tadeventos.model.Evento;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventosController {

    EventoDAOImp eventoDAO;

    @RequestMapping(value = {"/GravarEvento"}, method = RequestMethod.POST)
    public String GravarEvento(@ModelAttribute Evento evento) throws SQLException {
        System.out.println("MMMMM" + evento + "MMMMM");
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

}
