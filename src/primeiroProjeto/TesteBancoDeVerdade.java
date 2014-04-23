package primeiroProjeto;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;
public class TesteBancoDeVerdade {

	@Test
	public void adicionaUmContato(){
    Contato contato = new Contato();
    contato.id= 1;
    contato.nome= "Bruno";
    contato.telefone= "9999-8888";
	
    BancoDeContatos banco = new BancoDeDadosEmMemoria();
    
    banco.salvaContato(contato);
    
	Contato resultadoDaBusca = banco.buscaContato(1);
	
	assertEquals(resultadoDaBusca, contato);
	}
	
	@Test
	public void testaBuscaDeTodosOsContatos(){
		Contato contato1 = new Contato();
	    contato1.id= 1;
	    contato1.nome= "Bruno";
	    contato1.telefone= "9999-8888";	
	    
	    Contato contato2 = new Contato();
	    contato2.id= 2;
	    contato2.nome= "Melissa";
	    contato2.telefone= "9344-2890";
	    
	    BancoDeContatos banco = new BancoDeDadosEmMemoria();
	    banco.salvaContato(contato1);
	    banco.salvaContato(contato2);
	    
	    List<Contato> buscaTodosOsContatos = banco.buscaTodosOsContatos();
	    
	    assertEquals(buscaTodosOsContatos.get(0), contato1);
        assertEquals(buscaTodosOsContatos.get(1), contato2);	
	}
	
}
