package com.tadeventos.DAO;

import com.mysql.jdbc.Statement;
import com.tadeventos.model.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDAOImp implements CompraDAO {

    private final Connection conexao;

    public CompraDAOImp(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void AddCompra(Compra compra) {

        String 
               insercao = "INSERT INTO `TADeventos`.`Compra` "
                + "(`evento_idevento`,`numero_cartao`,`bandeira`,\n"
                + "`data_vencimento`,`digito_validador`,`user` , `valorTotal`)\n"
                + "VALUES( ? , ? , ? , ?, ? , ? , ? )";
        System.out.println(insercao);
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
            
           
            pstmt.  setInt(   1, compra.getEvento_idevento());
            pstmt.  setString(2, compra.getNumero_cartao());
            pstmt.  setString(3, compra.getBandeira());
            pstmt.  setString(4, compra.getData_vencimento());
            pstmt.  setString(5, compra.getDigito_validador());
            pstmt.  setString(6, compra.getUser());
            pstmt.  setDouble(7, compra.getValorTotal());
            
            System.out.println(pstmt.toString());
            int resultado = pstmt.executeUpdate();
            
            if (resultado == 1) {
                System.out.println("\nInsersao bem sucedida.");
            } else {
                System.out.println("A insersao nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List Busca(String str) {
        
        Compra compra;
        List<Compra> compras = new ArrayList<>();
        String selecao = "SELECT * FROM Compra " + str + ";";
        
        System.out.println("Select::>" + selecao);
        
        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                
                while (rs.next()) {
                    
                    compra = new Compra();
                    compra.setIdCompra          (rs.getInt( 1  ));
                    compra.setEvento_idevento   (rs.getInt( 2  ));
                    compra.setNumero_cartao     (rs.getString(3));
                    compra.setBandeira          (rs.getString(4));
                    compra.setData_vencimento   (rs.getString(5));
                    compra.setDigito_validador  (rs.getString(6));
                    compra.setUser              (rs.getString(7));
                    compra.setValorTotal        (rs.getDouble(8));
                    
                    compras.add(compra);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return compras;

    }

}
