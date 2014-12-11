package applicr;

import java.sql.Date;

public class CompteRendu {
	private String matriculeVisiteur, nomPraticien, prenomPraticien, villePraticien,bilan;
	private Date dateVisite, dateRedaction;
	private Byte estLu;
	private int numeroCompteRendu;
	public CompteRendu(int numeroCompteRendu,String matriculeVisiteur, String nomPraticien, String prenomPraticien, String villePraticien, Date dateVisite,  Date dateRedaction, Byte estLu, String bilan){
		super();
		this.numeroCompteRendu = numeroCompteRendu;
		this.matriculeVisiteur = matriculeVisiteur;
		this.nomPraticien = nomPraticien;
		this.prenomPraticien = prenomPraticien;
		this.villePraticien = villePraticien;
		this.dateVisite = dateVisite;
		this.dateRedaction = dateRedaction;
		this.estLu = estLu;
		this.bilan = bilan;
	}

	public int getNumeroCompteRendu() {
		return numeroCompteRendu;
	}

	public void setNumeroCompteRendu(int numeroCompteRendu) {
		this.numeroCompteRendu = numeroCompteRendu;
	}

	public String getBilan() {
		return bilan;
	}

	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	@Override
	public String toString() {
		return "CompteRendu [matriculeVisiteur=" + matriculeVisiteur
				+ ", nomPraticien=" + nomPraticien + ", prenomPraticien="
				+ prenomPraticien + ", villePraticien=" + villePraticien
				+ ", dateVisite=" + dateVisite + ", dateRedaction="
				+ dateRedaction + ", estLu=" + estLu + "]";
	}

	public String getMatriculeVisiteur() {
		return matriculeVisiteur;
	}

	public void setMatriculeVisiteur(String matriculeVisiteur) {
		this.matriculeVisiteur = matriculeVisiteur;
	}

	public String getNomPraticien() {
		return nomPraticien;
	}

	public void setNomPraticien(String nomPraticien) {
		this.nomPraticien = nomPraticien;
	}

	public String getPrenomPraticien() {
		return prenomPraticien;
	}

	public void setPrenomPraticien(String prenomPraticien) {
		this.prenomPraticien = prenomPraticien;
	}

	public String getVillePraticien() {
		return villePraticien;
	}

	public void setVillePraticien(String villePraticien) {
		this.villePraticien = villePraticien;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Date getDateRedaction() {
		return dateRedaction;
	}

	public void setDateRedaction(Date dateRedaction) {
		this.dateRedaction = dateRedaction;
	}

	public Byte getEstLu() {
		return estLu;
	}

	public void setEstLu(Byte estLu) {
		this.estLu = estLu;
	}
}
