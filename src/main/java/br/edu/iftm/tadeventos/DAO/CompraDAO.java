package br.edu.iftm.tadeventos.DAO;

import br.edu.iftm.tadeventos.model.Compra;
import br.edu.iftm.tadeventos.model.Evento;
import br.edu.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDAO {

    private final Connection conexao;
    private final UserDAO userDAO;
    private final EventoDAO eventoDAO;

    public CompraDAO(Connection conexao) {
        this.conexao = conexao;
        userDAO = new UserDAO(conexao);
        eventoDAO = new EventoDAO(conexao);
    }

    public void add(Compra compra) {
        String insercao = "INSERT INTO `tadeventos`.`compra` "
                + "(`id_evento`, `id_user` , `total`, `quantidade`) \n"
                + "VALUES(?, ?, ?, ?)";

        System.out.println(insercao);
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, compra.getEvento().getId());
            pstmt.setLong(2, compra.getUser().getId());
            pstmt.setDouble(3, compra.getTotal());
            pstmt.setInt(4, compra.getQuantidade());

            System.out.println(pstmt.toString());
            int resultado = pstmt.executeUpdate();

            if (resultado == 1) {
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A Inserção nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Compra buscar(User user, Evento evento) {
        Compra compra = null;
        String selecao = "SELECT * FROM compra WHERE id_user = ? AND id_evento = ?;";

        System.out.println(selecao);

        try (PreparedStatement pstmt =  conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, user.getId());
            pstmt.setLong(2, evento.getId());
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    compra = new Compra();
                    compra.setId(rs.getLong("id"));
                    compra.setTotal(rs.getDouble("total"));
                    compra.setQuantidade(rs.getInt("quantidade"));
                    compra.setEvento(evento);
                    compra.setUser(user);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return compra;
    }

    public List buscarTodos(String str) {
        Compra compra;
        List<Compra> compras = new ArrayList<>();
        String selecao = "SELECT * FROM compra " + str + ";";

        System.out.println("Select::>" + selecao);

        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                while (rs.next()) {
                    compra = new Compra();
                    compra.setId(rs.getLong("id"));
                    compra.setTotal(rs.getDouble("total"));
                    compra.setQuantidade(rs.getInt("quantidade"));
                    compra.setEvento(eventoDAO.buscar(rs.getLong("id_evento")));
                    compra.setUser(userDAO.buscar(rs.getLong("id_user")));

                    compras.add(compra);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return compras;
    }

    public List buscarTodos(User user) {
        Compra compra;
        List<Compra> compras = new ArrayList<>();
        String selecao = "SELECT * FROM compra WHERE id_user = ?;";

        System.out.println("Select::>" + selecao);

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, user.getId());
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    compra = new Compra();
                    compra.setId(rs.getLong("id"));
                    compra.setTotal(rs.getDouble("total"));
                    compra.setQuantidade(rs.getInt("quantidade"));
                    compra.setEvento(eventoDAO.buscar(rs.getLong("id_evento")));
                    compra.setUser(userDAO.buscar(rs.getLong("id_user")));

                    compras.add(compra);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return compras;
    }

    public void atualizar(Compra compra) {
        String alteracao = "UPDATE `tad`.`compra` "
                + "SET `id_evento` = ?, `id_user` = ?, `total` = ?, `quantidade` = ? "
                + "WHERE `id` = ?;";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
            pstmt.setLong(1, compra.getEvento().getId());
            pstmt.setLong(2, compra.getUser().getId());
            pstmt.setDouble(3, compra.getTotal());
            pstmt.setInt(4, compra.getQuantidade());
            pstmt.setLong(5, compra.getId());
            
            int alteracoes = pstmt.executeUpdate();
            
            if (alteracoes == 1) {
                System.out.println("\nAlteracao bem sucedida.");
            } else {
                System.out.println("A alteracao não foi feita corretamente.");
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

}
