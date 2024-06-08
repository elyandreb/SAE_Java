package main.java.com.cdal;

/**
 * La classe Handball représente le sport de handball dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Handball extends Sport {

    /**
     * Constructeur de la classe Handball
     * @param nom Le nom du sport (ici, "Handball")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe de handball
     */
    public Handball(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
    }

}
