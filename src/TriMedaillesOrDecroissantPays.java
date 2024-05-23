import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Pays
 * en fonction du nombre total de médailles d'or dans l'ordre décroissant
 */
public class TriMedaillesOrDecroissantPays implements Comparator<Pays> {

    /**
     * Compare deux objets Pays en fonction de leur nombre total de médailles d'or
     * @param p1 Le premier objet Pays à comparer
     * @param p2 Le deuxième objet Pays à comparer
     * @return Un entier négatif si p2 a moins de médailles d'or que p1
     *         un entier positif si p2 a plus de médailles d'or que p1
     *         et zéro si les deux ont le même nombre de médailles d'or
     */
    @Override
    public int compare(Pays p1, Pays p2) {
        int nbMedailles1 = p1.getNbMedaillesOr();
        int nbMedailles2 = p2.getNbMedaillesOr();
        return nbMedailles2 - nbMedailles1; // Ordre décroissant
    }
    
}
