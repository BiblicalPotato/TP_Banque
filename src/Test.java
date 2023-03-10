import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Banque b = new Banque("BANQUE CDA");
		Agence a = new Agence("123", "a", "fhg");
		Client c = new Client(null, null, null, null, null);
		ArrayList<Agence> listeAgence = new ArrayList<Agence>();

		menuLoop(scanner, b, a, c, listeAgence);

	}

	public static void menuLoop(Scanner scanner, Banque b, Agence a, Client c, ArrayList<Agence> listeAgence) {
		String idClient;
		
		while (true) {
			printMenuPrincipal();
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				b.nouvelleAgence();
				break;
			case 2:
				a.nouveauCompte();
				break;
			case 3:
				a.nouveauClient();
				break;
			case 4:
				System.out.println("Numéro Compte : ");
				String noCompte = scanner.next();
				a.afficherCompte(noCompte, a.getListeCompte());
				break;
			case 5:
				System.out.println("Identifiant client : ");
				idClient = scanner.next();
				a.afficherClient(idClient, a.getListeClient());
				break;
			case 6:
				System.out.println("Identifiant client : ");
				idClient = scanner.next();
				for (Client client : a.getListeClient()) {
					if(idClient.equals(client.getId())){
						client.afficherListeComptes();
					}
				}
				
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

	public void imprimerInfosClient(String id, Agence a) {
		try {
			FileWriter fw = new FileWriter("Fiche client.txt");

			fw.write("Fiche client " + "\r\n");

			for (Client client : a.getListeClient()) {
				if (id.equals(client.getId())) {
					fw.write(client.getId() + "\r\n");
					fw.write(client.getNom() + "\r\n");
					fw.write(client.getPrenom() + "\r\n");
					fw.write(client.getNaissance() + "\r\n" + "\r\n");
				}
			}

			fw.write("___________________________________________________________________" + "\r\n");
			fw.write("Liste de compte" + "\r\n");
			fw.write("___________________________________________________________________" + "\r\n");
			fw.write("Numéro de compte                Solde" + "\r\n");
			fw.write("\r\n" + "\r\n");

			for (Compte compte : a.getListeCompte()) {
				if (id.equals(compte.getClient().getId())) {
					fw.write(compte.getCodeAgence() + "\r\n");
					fw.write(compte.getFraisAnnuels() + "\r\n");
					fw.write(compte.getNoCompte() + "\r\n");
					fw.write(compte.getSolde() + "\r\n" + "\r\n");
				}
			}
			
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
