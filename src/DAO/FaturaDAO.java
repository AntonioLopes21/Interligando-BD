package DAO;

import entity.Fatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {

    private Connection connection;

    public FaturaDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirFatura(Fatura fatura) throws SQLException {
        String sql = "INSERT INTO Fatura (socio_id, data, valor, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fatura.getSocio_id());
            stmt.setDate(2, fatura.getData());
            stmt.setDouble(3, fatura.getValor());
            stmt.setString(4, fatura.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Fatura> listarFaturas() throws SQLException {
        List<Fatura> faturas = new ArrayList<>();
        String sql = "SELECT * FROM Fatura";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setId(rs.getInt("id"));
                fatura.setSocio_id(rs.getInt("socio_id"));
                fatura.setData(rs.getDate("data"));
                fatura.setValor(rs.getDouble("valor"));
                fatura.setStatus(rs.getString("status"));
                faturas.add(fatura);
            }
        }
        return faturas;
    }

    public void atualizarFatura(Fatura fatura) throws SQLException {
        String sql = "UPDATE Fatura SET socio_id = ?, data = ?, valor = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fatura.getSocio_id());
            stmt.setDate(2, fatura.getData());
            stmt.setDouble(3, fatura.getValor());
            stmt.setString(4, fatura.getStatus());
            stmt.setInt(5, fatura.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirFatura(int id) throws SQLException {
        String sql = "DELETE FROM Fatura WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
   
