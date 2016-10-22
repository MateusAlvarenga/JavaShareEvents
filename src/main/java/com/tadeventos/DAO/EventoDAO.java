 
package com.tadeventos.DAO;

import com.tadeventos.model.Evento;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDAO {
    
   public void AddEvento(Evento evento);
   public void DeleteEvento(Long idevento) throws SQLException;
   public void EditEvento(Evento evento) ;
   public Evento GetEvento(Long idevento);
   public List GetAllEventos();
   public List Busca(String str);
    
}
