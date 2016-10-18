 
package com.tadeventos.DAO;

import com.tadeventos.model.Evento;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDAO {
    
   public void AddEvento(Evento evento);
   public void DeleteEvento(Long idevento);
   public void EditEvento(Evento evento);
   public Evento GetEvento(Long idevento);
   public List GetAllEventos();
    
}
