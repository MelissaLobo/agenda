package primeiroProjeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteAgenda {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");

		Statement statement = connection.createStatement();
		statement.execute("select * from Contatos");
		
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()){
		int id = resultSet.getInt("id");
	    System.out.println(id);
		String nome = resultSet.getString("nome");
	    System.out.println(nome);
		String telefone = resultSet.getString("telefone");
	    System.out.println(telefone);
	}
	resultSet.close();
	statement.close();
	connection.close();
 }

}