/**
 * L'interface Participant définit les méthodes communes pour les participants aux épreuves des Jeux Olympiques
 */
public interface Participant {

    /**
     * Récupère le nom du participant
     * @return Le nom du participant
     */
    public String obtenirNom();

    /**
     * Récupère le sexe du participant
     * @return Le sexe du participant
     */
    public String obtenirSexe();

    /**
     * Permet au participant de participer à une épreuve spécifique
     * @param epreuve L'épreuve à laquelle le participant participe
     */
    public void participer(Epreuve epreuve);

    /**
     * Récupère le résultat du participant dans une épreuve spécifique
     * @param epreuve L'épreuve pour laquelle on veut obtenir le résultat du participant
     * @return Le résultat du participant dans l'épreuve spécifiée
     */
    public double resultat(Epreuve epreuve);
    
}
