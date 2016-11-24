package br.edu.iftm.tadeventos.DAO;

import br.edu.iftm.tadeventos.model.Evento;
import br.edu.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private final Connection conexao;
    private final UserDAO userDAO;

    public EventoDAO(Connection conexao) {
        this.conexao = conexao;
        userDAO = new UserDAO(conexao);
    }

    public void add(Evento evento) {
        String insercao = "INSERT INTO `tadeventos`.`evento` "
                + "(`titulo`,`descricao`,`id_user`,`datafim`,`datainicio`,`endereco`,`preco_entrada`,`participantes`) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
            pstmt.setString(1, evento.getTitulo());
            pstmt.setString(2, evento.getDescricao());
            pstmt.setLong(3, evento.getAnfitriao().getId());
            pstmt.setString(4, evento.getDataFim());
            pstmt.setString(5, evento.getDataInicio());
            pstmt.setString(6, evento.getEndereco());
            pstmt.setDouble(7, evento.getPrecoEntrada());
            pstmt.setInt(8, evento.getParticipantes());
            
            System.out.println(pstmt.toString());
            
            int resultado = pstmt.executeUpdate();
            
            if (resultado == 1) {
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A Inserção nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void remover(Evento evento) {
        String remocoes = "DELETE FROM `tadeventos`.`evento` WHERE `id` = ?;";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(remocoes)) {
            pstmt.setLong(1, evento.getId());            
            int removeu = pstmt.executeUpdate();
            
            if (removeu == 1) {
                System.out.println("Remoção efetuada com sucesso.");
            } else {
                System.out.println("Não foi possível efetuar a remoção.");
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public void atualizar(Evento evento) {
        String alteracao = "UPDATE `tadeventos`.`evento`"
                + "SET `titulo` = ?, `descricao` = ?,"
                + "`id_user` = ? ,`datafim` = ?,`datainicio` = ?,`endereco` = ?,"
                + "`preco_entrada` = ?,`participantes` = ? WHERE `id` = ?;";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
            pstmt.setString(1, evento.getTitulo());
            pstmt.setString(2, evento.getDescricao());
            pstmt.setLong(3, evento.getAnfitriao().getId());
            pstmt.setString(4, evento.getDataFim());
            pstmt.setString(5, evento.getDataInicio());
            pstmt.setString(6, evento.getEndereco());
            pstmt.setDouble(7, evento.getPrecoEntrada());
            pstmt.setInt(8, evento.getParticipantes());
            pstmt.setLong(9, evento.getId());
            
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

    public Evento buscar(Long id) {
        Evento evento = null;
        String selecao = "SELECT * FROM evento WHERE id = ?";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    evento = new Evento();
                    evento.setId(rs.getLong("id"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataFim(rs.getString("datafim"));
                    evento.setDataInicio(rs.getString("datainicio"));
                    evento.setEndereco(rs.getString("endereco"));
                    evento.setParticipantes(rs.getInt("participantes"));
                    evento.setPrecoEntrada(rs.getDouble("preco_entrada"));
                    evento.setAnfitriao(userDAO.buscar(rs.getLong("id_user")));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return evento;
    }

    public List buscarTodos() {
        Evento evento;
        List<Evento> eventos = new ArrayList<>();
        String selecao = "SELECT * FROM evento;";

        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                while (rs.next()) {
                    evento = new Evento();
                    evento.setId(rs.getLong("id"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataFim(rs.getString("datafim"));
                    evento.setDataInicio(rs.getString("datainicio"));
                    evento.setEndereco(rs.getString("endereco"));
                    evento.setParticipantes(rs.getInt("participantes"));
                    evento.setPrecoEntrada(rs.getDouble("preco_entrada"));
                    evento.setAnfitriao(userDAO.buscar(rs.getLong("id_user")));
                    eventos.add(evento);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return eventos;
    }   

    public List buscarTodos(String endereco) {
        Evento evento;
        List<Evento> eventos = new ArrayList<>();
        String selecao = "SELECT * FROM evento WHERE endereco LIKE ?;";

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setString(1, "%" + endereco + "%");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    evento = new Evento();
                    evento.setId(rs.getLong("id"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataFim(rs.getString("datafim"));
                    evento.setDataInicio(rs.getString("datainicio"));
                    evento.setEndereco(rs.getString("endereco"));
                    evento.setParticipantes(rs.getInt("participantes"));
                    evento.setPrecoEntrada(rs.getDouble("preco_entrada"));
                    evento.setAnfitriao(userDAO.buscar(rs.getLong("id_user")));
                    eventos.add(evento);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return eventos;
    } 

    public List buscarTodos(User user) {
        Evento evento;
        List<Evento> eventos = new ArrayList<>();
        String selecao = "SELECT * FROM evento WHERE id_user = ?;";

        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, user.getId());
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    evento = new Evento();
                    evento.setId(rs.getLong("id"));
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataFim(rs.getString("datafim"));
                    evento.setDataInicio(rs.getString("datainicio"));
                    evento.setEndereco(rs.getString("endereco"));
                    evento.setParticipantes(rs.getInt("participantes"));
                    evento.setPrecoEntrada(rs.getDouble("preco_entrada"));
                    evento.setAnfitriao(userDAO.buscar(rs.getLong("id_user")));
                    eventos.add(evento);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return eventos;
    }
}
