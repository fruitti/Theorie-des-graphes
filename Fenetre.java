import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame implements ActionListener{
	private JButton click;
	private JTextField text;
	private JPanel container;
	private JPanel buttonContainer;
	private FenetreMatrice fenetreMatrice;
	
	public Fenetre() {
		this.container = new JPanel();
		this.buttonContainer = new JPanel();
		this.text = new JTextField();
		this.click = new JButton("valider");
		
		this.container.setLayout(new BorderLayout());
		this.container.add(new JLabel("Entrez la taille de la matrice"), BorderLayout.NORTH);
		this.container.add(new JPanel(), BorderLayout.SOUTH);
		this.buttonContainer.setLayout(new GridLayout(1, 2));
		this.buttonContainer.add(text);
		this.buttonContainer.add(click);
		this.container.add(buttonContainer, BorderLayout.CENTER);
		this.click.addActionListener(this);
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(container);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();
		if(source.getText().contains("valider")) {
			FenetreMatrice fenetre = new FenetreMatrice(Integer.parseInt(this.text.getText()));
		}
		
	}
}
