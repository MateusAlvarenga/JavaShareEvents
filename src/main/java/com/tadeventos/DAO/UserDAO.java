
package com.tadeventos.DAO;

import com.iftm.tadeventos.model.Evento;
import com.iftm.tadeventos.model.User;
 


public interface UserDAO {
        
   public void AddUser(User user);    
   public User GetUser(String username);   
   public User GetUser(Long username);   
    
    
}
