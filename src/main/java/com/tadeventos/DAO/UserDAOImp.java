package com.tadeventos.DAO;

import com.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImp implements UserDAO {

    private final Connection conexao;

    public UserDAOImp(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void AddUser(User user) {
        String insercao = "INSERT INTO `TADeventos`.`user` (`username`,`password`) " + "VALUES( ? , ? )";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

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
    public User GetUser(String username) {
        return GetUserGenerico("username", username);
    }
    
    @Override
    public User GetUser(Long userId) {
        return GetUserGenerico("id", userId.toString());
    }

    private User GetUserGenerico(String campo, String valor) {
        User user = null;
        String selecao = "SELECT * FROM TADeventos.user WHERE " + campo +  " = '" + valor + "' Limit 1";
        System.out.println(selecao);
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
 
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    user = new User(rs.getLong(1), rs.getString(2), rs.getString(3));

                }
            } catch (SQLException sqle) {
                System.out.println(sqle);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

}
