package primeiroProjeto;

import java.util.List;

public interface BancoDeContatos {

	public void salvaContato(Contato contato);
    public Contato buscaContato(int id);
    public List<Contato> buscaTodosOsContatos();
    
}

