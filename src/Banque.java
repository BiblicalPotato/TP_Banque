import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Banque {

	static Scanner sc = new Scanner(System.in);

	private String nom;
	ArrayList<Agence> listeAgences = new ArrayList<Agence>();

	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void nouvelleAgence() {
		System.out.println(" Quel est le code de l'agence ? ");
		String codeAgence = sc.nextLine();

		Pattern p = Pattern.compile("[0-9]{3}");

		Matcher m = p.matcher(codeAgence);

		if (m.matches()) {
			System.out.println(" Quel est le nom de l'agence ? ");
			String nom = sc.nextLine();
			System.out.println(" Quel est l'adresse de l'agence ? ");
			String adresse = sc.nextLine();
			Agence agence = new Agence(codeAgence, nom, adresse);
			listeAgences.add(agence);

		} else {

			System.out.println(" Le code n'est pas bon, donnez 3 chiffres ");

		}
		//sc.close();
	}

}
