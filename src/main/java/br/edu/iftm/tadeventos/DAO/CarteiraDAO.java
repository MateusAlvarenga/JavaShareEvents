package br.edu.iftm.tadeventos.DAO;

import br.edu.iftm.tadeventos.model.Carteira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarteiraDAO {

    private final Connection conexao;

    public CarteiraDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void AddCarteira(Carteira carteira) {

        String insercao = "INSERT INTO `carteira`(`proprietario`, `saldo`) VALUES ( ? , ? )";
        System.out.println(insercao);
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {

            pstmt.setInt(1, carteira.getProprietario());
            pstmt.setDouble(2, carteira.getSaldo());
            int resultado = pstmt.executeUpdate();

            if (resultado == 1) {
                System.out.println("\nInsersao bem sucedida.");
            } else {
                System.out.println("A insersao nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List Busca(String str) {

        Carteira carteira;
        List<Carteira> carteiras = new ArrayList<>();
        String selecao = "SELECT * FROM carteira " + str + ";";

        System.out.println("Select::>" + selecao);

        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {

                while (rs.next()) {

                    carteira = new Carteira();
                    carteira.setProprietario(rs.getInt(1));
                    carteira.setSaldo(rs.getDouble(2));

                    carteiras.add(carteira);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return carteiras;
    }

    public Carteira getCarteira(Long proprietario) {
        
        Carteira carteira = null;
        String selecao = "SELECT `proprietario`, `saldo` FROM `carteira` WHERE `proprietario` = " + proprietario;

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    carteira = new Carteira(rs.getInt(1), rs.getDouble(2));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return carteira;
    }

    public void AtualizaSaldo(Carteira carteira) {
        
        String insercao = "UPDATE `carteira` SET `saldo` =  ?  WHERE `proprietario` = ? ;";
        System.out.println(insercao);
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
            
            pstmt.setDouble(1, carteira.getSaldo());
            pstmt.setInt(2, carteira.getProprietario());
            
            int resultado = pstmt.executeUpdate();

            if (resultado == 1) {
                System.out.println("\nAtualizacao bem sucedida.");
            } else {
                System.out.println("A Atualizacao nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
