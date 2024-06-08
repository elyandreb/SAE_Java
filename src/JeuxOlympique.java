import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * La classe JeuxOlympique représente un événement olympique comprenant des participants, des pays et des épreuves
 */
public class JeuxOlympique {
    private String nom; // Nom de l'événement olympique
    private int annee; // Année de l'événement olympique
    private String ville; // Ville hôte de l'événement olympique
    private List<Participant> participants; // Liste des participants aux Jeux Olympiques
    private List<Pays> pays; // Liste des pays représentés aux Jeux Olympiques
    private List<Epreuve> epreuves; // Liste des épreuves organisées aux Jeux Olympiques

    /**
     * Constructeur de la classe JeuxOlympique
     * @param nom Nom de l'événement olympique
     * @param annee Année de l'événement olympique
     * @param ville Ville hôte de l'événement olympique
     * @throws IllegalArgumentException si l'année n'est pas multiple de 4 ou si le nom ou la ville est vide
     */
    public JeuxOlympique(String nom, int annee, String ville) throws IllegalArgumentException {
        if (annee % 4 != 0) {
            throw new IllegalArgumentException("Erreur : Les Jeux Olympiques doivent avoir lieu tous les quatre ans et à des années spécifique.");
        }
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'événement olympique ne peut pas être vide.");
        }
        if (ville == null || ville.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de la ville hôte ne peut pas être vide.");
        }
        this.nom = nom;
        this.annee = annee;
        this.ville = ville;
        this.participants = new ArrayList<>();
        this.pays = new ArrayList<>();
        this.epreuves = new ArrayList<>();
    }

    /**
     * Retourne le nom de l'événement olympique
     * @return Le nom de l'événement olympique
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne l'année de l'événement olympique
     * @return L'année de l'événement olympique
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Retourne la ville hôte de l'événement olympique
     * @return La ville hôte de l'événement olympique
     */
    public String getVille() {
        return this.ville;
    }

    /**
     * Retourne la liste des participants des Jeux Olympiques
     * @return La liste des participants des Jeux Olympiques
     */
    public List<Participant> getParticipants() {
        return this.participants;
    } 

    /**
     * Retourne la liste des pays représentés aux Jeux Olympiques
     * @return La liste des pays représentés aux Jeux Olympiques
     */
    public List<Pays> getPays() {
        return this.pays;
    } 

    /**
     * Retourne la liste des épreuves organisées aux Jeux Olympiques
     * @return La liste des épreuves organisées aux Jeux Olympiques
     */
    public List<Epreuve> getEpreuves() {
        return this.epreuves;
    }
    
    /**
     * Modifie le nom de l'événement olympique
     * @param nouveauNom Le nouveau nom de l'événement olympique
     * @throws IllegalArgumentException si le nouveau nom est vide ou null
     */
    public void setNom(String nouveauNom) throws IllegalArgumentException {
        if (nouveauNom == null || nouveauNom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'événement olympique ne peut pas être vide.");
        }
        else {
            this.nom = nouveauNom;
        }
    }

    /**
     * Modifie l'année de l'événement olympique
     * @param nouvelleAnnee La nouvelle année de l'événement olympique
     * @throws IllegalArgumentException si la nouvelle année n'est pas multiple de 4
     */
    public void setAnnee(int nouvelleAnnee) throws IllegalArgumentException {
        if (nouvelleAnnee % 4 == 0) {
            this.annee = nouvelleAnnee;
        }
        else {
            throw new IllegalArgumentException("Erreur : Les Jeux Olympiques doivent avoir lieu tous les quatre ans et à des années spécifique.");
        }
    }

    /**
     * Modifie la ville hôte de l'événement olympique.
     * @param nouvelleVille La nouvelle ville hôte de l'événement olympique
     * @throws IllegalArgumentException si la nouvelle ville est vide ou null
     */
    public void setVille(String nouvelleVille) throws IllegalArgumentException {
        if (nouvelleVille == null || nouvelleVille.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de la ville hôte ne peut pas être vide.");
        }
        else {
            this.ville = nouvelleVille;
        }
    }

    /**
     * Retourne le nombre de participants aux Jeux Olympiques
     * @return Le nombre de participants aux Jeux Olympiques
     */
    public int nbParticipants() {
        return this.participants.size();
    }

    /**
     * Retourne le nombre de pays représentés aux Jeux Olympiques
     * @return Le nombre de pays représentés aux Jeux Olympiques
     */
    public int nbPays() {
        return this.pays.size();
    }

    /**
     * Retourne le nombre d'épreuves organisées aux Jeux Olympiques
     * @return Le nombre d'épreuves organisées aux Jeux Olympiques
     */
    public int nbEpreuves() {
        return this.epreuves.size();
    }

    /**
     * Ajoute un nouveau participant à la liste des participants aux Jeux Olympiques
     * @param nouveauParticipant Le participant à ajouter
     * @throws IllegalArgumentException si le participant est déjà présent dans la liste
     */
    public void ajouteParticipant(Participant nouveauParticipant) throws IllegalArgumentException {
        if (this.participants.contains(nouveauParticipant)) {
            throw new IllegalArgumentException("Erreur : Le participant est déjà présent dans la liste des participants.");
        }                
        else {
            this.participants.add(nouveauParticipant);
        }
    }

    /**
     * Ajoute un nouveau pays à la liste des pays représentés aux Jeux Olympiques
     * @param nouveauPays Le pays à ajouter
     * @throws IllegalArgumentException si le pays est déjà présent dans la liste
     */
    public void ajoutePays(Pays nouveauPays) throws IllegalArgumentException {
        if (this.pays.contains(nouveauPays)) {
            throw new IllegalArgumentException("Erreur : Le pays est déjà présent dans la liste des pays.");
        }
        else {
            this.pays.add(nouveauPays);
        }
    }

    /**
     * Ajoute une nouvelle épreuve à la liste des épreuves organisées aux Jeux Olympiques
     * @param nouvelleEpreuve L'épreuve à ajouter
     * @throws IllegalArgumentException si l'épreuve est déjà présente dans la liste
     */
    public void ajouteEpreuve(Epreuve nouevellEpreuve) throws IllegalArgumentException {
        if (this.epreuves.contains(nouevellEpreuve)) {
            throw new IllegalArgumentException("Erreur : L'épreuve est déjà présente dans la liste des épreuves.");
        }
        else {
            this.epreuves.add(nouevellEpreuve);
        }
    }

    /**
     * Supprime un participant de la liste des participants aux Jeux Olympiques
     * @param participant Le participant à supprimer
     * @throws NoSuchElementException si la liste des participants est vide ou si le participant n'est pas présent dans la liste
     */
    public void supprimeParticipant(Participant suppParticipant) throws NoSuchElementException {
        if (this.participants.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des participants est vide.");
        }
        if (!(this.participants.contains(suppParticipant))) {
            throw new NoSuchElementException("Erreur : Le participant n'est pas présent dans la liste des participants.");
        }
        this.participants.remove(suppParticipant);
    }
    
    /**
     * Supprime un pays de la liste des pays représentés aux Jeux Olympiques
     * @param pays Le pays à supprimer
     * @throws NoSuchElementException si la liste des pays est vide ou si le pays n'est pas présent dans la liste
     */
    public void supprimePays(Pays suppPays) throws NoSuchElementException {
        if (this.pays.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des pays est vide.");
        }
        if (!(this.pays.contains(suppPays))) {
            throw new NoSuchElementException("Erreur : Le pays n'est pas présent dans liste des pays.");
        }
        this.pays.remove(suppPays);
    }

    /**
     * Supprime une épreuve de la liste des épreuves organisées aux Jeux Olympiques
     * @param epreuve L'épreuve à supprimer
     * @throws NoSuchElementException si la liste des épreuves est vide ou si l'épreuve n'est pas présente dans la liste
     */
    public void supprimeEpreuve(Epreuve suppEpreuve) throws NoSuchElementException {
        if (this.epreuves.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des participants est vide.");
        }
        if (!(this.epreuves.contains(suppEpreuve))) {
            throw new NoSuchElementException("Erreur : L'épreuve n'est pas présente dans la liste des épreuves.");
        }
        else {
            this.epreuves.remove(suppEpreuve);
        }
    }

    /**
     * Recherche un participant dans la liste des participants aux Jeux Olympiques
     * @param participant Le participant à rechercher
     * @return Le participant recherché
     * @throws NoSuchElementException si la liste des participants est vide ou si le participant n'est pas présent dans la liste
     */
    public Participant rechercheParticipant(Participant rechParticipant) throws NoSuchElementException {
        if (this.participants.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des participants est vide.");
        }
        if (this.participants.contains(rechParticipant)) {
            return rechParticipant;
        }
        throw new NoSuchElementException("Erreur : Le participant n'est pas présent dans la liste des participant.");
    }

    /**
     * Recherche un pays dans la liste des pays représentés aux Jeux Olympiques
     * @param pays Le pays à rechercher
     * @return Le pays recherché
     * @throws NoSuchElementException si la liste des pays est vide ou si le pays n'est pas présent dans la liste
     */
    public Pays recherchePays(Pays rechPays) throws NoSuchElementException {
        if (this.pays.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des pays est vide.");
        }
        if (this.pays.contains(rechPays)) {
            return rechPays;
        }
        throw new NoSuchElementException("Erreur : Le pays n'est pas présent dans la liste des pays.");
    }

    /**
     * Recherche une épreuve dans la liste des épreuves organisées aux Jeux Olympiques
     * @param epreuve L'épreuve à rechercher
     * @return L'épreuve recherchée
     * @throws NoSuchElementException si la liste des épreuves est vide ou si l'épreuve n'est pas présente dans la liste
     */
    public Epreuve rechercheEpreuve(Epreuve rechEpreuve) throws NoSuchElementException {
        if (this.epreuves.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des épreuves est vide.");
        }
        if (this.epreuves.contains(rechEpreuve)) {
            return rechEpreuve;
        }
        throw new NoSuchElementException("Erreur : L'épreuve n'est pas présente dans la liste des épreuves.");
    }

    /**
     * Retourne une chaîne de caractères représentant l'objet courant
     * @return Une chaîne de caractères représentant l'objet courant
     */
    @Override
    public String toString() {
        return "Nom des Jeux Olympiques : " + this.getNom() + 
            ", Année des Jeux Olympiques : " + this.getAnnee() + 
            ", Ville hôte des Jeux Olympiques : " + this.getVille() + 
            ", Participants aux Jeux Olympiques : " + this.getParticipants() + 
            ", Pays représentés aux Jeux Olympiques : " + this.getPays() + 
            ", Epreuves présentes aux Jeux Olympiques : " + this.getEpreuves();
    }

    /**
     * Vérifie si l'objet spécifié est égal à l'objet courant
     * @param objet L'objet à comparer avec l'objet courant
     * @return true si les objets sont égaux et false sinon
     */
    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (! (objet instanceof JeuxOlympique)) {
            return false;
        }
        JeuxOlympique jo = (JeuxOlympique) objet;
        return this.nom.equals(jo.nom) && this.annee == jo.annee && this.ville.equals(jo.ville) && this.participants.equals(jo.participants) && this.pays.equals(jo.pays) && this.epreuves.equals(jo.epreuves);
    } 
    
}
