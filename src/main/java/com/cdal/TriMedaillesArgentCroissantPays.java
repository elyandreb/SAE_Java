package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Pays
 * en fonction du nombre total de médailles d'argent dans l'ordre croissant
 */
public class TriMedaillesArgentCroissantPays implements Comparator<Pays> {

    /**
     * Compare deux objets Pays en fonction de leur nombre total de médailles d'argent
     * @param p1 Le premier objet Pays à comparer
     * @param p2 Le deuxième objet Pays à comparer
     * @return Un entier négatif si p1 a moins de médailles d'argent que p2
     *         un entier positif si p1 a plus de médailles d'argent que p2 
     *         et zéro si les deux ont le même nombre de médailles d'argent
     */
    @Override
    public int compare(Pays p1, Pays p2) {
        int nbMedailles1 = p1.getNbMedaillesArgent();
        int nbMedailles2 = p2.getNbMedaillesArgent();
        return nbMedailles1 - nbMedailles2; // Ordre croissant
    }

}
