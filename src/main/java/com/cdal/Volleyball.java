package main.java.com.cdal;

/**
 * La classe Volleyball représente le sport de volley-ball dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Volleyball extends Sport {
    private int scoreEquipe1; // Stocke le score de l'équipe 1
    private int scoreEquipe2; // Stocke le score de l'équipe 2

    /**
     * Constructeur de la classe Volleyball
     * @param nom Le nom du sport (ici, "Volleyball")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe de volley-ball
     */
    public Volleyball(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
        this.scoreEquipe1 = 0; 
        this.scoreEquipe2 = 0; 
    }

    /**
     * Enregistre le score de l'équipe 1
     * @param score Le score à enregistrer pour l'équipe 1
     */
    public void enregistrerScoreEquipe1(int score) {
        this.scoreEquipe1 = score;
    }

    /**
     * Enregistre le score de l'équipe 2
     * @param score Le score à enregistrer pour l'équipe 2
     */
    public void enregistrerScoreEquipe2(int score) {
        this.scoreEquipe2 = score;
    }

    /**
     * Obtient le score actuel de l'équipe 1
     * @return Le score actuel de l'équipe 1
     */
    public int getScoreEquipe1() {
        return scoreEquipe1;
    }

    /**
     * Obtient le score actuel de l'équipe 2
     * @return Le score actuel de l'équipe 2
     */
    public int getScoreEquipe2() {
        return scoreEquipe2;
    }

    /**
     * Affiche les scores des deux équipes.
     * @return Une chaîne de caractères décrivant les scores des deux équipes
     */
    public String score() {
        return "Scores - Équipe 1 : " + scoreEquipe1 + ", Équipe 2 : " + scoreEquipe2;
    }
}
