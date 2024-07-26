import java.util.Scanner;

public class Principal {

	public static Scanner entrada = new Scanner(System.in);
	public static String agenda[][] = new String[10][3];

	public static void exibeMenu() {
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

	public static void main(String[] args) {
		int opcao, linha;

		String nome;

		do {

			exibeMenu();

			System.out.println("Escolha um opção: ");
			opcao = entrada.nextInt();
			System.out.println();

			switch (opcao) {

			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				System.out.println("OBRIGADO POR UTILIZAR A NOSSA AGENDA");

			}
			System.out.println();

		} while (opcao != 6);
	}

}
