package applicr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EcouteurBoutonCompteRendus implements ActionListener {
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
		System.out.println("EcouteurBoutonCompteRendus::actionPerformed()") ;
		Controleur controleur = ((ModeleListeCompteRendus)this.table.getModel()).getControleur() ;
		modele = ((ModeleListeCompteRendus)this.table.getModel()).getModele();
	
		String  bilanCompteRendu = ((ModeleListeCompteRendus)this.table.getModel()).getBilan(this.row) ;
		String nomPraticien = ((ModeleListeCompteRendus)this.table.getModel()).getNomPraticien(this.row);
		String prenomPraticien = ((ModeleListeCompteRendus)this.table.getModel()).getPrenomPraticien(this.row);
		Date dateRedaction = ((ModeleListeCompteRendus)this.table.getModel()).getDateRedaction(this.row);
		Date dateVisite = ((ModeleListeCompteRendus)this.table.getModel()).getDateVisite(this.row);
		int numeroCompteRendu = ((ModeleListeCompteRendus)this.table.getModel()).getNumeroCompteRendu(this.row);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Praticien : "+prenomPraticien+" "+nomPraticien+"\n"+"Date de Visite: "+dateVisite+"\n"+"Date de Rédaction: "+dateRedaction+"\n"+"Bilan : "+bilanCompteRendu); // A string of ~100 words "Lorem ipsum...\nFin."
		textArea.setColumns(50);
		textArea.setRows(5);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JScrollPane scrollBilan = new JScrollPane(textArea);
		
		
		
		
		switch(this.column){
			case 6 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Action clique CR]") ;				
				controleur.actualiserTableauCR();
				JOptionPane.showMessageDialog(null,scrollBilan,"Compte rendu",JOptionPane.CLOSED_OPTION);
				modele.setEstlu(numeroCompteRendu);
				break;
		}
				
		}
}
