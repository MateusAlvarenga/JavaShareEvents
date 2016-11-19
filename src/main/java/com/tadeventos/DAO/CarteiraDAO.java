package com.tadeventos.DAO;

import com.iftm.tadeventos.model.Carteira;
import java.util.List;

public interface CarteiraDAO {
    
     public void AddCarteira(Carteira compra); 
     public List Busca(String str);
     public Carteira getCarteira(Long proprietario);
     public void AtualizaSaldo(Carteira carteira);
}
