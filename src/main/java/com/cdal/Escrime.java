package main.java.com.cdal;

/**
 * La classe Escrime représente le sport d'escrime dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Escrime extends Sport {

    /**
     * Constructeur de la classe Escrime
     * @param nom Le nom du sport (ici, "Escrime")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe d'escrime (dans ce cas, individuel)
     */
    public Escrime(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
    }

}
