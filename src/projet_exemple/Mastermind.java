package projet_exemple;

/**
 * Classe Mastermind
 */
public class Mastermind {
	protected final Serie solution;
	private int nombresEssais;
        public boolean win = false;
	


	public Mastermind() {
		solution = new Serie();
	}

	public Serie getSolution() {
		return this.solution;
	}

	public int getNombreEssais() {
		return this.nombresEssais;
	}

	/**
	 * Methode Essayer qui compare l'ordre des couleurs
	 *
	 * @param uneSérie
	 * @return
	 */
	public String essayer(Serie uneSérie) {
		
		return "";
	}

	public boolean isWin() {
		return win;
	}

	/**
	 * Methode ToString qui renvoit tout les essaiTenté
	 * @return essaiTenté
	 */
	public String toString() {
		String str = "";
                for (int i = 0; i < 4; i++) {
                    str += solution.getAbréviation(solution.getCouleur(i));
                }
                return str;
	}
}

	



