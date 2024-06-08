package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Athlete
 * en fonction de leur force de manière décroissante
 */
public class TriForceDecroissant implements Comparator<Athlete> {

    /**
     * Compare deux objets Athlete en fonction de leur force
     * @param a1 Le premier objet Athlete à comparer
     * @param a2 Le deuxième objet Athlete à comparer
     * @return Un entier négatif si la force de a1 est supérieure à celle de a2
     *         un entier positif si la force de a1 est inférieure à celle de a2
     *         et zéro si les deux athlètes ont la même force
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        int force1 = a1.getForce();
        int force2 = a2.getForce();
        return force2 - force1; // Ordre décroissant
    }
    
}
