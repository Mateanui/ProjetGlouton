package glouton.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VueInformation extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTextArea jTextAreaInformations;
	private JButton jButtonFilename;
	private JButton jButtonLancerAlgo;
	private JTextArea jTextAreaNbFoisAlgorithmeGlouton;
	private JButton jButtonLancerAlgo1000;
	
	public VueInformation(boolean b) {
		affichage(b);
	}
	
	/* **************** */
	/* *** Méthodes *** */
	/* **************** */
	
	public void affichage(boolean b) {
		jTextAreaInformations = new JTextArea(30,31);
		jTextAreaInformations.setEditable(false);
		jTextAreaInformations.setForeground(Color.BLUE);
		JScrollPane scrollPane = new JScrollPane(jTextAreaInformations,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jButtonFilename = new JButton("Selectionner");
		jButtonLancerAlgo = new JButton("Lancer");
		
		jTextAreaNbFoisAlgorithmeGlouton = new JTextArea("10");
		jTextAreaNbFoisAlgorithmeGlouton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jButtonLancerAlgo1000 = new JButton("Solution ultime");
		
		JPanel conteneurInformation = new JPanel();
		conteneurInformation.add(scrollPane);
		
		JPanel conteneurButtonSuperieur = new JPanel();
		conteneurButtonSuperieur.setLayout(new GridLayout(1,2));
		conteneurButtonSuperieur.add(jButtonFilename);
		conteneurButtonSuperieur.add(jButtonLancerAlgo);
		
		JPanel conteneurButtonInferieur = new JPanel();
		conteneurButtonInferieur.setLayout(new GridLayout(1,2));
		conteneurButtonInferieur.add(jTextAreaNbFoisAlgorithmeGlouton);
		conteneurButtonInferieur.add(jButtonLancerAlgo1000);
		
		JPanel conteneurSaisie = new JPanel();
		conteneurSaisie.setLayout(new GridLayout(2,1));
		conteneurSaisie.add(conteneurButtonSuperieur);
		conteneurSaisie.add(conteneurButtonInferieur);
		
		JPanel conteneurGeneral = new JPanel();
		conteneurGeneral.setLayout(new BorderLayout());
		conteneurGeneral.add(conteneurInformation,BorderLayout.NORTH);
		conteneurGeneral.add(conteneurSaisie,BorderLayout.SOUTH);
		
		this.setTitle("Informations sur les instances");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,520);
		this.setLocation(300,100);
		this.setContentPane(conteneurGeneral);
		this.setVisible(b);
		
	}
	
	/* **************************************** */
	/* ********* Getteurs et Setteurs ********* */
	/* **************************************** */
	
	public JTextArea getjTextAreaInformations() {
		return jTextAreaInformations;
	}
	public void setjTextAreaInformations(JTextArea jTextAreaInformations) {
		this.jTextAreaInformations = jTextAreaInformations;
	}
	public JButton getjButtonFilename() {
		return jButtonFilename;
	}
	public void setjButtonFilename(JButton jButtonFilename) {
		this.jButtonFilename = jButtonFilename;
	}
	public JButton getjButtonLancerAlgo() {
		return jButtonLancerAlgo;
	}
	public void setjButtonLancerAlgo(JButton jButtonLancerAlgo) {
		this.jButtonLancerAlgo = jButtonLancerAlgo;
	}
	public JTextArea getjTextAreaNbFoisAlgorithmeGlouton() {
		return jTextAreaNbFoisAlgorithmeGlouton;
	}
	public void setjTextAreaNbFoisAlgorithmeGlouton(JTextArea jTextAreaNbFoisAlgorithmeGlouton) {
		this.jTextAreaNbFoisAlgorithmeGlouton = jTextAreaNbFoisAlgorithmeGlouton;
	}
	public JButton getjButtonLancerAlgo1000() {
		return jButtonLancerAlgo1000;
	}
	public void setjButtonLancerAlgo1000(JButton jButtonLancerAlgo1000) {
		this.jButtonLancerAlgo1000 = jButtonLancerAlgo1000;
	}
}
