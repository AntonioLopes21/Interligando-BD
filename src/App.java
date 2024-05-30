
import DAO.UsuarioDAO;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        Usuario u = new Usuario();
        u.setNome( "Paulin");
        u.setLogin("Paulo Paulo");
        u.setSenha("1234");
        u.setEmail("pauliiiiin@gmail.com");

        new UsuarioDAO().cadastrarUsuario(u);
    }
}
