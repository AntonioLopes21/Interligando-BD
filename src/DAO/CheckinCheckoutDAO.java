package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.CheckinCheckout;

public class CheckinCheckoutDAO {

    private Connection connection;

    public CheckinCheckoutDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirCheckinCheckout(CheckinCheckout checkinCheckout) throws SQLException {
        String sql = "INSERT INTO CheckinCheckout (socio_id, entrada, saida) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, checkinCheckout.getSocio_id());
            stmt.setTimestamp(2, checkinCheckout.getEntrada());
            stmt.setTimestamp(3, checkinCheckout.getSaida());
            stmt.executeUpdate();
        }
    }

    public List<CheckinCheckout> listarCheckinCheckouts() throws SQLException {
        List<CheckinCheckout> checkinCheckouts = new ArrayList<>();
        String sql = "SELECT * FROM CheckinCheckout";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CheckinCheckout checkinCheckout = new CheckinCheckout();
                checkinCheckout.setId(rs.getInt("id"));
                checkinCheckout.setSocio_id(rs.getInt("socio_id"));
                checkinCheckout.setEntrada(rs.getTimestamp("entrada"));
                checkinCheckout.setSaida(rs.getTimestamp("saida"));
                checkinCheckouts.add(checkinCheckout);
            }
        }
        return checkinCheckouts;
    }

    public void atualizarCheckinCheckout(CheckinCheckout checkinCheckout) throws SQLException {
        String sql = "UPDATE CheckinCheckout SET socio_id = ?, entrada = ?, saida = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, checkinCheckout.getSocio_id());
            stmt.setTimestamp(2, checkinCheckout.getEntrada());
            stmt.setTimestamp(3, checkinCheckout.getSaida());
            stmt.setInt(4, checkinCheckout.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirCheckinCheckout(int id) throws SQLException {
        String sql = "DELETE FROM CheckinCheckout WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
