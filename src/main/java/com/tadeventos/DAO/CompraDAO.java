
package com.tadeventos.DAO;


import com.iftm.tadeventos.model.Compra;
import java.util.List;


public interface CompraDAO {

  public void AddCompra(Compra compra); 
  public List Busca(String str);


}
