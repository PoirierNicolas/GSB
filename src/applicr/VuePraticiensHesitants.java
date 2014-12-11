package applicr;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;


import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class VuePraticiensHesitants  extends JPanel {
	
	
	private ModeleCR modele ;
	private Controleur controleur ;
	private JTable tableauPraticiensHesitants ;
	private ModeleListePraticiensHesitants modeleTableauPraticiensHesitants ;
	
	
	public VuePraticiensHesitants(ModeleCR modele, Controleur controleur) {
		super();
		System.out.println("VuePraticiensHesitants::VuePraticiensHesitants") ;
		this.modele = modele;
		this.controleur = controleur;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("Praticiens :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele,controleur) ;
		tableauPraticiensHesitants = new JTable(modeleTableauPraticiensHesitants) ;
		tableauPraticiensHesitants.setRowHeight(30) ;
		
		
		JScrollPane spPraticiensHesitants = new JScrollPane(tableauPraticiensHesitants) ;
		spPraticiensHesitants.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spPraticiensHesitants) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		this.appliquerRendu() ;
		
		tableauPraticiensHesitants.setAutoCreateRowSorter(true);

		
	}

	
	/** Actualiser le tableau
	 * 
	 */
	public void actualiser(){
		System.out.println("VuePraticiensHesitants::actualiser()") ;
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele,controleur) ;
		tableauPraticiensHesitants.setModel(modeleTableauPraticiensHesitants) ;
		this.appliquerRendu() ;
	}
	
	/** Appliquer le "rendu" au tableau
	 * 
	 */
	private void appliquerRendu(){
		System.out.println("VueListeVehicules::appliquerRendu()") ;
		tableauPraticiensHesitants.setDefaultRenderer(Object.class,new RenduCellulePraticiensHesitants()) ;

	}
		


	public ModeleCR getModele() {
		return modele;
	}



	public void setModele(ModeleCR modele) {
		this.modele = modele;
	}



	public Controleur getControleur() {
		return controleur;
	}



	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}


}
