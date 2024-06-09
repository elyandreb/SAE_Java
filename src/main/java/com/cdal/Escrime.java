package main.java.com.cdal;

/**
 * La classe Escrime représente le sport d'escrime dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Escrime extends Sport {
    private int scoreJoueur1; // Stocke le score du joueur 1
    private int scoreJoueur2; // Stocke le score du joueur 2

    /**
     * Constructeur de la classe Escrime.
     * @param nom Le nom du sport (ici, "Escrime")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe d'escrime (dans ce cas, individuel)
     */
    public Escrime(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
        this.scoreJoueur1 = 0; 
        this.scoreJoueur2 = 0; 
    }

    /**
     * Enregistre le score du joueur 1
     * @param score Le score à enregistrer pour le joueur 1
     */
    public void enregistrerScoreJoueur1(int score) {
        this.scoreJoueur1 = score;
    }

    /**
     * Enregistre le score du joueur 2
     * @param score Le score à enregistrer pour le joueur 2
     */
    public void enregistrerScoreJoueur2(int score) {
        this.scoreJoueur2 = score;
    }

    /**
     * Obtient le score actuel du joueur 1
     * @return Le score actuel du joueur 1
     */
    public int getScoreJoueur1() {
        return scoreJoueur1;
    }

    /**
     * Obtient le score actuel du joueur 2
     * @return Le score actuel du joueur 2
     */
    public int getScoreJoueur2() {
        return scoreJoueur2;
    }

    /**
     * Affiche les scores des deux joueurs
     * @return Une chaîne de caractères décrivant les scores des deux joueurs
     */
    public String score() {
        return "Scores - Joueur 1 : " + scoreJoueur1 + ", Joueur 2 : " + scoreJoueur2;
    }
}
