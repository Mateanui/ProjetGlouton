package glouton.main;

import glouton.controleur.Controleur;
import glouton.model.AlgorithmeGlouton;
import glouton.vue.VueGenerale;

public class Main {

	public static void main(String[] args) {		
		AlgorithmeGlouton algo = new AlgorithmeGlouton("instances/instance1.txt");
		algo.initGenerale();
		algo.algorithmeGlouton();
		
		Controleur controleur = new Controleur(algo);
		@SuppressWarnings("unused")
		VueGenerale vueGenerale = new VueGenerale(controleur);
	}
}