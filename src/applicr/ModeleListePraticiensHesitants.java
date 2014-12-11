package applicr;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import applicr.Praticien;

public class ModeleListePraticiensHesitants extends AbstractTableModel{
	private List<Praticien> praticiensHesitants ;
	private final String[] entetes = {"Numero","Nom","Ville","Coefficient de confience","Date visite", "Coefficient de notoriete"} ;
	
	private ModeleCR modele;
	private Controleur controleur;

	public Controleur getControleur() {
		return controleur;
	}

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	public ModeleListePraticiensHesitants(ModeleCR modele, Controleur controleur) {
		super();
		this.modele = modele;
		this.controleur = controleur;
		praticiensHesitants = modele.getPraticiensHesitants() ;
		/*for(Praticien p:praticiensHesitants){
			System.out.println(p);
		}*/
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return praticiensHesitants.size();
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
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		
		switch(indiceColonne){
		case 0 : 
			return praticiensHesitants.get(indiceLigne).getNumP() ;
		case 1 : 
			return praticiensHesitants.get(indiceLigne).getNomP() ;
		case 2 :
			return praticiensHesitants.get(indiceLigne).getVilleP() ;
		case 3 : 
			return praticiensHesitants.get(indiceLigne).getCoefConfianceP();
		case 4 : 
			return praticiensHesitants.get(indiceLigne).getDateVisite() ;
		case 5 :
			return praticiensHesitants.get(indiceLigne).getCoefNotoriete();
		default :
			return null ;
		}
	}
}
