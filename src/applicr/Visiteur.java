package applicr;

public class Visiteur {
	private String nomVisiteur,prenomVisiteur,matriculeVisiteur;
	
	public Visiteur(String matriculeVisiteur, String nomVisiteur, String prenomVisiteur){
		super();
		this.matriculeVisiteur = matriculeVisiteur;
		this.nomVisiteur = nomVisiteur;
		this.prenomVisiteur = prenomVisiteur;
	}

	public String getNomVisiteur() {
		return nomVisiteur;
	}

	public void setNomVisiteur(String nomVisiteur) {
		this.nomVisiteur = nomVisiteur;
	}

	public String getPrenomVisiteur() {
		return prenomVisiteur;
	}

	public void setPrenomVisiteur(String prenomVisiteur) {
		this.prenomVisiteur = prenomVisiteur;
	}

	public String getMatriculeVisiteur() {
		return matriculeVisiteur;
	}

	public void setMatriculeVisiteur(String matriculeVisiteur) {
		this.matriculeVisiteur = matriculeVisiteur;
	}

	@Override
	public String toString() {
		return "Visiteur [nomVisiteur=" + nomVisiteur + ", prenomVisiteur="
				+ prenomVisiteur + ", matriculeVisiteur=" + matriculeVisiteur
				+ "]";
	}
	
	
}
