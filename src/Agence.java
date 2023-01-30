import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agence {

	private String codeAgence;
	private String nom;
	private String adresse;

	private ArrayList<Client> listeClients = new ArrayList<>();
	private ArrayList<Compte> listeComptes = new ArrayList<Compte>();

	public Agence(String codeAgence, String nom, String adresse) {

		this.codeAgence = codeAgence;
		this.nom = nom;
		this.adresse = adresse;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Client> getListeClient() {
		return listeClients;
	}

	public void setListeClient(ArrayList<Client> listeClient) {
		this.listeClients = listeClient;
	}

	public ArrayList<Compte> getListeCompte() {
		return listeComptes;
	}

	public void setListeCompte(ArrayList<Compte> listeCompte) {
		this.listeComptes = listeCompte;
	}

	@Override
	public String toString() {
		return "Agence [codeAgence=" + codeAgence + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	public void afficherClient(String id, ArrayList<Client> clients) {
    	for (Client client : clients) {
    		System.out.println("Numéro client : " + id + "\n"
    				+ "Nom : " + nom + "\n"
    						+ "Prénom : " + client.prenom + "\n"
    								+ "Date de naissance : " + client.naissance +"\n"
    										+ "Numéro(s) de compte : " + client.afficherNoCompte());
		}
		return;
	}

	public void nouveauClient() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Quel est l'id du client ? ");
		String id = sc.next();
		Pattern p = Pattern.compile("[A-Z]{2}[0-9]{6}");
		Matcher m = p.matcher(id);

		if (m.matches()) {
			System.out.println(" Quel est le nom du client ? ");
			String nom = sc.next();
			System.out.println(" Quel est le prenom du client ? ");
			String prenom = sc.nextLine();
			System.out.println(" Quel est la date de naissance du client  ? ");
			String naissance = sc.nextLine();
			System.out.println(" Quel est l'adresse mail du client ? ");
			String email = sc.nextLine();
			Client client = new Client(id, nom, prenom, naissance, email);

			if (emailValide(client)) {
				listeClients.add(client);
			}

		} else {

			System.out.println(" L'Id n'est pas bon, format : 2 majuscules, 6 chiffres ");
			System.out.println(" Requête annulée ");

		}
		sc.close();
	}

	public boolean emailValide(Client client) {
		Scanner sc = new Scanner(System.in);
		String Regpex = "^[A-Za-z0-9._]+@[A-Za-z0-9._]+\\.[a-z]{2,}$";

		Pattern p = Pattern.compile(Regpex);
		Matcher m = p.matcher(client.getEmail());
		sc.close();

		if (m.matches()) {
			System.out.println(" email correct ");
			return true;

		}

		else {
			System.out.println(" email incorrect ");
			return false;
		}

	}

	public void nouveauCompte() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Quel est le numero de compte ? ");
		String id = sc.next();
		String Regpex = "[0-9]{11}";

		Pattern p = Pattern.compile(Regpex);
		Matcher m = p.matcher(id);

		if (m.matches()) {
			System.out.println(" Quel code agence ? ");
			String codeAgence = sc.next();
			System.out.println(" Quel est le type de compte ? 1- Courant 2-Livret A 3-PEL");
			int type = sc.nextInt();
			System.out.println(" Quel est votre solde ");
			float solde = sc.nextFloat();

			System.out.println(" Quel est l'id client  ? ");
			String idClient = sc.next();
			Client client1 = null;

			for (Client client : listeClients) {
				if (idClient.equals(client.getId())) {
					client1 = client;

				}

				else
					return;

			}
			sc.close();
			Compte compte = new Compte(id, codeAgence, client1, solde, type);
			listeComptes.add(compte);

		} else {

			System.out.println(" Le numero de compte n'est pas bon ");
			System.out.println(" Requête annulée ");

		}

		sc.close();

	}

	public void afficherCompte(String noCompte, ArrayList<Compte> comptes) {
		for (Compte compte : comptes) {
			if(noCompte.equals(compte.getNoCompte())){
				System.out.println(compte.toString());
			}
		}
		
	}
}
