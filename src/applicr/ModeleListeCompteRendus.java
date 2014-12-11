package applicr;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.* ;
import javax.swing.table.* ;

import applicr.CompteRendu;

public class ModeleListeCompteRendus extends AbstractTableModel{
	private List<CompteRendu> compteRendus ;
	private final String[] entetes = {"Nom Praticien","Pr�nom Praticien","Ville Praticien","Date Visite","Date R�daction","Consult�","CR"} ;
	
	private ModeleCR modele;
	private Controleur controleur;
	
	public ModeleListeCompteRendus(ModeleCR modele, Controleur controleur) {
		super();
		this.modele = modele;
		this.controleur = controleur;
		compteRendus = modele.getCompteRendusDunVisiteur() ;
	}
	public Controleur getControleur() {
		return controleur;
	}
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return compteRendus.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	public String getColumnName(int indiceColonne){
		//System.out.println("ModeleListeVehicules::getColumnName()") ;
		return entetes[indiceColonne] ;
	}
	
	@Override
	public Class getColumnClass(int indiceColonne){
		//System.out.println("ModeleListeLocations::getColumnClass()") ;
		switch(indiceColonne){
			case 0 :
				return String.class ;
			case 1 : 
				return String.class ;
			case 2 : 
				return String.class ;
			case 3 :
				return Date.class ;
			case 4 :
				return Date.class ;
			case 5 :
				return Byte.class ;
			case 6 :
				return JButton.class ;
			default :
				return Object.class ;
		}
	}
	
	
	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		switch(indiceColonne){
		case 0 : 
			return compteRendus.get(indiceLigne).getNomPraticien() ;
		case 1 :
			return compteRendus.get(indiceLigne).getPrenomPraticien() ;
		case 2 :
			return compteRendus.get(indiceLigne).getVillePraticien() ;
		case 3 :
			return compteRendus.get(indiceLigne).getDateVisite() ;
		case 4 :
			return compteRendus.get(indiceLigne).getDateRedaction() ;
		case 5 : 
			return compteRendus.get(indiceLigne).getEstLu() ;
		case 6 : 
			return "Consulter" ;
		default :
			return null ;
		}
	}
	
	public String getMatriculeVisiteur(int indiceLigne){
		return compteRendus.get(indiceLigne).getMatriculeVisiteur();
	}
	
	public int getNumeroCompteRendu(int indiceLigne){
		return compteRendus.get(indiceLigne).getNumeroCompteRendu();
	}
	
	public String getNomPraticien(int indiceLigne){
		return compteRendus.get(indiceLigne).getNomPraticien();
	}
	
	public String getPrenomPraticien(int indiceLigne){
		return compteRendus.get(indiceLigne).getPrenomPraticien();
	}
	
	public Date getDateRedaction(int indiceLigne){
		return compteRendus.get(indiceLigne).getDateRedaction();
	}
	
	public Date getDateVisite(int indiceLigne){
		return compteRendus.get(indiceLigne).getDateVisite();
	}
	
	
	public boolean isCellEditable(int indiceLigne, int indiceColonne){
		switch(indiceColonne){
		case 6 :
			return true;
		default : 
			return false;
		}

	}
	
	
	public String getBilan(int indiceLigne){
		return compteRendus.get(indiceLigne).getBilan();
	}
	
	public ModeleCR getModele() {
		// TODO Auto-generated method stub
		return modele;
	}
}
