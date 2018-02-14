
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Matrice extends JPanel{
	
	private int taille;
	private JTextField[][] matrice;
	private String[] tabSommet = {"A", "B", "C", "D", "E", "F", "G"};
	private JPanel sommetHorizontal;
	private JPanel sommetVertical;
	private int[][] matriceImplicite;

	
	public Matrice(int taille) {
		this.taille = taille;
		this.matrice = new JTextField[taille][taille];
		this.matriceImplicite = new int[taille][taille];
		this.setSommetHorizontal(new JPanel());
		this.getSommetHorizontal().setLayout(new GridLayout(1, this.taille + 1));
		this.setSommetVertical(new JPanel());
		this.getSommetVertical().setLayout(new GridLayout(this.taille + 1 , 1));
		this.setLayout(new GridLayout(this.taille, this.taille));
		this.creerMatrice();
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void creerMatrice() {
		int indexTabSommetH = 0;
		int indexTabSommetV = 0;
		this.getSommetHorizontal().add(new JLabel());
		for(int i = 0; i < this.taille; i++) {
				
				this.getSommetHorizontal().add(new JLabel(this.getTabSommet()[indexTabSommetH]));							
				indexTabSommetH++;
			
		}
	
		for(int j = 0; j < this.taille; j++) {
				
			this.getSommetVertical().add(new JLabel(this.getTabSommet()[indexTabSommetV]));							
			indexTabSommetV++;
				
			}
		
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				this.matrice[i][j] = new JTextField("0");
				this.add(this.matrice[i][j]);
			}
		}
	
		
	}
	
	private void creerMatriceImplicite() {
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				this.matriceImplicite[i][j] = Integer.parseInt(this.matrice[i][j].getText());
			}
			
		}
	}
	
	private int [] remplirTabPredecesseur() {
		int[] tabPredecesseur = new int[taille];
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				tabPredecesseur[i] += this.matriceImplicite[j][i];
			}
		}
		
		return tabPredecesseur;
	}
	
	public int[] calculNiveau() {
		this.creerMatriceImplicite();
		int [] tabNiveau = new int[this.taille];
		int i = 0;
		int niveau = 0;
		int[] tabPredecesseur = this.remplirTabPredecesseur();
		while(i != tabPredecesseur.length) {
			
			for(int k = 0; k < this.taille; k++ ) {
				if (tabPredecesseur[k] == 0){
					
					tabNiveau[k] = niveau;
					for (int j = 0; j < this.taille; j++) {
						if( j == k){
							this.matriceImplicite[k][j] = -1;
						}
						
						else {
							
							this.matriceImplicite[k][j] = 0;
						}
						
					}
					i = 0;
				}
			}
			tabPredecesseur = this.remplirTabPredecesseur();
			niveau ++;
			i ++;

		} 
		return tabNiveau;
	}

	public JPanel getSommetVertical() {
		return sommetVertical;
	}

	public void setSommetVertical(JPanel sommetVertical) {
		this.sommetVertical = sommetVertical;
	}

	public JPanel getSommetHorizontal() {
		return sommetHorizontal;
	}

	public void setSommetHorizontal(JPanel sommetHorizontal) {
		this.sommetHorizontal = sommetHorizontal;
	}

	public String[] getTabSommet() {
		return tabSommet;
	}

	public void setTabSommet(String[] tabSommet) {
		this.tabSommet = tabSommet;
	}

}
