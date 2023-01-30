import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Banque b1 = new Banque("BANQUE CDA");
		Agence a1 = new Agence("lmp", "lmp", "fhg");
		ArrayList<Agence> listeAgence = new ArrayList<Agence>();

		menuLoop(scanner, b1, a1, listeAgence);
	}

	public static void menuLoop(Scanner scanner, Banque b1, Agence a1, ArrayList<Agence> listeAgence) {

		while (true) {
			printMenuPrincipal();
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				b1.nouvelleAgence();
				break;
			case 2:
				a1.nouveauCompte();
				break;
			case 3:
				a1.nouveauClient();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.out.println("Goodbye.");
				return;
			default:
				continue;
			}
		}
	}

	public static void printMenuPrincipal() {
		System.out.println(" \n___________________________MENU BANQUE CDA___________________________");
		System.out.println("");
		System.out.println("\n - 1. - Créer une agence");
		System.out.println("\n - 2. - Créer un compte bancaire");
		System.out.println("\n - 3. - Créer un client");
		System.out.println("\n - 4. - Recherche de compte");
		System.out.println("\n - 5. - Recherche de client");
		System.out.println("\n - 6. - Afficher la liste des comptes d'un client");
		System.out.println("\n - 7. - Imprimer les infos client");
		System.out.println("\n - 8. - Quitter");
		System.out.println("");
		System.out.println("___________________________________________________________________________");

	}

}
