package applicr;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiCR extends JFrame implements ActionListener {

	
	private ModeleCR modele ;
	private Controleur controleur ;
		
	private JMenuItem itemQuitter ;
	private JMenuItem itemSeConnecter ;
	private JMenuItem itemSeDeconnecter ;
	private JMenuItem itemVisualiserVisiteurs ;
	private JMenuItem itemVisualiserPraticiensHesitants ;
	private JMenu menuRapports ;
	
	private VueVisiteurs vueVisualiserVisiteurs ;
	private VuePraticiensHesitants vueVisualiserPraticiensHesitants ;
	private VueAccueil vueAccueil ;
	private VueListeCompteRendus vueVisualiserCompteRendus;
	
	private CardLayout vues ;
	private Container conteneur ;

	/** Construire la vue principale de l'application
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public GuiCR(ModeleCR modele, Controleur controleur) {
		super();
		this.modele = modele;
		this.controleur = controleur ;
		this.controleur.setVuePrincipales(this);
		
		this.setTitle("Application GSB") ;
		this.setSize(1120,520) ;
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.vues = new CardLayout(2,2) ;
		this.conteneur = this.getContentPane() ;
		this.conteneur.setLayout(this.vues) ;
		
		vueVisualiserPraticiensHesitants = new VuePraticiensHesitants(modele,controleur) ;
		vueVisualiserVisiteurs = new VueVisiteurs(modele,controleur) ;
		vueAccueil = new VueAccueil() ;
		
		
		this.conteneur.add(vueVisualiserPraticiensHesitants,"Liste praticiens h�sitants") ;
		this.conteneur.add(vueVisualiserVisiteurs,"Liste visiteurs") ;
		this.conteneur.add(vueAccueil,"Accueil") ;
		this.vues.show(this.conteneur, "Accueil");
		
		this.creerBarreMenus() ;
		this.setVisible(true) ;
		
	}
	
	/** Obtenir le contrôleur
	 * 
	 * @return Le contrôleur
	 */
	public Controleur getControleur() {
		return this.controleur;
	}

	/** Modifier le contrôleur
	 * 
	 * @param controleur Le nouveau contrôleur
	 */
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	/** Obtenir le modèle
	 * 
	 * @return Le modèle
	 */
	public ModeleCR getModele() {
		return this.modele;
	}

	/** Modifier le modèle
	 * 
	 * @param modele Le nouveau modèle
	 */
	public void setModele(ModeleCR modele) {
		this.modele = modele;
	}

	/** Créer la barre de menus
	 * 
	 */
	private void creerBarreMenus(){
		System.out.println("GuiCR::creerBarreMenus()") ;
		JMenuBar barreMenus = new JMenuBar() ;
		
		JMenu menuFichier = new JMenu("Fichier") ;
		
		this.itemSeConnecter = new JMenuItem("Se connecter") ;
		this.itemSeConnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeConnecter) ;
		
		this.itemSeDeconnecter = new JMenuItem("Se deconnecter") ;
		this.itemSeDeconnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeDeconnecter) ;
		
		this.itemQuitter = new JMenuItem("Quitter") ;
		this.itemQuitter.addActionListener(this) ;
		menuFichier.add(this.itemQuitter) ;
		
		this.menuRapports = new JMenu("Rapports") ;
		this.itemVisualiserVisiteurs = new JMenuItem("Liste des visiteurs") ;
		this.itemVisualiserVisiteurs.addActionListener(this) ;
		this.menuRapports.add(this.itemVisualiserVisiteurs) ;
		
		this.itemVisualiserPraticiensHesitants = new JMenuItem("Liste des praticiens h�sitants") ;
		this.itemVisualiserPraticiensHesitants.addActionListener(this) ;
		this.menuRapports.add(this.itemVisualiserPraticiensHesitants) ;
		
				
		barreMenus.add(menuFichier) ;
		barreMenus.add(this.menuRapports) ;
		
		this.setJMenuBar(barreMenus) ;
		
		this.itemSeDeconnecter.setEnabled(false) ;
		this.menuRapports.setEnabled(false) ;
		
	}
	
	/** Basculer sur l'une des vues
	 * 
	 * @param nomVue La vue qui doit passer au premier plan
	 */
	public void changerDeVue(String nomVue){
		System.out.println("GuiCR::changerDeVue()");
		if(nomVue.equals("Liste visiteurs")){
			this.vues.show(this.conteneur,nomVue) ;
			this.vueVisualiserVisiteurs.actualiser() ;
		}
		else if(nomVue.equals("Liste praticiens h�sitants")){
			this.vues.show(this.conteneur,nomVue) ;
			this.vueVisualiserPraticiensHesitants.actualiser() ;
		}
		else if(nomVue.equals("Liste compte rendus")){
			vueVisualiserCompteRendus = new VueListeCompteRendus(modele,controleur);
			this.conteneur.add(vueVisualiserCompteRendus,"Liste compte rendus");
			this.vues.show(this.conteneur,nomVue) ;
			this.vueVisualiserCompteRendus.actualiser() ;
		}
		
		else if(nomVue.equals("Actualiser vue liste CR d'un visiteur")){
			this.vues.show(this.conteneur,"Lite compte rendus") ;
			this.vueVisualiserCompteRendus.actualiser() ;
		}
		
		else if(nomVue.equals("Se Déconnecter")){
			int boxDeconnexion = JOptionPane.showConfirmDialog(null, "Voulez-vous vous déconnecter?","Déconnexion",JOptionPane.YES_NO_OPTION);
			if(boxDeconnexion == JOptionPane.YES_OPTION){
				this.menuRapports.setEnabled(false) ;
				this.itemSeConnecter.setEnabled(true) ;
				this.itemSeDeconnecter.setEnabled(false) ;
				this.vues.show(this.conteneur,"Accueil") ;
			}			
		}
		else if(nomVue.equals("Connexion")){
			this.vues.show(this.conteneur,"Accueil") ;
			JLabel matriculeLabel = new JLabel("Matricule : ");
			JTextField matriculeField = new JTextField(10);
			
			JLabel mdpLabel = new JLabel("Mot de Passe : ");
			JPasswordField mdpField = new JPasswordField(10);
			
			Object affichageBoxConnexion [] = {"Veuillez vous identifier", matriculeLabel, matriculeField, mdpLabel, mdpField};
			Object options [] = {"Valider", "Annuler"};
				
			int boxConnexion = JOptionPane.showOptionDialog(null,affichageBoxConnexion, "Identification", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,null);
			
			if(JOptionPane.OK_OPTION==boxConnexion){
				boolean connexionOk = this.controleur.tenterConnexion(matriculeField.getText(),new String(mdpField.getPassword())) ;
				if(connexionOk){
					this.menuRapports.setEnabled(true) ;
					this.itemSeConnecter.setEnabled(false) ;
					this.itemSeDeconnecter.setEnabled(true) ;
					JOptionPane.showMessageDialog(null, "Bienvenue.");
				}
				else {
					JOptionPane.showMessageDialog(null, "La connexion a échoué.");
				}
			}
			else {
				this.controleur.annulerConnexion() ;
			}	
		}
		
		
	}

	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'événement utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		System.out.println("----------------------------------------") ;
		System.out.println("GuiCR::actionPerformed()") ;
		Object sourceEvt = evenement.getSource() ;
		
		if(sourceEvt == this.itemQuitter){
			this.controleur.quitterApplication() ;
		}
		else if(sourceEvt == this.itemSeConnecter){
			this.controleur.seConnecter() ;
		}
		else if(sourceEvt == this.itemSeDeconnecter){
			this.controleur.seDeconnecter() ;
		}
		else if(sourceEvt == this.itemVisualiserVisiteurs){
			this.controleur.visualiserVisiteurs() ;
		}
		else if(sourceEvt == this.itemVisualiserPraticiensHesitants){
			this.controleur.visualiserPraticiensHesitants() ;
			System.out.println("GuiCR::visualiserPraticiensHesitants") ;
		}
	}

}
