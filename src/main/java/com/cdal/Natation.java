package main.java.com.cdal;

/**
 * La classe Natation représente le sport de natation dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Natation extends Sport {
    private int minutes; // Stocke les minutes du temps du nageur
    private int secondes; // Stocke les secondes du temps du nageur

    /**
     * Constructeur de la classe Natation
     * @param nom Le nom du sport (ici, "Natation")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe de natation (dans ce cas, individuel)
     */
    public Natation(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
        this.minutes = 0;
        this.secondes = 0;
    }

    /**
     * Enregistre le temps de nage du nageur
     * @param minutes Les minutes du temps
     * @param secondes Les secondes du temps
     * @throws IllegalArgumentException si les minutes ou les secondes sont négatives,
     *         ou si les secondes dépassent 59
     */
    public void enregistrerTemps(int minutes, int secondes) throws IllegalArgumentException {
        if (minutes < 0 || secondes < 0 || secondes >= 60) {
            throw new IllegalArgumentException("Erreur : Le temps est invalide");
        }
        this.minutes = minutes;
        this.secondes = secondes;
    }

    /**
     * Obtient le temps de nage du nageur sous forme d'une chaîne de caractères
     * @return Le temps de nage du nageur au format "minutes minutes et secondes secondes"
     */
    public String getTemps() {
        return minutes + " minutes et " + secondes + " secondes";
    }

    /**
     * Affiche le temps de nage du nageur
     * @return Une chaîne de caractères décrivant le temps de nage en minutes et secondes
     */
    public String temps() {
        return "Temps actuel : " + minutes + " minutes " + secondes + " secondes";
    }
}
