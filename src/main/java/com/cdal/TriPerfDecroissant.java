package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Athlete
 * en fonction de leur performance de manière décroissante
 */
public class TriPerfDecroissant implements Comparator<Athlete> {

    /**
     * Compare deux objets Athlete en fonction de leur performance
     * @param a1 Le premier objet Athlete à comparer
     * @param a2 Le deuxième objet Athlete à comparer
     * @return Un entier négatif si la performance de a1 est supérieure à celle de a2
     *         un entier positif si la performance de a1 est inférieure à celle de a2
     *         et zéro si les deux athlètes ont la même performance
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        double endurance1 = a1.perfAthlete();
        double endurance2 = a2.perfAthlete();
        return (int) (endurance2 - endurance1); // Ordre décroissant
    }
    
}
