import java.util.Scanner;

public class Principal {

	public static Scanner entrada = new Scanner(System.in);
	public static String agenda[][] = new String[10][3];

	public static void exibeMenu() {
		System.out.println();
		System.out.println("********* M E N U **********");
		System.out.println();
		System.out.println("[1] - Adicionar novo contato: ");
		System.out.println("[2] - Editar contato: ");
		System.out.println("[3] - Pesquisar contato: ");
		System.out.println("[4] - Lista de contato: ");
		System.out.println("[5] - Apagar um contato: ");
		System.out.println("[6] - Sair: ");
		System.out.println();
		System.out.println("****************************");
	}

	public static void limparMatriz(String mn[][]) {
		for (int l = 0; l < 10; l++) {
			for (int c = 0; c < 3; c++) {
				mn[l][c] = "";
			}
		}
	}

	public static int linhaProximoContato(String mn[][]) {
		for (int l = 0; l < 10; l++) {
			if (mn[l][0].equals("")) {
				return l;
			}
		}
		return -1;
	}

	public static void novo(String mn[][], int l) {
		System.out.println("----------- PREENCHA O NOVO CONTATO: ");
		System.out.print("Nome............: ");
		mn[l][0] = entrada.next();
		System.out.print("Celular.........: ");
		mn[l][1] = entrada.next();
		System.out.print("E-mail..........: ");
		mn[l][2] = entrada.next();
	}

	public static void exibirContato(String mn[][], int linha) {
		System.out.println("Nome............: " + mn[linha][0]);
		System.out.println("Celular.........: " + mn[linha][1]);
		System.out.println("E-mail..........: " + mn[linha][2]);
	}

	public static void editarContato(String mn[][], int l) {
		System.out.println();
		System.out.println("--------------- EDITE O CONTATO: ");
		System.out.println("Nome..........: " + mn[l][0]);

		System.out.print("Celular.......: ");
		mn[l][1] = entrada.next();
		System.out.print("E-mail........: ");
		mn[l][2] = entrada.next();
	}

	public static void listarAgenda(String mn[][]) {
		System.out.println("--------------- CONTATOS DA AGENDA: ");
		for (int l = 0; l < 10; l++) {
			if (mn[l][0] != "") {
				exibirContato(mn, l);
				System.out.println("-----------------------------------");
			}
		}
		System.out.println("-------------------- FIM DA AGENDA: ");
	}

	public static void excluiLinha(String mn[][], int l) {
		mn[l][0] = "";
		mn[l][1] = "";
		mn[l][2] = "";
		System.out.println("Contato Excluído");
	}

	public static int pesquisarContato(String mn[][], String n) {
		for (int l = 0; l < 10; l++) {
			if (mn[l][0].equals(n)) {
				return l;
			}
		}
		return -1;
	}

	public static void apagarContato(String mn[][], String n) {
		boolean achou = false;

		int linha = pesquisarContato(mn, n);
		String opcao;
		if (linha != -1) {
			exibirContato(mn, linha);
			System.out.print("Confirma a exclusao do contato ? [S]im ou [N]ão? ");
			opcao = entrada.next();
			if (opcao.equals("s") || opcao.equals("S")) {
				excluiLinha(mn, linha);
			} else {
				System.out.println("Exclusão cancelada!");
			}
		} else {
			System.out.println("Contato não encontrado!");
		}
	}

	public static void main(String[] args) {
		int opcao, linha;

		String nome;

		// ao iniciar a aplicação, sempre é bom limparmos a matriz para que a "sujeira"
		// do Buffer não influencie nos resultados
		limparMatriz(agenda);

		do {

			exibeMenu();

			System.out.print("Escolha um opção: ");
			opcao = entrada.nextInt();
			System.out.println();

			switch (opcao) {

			case 1:
				novo(agenda, linhaProximoContato(agenda));
				break;

			case 2:
				System.out.println("---------------- EDITANDO (PESQUISE O CONTATO): ");
				System.out.print("Digite o nome...........: ");
				nome = entrada.next();
				linha = pesquisarContato(agenda, nome);
				if (linha == -1) {
					System.out.println("Contato não Cadastrado!");
				} else {
					exibirContato(agenda, linha);
					editarContato(agenda, linha);
				}
				break;

			case 3:
				System.out.println("--------------- PESQUISE O CONTATO: ");
				System.out.println("Digite o nome..........: ");
				nome = entrada.next();

				linha = pesquisarContato(agenda, nome);
				if (linha == -1) {
					System.out.println("Contato não Cadastrado!");
				} else {
					exibirContato(agenda, linha);
				}
				break;

			case 4:
				listarAgenda(agenda);
				break;

			case 5:

				System.out.println("-------------- EXCLUINDO (PESQUISE O CONTATO): ");
				System.out.print("Digite o nome..........: ");
				nome = entrada.next();
				apagarContato(agenda, nome);

				break;

			case 6:

				System.out.println("OBRIGADO POR UTILIZAR A NOSSA AGENDA");

			}
			System.out.println();

		} while (opcao != 6);
	}

}
