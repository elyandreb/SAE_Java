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
     * @throws IllegalArgumentException si le score est négatif
     */
    public void enregistrerScoreJoueur1(int score1) throws IllegalArgumentException {
        if (score1 < 0) {
            throw new IllegalArgumentException("Erreur : Le score est invalide.");
        }
        this.scoreJoueur1 = score1;
    }

    /**
     * Enregistre le score du joueur 1
     * @param score Le score à enregistrer pour le joueur 1
     * @throws IllegalArgumentException si le score est négatif
     */
    public void enregistrerScoreJoueur2(int score2) throws IllegalArgumentException {
        if (score2 < 0) {
            throw new IllegalArgumentException("Erreur : Le score est invalide.");
        }
        this.scoreJoueur2 = score2;
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
