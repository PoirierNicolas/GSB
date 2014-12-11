package applicr;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueListeCompteRendus extends JPanel {
	private ModeleCR modele ;
	private Controleur controleur ;
	
	private ModeleListeCompteRendus modeleTableauCompteRendus;
	private JTable tableauCompteRendus;
	
	public VueListeCompteRendus(ModeleCR modele, Controleur controleur) {
		super();
		System.out.println("vueListeCompteRendus::vueListeCompteRendus") ;
		this.modele = modele;
		this.controleur = controleur;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
				
		boxEtiquette.add(new JLabel("Compte Rendus :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
	
		modeleTableauCompteRendus = new ModeleListeCompteRendus(modele,controleur) ;
		tableauCompteRendus = new JTable(modeleTableauCompteRendus) ;
		tableauCompteRendus.setRowHeight(30) ;
		
		this.appliquerRendu() ;

		JScrollPane spVisiteurs = new JScrollPane(tableauCompteRendus) ;
		//spLocations.setPreferredSize(new Dimension(1290,420)) ;
		spVisiteurs.setPreferredSize(new Dimension(1090,420)) ;

		boxTableau.add(spVisiteurs) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}

	private void appliquerRendu(){
		System.out.println("VueListeCompteRendus::appliquerRendu()") ;
		this.tableauCompteRendus.getColumn("CR").setCellRenderer(new RenduBoutonCompteRendus()) ;
		this.tableauCompteRendus.getColumn("CR").setCellEditor(new BoutonCompteRendus(new JCheckBox())) ;
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
		System.out.println("VueListeCompteRendus::actualiser()") ;
		modeleTableauCompteRendus = new ModeleListeCompteRendus(modele,controleur) ;
		tableauCompteRendus.setModel(modeleTableauCompteRendus);
		this.appliquerRendu();
	}
}
