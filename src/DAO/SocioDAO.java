package DAO;

import entity.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO {
    
    private Connection conexao;

    // Construtor que recebe a conexão com o banco de dados
    public SocioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public SocioDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para inserir um novo sócio no banco de dados
    public void inserirSocio(Socio socio) throws SQLException {
        String sql = "INSERT INTO Socios (nome, matricula, endereco, telefone, email, data_cadastro, ativo, bloqueado, data_bloqueio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, socio.getNome());
            stmt.setInt(2, socio.getMatricula());
            stmt.setString(3, socio.getEndereco());
            stmt.setString(4, socio.getTelefone());
            stmt.setString(5, socio.getEmail());
            stmt.setDate(6, socio.getData_cadastro());
            stmt.setBoolean(7, socio.isAtivo());
            stmt.setBoolean(8, socio.isBloqueado());
            stmt.setDate(9, socio.getData_bloqueio());
            stmt.executeUpdate();
        }
    }

    // Método para recuperar todos os sócios do banco de dados
    public List<Socio> listarSocios() throws SQLException {
        List<Socio> socios = new ArrayList<>();
        String sql = "SELECT * FROM Socios";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio();
                socio.setSocio_id(rs.getInt("socio_id"));
                socio.setNome(rs.getString("nome"));
                socio.setMatricula(rs.getInt("matricula"));
                socio.setEndereco(rs.getString("endereco"));
                socio.setTelefone(rs.getString("telefone"));
                socio.setEmail(rs.getString("email"));
                socio.setData_cadastro(rs.getDate("data_cadastro"));
                socio.setAtivo(rs.getBoolean("ativo"));
                socio.setBloqueado(rs.getBoolean("bloqueado"));
                socio.setData_bloqueio(rs.getDate("data_bloqueio"));
                socios.add(socio);
            }
        }
        return socios;
    }
    
    // Método para atualizar um sócio no banco de dados
    public void atualizarSocio(Socio socio) throws SQLException {
        String sql = "UPDATE Socios SET nome=?, matricula=?, endereco=?, telefone=?, email=?, data_cadastro=?, ativo=?, bloqueado=?, data_bloqueio=? WHERE socio_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, socio.getNome());
            stmt.setInt(2, socio.getMatricula());
            stmt.setString(3, socio.getEndereco());
            stmt.setString(4, socio.getTelefone());
            stmt.setString(5, socio.getEmail());
            stmt.setDate(6, socio.getData_cadastro());
            stmt.setBoolean(7, socio.isAtivo());
            stmt.setBoolean(8, socio.isBloqueado());
            stmt.setDate(9, socio.getData_bloqueio());
            stmt.setInt(10, socio.getSocio_id());
            stmt.executeUpdate();
        }
    }
    
    // Método para excluir um sócio do banco de dados
    public void excluirSocio(int socio_id) throws SQLException {
        String sql = "DELETE FROM Socios WHERE socio_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, socio_id);
            stmt.executeUpdate();
        }
    }
}
