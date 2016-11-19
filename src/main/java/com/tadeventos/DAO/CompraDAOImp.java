package com.tadeventos.DAO;

import com.iftm.tadeventos.model.Carteira;
import com.iftm.tadeventos.model.Compra;
import com.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        String insercao = "INSERT INTO `TADeventos`.`compra` "
                + "(`evento_idevento`,`numero_cartao`,`bandeira`,\n"
                + "`data_vencimento`,`digito_validador`,`user` , `valorTotal`,`qtd`)\n"
                + "VALUES( ? , ? , ? , ?, ? , ? , ? , ? )";
        System.out.println(insercao);
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, compra.getEvento_idevento());
            pstmt.setString(2, compra.getNumero_cartao());
            pstmt.setString(3, compra.getBandeira());
            pstmt.setString(4, compra.getData_vencimento());
            pstmt.setString(5, compra.getDigito_validador());
            pstmt.setString(6, compra.getUser());
            pstmt.setDouble(7, compra.getValorTotal());
            pstmt.setInt(8, compra.getQtd());

            System.out.println(pstmt.toString());
            int resultado = pstmt.executeUpdate();
            
            if (resultado == 1) {
                System.out.println("\nInsersao bem sucedida.");
                AddUserEvento(compra.getUser(), compra.getEvento_idevento());
            } else {
                System.out.println("A insersao nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AddUserEvento(String user, int resultado) {
        String insercao = "INSERT INTO `TADeventos`.`user_has_evento`\n"
                + "(`user_id`,\n"
                + "`evento_idevento`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?)";
        System.out.println(insercao);

        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {

            pstmt.setString(1, user);
            pstmt.setInt(2, resultado);

            System.out.println(pstmt.toString());
            int resu = pstmt.executeUpdate();

            if (resu == 1) {
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
        String selecao = "SELECT * FROM compra " + str + ";";

        System.out.println("Select::>" + selecao);

        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {

                while (rs.next()) {

                    compra = new Compra();
                    compra.setIdCompra(rs.getInt(1));
                    compra.setEvento_idevento(rs.getInt(2));
                    compra.setNumero_cartao(rs.getString(3));
                    compra.setBandeira(rs.getString(4));
                    compra.setData_vencimento(rs.getString(5));
                    compra.setDigito_validador(rs.getString(6));
                    compra.setUser(rs.getString(7));
                    compra.setValorTotal(rs.getDouble(8));
                    compra.setQtd(rs.getInt(9));
                    
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
