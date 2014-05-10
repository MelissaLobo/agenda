package primeiroProjeto;

import java.util.List;

public interface FuncoesDaAgenda {
	//define os métodos básicos para se manipular os dados da agenda

	public void salvaContato(Contato contato);
    public Contato buscaContato(int id);
    public List<Contato> buscaTodosOsContatos();
    
}

