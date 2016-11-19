package com.tadeventos.DAO;

import br.edu.iftm.upt.ads.daw2.contatossimples.modelo.dao.DAOFactory;
import com.iftm.tadeventos.model.Evento;
import com.iftm.tadeventos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOImp implements EventoDAO {

    private final Connection conexao;

    public EventoDAOImp(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void AddEvento(Evento evento) {

        String insercao = "INSERT INTO `TADeventos`.`evento` (`titulo`,`cidade`,`estado`,`Pais`,\n"
                + "`Descricao`,`anfitriao`,`datafim`,`datainicio`,`endereco`,`preco_entrada`,`count_entradas`)\n"
                + "VALUES( ? , ? , ? , ? , ?, ? , ? , ? , ?, ? , ? )";
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
                System.out.println("\nInsersao bem sucedida.");
            } else {
                System.out.println("A insersao nao foi feita corretamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteEvento(Long idevento) {

        String remocoes = "DELETE FROM `TADeventos`.`evento` WHERE `idevento` = " + idevento + ";";
        try (PreparedStatement pstmt = conexao.prepareStatement(remocoes)) {
            pstmt.setLong(1, idevento);
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

    @Override
    public void EditEvento(Evento evento) {

        String alteracao = "UPDATE `TADeventos`.`evento`"
                + "SET `titulo` = ?,`cidade` = ? ,`estado` = ?,`Pais` = ? ,Descricao` = ?,"
                + "`anfitriao` = ? ,`datafim` = ?,`datainicio` = ?,`endereco` = ?,"
                + "`preco_entrada` = ?,`count_entradas` = ? WHERE `idevento` = ?;";
        try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
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
            pstmt.setLong(12, evento.getIdevento());
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

    @Override
    public Evento GetEvento(Long idevento) {

        Evento evento = null;
        String selecao = "SELECT * FROM evento WHERE idevento = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setLong(1, idevento);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    evento = new Evento();
                    evento.setIdevento(rs.getLong(1));
                    evento.setTitulo(rs.getString(2));
                    evento.setCidade(rs.getString(3));
                    evento.setEstado(rs.getString(4));
                    evento.setPais(rs.getString(5));
                    evento.setDescricao(rs.getString(6));
                    evento.setDatafim(rs.getString(7));
                    evento.setDatainicio(rs.getString(8));
                    evento.setEndereco(rs.getString(9));
                    evento.setCount_entradas(rs.getInt(10));
                    evento.setPreco_entrada(rs.getDouble(11));
                    evento.setAnfitriao(rs.getString(12));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return evento;

    }

    @Override
    public List GetAllEventos() {
        return Busca("");
    }

    @Override
    public List Busca(String str) {

        Evento evento;
        List<Evento> eventos = new ArrayList<>();
        String selecao = "SELECT * FROM evento " + str + ";";

        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {

                while (rs.next()) {
                    evento = new Evento();
                    evento.setIdevento(rs.getLong(1));
                    evento.setTitulo(rs.getString(2));
                    evento.setCidade(rs.getString(3));
                    evento.setEstado(rs.getString(4));
                    evento.setPais(rs.getString(5));
                    evento.setDescricao(rs.getString(6));
                    evento.setDatafim(FormatarData(rs.getString(7)));
                    evento.setDatainicio(FormatarData(rs.getString(8)));
                    evento.setEndereco(rs.getString(9));
                    evento.setCount_entradas(rs.getInt(10));
                    evento.setPreco_entrada(rs.getDouble(11));
                    evento.setAnfitriao(rs.getString(12));
                    eventos.add(evento);
                }
            } catch (Exception sqle) {
                System.out.println(sqle);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return eventos;

    }

    private String FormatarData(String date_s) throws ParseException {
        String reformattedStr = "";
        SimpleDateFormat fromDataBase = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            reformattedStr = myFormat.format(fromDataBase.parse(date_s));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        if(reformattedStr.substring(11).equals("00:00")){
//             
//          
//        }
//         
        return reformattedStr;
    }

    public List<User> getPresentes(String evento) throws SQLException {
        System.out.println("[evento]:"+evento+'\n');
        List<User> users = new ArrayList();
        String selecao = "SELECT user_id FROM TADeventos.user_has_evento\n"
                + "where evento_idevento = "  +evento+  "\n"
                + " group by user_id;";
        System.out.println("[selecao]:"+selecao+'\n');
        DAOFactory df = new DAOFactory();
        df.abrirConexao();
        try (Statement stmt = (Statement) conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                User user;
                
                UserDAO ud = df.criarUserDAO();
                while (rs.next()) {
                    long id = Long.valueOf(rs.getString(1));
                    user = ud.GetUser(id);
                    users.add(user);
                     System.out.println("[user]:"+user+'\n');
                }

            }
        }
        
        System.out.println(users);
        return users;
    }
}
