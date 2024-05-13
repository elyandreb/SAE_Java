import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * La classe Pays représente un pays participant aux Jeux Olympiques
 */
public class Pays {
    private String nom; // Le nom du pays
    private int nbMedaillesOr; // Le nombre de médailles d'or remportées par le pays
    private int nbMedaillesArgent; // Le nombre de médailles d'argent remportées par le pays
    private int nbMedaillesBronze; // Le nombre de médailles de bronze remportées par le pays
    private List<Equipe> equipes; // La liste des équipes représentant le pays
    private List<Athlete> athletes; // La liste des athlètes représentant le pays

    /**
     * Constructeur de la classe Pays
     * @param nom Le nom du pays
     * @param nbMedaillesOr Le nombre de médailles d'or
     * @param nbMedaillesArgent Le nombre de médailles d'argent
     * @param nbMedaillesBronze Le nombre de médailles de bronze
     * @throws IllegalArgumentException si le nom du pays est vide ou null
     */
    public Pays(String nom, int nbMedaillesOr, int nbMedaillesArgent, int nbMedaillesBronze) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom du pays ne peut pas être vide ou null.");
        }
        this.nom = nom;
        this.nbMedaillesOr = nbMedaillesOr;
        this.nbMedaillesArgent = nbMedaillesArgent;
        this.nbMedaillesBronze = nbMedaillesBronze;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    /**
     * Retourne le nom du pays
     * @return Le nom du pays
     */
    public String getNom() {
        return this.nom;
    } 

    /**
     * Retourne le nombre de médailles d'or du pays
     * @return Le nombre de médailles d'or du pays
     */
    public int getNbMedaillesOr() {
        return this.nbMedaillesOr;
    }

    /**
     * Retourne le nombre de médailles d'argent du pays
     * @return Le nombre de médailles d'argent du pays
     */
    public int getNbMedaillesArgent() {
        return this.nbMedaillesArgent;
    }

    /**
     * Retourne le nombre de médailles de bronze du pays
     * @return Le nombre de médailles de bronze du pays
     */
    public int getNbMedaillesBronze() {
        return this.nbMedaillesBronze;
    }

    /**
     * Retourne la liste des équipes représentant le pays
     * @return La liste des équipes représentant le pays
     */
    public List<Equipe> getEquipes() {
        return this.equipes;
    }

    /**
     * Retourne la liste des athlètes représentant le pays
     * @return La liste des athlètes représentant le pays
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Définit le nom du pays
     * @param nouveauNom Le nouveau nom du pays
     * @throws IllegalArgumentException si le nouveau nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nouveauNom.equals(null) || nouveauNom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom du pays ne peut pas être vide ou null.");
        }
        else {
            this.nom = nouveauNom;
        }
    }

    /**
     * Définit le nombre de médailles d'or du pays
     * @param nouvellesMedaillesOr Le nouveau nombre de médailles d'or
     */
    public void setNbMedaillesOr(int nouvellesMedaillesOr) {
        this.nbMedaillesOr = nouvellesMedaillesOr;
    }

    /**
     * Définit le nombre de médailles d'argent du pays
     * @param nouvellesMedaillesArgent Le nouveau nombre de médailles d'argent
     */
    public void setNbMedaillesArgent(int nouvellesMedaillesArgent) {
        this.nbMedaillesArgent = nouvellesMedaillesArgent;
    }

    /**
     * Définit le nombre de médailles de bronze du pays
     * @param nouvellesMedaillesBronze Le nouveau nombre de médailles de bronze
     */
    public void setNbMedaillesBronze(int nouvellesMedaillesBronze) {
        this.nbMedaillesBronze = nouvellesMedaillesBronze;
    }

    /**
     * Calcul le nombre total de médailles remporté par une nation
     * @return Le nombre total de médailles remportée par une nation
     */
    public int nbMedaillesTotal() {
        return this.getNbMedaillesOr() + this.getNbMedaillesArgent() + this.getNbMedaillesBronze();
    }

    /**
     * Retourne le nombre d'équipes représentant le pays
     * @return Le nombre d'équipes représentant le pays
     */
    public int nbEquipes() {
        return this.equipes.size();
    }

    /**
     * Retourne le nombre d'athlètes représentant le pays
     * @return Le nombre d'athlètes représentant le pays
     */
    public int nbAthletes() {
        return this.athletes.size();
    }

    /**
     * Ajoute une équipe à la liste des équipes représentant le pays
     * @param nouvelleEquipe La nouvelle équipe à ajouter
     * @throws IllegalArgumentException si l'équipe est déjà présente dans la liste
     */
    public void ajouteEquipe(Equipe nouvelleEquipe) throws IllegalArgumentException {
        if (this.equipes.contains(nouvelleEquipe)) {
            throw new IllegalArgumentException("Erreur : L'équipe est déjà présent dans la liste des équipes.");
        }                
        else {
            this.equipes.add(nouvelleEquipe);
        }
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
     * Supprime une équipe de la liste des équipes représentant le pays
     * @param suppEquipe L'équipe à supprimer
     * @throws NoSuchElementException si la liste des équipes est vide ou si l'équipe n'est pas présente
     */
    public void supprimeEquipe(Equipe suppEquipe) throws NoSuchElementException {
        if (this.equipes.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des équipes est vide.");
        }
        if (!(this.equipes.contains(suppEquipe))) {
            throw new NoSuchElementException("Erreur : L'équipe n'est pas présente dans liste des équipes.");
        }
        this.equipes.remove(suppEquipe);
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
     * Recherche une équipe dans la liste des équipes représentant le pays
     * @param rechEquipe L'équipe à rechercher
     * @return L'équipe recherchée
     * @throws NoSuchElementException si la liste des équipes est vide ou si l'équipe n'est pas présente
     */
    public Equipe rechercheEquipe(Equipe rechEquipe) throws NoSuchElementException {
        if (this.equipes.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des équipes est vide.");
        }
        if (this.equipes.contains(rechEquipe)) {
            return rechEquipe;
        }
        throw new NoSuchElementException("Erreur : L'équipe n'est pas présente dans liste des équipes.");
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
     * Compare ce pays à un autre pays pour déterminer leur ordre relatif basé sur le nom
     * @param pays Le pays à comparer avec
     * @return Un entier négatif si le nom de ce pays est avant le nom de l'autre pays dans l'ordre alphabétique, un entier positif si le nom de ce pays est après le nom de l'autre pays, et zéro si les deux pays ont le même nom
     */
    @Override
    public int compareTo(Pays pays) {
        return this.getNom().compareTo(pays.getNom());
    }

    /**
     * Retourne une représentation textuelle de l'objet Pays
     * @return Une chaîne de caractères représentant le pays
     */
    @Override
    public String toString() {
        return "Le nom du pays : " + this.getNom() + ", Le nombre de médailles d'or : " + this.getNbMedaillesOr() + ", Le nombre de médailles d'argent : " + this.getNbMedaillesArgent() + ", Le nombre de médailles de bronze : " + this.getNbMedaillesBronze() + ", La liste des équipes : " + this.getEquipes() + ", La liste des athlètes : " + this.getAthletes();
    }

    /**
     * Vérifie l'égalité entre deux objets Pays
     * @param objet L'objet à comparer
     * @return true si les deux objets sont égaux et false sinon
     */
    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (!(objet instanceof Pays)) {
            return false;
        }
        Pays pays = (Pays) objet;
        return pays.nom.equals(this.nom) && pays.nbMedaillesOr == this.nbMedaillesOr && pays.nbMedaillesArgent == this.nbMedaillesArgent && pays.nbMedaillesBronze == this.nbMedaillesBronze && pays.equipes == this.equipes && pays.athletes == this.athletes;
    }
    
}
