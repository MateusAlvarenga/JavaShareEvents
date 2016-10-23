
package com.tadeventos.DAO;

import com.tadeventos.model.Compra;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraDAO {

  public void AddCompra(Compra compra); 
  public List Busca(String str);

}
