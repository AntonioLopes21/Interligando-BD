

import DAO.SocioDAO;
import entity.Socio;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;


import javax.swing.JFrame;
 //importando popup que servira como janelinha para cadastro
import javax.swing.WindowConstants; 
import javax.swing.JLabel; 
import javax.swing.JTextField; 
import javax.swing.JButton; 
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws SQLException {
        SocioDAO socioDAO = new SocioDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do sócio:");
        String nome = scanner.nextLine();

        System.out.println("Digite a matrícula do sócio:");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o endereço do sócio:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone do sócio:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o e-mail do sócio:");
        String email = scanner.nextLine();

        System.out.println("Digite a data de cadastro do sócio (Formato: AAAA-MM-DD):");
        String dataCadastroStr = scanner.nextLine();
        Date dataCadastro = Date.valueOf(dataCadastroStr);

        System.out.println("O sócio está ativo? (true/false):");
        boolean ativo = scanner.nextBoolean();
        scanner.nextLine(); // Consumir a nova linha após nextBoolean()

        System.out.println("O sócio está bloqueado? (true/false):");
        boolean bloqueado = scanner.nextBoolean();
        scanner.nextLine(); // Consumir a nova linha após nextBoolean()

        System.out.println("Digite a data de bloqueio do sócio (Formato: AAAA-MM-DD):");
        String dataBloqueioStr = scanner.nextLine();
        Date dataBloqueio = Date.valueOf(dataBloqueioStr);

        Socio novoSocio = new Socio();
        novoSocio.setNome(nome);
        novoSocio.setMatricula(matricula);
        novoSocio.setEndereco(endereco);
        novoSocio.setTelefone(telefone);
        novoSocio.setEmail(email);
        novoSocio.setDataCadastro(dataCadastro);
        novoSocio.setAtivo(ativo);
        novoSocio.setBloqueado(bloqueado);
        novoSocio.setDataBloqueio(dataBloqueio);

        socioDAO.inserirSocio(novoSocio);

        System.out.println("Sócio cadastrado com sucesso!");
    }
}
