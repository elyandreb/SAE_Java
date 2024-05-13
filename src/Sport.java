/**
 * La classe abstraite Sport représente un sport avec ses caractéristiques telles que le nom, la catégorie et le nombre de joueurs
 */
public abstract class Sport {
    protected String nom; // Le nom du sport
    protected String categorie; // La catégorie du sport (M pour masculin, F pour féminin)
    protected int nbjoueur; // Le nombre du joueurs du sport

    /**
     * Constructeur de la classe Sport
     * @param nom Le nom du sport
     * @param categorie La catégorie du sport (M pour masculin, F pour féminin)
     * @param nbjoueur Le nombre de joueurs du sport.
     * @throws IllegalArgumentException si le nom est vide ou null
     *                                  si la catégorie n'est pas "M" ou "F"
     *                                  ou si le nombre de joueurs est négatif ou null
     */
    public Sport(String nom, String categorie, int nbjoueur) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom du sport ne doit pas être vide ou null.");
        }
        if (!(categorie.equals("M") || categorie.equals("F"))) {
            throw new IllegalArgumentException("Erreur : Le format de catégorie n'est pas respecté.");
        }
        if (categorie.equals(null) || categorie.isEmpty()) {
            throw new IllegalArgumentException("Erreur : La catégorie ne peut pas être vide ou null");
        }
        if (nbjoueur < 1) {
            throw new IllegalArgumentException("Erreur : Le nombre de joueurs ne peut pas être négatif ou null.");
        }
        this.nom = nom;
        this.categorie = categorie;
        this.nbjoueur = nbjoueur;
    }

    /**
     * Retourne le nom du sport
     * @return Le nom du sport
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne la catégorie du sport
     * @return La catégorie du sport
     */
    public String getCategorie() {
        return this.categorie;
    }

     /**
     * Retourne le nombre de joueurs du sport
     * @return Le nombre de joueurs du sport
     */
    public int getNbJoueur() {
        return this.nbjoueur;
    }

    /**
     * Modifie le nom du sport
     * @param nouveauNom Le nouveau nom du sport
     * @throws IllegalArgumentException si le nouveau nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nom.equals(null) || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom du sport ne doit pas être vide ou null.");
        }
        this.nom = nouveauNom;
    }

    /**
     * Modifie la catégorie du sport
     * @param nouvelleCategorie La nouvelle catégorie du sport
     * @throws IllegalArgumentException si la nouvelle catégorie n'est pas "M" ou "F"
     *                                  ou si elle est vide ou null
     */
    public void setCategorie(String nouvelleCategorie) throws IllegalArgumentException {
        if (!(categorie.equals("M") || categorie.equals("F"))) {
            throw new IllegalArgumentException("Erreur : Le format de catégorie n'est pas respecté.");
        }
        if (categorie.equals(null) || categorie.isEmpty()) {
            throw new IllegalArgumentException("Erreur : La catégorie ne peut pas être vide ou null");
        }
        this.categorie = nouvelleCategorie;
    }

    /**
     * Modifie le nombre de joueurs du sport
     * @param nouveauNbjoueur Le nouveau nombre de joueurs du sport
     * @throws IllegalArgumentException si le nouveau nombre de joueurs est négatif ou null
     */
    public void setNbJoueur(int nouveauNbjoueur) {
        if (nbjoueur < 1) {
            throw new IllegalArgumentException("Erreur : Le nombre de joueurs ne peut pas être négatif ou null.");
        }
        this.nbjoueur = nouveauNbjoueur;
    }

    /**
     * Redéfinition de la méthode toString pour afficher les informations du sport
     * @return Une chaîne représentant les informations du sport
     */
    @Override
    public String toString(){
        return "Le nom du sport : " + this.getNom() + ", La catégorie du sport : " + this.getCategorie() + ", Le nombre de joueur du sport : " + this.getNbJoueur();        
    }

    /**
     * Redéfinition de la méthode equals pour comparer deux sports
     * @param objet L'objet à comparer avec le sport actuel
     * @return true si les deux sports sont identiques, false sinon
     */
    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (!(objet instanceof Sport)) {
            return false;
        }
        Sport sport = (Sport) objet;
        return sport.nom.equals(this.nom) && sport.categorie.equals(this.categorie) && sport.nbjoueur == this.nbjoueur;
    }
    
}
