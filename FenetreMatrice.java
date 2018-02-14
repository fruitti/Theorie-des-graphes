
import java.awt.BorderLayout;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class FenetreMatrice extends JFrame implements ActionListener {
		private JPanel container;
		private Matrice matrice;
		private FenetreNiveau fenetreNiveau;
		private JButton calculNiveau;
		
	public FenetreMatrice(int tailleMatrice) {
		
		this.container = new JPanel();
		this.container.setLayout(new BorderLayout());
		this.setMatrice(new Matrice(tailleMatrice));
		this.container.add(getMatrice().getSommetHorizontal(),BorderLayout.NORTH);
		this.container.add(getMatrice().getSommetVertical(), BorderLayout.WEST);
		this.container.add(getMatrice(), BorderLayout.CENTER);
		this.calculNiveau = new JButton("Calcul les niveaux");
		this.calculNiveau.addActionListener(this);
		this.container.add(this.calculNiveau, BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(container);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();
		if(source.getText().contains("Calcul les niveaux")){
			int[] tabNiveau = this.matrice.calculNiveau();
			JFrame frame = new JFrame();
			JPanel panel = new JPanel(new GridLayout(2, this.matrice.getTaille()));
			frame.setContentPane(panel);
			frame.setSize(300, 300);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			for (int i =0; i < this.matrice.getTaille(); i ++ ){
				panel.add(new JLabel(this.matrice.getTabSommet()[i]));
			}
			for (int i = 0; i < tabNiveau.length; i++) {
				panel.add(new JLabel(Integer.toString(tabNiveau[i])));
			}
			
		}
		
	}

	public Matrice getMatrice() {
		return matrice;
	}

	public void setMatrice(Matrice matrice) {
		this.matrice = matrice;
	}

	
	
	

}
