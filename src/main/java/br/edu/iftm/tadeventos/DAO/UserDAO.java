package br.edu.iftm.tadeventos.DAO;

import br.edu.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    private final Connection conexao;

    public UserDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void add(User user) {
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
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User buscar(String username) {
        User user = null;
        String selecao = "SELECT * FROM TADeventos.user WHERE username = ? LIMIT 1";

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setString(1, username);
            System.out.println(selecao);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return user;
    }

    public User buscar(Long id) {
        User user = null;
        String selecao = "SELECT * FROM TADeventos.user WHERE id = ? LIMIT 1";

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, id);
            System.out.println(selecao);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"));
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
