package com.tadeventos.web;

import br.edu.iftm.upt.ads.daw2.contatossimples.modelo.dao.DAOFactory;
import com.tadeventos.DAO.CompraDAOImp;
import com.tadeventos.DAO.EventoDAOImp;
import com.tadeventos.model.Compra;
import com.tadeventos.model.Evento;
import com.tadeventos.service.QueryService;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CompraController {

    EventoDAOImp eventoDAO;

    @RequestMapping(value = {"/Compra"})
    public ModelAndView IniciarCompra(@RequestParam("idevento") String idevento) throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        eventoDAO = factory.criarEventoDAO();
        Evento evento = eventoDAO.GetEvento(Long.valueOf(idevento));

        return new ModelAndView("compra", "ObjEvento", evento);
    }

    
    //qtd=1&preco_entrada=12.9&valor_total=12.9&idevento=16
//&user=%3%&card_type=Visa&card_number=2131+2312+3131+2313&digito_verificador=132&expiration=12%2F3123
    
    
    @RequestMapping(value = {"/EfetivarCompra"}) public String 
        ValidaCompra(@RequestParam("idevento") int idevento, @RequestParam("user") String user ,
                    @RequestParam("card_type") String card_type, @RequestParam("card_number") String card_number ,
                    @RequestParam("digito_verificador") String digito_verificador, @RequestParam("expiration") String data_epiracao ,
                    @RequestParam("qtd") int qtd, @RequestParam("preco_entrada") Double preco_entrada , @RequestParam("valor_total") Double valor_total
                    ,ModelMap model)
                    throws SQLException {
            
         Compra nova_compra = new Compra();
         nova_compra.setEvento_idevento(idevento);
         nova_compra.setUser(user);
         nova_compra.setValorTotal(valor_total);
         nova_compra.setNumero_cartao(card_number);
         nova_compra.setValorTotal(valor_total);
         nova_compra.setBandeira(card_type);
         nova_compra.setData_vencimento(data_epiracao);
         nova_compra.setDigito_validador(digito_verificador);
         
  
         
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();      
        CompraDAOImp compraDao = factory.criarCompraDAO();
        compraDao.AddCompra(nova_compra);        
        
       
         model.addAttribute("qtd", qtd);
         model.addAttribute("idevento", idevento);
    
        
        return "redirect:/Confirmacao";
    }

    @RequestMapping(value = {"/Confirmacao"})
    public ModelAndView Confirmaccao(@RequestParam("idevento") String idevento, @RequestParam("qtd") int qtd, ModelMap model) throws SQLException {
        
         QueryService qs = new QueryService();
         qs.addString("idevento", String.valueOf(idevento));
        
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();        
        EventoDAOImp eventoDao = factory.criarEventoDAO();
        Evento evento = (Evento) eventoDao.Busca(qs.getWhere()).get(0);
        model.addAttribute("evento", evento);
        model.addAttribute("qtd",qtd);
        return new ModelAndView("gerarEntradas", (Map<String, ?>) model);
    }

}
