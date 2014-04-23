package primeiroProjeto;

import java.util.List;

public class Agenda {
	
	BancoDeContatos banco = new BancoDeDadosEmMemoria();

	public List<Contato> buscarTodosOsContatos() {
		return banco.buscaTodosOsContatos();
	}

	public void adicionaContato(Integer id, String nome, String telefone) {

		Contato contato = new Contato();
		contato.id= id;
		contato.nome= nome;
		contato.telefone= telefone;

		banco.salvaContato(contato);

	}

}
