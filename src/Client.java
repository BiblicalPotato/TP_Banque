import java.util.ArrayList;

public class Client {

	String id;
	String nom;
	String prenom;
	String naissance;
	String email;

	ArrayList<Compte> listeCompteClient = new ArrayList<Compte>();

	public Client(String id, String nom, String prenom, String naissance, String email) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.email = email;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Compte> getListeCompteClient() {
		return listeCompteClient;
	}

	public void setListeCompteClient(ArrayList<Compte> listeCompteClient) {
		this.listeCompteClient = listeCompteClient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public void afficherListeComptes(String id) {
		System.out.println("___________________________________________________________________");
		System.out.println("Liste de compte");
		System.out.println("___________________________________________________________________");
		System.out.println("Numéro de compte				Solde");
		for (Compte compte : listeCompteClient) {
			if (id.equals(this.id)) {
				System.out.println(compte + "					" + compte.getSolde() + "				");
			}
		}
		return;
	}

	public void afficherNoCompte() {
		for (Compte compte : listeCompteClient) {
			System.out.print(compte.getNoCompte());
		}
		return;
	}
}
