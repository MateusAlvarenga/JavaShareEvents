 
package com.tadeventos.DAO;

 

import com.iftm.tadeventos.model.Evento;
import java.sql.SQLException;
import java.util.List;
 

 
public interface EventoDAO {
    
   public void AddEvento(Evento evento);
   public void DeleteEvento(Long idevento) throws SQLException;
   public void EditEvento(Evento evento) ;
   public Evento GetEvento(Long idevento);
   public List GetAllEventos();
   public List Busca(String str);
    
}
