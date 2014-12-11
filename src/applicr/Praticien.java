package applicr;

import java.util.GregorianCalendar;
import java.math.BigDecimal;
import java.sql.Date;
public class Praticien {
	private String nomP,prenomP,villeP;
	private float coefNotoriete;
	private BigDecimal coefConfianceP;
	private Date dateVisite;
	private int numP;
	
	public Praticien(int numP,String nomP, String prenomP, String villeP,BigDecimal coefConfianceP, float coefNotoriete,Date dateVisite) {
		super();
		this.numP = numP ;
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.villeP = villeP;
		this.coefConfianceP = coefConfianceP;
		this.coefNotoriete = coefNotoriete;
		this.dateVisite = dateVisite;		
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getPrenomP() {
		return prenomP;
	}
	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}
	public String getVilleP() {
		return villeP;
	}
	public void setVilleP(String villeP) {
		this.villeP = villeP;
	}
	public BigDecimal getCoefConfianceP() {
		return coefConfianceP;
	}
	public void setCoefConfianceP(BigDecimal coefConfianceP) {
		this.coefConfianceP = coefConfianceP;
	}
	@Override
	public String toString() {
		return "Praticien [nomP=" + nomP + ", prenomP=" + prenomP + ", villeP="
				+ villeP + ", coefNotoriete=" + coefNotoriete
				+ ", coefConfianceP=" + coefConfianceP + ", dateVisite="
				+ dateVisite + ", numP=" + numP + "]";
	}
	public float getCoefNotoriete() {
		return coefNotoriete;
	}
	public void setCoefNotoriete(float coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}
	public Date getDateVisite() {
		return dateVisite;
	}
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	public int getNumP() {
		return numP;
	}
	public void setNumP(int numP) {
		this.numP = numP;
	}
	
	
}
