package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Athlete
 * en fonction de leur sexe en plaçant les femmes avant les hommes
 */
public class TriSexeFemme implements Comparator<Athlete> {

    /**
     * Compare deux objets Athlete en fonction de leur sexe
     * @param a1 Le premier objet Athlete à comparer
     * @param a2 Le deuxième objet Athlete à comparer
     * @return Un entier négatif si le sexe de a1 est "Femme" et celui de a2 est "Homme"
     *         un entier positif si le sexe de a1 est "Homme" et celui de a2 est "Femme"
     *         et zéro si les deux athlètes ont le même sexe
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        if (a1.obtenirSexe().equals("Femme") && a2.obtenirSexe().equals("Homme")) {
            return -1;
        } else if (a1.obtenirSexe().equals("Homme") && a2.obtenirSexe().equals("Femme")) {
            return 1;
        } else {
            return a1.obtenirSexe().compareTo(a2.obtenirSexe());
        }
    }
    
}
