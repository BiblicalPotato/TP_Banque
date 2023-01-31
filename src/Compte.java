public class Compte {

	final float FRAIS_TENUE_COMPTE = 25;

	private String noCompte;
	private String codeAgence;
	private Client client;
	private double solde;
	private int type;
	private boolean decouvertAutorise;

	public Compte(String noCompte, String codeAgence, Client client, double solde, int type) {
		this.type = type;
		this.noCompte = noCompte;
		this.codeAgence = codeAgence;
		this.client = client;
		this.solde = solde;

		
		
		
	}

	
	
	public String getNoCompte() {
		return noCompte;
	}

	public void setNoCompte(String noCompte) {
		this.noCompte = noCompte;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public boolean isDecouvert() {
		return decouvertAutorise;
	}

	public void setDecouvert(boolean decouvert) {
		this.decouvertAutorise = decouvert;
	}

	public double getFraisAnnuels() {
		switch (type) {
		case 1:
			return FRAIS_TENUE_COMPTE;
		case 2:
			return FRAIS_TENUE_COMPTE + 0.1 * solde;
		case 3:
			return FRAIS_TENUE_COMPTE + 0.025 * solde;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Compte [noCompte=" + noCompte + ", codeAgence=" + codeAgence + ", client=" + client + ", solde=" + solde
				+ ", decouvert=" + decouvertAutorise + "]";
	}

}
