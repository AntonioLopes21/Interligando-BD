package DAO;

import entity.Evento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class EventoDAO {

    private Connection connection;

    public EventoDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirEvento(Evento evento) throws SQLException {
        String sql = "INSERT INTO Evento (nome, data, local, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, evento.getNome());
            stmt.setDate(2, evento.getData());
            stmt.setString(3, evento.getLocal());
            stmt.setString(4, evento.getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<Evento> listarEventos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Evento";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNome(rs.getString("nome"));
                evento.setData(rs.getDate("data"));
                evento.setLocal(rs.getString("local"));
                evento.setDescricao(rs.getString("descricao"));
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public void atualizarEvento(Evento evento) throws SQLException {
        String sql = "UPDATE Evento SET nome = ?, data = ?, local = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, evento.getNome());
            stmt.setDate(2, evento.getData());
            stmt.setString(3, evento.getLocal());
            stmt.setString(4, evento.getDescricao());
            stmt.setInt(5, evento.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirEvento(int id) throws SQLException {
        String sql = "DELETE FROM Evento WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
