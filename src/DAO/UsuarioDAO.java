package DAO;
//DATA ACESS OBJECT
import conexao.Conexao;
import entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario){

        String sql = "INSERT USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES(?, ?, ?, ?)";
    
        
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            

            ps.execute();
            ps.close();
       
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
