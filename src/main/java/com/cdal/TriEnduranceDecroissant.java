package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Athlete
 * en fonction de leur endurance de manière décroissante
 */
public class TriEnduranceDecroissant implements Comparator<Athlete> {

    /**
     * Compare deux objets Athlete en fonction de leur endurance
     * @param a1 Le premier objet Athlete à comparer
     * @param a2 Le deuxième objet Athlete à comparer
     * @return Un entier négatif si l'endurance de a1 est supérieure à celle de a2
     *         un entier positif si l'endurance de a1 est inférieure à celle de a2
     *         et zéro si les deux athlètes ont la même endurance
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        int endurance1 = a1.getEndurance();
        int endurance2 = a2.getEndurance();
        return endurance2 - endurance1; // Ordre décroissant
    }
    
}
