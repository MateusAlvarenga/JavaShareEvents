
package com.tadeventos.DAO;

import com.tadeventos.model.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class EventoDAOImp  implements EventoDAO {
    
     private final Connection conexao;
    

    public EventoDAOImp(Connection conexao) {
        this.conexao = conexao;
    }
    
 
 
    public void AddEvento(Evento evento) {
        String insercao = "INSERT INTO `TADeventos`.`evento` (`titulo`,`cidade`,`estado`,`Pais`,\n" +
                          "`Descricao`,`anfitriao`,`datafim`,`datainicio`,`endereco`,`preco_entrada`,`count_entradas`)\n" +
                         "VALUES( ? , ? , ? , ? , ?, ? , ? , ? , ?, ? , ? )";
          try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
            pstmt.setString(1, evento.getTitulo());
            pstmt.setString(2, evento.getCidade());
            pstmt.setString(3, evento.getEstado());
            pstmt.setString(4, evento.getPais());
            pstmt.setString(5, evento.getDescricao());
            pstmt.setString(6, evento.getAnfitriao());
            pstmt.setString(7, evento.getDatafim());
            pstmt.setString(8, evento.getDatainicio());
            pstmt.setString(9, evento.getEndereco());
            pstmt.setDouble(10, evento.getPreco_entrada());
            pstmt.setInt(11, evento.getCount_entradas());
            System.out.println(pstmt.toString());
            int resultado = pstmt.executeUpdate();
            if (resultado == 1) {
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A inserção não foi feita corretamente.");
            }
        } catch (SQLException ex) {
             Logger.getLogger(EventoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void DeleteEvento(Long idevento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evento GetEvento(Long idevento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List GetAllEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
