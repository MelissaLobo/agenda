package primeiroProjeto;


import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosEmMemoria implements FuncoesDaAgenda{

	private List<Contato> banco =  new ArrayList<Contato>();

	public void salvaContato(Contato contato) {
		banco.add(contato);
	}

	public Contato buscaContato(int id) {
		for(Contato contatoAtual: banco){
			if(contatoAtual.getId().equals(id)){
				return contatoAtual;
			}
		}
		return null;
	}

	public List<Contato> buscaTodosOsContatos() {

		return banco;
	}

}