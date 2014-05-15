package primeiroProjeto;


import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosEmMemoria implements FuncoesDaAgenda{

	private List<Contato> listaDeContatos =  new ArrayList<Contato>();

	public Contato salvaContato(Contato contato) {
		listaDeContatos.add(contato);
		return contato;
	}

	public Contato buscaContatoPorID(Long id) {
		for(Contato contatoAtual: listaDeContatos){
			if(contatoAtual.getId().equals(id)){
				return contatoAtual;
			}
		}
		return null;
	}

	public List<Contato> buscaTodosOsContatos() {
		return listaDeContatos;
	}

	public void deletarPorNome(String nome) {
		for(Contato contatoAtual: listaDeContatos){
			if(contatoAtual.getNome().equals(nome)){
				listaDeContatos.remove(contatoAtual);
			}
		}
	}
}