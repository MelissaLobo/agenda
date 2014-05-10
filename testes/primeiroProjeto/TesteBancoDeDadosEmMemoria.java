package primeiroProjeto;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class TesteBancoDeDadosEmMemoria {
	@Test
	public void adicionaUmContato(){
    Contato contato = new Contato();
    contato.setId(1);
    contato.setNome("Bruno");
    contato.setTelefone("9999-8888");

    FuncoesDaAgenda banco = new BancoDeDadosEmMemoria();
    
    banco.salvaContato(contato);
    
	Contato resultadoDaBusca = banco.buscaContato(1);

	assertEquals(resultadoDaBusca, contato);
	}

	@Test
	public void testaBuscaDeTodosOsContatos(){
		Contato contato1 = new Contato();
		contato1.setId(1);
	    contato1.setNome("Bruno");
	    contato1.setTelefone("9999-8888");
	

	    Contato contato2 = new Contato();
	    contato2.setId(2);
	    contato2.setNome("Melissa");
	    contato2.setTelefone("9344-2890");

	    FuncoesDaAgenda banco = new BancoDeDadosEmMemoria();
	    banco.salvaContato(contato1);
	    banco.salvaContato(contato2);

	    List<Contato> buscaTodosOsContatos = banco.buscaTodosOsContatos();

	    assertEquals(buscaTodosOsContatos.get(0), contato1);
        assertEquals(buscaTodosOsContatos.get(1), contato2);	
	}
}
