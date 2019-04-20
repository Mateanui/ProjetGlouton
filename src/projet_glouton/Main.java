package projet_glouton;

public class Main {

	public static void main(String[] args) {
		Parseur parseur = new Parseur("instances/instance1.txt");
		parseur.lecture();
		parseur.affichage();
	}

}
