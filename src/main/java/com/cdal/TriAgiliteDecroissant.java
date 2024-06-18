package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Athlete
 * en fonction de leur agilité de manière décroissante
 */
public class TriAgiliteDecroissant implements Comparator<Athlete> {

    /**
     * Compare deux objets Athlete en fonction de leur agilité
     * @param a1 Le premier objet Athlete à comparer
     * @param a2 Le deuxième objet Athlete à comparer
     * @return Un entier négatif si l'agilité de a1 est supérieure à celle de a2
     *         un entier positif si l'agilité de a1 est inférieure à celle de a2
     *         et zéro si les deux athlètes ont la même agilité
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        int agilite1 = a1.getAgilite();
        int agilite2 = a2.getAgilite();
        return agilite2 - agilite1; // Ordre décroissant
    }
    
}
