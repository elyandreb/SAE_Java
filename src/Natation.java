/**
 * La classe Natation représente le sport de natation dans le contexte des Jeux Olympiques
 * Elle hérite de la classe abstraite Sport
 */
public class Natation extends Sport {

    /**
     * Constructeur de la classe Natation
     * @param nom Le nom du sport (ici, "Natation")
     * @param categorie La catégorie du sport (individuel ou collectif)
     * @param nbjoueur Le nombre de joueurs dans une équipe de natation (dans ce cas, individuel)
     */
    public Natation(String nom, String categorie, int nbjoueur) {
        super(nom, categorie, nbjoueur);
    }

}
