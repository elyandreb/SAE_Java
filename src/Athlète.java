/**
 * La classe Athlete représente un athlète participant à des épreuves sportives
 * Elle implémente l'interface Participant
 */
public class Athlete implements Participant {
    private String nom; // Le nom de l'athlète
    private String prenom; // Le prénom de l'athlète
    private String sexe; // Le sexe de l'athlète
    private int force; // La force de l'athlète
    private int agilite; // L'agilité de l'athlète
    private int endurance; // L'endurance de l'athlète

    /**
     * Constructeur de la classe Athlete
     * @param nom Le nom de l'athlète
     * @param prenom Le prénom de l'athlète
     * @param sexe Le sexe de l'athlète ("Homme" ou "Femme")
     * @param force La force de l'athlète
     * @param agilite L'agilité de l'athlète
     * @param endurance L'endurance de l'athlète
     * @throws IllegalArgumentException Si l'un des paramètres est invalide
     */
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'athlète ne peut pas être vide ou null");
        }
        if (prenom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le prénom de l'athlète ne peut pas être vide ou null");
        }
        if (!(sexe.equals("Homme") || sexe.equals("Femme"))) {
            throw new IllegalArgumentException("Erreur : Le format du sexe n'est pas respecter");
        }
        if (sexe.equals(null) || sexe.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le sexe ne peut pas être vide ou null");
        }
        if (force < 0) {
            throw new IllegalArgumentException("Erreur : La force ne peut pas être une valeur négative.");
        }
        if (agilite < 0) {
            throw new IllegalArgumentException("Erreur : L'agilité ne peut pas être une valeur négative.");
        }
        if (endurance < 0) {
            throw new IllegalArgumentException("Erreur : L'endurance ne peut pas être une valeur négative.");
        } 
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
    }

    /**
     * Méthode pour obtenir le nom de l'athlète
     * @return Le nom de l'athlète
     */
    @Override
    public String obtenirNom() {
        return this.nom;
    }

    /**
     * Méthode pour obtenir le prénom de l'athlète
     * @return Le prénom de l'athlète
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Méthode pour obtenir le sexe de l'athlète
     * @return Le sexe de l'athlète
     */
    @Override
    public String obtenirSexe() {
        return this.sexe;
    }

    /**
     * Méthode pour obtenir la force de l'athlète
     * @return La force de l'athlète
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Méthode pour obtenir l'agilité de l'athlète
     * @return L'agilité de l'athlète
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Méthode pour obtenir l'endurance de l'athlète
     * @return L'endurance de l'athlète
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Méthode pour définir le nom de l'athlète
     * @param nom Le nouveau nom de l'athlète
     * @throws IllegalArgumentException Si le nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nouveauNom.equals(null) || nouveauNom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'athlète ne peut pas être vide ou null");
        }
        this.nom = nouveauNom;
    }

    /**
     * Méthode pour définir le prénom de l'athlète
     * @param prenom Le nouveau prénom de l'athlète
     * @throws IllegalArgumentException Si le prénom est vide ou null
     */
    public void setPrenom(String nouveauPrenom) throws IllegalArgumentException {
        if (nouveauPrenom.equals(null) || nouveauPrenom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le prénom de l'athlète ne peut pas être vide ou null");
        }
        this.prenom = nouveauPrenom;
    }
    
    /**
     * Méthode pour définir le sexe de l'athlète
     * @param sexe Le nouveau sexe de l'athlète ("Homme" ou "Femme")
     * @throws IllegalArgumentException Si le format du sexe n'est pas respecté ou si le sexe est vide ou null
     */
    public void setSexe(String nouveauSexe) throws IllegalArgumentException {
        if (!(nouveauSexe.equals("Homme")) || !(nouveauSexe.equals("Femme"))) {
            throw new IllegalArgumentException("Erreur : Le format du sexe n'est pas respecter");
        }
        if (nouveauSexe.equals(null) || nouveauSexe.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le sexe ne peut pas être vide ou null");
        }
        this.sexe = nouveauSexe;
    }

    /**
     * Méthode pour définir la force de l'athlète
     * @param force La nouvelle force de l'athlète
     * @throws IllegalArgumentException Si la force est une valeur négative
     */
    public void setForce(int nouvelleForce) throws IllegalArgumentException {
        if (nouvelleForce < 0) {
            throw new IllegalArgumentException("Erreur : La force ne peut pas être une valeur négative.");
        }
        this.force = nouvelleForce;
    }

    /**
     * Méthode pour définir l'agilité de l'athlète
     * @param agilite La nouvelle agilité de l'athlète
     * @throws IllegalArgumentException Si l'agilité est une valeur négative
     */
    public void setAgilite(int nouvelleAgilite) throws IllegalArgumentException {
        if (nouvelleAgilite < 0) {
            throw new IllegalArgumentException("Erreur : L'agilité ne peut pas être une valeur négative.");
        }
        this.agilite = nouvelleAgilite;
    }

    /**
     * Méthode pour définir l'endurance de l'athlète
     * @param endurance La nouvelle endurance de l'athlète
     * @throws IllegalArgumentException Si l'endurance est une valeur négative
     */
    public void setEndurance(int nouvelleEndurance) throws IllegalArgumentException {
        if (nouvelleEndurance < 0) {
            throw new IllegalArgumentException("Erreur : L'endurance ne peut pas être une valeur négative.");
        }    
        this.endurance = nouvelleEndurance;
    }

    /**
     * Méthode pour que l'athlète participe à une épreuve
     * @param epreuve L'épreuve à laquelle l'athlète participe
     */
    @Override
    public void participer(Epreuve epreuve) {
        System.out.println(this.nom + " participe à l'épreuve de " + epreuve.getNom());
    }

    /**
     * Méthode pour obtenir le résultat de l'athlète dans une épreuve
     * @param epreuve L'épreuve pour laquelle on souhaite obtenir le résultat
     * @return Le résultat de l'athlète dans l'épreuve
     */
    @Override 
    public double resultat(Epreuve epreuve) {
        double res = (this.force + this.agilite + this.endurance) / 3;
        System.out.println("Résultat de " + this.nom + " dans l'épreuve de " + epreuve.getNom() + " : " + res);
        return res;
    }

    /**
     * Méthode pour obtenir une représentation textuelle de l'athlète
     * @return Une chaîne de caractères représentant l'athlète
     */
    @Override
    public String toString() {
        return "Le nom de l'athlète : " + this.obtenirNom() + ", Le prénom de l'athlète : " + this.getPrenom() + ", Le sexe de l'athlète : " + this.obtenirSexe() + ", La force de l'athlète : " + this.getForce() + ", L'agilité de l'athlète : " + this.getAgilite() + ", L'endurance de l'athlète : " + this.getEndurance();
    }

    /**
     * Méthode pour vérifier l'égalité entre deux athlètes
     * @param objet L'objet à comparer avec l'athlète
     * @return true si les deux athlètes sont égaux, false sinon
     */
    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (!(objet instanceof Athlete)) {
            return false;
        }
        Athlete athlete = (Athlete) objet;
        return this.nom.equals(athlete.nom) && this.prenom.equals(athlete.prenom) && this.sexe.equals(athlete.sexe) && this.force == athlete.force && this.agilite == athlete.agilite && this.endurance == athlete.endurance;
    }

}
