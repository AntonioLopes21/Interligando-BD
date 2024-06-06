package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class DependenteDAO {

    private Connection connection;

    public DependenteDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirDependente(Dependente dependente) throws SQLException {
        String sql = "INSERT INTO Dependente (socio_id, nome, dataNascimento, parentesco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dependente.getSocio_id());
            stmt.setString(2, dependente.getNome());
            stmt.setDate(3, dependente.getDataNascimento());
            stmt.setString(4, dependente.getParentesco());
            stmt.executeUpdate();
        }
    }

    public List<Dependente> listarDependentes() throws SQLException {
        List<Dependente> dependentes = new ArrayList<>();
        String sql = "SELECT * FROM Dependente";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Dependente dependente = new Dependente();
                dependente.setId(rs.getInt("id"));
                dependente.setSocio_id(rs.getInt("socio_id"));
                dependente.setNome(rs.getString("nome"));
                dependente.setDataNascimento(rs.getDate("dataNascimento"));
                dependente.setParentesco(rs.getString("parentesco"));
                dependentes.add(dependente);
            }
        }
        return dependentes;
    }

    public void atualizarDependente(Dependente dependente) throws SQLException {
        String sql = "UPDATE Dependente SET socio_id = ?, nome = ?, dataNascimento = ?, parentesco = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dependente.getSocio_id());
            stmt.setString(2, dependente.getNome());
            stmt.setDate(3, dependente.getDataNascimento());
            stmt.setString(4, dependente.getParentesco());
            stmt.setInt(5, dependente.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirDependente(int id) throws
