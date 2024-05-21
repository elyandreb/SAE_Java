import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * La classe Equipe représente une équipe de sport composée d'athlètes
 * Elle implémente l'interface Participant
 */
public class Equipe implements Participant {
    private String nom; // Le nom de l'équipe
    private List<Athlete> athletes; // La liste des athlètes de l'équipe

    /**
     * Constructeur de la classe Equipe
     * @param nom Le nom de l'équipe
     * @throws IllegalArgumentException si le nom est vide ou null
     */
    public Equipe(String nom) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'équipe ne peut pas être vide ou null.");
        }
        this.nom = nom;
        this.athletes = new ArrayList<>();
    }
    
    /**
     * Méthode pour obtenir le nom de l'équipe
     * @return Le nom de l'équipe
     */
    @Override
    public String obtenirNom() {
        return this.nom;
    }

    /**
     * Méthode pour obtenir la liste des athlètes de l'équipe
     * @return La liste des athlètes de l'équipe
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Méthode pour obtenir le sexe de l'équipe
     * @return Le sexe de l'équipe (Masculine ou Féminine)
     */
    @Override
    public String obtenirSexe() {
        String sexe = this.athletes.get(0).obtenirSexe();
        for (int i = 0; i < this.athletes.size(); ++i) {
            if (this.athletes.get(i).obtenirSexe().equals("Homme")) {
                sexe = "Masculine";
            }
            else {
                sexe = "Féminine";
            }
        }
        return sexe;
    }

    /**
     * Méthode pour définir le nom de l'équipe
     * @param nouveauNom Le nouveau nom de l'équipe
     * @throws IllegalArgumentException si le nouveau nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'équipe ne peut pas être vide ou null.");
        }
        this.nom = nouveauNom;
    }

    /**
     * Méthode pour que l'équipe participe à une épreuve
     * @param epreuve L'épreuve à laquelle l'équipe participe
     */
    @Override
    public void participer(Epreuve epreuve) {
        System.out.println(this.nom + " participe à l'épreuve de " + epreuve.getNom());
    }

    /**
     * Méthode pour calculer le résultat moyen de l'équipe dans une épreuve
     * @param epreuve L'épreuve pour laquelle on calcule le résultat
     * @return Le résultat moyen de l'équipe dans l'épreuve
     */
    @Override
    public double resultat(Epreuve epreuve) {
        double res = 0;
        int cpt = 0;
        for (int i = 0; i < this.athletes.size(); ++i) {
            res += (athletes.get(i).getForce() + athletes.get(i).getAgilite() + athletes.get(i).getEndurance()) / 3;
            cpt += 1;
        }
        if (cpt == 0) {
            return 0;
        }
        System.out.println("Résultat moyen de l'équipe " + this.nom + " dans l'épreuve de " + epreuve.getNom() + " : " + res);
        return res / cpt;
    }

    /**
     * Ajoute un athlète à la liste des athlètes représentant le pays
     * @param nouvelleAthlete Le nouvel athlète à ajouter
     * @throws IllegalArgumentException si l'athlète est déjà présent dans la liste
     */
    public void ajouteAthlete(Athlete nouvelleAthlete) throws IllegalArgumentException {
        if (this.athletes.contains(nouvelleAthlete)) {
            throw new IllegalArgumentException("Erreur : L'athlète est déjà présent dans la liste des athlètes.");
        }
        else {
            this.athletes.add(nouvelleAthlete);
        }
    }

    /**
     * Supprime un athlète de la liste des athlètes représentant le pays
     * @param suppAthlete L'athlète à supprimer
     * @throws NoSuchElementException si la liste des athlètes est vide ou si l'athlète n'est pas présent
     */
    public void supprimeAthlete(Athlete suppAthlete) throws NoSuchElementException {
        if (this.athletes.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des athlètes est vide.");
        }
        if (!(this.athletes.contains(suppAthlete))) {
            throw new NoSuchElementException("Erreur : L'athlète n'est pas présent dans la liste des athlètes.");
        }
        else {
            this.athletes.remove(suppAthlete);
        }
    }

    /**
     * Recherche un athlète dans la liste des athlètes représentant le pays
     * @param rechAthlete L'athlète à rechercher
     * @return L'athlète recherché
     * @throws NoSuchElementException si la liste des athlètes est vide ou si l'athlète n'est pas présent
     */
    public Athlete rechercheAthlete(Athlete rechAthlete) throws NoSuchElementException {
        if (this.athletes.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des athlètes est vide.");
        }
        if (this.athletes.contains(rechAthlete)) {
            return rechAthlete;
        }
        throw new NoSuchElementException("Erreur : L'athlète n'est pas présent dans la liste des athlètes.");
    }

    /**
     * Méthode pour obtenir une représentation textuelle de l'équipe
     * @return Une chaîne de caractères représentant l'équipe
     */
    @Override 
    public String toString() {
        return "Le nom de l'équipe : " + this.obtenirNom() + ", Les athlètes de l'équipe : " + this.getAthletes();
    }

    /**
     * Méthode pour vérifier l'égalité entre deux équipes
     * @param objet L'objet à comparer avec l'équipe
     * @return true si les deux équipes sont égales, false sinon
     */
    @Override 
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (!(objet instanceof Equipe)) {
            return false;
        }
        Equipe e = (Equipe) objet;
        return this.nom.equals(e.nom) && this.athletes == e.athletes;
    }

}
