

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class FenetreNiveau extends JFrame{
	
	private Matrice matrice;
	
	private JPanel container;

	
	public FenetreNiveau(int taille) {
		
		
		this.container = new JPanel(new GridLayout(2, taille));
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.afficherNiveau();
		this.setContentPane(container);
	}
	
	public void afficherNiveau() {
		int[] calculNiveau = this.matrice.calculNiveau();
		
		for(int i = 0; i < this.matrice.getTaille(); i++ ){
			this.container.add(new JLabel(this.matrice.getTabSommet()[i]));
		}
		for (int i = 0; i < calculNiveau.length; i++) {
			this.container.add(new JLabel(Integer.toString(calculNiveau[i])));
		}
		
	}
}
