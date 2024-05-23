import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Pays
 * en fonction du nombre total de médailles de bronze dans l'ordre décroissant
 */
public class TriMedaillesBronzeDecroissantPays implements Comparator<Pays> {

    /**
     * Compare deux objets Pays en fonction de leur nombre total de médailles de bronze
     * @param p1 Le premier objet Pays à comparer
     * @param p2 Le deuxième objet Pays à comparer
     * @return Un entier négatif si p2 a moins de médailles de bronze que p1
     *         un entier positif si p2 a plus de médailles bronze que p1 
     *         et zéro si les deux ont le même nombre de médailles bronze
     */
    @Override
    public int compare(Pays p1, Pays p2) {
        int nbMedailles1 = p1.getNbMedaillesBronze();
        int nbMedailles2 = p2.getNbMedaillesBronze();
        return nbMedailles2 - nbMedailles1; // Ordre décroissant
    }
    
}
