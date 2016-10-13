package com.tadeventos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mat
 */
@Controller 
public class HomeController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
    
   @RequestMapping(value = {"/PublicarEvento"}, method = RequestMethod.GET)
    public String PublicarEvento(Model model) {
        return "publicar_evento";
    }
    
}
