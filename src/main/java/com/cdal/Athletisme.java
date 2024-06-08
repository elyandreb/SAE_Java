package main.java.com.cdal;

/**
 * La classe Athlétisme représente le sport d'athlétisme dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Athletisme extends Sport {

    /**
     * Constructeur de la classe Athlétisme
     * @param nom Le nom du sport (ici, "Athlétisme")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe d'athlétisme (dans ce cas, individuel)
     */
    public Athletisme(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
    }

}
