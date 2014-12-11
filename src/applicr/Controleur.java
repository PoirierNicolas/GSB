package applicr;

public class Controleur {

	private GuiCR vuePrincipale ;
	private ModeleCR modele ;
	
	/** Créer le contrôleur
	 * 
	 * @param modele Le modèle
	 */
	public Controleur(ModeleCR modele) {
		super();
		System.out.println("Controleur::Controleur()") ;
		this.modele = modele;
	}
	
	/** Obtenir la vue principale
	 * 
	 * @return La vue principale
	 */
	public GuiCR getVuePrincipale() {
		System.out.println("Controleur::getVuePrincipale()") ;
		return vuePrincipale ;
	}

	/** Modifier la vue principale
	 * 
	 * @param vuePrincipale La nouvelle vue principale
	 */
	public void setVuePrincipales(GuiCR vuePrincipale) {
		System.out.println("Controleur::setVuePrincipale()") ;
		this.vuePrincipale = vuePrincipale ;
	}
	
	public void quitterApplication(){
		System.exit(0) ;
	}
	
	public void seConnecter(){
		this.vuePrincipale.changerDeVue("Connexion");
		
	}
	
	public void seDeconnecter(){
		this.vuePrincipale.changerDeVue("Se Déconnecter");	
	
	}
	
	public void visualiserCompteRendus(){
		this.vuePrincipale.changerDeVue("Liste compte rendus");
		System.out.println("Controleur::visualiserVisiteurs()") ;
	}
	
	public void visualiserVisiteurs(){
		this.vuePrincipale.changerDeVue("Liste visiteurs");
		System.out.println("Controleur::visualiserVisiteurs()") ;
	}
	
	public void visualiserPraticiensHesitants(){
		this.vuePrincipale.changerDeVue("Liste praticiens h�sitants");
		System.out.println("Controleur::visualiserPraticiensHesitants()") ;
	}
	
	public boolean tenterConnexion(String matricule, String mdp){
		return Authentification.connecter(matricule, mdp) ;
	}

	
	public void annulerConnexion(){
		
	}

	public void actualiserTableauCR() {
		this.vuePrincipale.changerDeVue("Actualiser vue liste CR d'un visiteur");
	}
	
}
