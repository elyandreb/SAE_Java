package main.java.com.cdal;

import java.util.Collections;
import java.util.List;

/**
 * La classe Athlete représente un athlète participant à des épreuves sportives
 * Elle implémente l'interface Participant
 */
public class Athlete implements Participant, Comparable<Athlete> {
    private String nom; // Le nom de l'athlète
    private String prenom; // Le prénom de l'athlète
    private String sexe; // Le sexe de l'athlète
    private int force; // La force de l'athlète
    private int agilite; // L'agilité de l'athlète
    private int endurance; // L'endurance de l'athlète
    private final Pays pays; // Le pays auquel l'athlète appartient
    private final Boolean estEquipe; //Savoir si l'athlète fait partie d'une équipe

    /**
     * Constructeur de la classe Athlete
     * @param nom Le nom de l'athlète
     * @param prenom Le prénom de l'athlète
     * @param sexe Le sexe de l'athlète ("H" ou "F")
     * @param force La force de l'athlète
     * @param agilite L'agilité de l'athlète
     * @param endurance L'endurance de l'athlète
     * @param pays Le pays de l'athlète
     * @param estEquipe Boolean pour savoir si l'athlète fait partie d'une équipe
     * @throws IllegalArgumentException Si l'un des paramètres est invalide
     */
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, Pays pays, Boolean estEquipe) throws IllegalArgumentException {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'athlète ne peut pas être vide ou null.");
        }
        if (prenom == null || prenom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le prénom de l'athlète ne peut pas être vide ou null.");
        }
        if (!(sexe.equals("H") || sexe.equals("F"))) {
            throw new IllegalArgumentException("Erreur : Le format du sexe n'est pas respecter.");
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
        this.pays = pays;
        this.estEquipe = estEquipe;
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
     * Méthode pour obtenir le pays de l'athlète
     * @return L'endurance de l'athlète
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Méthode pour obtenir le pays de l'athlète
     * @return L'endurance de l'athlète
     */
    public boolean getEstEquipe() {
        return this.estEquipe;
    }


    /**
     * Méthode pour définir le nom de l'athlète
     * @param nom Le nouveau nom de l'athlète
     * @throws IllegalArgumentException Si le nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nouveauNom == null || nouveauNom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'athlète ne peut pas être vide ou null.");
        }
        this.nom = nouveauNom;
    }

    /**
     * Méthode pour définir le prénom de l'athlète
     * @param prenom Le nouveau prénom de l'athlète
     * @throws IllegalArgumentException Si le prénom est vide ou null
     */
    public void setPrenom(String nouveauPrenom) throws IllegalArgumentException {
        if (nouveauPrenom == null || nouveauPrenom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le prénom de l'athlète ne peut pas être vide ou null.");
        }
        this.prenom = nouveauPrenom;
    }
    
    /**
     * Méthode pour définir le sexe de l'athlète
     * @param sexe Le nouveau sexe de l'athlète ("H" ou "F")
     * @throws IllegalArgumentException Si le format du sexe n'est pas respecté ou si le sexe est vide ou null
     */
    public void setSexe(String nouveauSexe) throws IllegalArgumentException {
        if (!(nouveauSexe.equals("H") || nouveauSexe.equals("F"))) {
            throw new IllegalArgumentException("Erreur : Le format du sexe n'est pas respecter.");
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
     * Méthode pour obteniir les performances moyennes de l'athlète
     * @return Une valeur moyenne représentant les performances de l'athlète
     */
    public double perfAthlete() {
        return ((this.force + this.agilite + this.endurance)/3);
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
        double res = ((this.force + this.agilite + this.endurance) / 3);
        System.out.println("Résultat de " + this.nom + " dans l'épreuve de " + epreuve.getNom() + " : " + res);
        return res;
    }

    /**
     * Trie la liste d'athlètes en fonction de leur force de manière croissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triForceCroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriForceCroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur force de manière décroissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triForceDecroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriForceDecroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur agilité de manière croissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triAgiliteCroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriAgiliteCroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur agilité de manière décroissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triAgiliteDecroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriAgiliteDecroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur endurance de manière croissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triEnduranceCroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriEnduranceCroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur endurance de manière décroissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triEnduranceDecroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriEnduranceDecroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur performance de manière croissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triPerfCroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriPerfCroissant());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur performance de manière décroissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triPerfDecroissant(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriPerfDecroissant());
    }

    /**
     * Trie la liste d'athlètes en plaçant les hommes avant les femmes
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triSexeHomme(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriSexeHomme());
    }

    /**
     * Trie la liste d'athlètes en plaçant les femmes avant les hommes
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triSexeFemme(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete, new TriSexeFemme());
    }

    /**
     * Trie la liste d'athlètes en fonction de leur nom de manière alphabétique croissante
     * @param listeAthlete La liste d'athlètes à trier
     */
    public static void triNomAthlete(List<Athlete> listeAthlete) {
        Collections.sort(listeAthlete);
    }

    /**
     * Compare cette athlète à un autre athlète pour déterminer leur ordre relatif basé sur le nom
     * @param pays L'athlète à comparer
     * @return Un entier négatif si le nom de cette athhlète est avant le nom de l'autre athlète dans l'ordre alphabétique, un entier positif si le nom de cette athlète est après le nom de l'autre athlète, et zéro si les deux athlètes ont le même nom
     */
    @Override
    public int compareTo(Athlete athlete) {
        return this.obtenirNom().compareTo(athlete.obtenirNom());
    }

    /**
     * Obtient une représentation textuelle de l'athlète
     * @return Une chaîne de caractères représentant l'athlète
     */
    @Override
    public String toString() {
        return "Nom : " + this.obtenirNom() + ", Prénom : " + this.getPrenom() + 
            ", Sexe : " + this.obtenirSexe() + ", Force : " + this.getForce() + 
            ", Agilité : " + this.getAgilite() + ", Endurance : " + this.getEndurance()+ ", Pays : " + this.getPays() + "Dans une équipe ? "+this.getEstEquipe();
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
        return this.nom.equals(athlete.nom) && this.prenom.equals(athlete.prenom) && this.sexe.equals(athlete.sexe) && this.force == athlete.force && this.agilite == athlete.agilite && this.endurance == athlete.endurance && this.pays.equals(athlete.pays) && this.estEquipe.equals(athlete.estEquipe);
    }
    /**
     * Méthode pour obtenir le code de hachage de l'athlète
     * @return Le code de hachage de l'athlète
     */
    @Override
    public int hashCode() {
        return this.nom.hashCode() + this.prenom.hashCode() + this.sexe.hashCode() + this.force + this.agilite + this.endurance + this.pays.hashCode() + this.estEquipe.hashCode();
    }


}
