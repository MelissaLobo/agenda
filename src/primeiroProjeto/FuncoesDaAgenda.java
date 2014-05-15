package primeiroProjeto;

import java.util.List;

public interface FuncoesDaAgenda {
	//define os métodos básicos para se manipular os dados da agenda

	public Contato salvaContato(Contato contato);
    public Contato buscaContatoPorID(Long id);
    public List<Contato> buscaTodosOsContatos();
    public void deletarPorNome(String contato);
    
    
}

