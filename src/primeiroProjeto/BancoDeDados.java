package primeiroProjeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements FuncoesDaAgenda{

	private List<Contato> banco =  new ArrayList<Contato>();
	
	public void salvaContato(Contato contato) {
		//implementa a interface BancoDeContatos que usa JDBC para realizar as operações sobre os dados da base
		
		Connection connection = null;
		  PreparedStatement statement = null;
		 
		  try {
		    connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");

		    String sql = "INSERT INTO Contatos (id,nome, telefone) VALUES (?, ?, ?)";
		 
		    statement = connection.prepareStatement(sql);
		    statement.setInt(1, contato.getId());
		    statement.setString(2, contato.getNome());
		    statement.setString(3, contato.getTelefone());
		   
		    statement.executeUpdate();
		
		 
		   // contato.id=key;
		  } catch (Exception e) {
		    throw new RuntimeException("Erro ao inserir contato", e);
		  } finally {
		    releaseDatabaseResources(statement, connection);
	}
}
	private void releaseDatabaseResources(PreparedStatement statement,
			Connection connection) {try {
			      statement.close();
		    } catch (Exception e) {}
		 
		    try {
		      connection.close();
		    } catch (Exception e) {}
		  }	

	public Contato buscaContato(int id) {
		/*Contato contact = null;
		  Connection connection = null;
		  PreparedStatement statement = null;
		 
		  try {
		    connection = TestaAgenda.getConnection();
		    String sql = "SELECT * FROM Contatos WHERE nome = ?";
		    statement = connection.prepareStatement(sql);
		    statement.setString(id, sql);
		    ResultSet resultSet = statement.executeQuery();
		 
		    if (resultSet.next()) {
		      contact = new Contato();
		      contact.setId(resultSet.getLong("id"));
		      contact.setNome(resultSet.getString("name"));
		      contact.setTelefone(resultSet.getString("telefone"));
		    }
		 
		    resultSet.close();
		  } catch (Exception e) {
		    throw new RuntimeException("Erro ao buscar contato.", e);
		  } finally {
		    releaseDatabaseResources(statement, connection);
		  }*/
		 
		  return null;
		}


	public List<Contato> buscaTodosOsContatos() {
		return banco;
	}

}
