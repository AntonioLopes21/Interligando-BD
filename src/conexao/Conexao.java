package conexao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        Connection conexao = null;
        
        try {
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/bancocadastro", "root", "root");
            
            // Obter metadados do banco de dados
            DatabaseMetaData metaData = conexao.getMetaData();
            
            // Lista de tabelas que queremos verificar
            String[] tabelas = {"Socios", "Dependentes", "Funcionarios", "CheckinCheckout", "Consumo", 
                                "Eventos", "Faturas", "Atividades"};
            
            // Exibir o nome das tabelas existentes no banco de dados
            System.out.println("Tabelas no banco de dados bancocadastro:");
            for (String tabela : tabelas) {
                ResultSet rsTabela = metaData.getTables(null, null, tabela, new String[] {"TABLE"});
                if (rsTabela.next()) {
                    System.out.println(tabela);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + ex.getMessage());
        } finally {
            // Fechar a conexão com o banco de dados
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar a conexão com o banco de dados: " + ex.getMessage());
                }
            }
        }
    }

    public static Object getConexao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
