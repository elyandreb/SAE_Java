package main.java.com.cdal;

/**
 * La classe Volleyball représente le sport de volley-ball dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Volleyball extends Sport {
    
    /**
     * Constructeur de la classe Volleyball
     * @param nom Le nom du sport (ici, "Volleyball")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe de volley-ball
     */
    public Volleyball(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
    }
    
}
