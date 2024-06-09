package main.java.com.cdal;

/**
 * La classe Athlétisme représente le sport d'athlétisme dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Athletisme extends Sport {
    private int minutes; // Stocke les minutes du temps de l'athlète
    private int secondes; // Stocke les secondes du temps de l'athlète

    /**
     * Constructeur de la classe Athlétisme
     * @param nom Le nom du sport (ici, "Athlétisme")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe d'athlétisme (dans ce cas, individuel)
     */
    public Athletisme(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
        this.minutes = 0;
        this.secondes = 0;
    }

    /**
     * Enregistre le temps de la course de l'athlète
     * @param minutes Les minutes de la durée
     * @param secondes Les secondes de la durée
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
     * Affiche le temps de la course de l'athlète
     * @return Une chaîne de caractères décrivant le temps actuel en minutes et secondes
     */
    public String temps() {
        return "Temps actuel : " + minutes + " minutes " + secondes + " secondes";
    }
}