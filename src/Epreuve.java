import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * La classe Epreuve représente une épreuve sportive dans le cadre des Jeux Olympiques
 */
public class Epreuve {
    private String nom; // Le nom de l'épreuve
    private String genre; // Le genre de l'épreuve (Masculine/Féminine)
    private Sport sport; // Le sport associé à l'épreuve
    private List<Participant> participants; // La liste des participants à l'épreuve

    /**
     * Constructeur de la classe Epreuve
     * @param nom Le nom de l'épreuve
     * @param genre Le genre de l'épreuve (Masculine/Féminine)
     * @param sport Le sport associé à l'épreuve
     * @throws IllegalArgumentException Si le nom de l'épreuve est vide ou null ou si le format du genre n'est pas respecté ou si le sport est null
     */
    public Epreuve(String nom, String genre, Sport sport) throws IllegalArgumentException {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'épreuve ne peut pas être vide ou null.");
        }
        if (!(genre.equals("Masculine") || genre.equals("Féminine"))) {
            throw new IllegalArgumentException("Erreur : Le format de genre n'est pas respecté.");
        }
        if (genre.equals(null) || genre.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le genre ne peut pas être vide ou null");
        }
        if (sport == null) {
            throw new IllegalArgumentException("Erreur : Le sport ne peut pas être null.");
        }
        this.nom = nom;
        this.genre = genre;
        this.sport = sport;
        this.participants = new ArrayList<>();
    }

    /**
     * Méthode pour obtenir le nom de l'épreuve
     * @return Le nom de l'épreuve
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour obtenir le genre de l'épreuve
     * @return Le genre de l'épreuve (Masculine/Féminine)
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Méthode pour obtenir le sport associé à l'épreuve
     * @return Le sport associé à l'épreuve
     */
    public Sport getSport() {
        return sport;
    }

    /**
     * Méthode pour obtenir la liste des participants à l'épreuve
     * @return La liste des participants à l'épreuve
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * Méthode pour modifier le nom de l'épreuve
     * @param nom Le nouveau nom de l'épreuve
     * @throws IllegalArgumentException Si le nouveau nom est vide ou null
     */
    public void setNom(String nom) throws IllegalArgumentException {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le nom de l'épreuve ne peut pas être vide ou null.");
        }
        this.nom = nom;
    }

    /**
     * Méthode pour modifier le genre de l'épreuve
     * @param genre Le nouveau genre de l'épreuve (Masculine/Féminine)
     * @throws IllegalArgumentException Si le nouveau genre n'est pas valide
     */
    public void setGenre(String genre) throws IllegalArgumentException {
        if (!(genre.equals("Masculine") || genre.equals("Féminine"))) {
            throw new IllegalArgumentException("Erreur : Le format de genre n'est pas respecté.");
        }
        if (genre.equals(null) || genre.isEmpty()) {
            throw new IllegalArgumentException("Erreur : Le genre ne peut pas être vide ou null");
        }
        this.genre = genre;
    }

    /**
     * Méthode pour obtenir le nombre de participants à l'épreuve
     * @return Le nombre de participants à l'épreuve
     */
    public int nbParticipantsEpreuve() {
        return this.participants.size();
    }

    /**
     * Méthode pour ajouter un participant à l'épreuve
     * @param nouveauParticipant Le participant à ajouter
     * @throws IllegalArgumentException Si le participant est déjà présent dans la liste des participants
     */
    public void ajouteParticipantEpreuve(Participant nouveauParticipant) throws IllegalArgumentException {
        if (this.participants.contains(nouveauParticipant)) {
            throw new IllegalArgumentException("Erreur : Le participant est déjà présent dans la liste des participants.");
        }
        this.participants.add(nouveauParticipant);
    }

    /**
     * Méthode pour supprimer un participant de l'épreuve
     * @param suppParticipant Le participant à supprimer
     * @throws NoSuchElementException Si la liste des participants est vide ou si le participant n'est pas présent
     */
    public void supprimeParticipantEpreuve(Participant suppParticipant) throws NoSuchElementException {
        if (this.participants.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des participants est vide.");
        }
        if (!(this.participants.contains(suppParticipant))) {
            throw new NoSuchElementException("Erreur : Le participant n'est pas présent dans la liste des participants.");
        }
        this.participants.remove(suppParticipant);
    }

    /**
     * Méthode pour rechercher un participant dans l'épreuve
     * @param rechParticipant Le participant à rechercher
     * @return Le participant recherché s'il est trouvé
     * @throws NoSuchElementException Si la liste des participants est vide ou si le participant n'est pas présent
     */
    public Participant rechercheParticipantEpreuve(Participant rechParticipant) throws NoSuchElementException {
        if (this.participants.isEmpty()) {
            throw new NoSuchElementException("Erreur : La liste des participants est vide.");
        }
        if (this.participants.contains(rechParticipant)) {
            return rechParticipant;
        }
        throw new NoSuchElementException("Erreur : Le participant n'est pas présent dans la liste des participants.");
    }

    /**
     * Méthode pour obtenir une représentation textuelle de l'épreuve
     * @return Une chaîne de caractères représentant l'épreuve
     */
    @Override
    public String toString() {
        return "Le nom de l'épreuve : " + this.getNom() + ", Le genre de l'épreuve : " + this.getGenre() + ", Le sport de l'épreuve : " + this.getSport() + ", Les participants à l'épreuve : " + this.getParticipants();
    }

    /**
     * Méthode pour comparer deux épreuves et vérifier leur égalité
     * @param objet L'objet à comparer
     * @return true si les épreuves sont égales et false sinon
     */
    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (objet == this) {
            return true;
        }
        if (!(objet instanceof Epreuve)) {
            return false;
        }
        Epreuve epreuve = (Epreuve) objet;
        return epreuve.nom.equals(this.nom) && epreuve.genre.equals(this.genre) && epreuve.sport == this.sport && epreuve.participants == this.participants;
    }
    
}
