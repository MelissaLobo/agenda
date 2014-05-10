package primeiroProjeto;

import java.util.List;

public class Agenda {
	
	//FuncoesDaAgenda banco = new BancoDeDadosEmMemoria();
    FuncoesDaAgenda banco = new BancoDeDados();
	
	public List<Contato> buscarTodosOsContatos() {
		return banco.buscaTodosOsContatos();
	}

	public void adicionaContato(Integer id, String nome, String telefone) {

		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setTelefone(telefone);

		banco.salvaContato(contato);

}

}