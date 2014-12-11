package applicr;

import java.awt.Component;

import javax.swing.DefaultCellEditor ;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class BoutonVisiteurs extends DefaultCellEditor {
	private static final long serialVersionUID = 1L;
	protected JButton bouton ;
	private boolean isPushed ;
	private EcouteurBoutonVisiteurs ecouteur = new EcouteurBoutonVisiteurs() ;

	/** Créer l'éditeur
	 * 
	 * @param checkBox La case à cocher associée au bouton
	 */
	public BoutonVisiteurs(JCheckBox checkBox) {
		super(checkBox);
		//System.out.println("EditeurBoutonLocation::EditeurBoutonLocation()") ;
		this.bouton = new JButton() ;
		this.bouton.setOpaque(true) ;
		this.bouton.addActionListener(this.ecouteur) ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.DefaultCellEditor#getTableCellEditorComponent(javax.swing.JTable, java.lang.Object, boolean, int, int)
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		System.out.println("BoutonVisiteurs::getTableCellEditorComponent()") ;
		this.ecouteur.setRow(row) ;
		this.ecouteur.setColumn(column) ;
		this.ecouteur.setTable(table) ;
		
		if(value == null){
			this.bouton.setText("") ;
		}
		else {
			this.bouton.setText(value.toString()) ;
		}
		
		return this.bouton ;
	}
}
