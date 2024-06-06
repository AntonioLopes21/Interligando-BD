package DAO;

import entity.Consumo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {

    private Connection connection;

    public ConsumoDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirConsumo(Consumo consumo) throws SQLException {
        String sql = "INSERT INTO Consumo (socio_id, data, descricao, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consumo.getSocio_id());
            stmt.setDate(2, consumo.getData());
            stmt.setString(3, consumo.getDescricao());
            stmt.setDouble(4, consumo.getValor());
            stmt.executeUpdate();
        }
    }

    public List<Consumo> listarConsumos() throws SQLException {
        List<Consumo> consumos = new ArrayList<>();
        String sql = "SELECT * FROM Consumo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setId(rs.getInt("id"));
                consumo.setSocio_id(rs.getInt("socio_id"));
                consumo.setData(rs.getDate("data"));
                consumo.setDescricao(rs.getString("descricao"));
                consumo.setValor(rs.getDouble("valor"));
                consumos.add(consumo);
            }
        }
        return consumos;
    }

    public void atualizarConsumo(Consumo consumo) throws SQLException {
        String sql = "UPDATE Consumo SET socio_id = ?, data = ?, descricao = ?, valor = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consumo.getSocio_id());
            stmt.setDate(2, consumo.getData());
            stmt.setString(3, consumo.getDescricao());
            stmt.setDouble(4, consumo.getValor());
            stmt.setInt(5, consumo.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirConsumo(int id) throws SQLException {
        String sql = "DELETE FROM Consumo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
