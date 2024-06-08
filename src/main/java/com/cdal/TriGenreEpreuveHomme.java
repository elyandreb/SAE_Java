package main.java.com.cdal;

import java.util.Comparator;

/**
 * Cette classe implémente l'interface Comparator pour trier les objets Epreuve
 * en fonction de leur genre d'épreuve en plaçant les hommes avant les femmes
 */
public class TriGenreEpreuveHomme implements Comparator<Epreuve> {

    /**
     * Compare deux objets Epreuve en fonction de leur genre.
     * @param e1 Le premier objet Epreuve à comparer
     * @param e2 Le deuxième objet Epreuve à comparer
     * @return Un entier négatif si le genre de e1 est "M" et celui de e2 est "F"
     *         un entier positif si le genre de e1 est "F" et celui de e2 est "M"
     *         et zéro si les deux épreuves ont le même genre
     */
    @Override
    public int compare(Epreuve e1, Epreuve e2) {
        if (e1.getGenre().equals("M") && e2.getGenre().equals("F")) {
            return -1;
        } else if (e1.getGenre().equals("F") && e2.getGenre().equals("M")) {
            return 1;
        } else {
            return e1.getGenre().compareTo(e2.getGenre());
        }
    }
}
