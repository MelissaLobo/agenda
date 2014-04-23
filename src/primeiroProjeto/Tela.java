package primeiroProjeto;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tela{

	
	public static void main(String[] args) {

		boolean menuInicial = true;
		Agenda agenda = new Agenda();
		while(menuInicial){
			String menu = showInputDialog("0-Buscar todo os contatos, 1-Buscando contato por id, 2-Adicionar Contato, 3-Sair");	
			if(menu.equals("0")){
				showMessageDialog(null, "todos os contatos \n"+agenda.buscarTodosOsContatos());
			}else if(menu.equals("1")){
				System.out.println("Buscando contato por id");
			}else if (menu.equals("2")){
				cadastrarContato(agenda);
			}else if (menu.equals("3")){
				System.exit(0);
			}else{
				System.out.println("Essa opcao não é valida");
			}
		}

	}

	private static void cadastrarContato(Agenda agenda) {
		String id = showInputDialog("Id do Contato");
		String nome = showInputDialog("Nome do Contato");
		String telefone = showInputDialog("Telefone");

		agenda.adicionaContato(Integer.parseInt(id),nome,telefone);
		
		showMessageDialog(null, "Usuario cadastrado com sucesso");
	}

	}
