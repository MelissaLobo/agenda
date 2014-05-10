package primeiroProjeto;

public class Contato {
	
	//Contato da agenda
	
	private Integer id;
	private String nome;
	private String telefone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String toString() {
		return "nome "+ nome;
	}


}