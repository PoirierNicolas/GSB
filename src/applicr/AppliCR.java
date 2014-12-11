package applicr;

public class AppliCR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" [Cr�ation du modele]") ;
		ModeleCR modele = new ModeleCR() ;
		
		System.out.println(" [Cr�ation du controleur]") ;
		Controleur controleur = new Controleur(modele) ;
		
		System.out.println(" [Cr�ation de la vue principale]") ;
		new GuiCR(modele,controleur) ;
	}

}
