package primeiroProjeto;

public class Contato {
	
	public Integer id;
	public String nome;
	public String telefone;

	public Contato() {
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Contato outroContato=(Contato)obj;
		return this.id.equals(outroContato.id);
	}
	
	@Override
	public String toString() {
		 
		return "nome "+ nome;
	}
}