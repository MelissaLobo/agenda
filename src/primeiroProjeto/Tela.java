package primeiroProjeto;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tela{

	public static void main(String[] args) {

		boolean menuInicial = true;
		Agenda agenda = new Agenda();
		while(menuInicial){
			String menu = showInputDialog("0-Contatos, 1-Buscar contato por ID, 2-Adicionar Contato, 3-Deletar Contato, 4-Sair");	
			if(menu.equals("0")){
				todosOsContatos(agenda);
			}else if(menu.equals("1")){
				bucandoContato(agenda);
			}else if (menu.equals("2")){
				cadastrarContato(agenda);
			}else if (menu.equals("3")){
				deletarContato(agenda);
			}else if (menu.equals("4")){
				System.exit(0);
			}else{
				System.out.println("Essa opcao não é valida");
			}
		}

	}

	private static void todosOsContatos(Agenda agenda) {
		showMessageDialog(null, "todos os contatos \n"+agenda.buscarTodosOsContatos());
	}

	private static void cadastrarContato(Agenda agenda) {
		String nome = showInputDialog("Nome do Contato");
		String telefone = showInputDialog("Telefone");
		agenda.adicionaContato(nome, telefone);
		showMessageDialog(null, "Usuario cadastrado com sucesso");
	}

	private static void bucandoContato(Agenda agenda) {
		Long id= null;
		try{
			id = Long.parseLong(showInputDialog("Id do Contato"));
		}catch(NumberFormatException e){
			showMessageDialog(null, "Digite somente numeros");
			System.exit(0);
		}
		Contato buscandoContato = agenda.buscandoContato(id);
		showMessageDialog(null, "Resultado da busca " + buscandoContato);
	}

	private static void deletarContato(Agenda agenda) {
		String nome = showInputDialog("Nome do Contato");
		agenda.deletarPorNome(nome);
		showMessageDialog(null, "Usuario deletado com sucesso");
	}
}
