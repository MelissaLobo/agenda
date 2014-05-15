package primeiroProjeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements FuncoesDaAgenda{

	public Contato salvaContato(Contato contato) {
		//implementa a interface BancoDeContatos que usa JDBC para realizar as operações sobre os dados da base

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");
			String sql = "INSERT INTO AgendaTelefonica (nome, telefone) VALUES (?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getTelefone());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			contato.setId(key);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir contato", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return contato;
	}

	private void releaseDatabaseResources(PreparedStatement statement,
			Connection connection) {try {
				statement.close();
			} catch (Exception e) {}

			try{
				connection.close();
			}catch (Exception e) {}
	}	

	public Contato buscaContatoPorID(Long id) {
		Contato contact = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");
			String sql = "SELECT * FROM AgendaTelefonica WHERE ID LIKE ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setString(1, "%" + id + "%");
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				contact = new Contato();
				contact.setId(resultSet.getLong("id"));
				contact.setNome(resultSet.getString("nome"));
				contact.setTelefone(resultSet.getString("telefone"));
			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar contato.", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}return contact;
	}

	public List<Contato> buscaTodosOsContatos() {
		List<Contato> contatos =  new ArrayList<Contato>();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");
			String sql = "SELECT * FROM AgendaTelefonica";
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Contato contact = new Contato();
				contact.setId(resultSet.getLong("id"));
				contact.setNome(resultSet.getString("nome"));
				contact.setTelefone(resultSet.getString("telefone"));
				contatos.add(contact);
			}resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar todos os contatos", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return contatos;
	}

	public void deletarPorNome(String nome) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CadastroEBusca","SA","");
			String sql = "DELETE FROM AgendaTelefonica WHERE nome = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar contato.", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
	}
}
