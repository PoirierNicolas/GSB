package applicr;

import java.util.List;
import java.util.ArrayList;

import javax.swing.* ;
import javax.swing.table.* ;

import applicr.Visiteur;

public class ModeleListeVisiteurs extends AbstractTableModel{
	public ModeleCR getModele() {
		return modele;
	}
	public void setModele(ModeleCR modele) {
		this.modele = modele;
	}

	private List<Visiteur> visiteurs ;
	private final String[] entetes = {"Matricule","Nom","Prénom","Choisir"} ;
	
	private ModeleCR modele;
	private Controleur controleur;
	
	public ModeleListeVisiteurs(ModeleCR modele, Controleur controleur) {
		super();
		this.modele = modele;
		this.controleur = controleur;
		visiteurs = modele.getVisiteurs() ;
		/*for(Visiteur unVisiteur:visiteurs){
			System.out.println(unVisiteur);
		}*/
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
		return visiteurs.size();
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
				return JButton.class ;
			default :
				return Object.class ;
		}
	}
	
	
	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		
		switch(indiceColonne){
		case 0 : 
			return visiteurs.get(indiceLigne).getMatriculeVisiteur() ;
		case 1 : 
			return visiteurs.get(indiceLigne).getNomVisiteur() ;
		case 2 :
			return visiteurs.get(indiceLigne).getPrenomVisiteur() ;
		case 3 : 
			return "Choisir";
		default :
			return null ;
		}
	}
	
	public String getMatriculeVisiteur(int indiceLigne){
		return visiteurs.get(indiceLigne).getMatriculeVisiteur();
	}
	
	public String getNomVisiteur(int indiceLigne){
		return visiteurs.get(indiceLigne).getNomVisiteur();
	}
	
	public String getPrenomVisiteur(int indiceLigne){
		return visiteurs.get(indiceLigne).getPrenomVisiteur();
	}
	
	public boolean isCellEditable(int indiceLigne, int indiceColonne){
		switch(indiceColonne){
		case 3 :
			return true;
		default : 
			return false;
		}

	}
	
	
}
