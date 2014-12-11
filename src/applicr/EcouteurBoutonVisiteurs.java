package applicr;

import javax.swing.table.AbstractTableModel ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EcouteurBoutonVisiteurs implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	private JButton bouton ;
	private ModeleCR modele;
	/** Modifier l'indice de la ligne
	 * @param row L'indice de la ligne
	 */
	public void setRow(int row){
		//System.out.println("EcouteurBoutonLocation::setRow()") ;
		this.row = row ;
	}
	
	/** Modifier l'indice de la colonne
	 * 
	 * @param column L'indice de la colonne
	 */
	public void setColumn(int column){
		//System.out.println("EcouteurBoutonLocation::setColumn()") ;
		this.column = column ;
	}
	
	/** Modifier le tableau
	 * @param table Le nouveau tableau
	 */
	public void setTable(JTable table){
		//System.out.println("EcouteurBoutonLocation::setTable()") ;
		this.table = table ;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("EcouteurBoutonVisiteur::actionPerformed()") ;
		Controleur controleur = ((ModeleListeVisiteurs)this.table.getModel()).getControleur() ;
		modele = ((ModeleListeVisiteurs)this.table.getModel()).getModele();
		String matriculeVisiteur = ((ModeleListeVisiteurs)this.table.getModel()).getMatriculeVisiteur(this.row) ;
		String nomVisiteur = ((ModeleListeVisiteurs)this.table.getModel()).getNomVisiteur(this.row) ;
		String prenomVisiteur = ((ModeleListeVisiteurs)this.table.getModel()).getPrenomVisiteur(this.row) ;
		switch(this.column){
			case 3 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Action clique Choisir]") ;
				//controleur.enregistrerDepart(numeroLocation);
				JLabel moisLabel = new JLabel("Mois (Format mm) : ");
				JTextField moisField = new JTextField(10);
				
				JLabel anneeLabel = new JLabel("Année (Format aaaa) : ");
				JTextField anneeField = new JTextField(10);
				
				Object affichageBoxChoixMoisAnnee [] = {"Saisissez le mois et l'année des CR à visualiser pour "+prenomVisiteur+" "+nomVisiteur, moisLabel, moisField, anneeLabel, anneeField};
				Object options [] = {"Valider", "Annuler"};
					
				int boxChoixMoisAnnee = JOptionPane.showOptionDialog(null,affichageBoxChoixMoisAnnee, "Période", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,null);
				
				if(JOptionPane.OK_OPTION==boxChoixMoisAnnee){
					if(Pattern.matches("^(0[1-9])|(1[0-2])$", moisField.getText()) && Pattern.matches("^2[0-9]{3}$", anneeField.getText())){
						System.out.println(moisField.getText()+ " " +anneeField.getText()+ " " + matriculeVisiteur);
						modele.getCompterendu(moisField.getText(),anneeField.getText(),matriculeVisiteur);
						controleur.visualiserCompteRendus();
					}
					else{
						JOptionPane.showMessageDialog(null, "Veuillez respecter les formats de date et année indiqué.");
					}
				
				}
		}
	}
}


