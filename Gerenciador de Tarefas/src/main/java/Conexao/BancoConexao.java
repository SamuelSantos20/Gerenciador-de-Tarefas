package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConexao {
	// VARIAVEL DO DRIVE
	private static final String drive = "com.mysql.cj.jdbc.Driver";

	// Caminho do banco de dados
	private static final String url = "jdbc:mysql://127.0.0.1:3306/tarefas?useTimezone=true&serverTimezone=UTC";

	// Nome do usuario do banco do dados
	private static final String usuario = "root";

	// Senha do Banco de dados
	private static final String senha = "";

	public static  Connection creaConnection() throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		Connection con = DriverManager.getConnection(url, usuario, senha);

		return con;
	}

	public void testedeconexao() {
		try {
			Connection con = creaConnection();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
