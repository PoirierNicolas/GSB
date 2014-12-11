package applicr;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class VueVisiteurs  extends JPanel {

	private ModeleCR modele ;
	private Controleur controleur ;
	
	private ModeleListeVisiteurs modeleTableauVisiteurs;
	private JTable tableauVisiteurs;
	
	public VueVisiteurs(ModeleCR modele, Controleur controleur) {
		super();
		System.out.println("VueVisiteurs::VueVisiteusr") ;
		this.modele = modele;
		this.controleur = controleur;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
				
		boxEtiquette.add(new JLabel("Visiteurs :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
	
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele,controleur) ;
		tableauVisiteurs = new JTable(modeleTableauVisiteurs) ;
		tableauVisiteurs.setRowHeight(30) ;
		
		this.appliquerRendu() ;

		JScrollPane spVisiteurs = new JScrollPane(tableauVisiteurs) ;
		//spLocations.setPreferredSize(new Dimension(1290,420)) ;
		spVisiteurs.setPreferredSize(new Dimension(1090,420)) ;

		boxTableau.add(spVisiteurs) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}

	private void appliquerRendu(){
		System.out.println("VueListeVisiteurs::appliquerRendu()") ;
		this.tableauVisiteurs.getColumn("Choisir").setCellRenderer(new RenduBoutonVisiteurs()) ;
		this.tableauVisiteurs.getColumn("Choisir").setCellEditor(new BoutonVisiteurs(new JCheckBox())) ; 
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

	public void actualiser(){
		System.out.println("VueVisiteurs::actualiser()") ;
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele,controleur) ;
		tableauVisiteurs.setModel(modeleTableauVisiteurs);
		this.appliquerRendu();
	}
}
