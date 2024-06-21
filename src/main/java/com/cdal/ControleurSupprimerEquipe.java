package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurSupprimerEquipe(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        String nom = appli.getTextEquipeNom();

        try {
            requetes.effacerEquipe(nom);
        } catch (SQLException e1) {
            System.err.println("L'équipe n'est pas dans la BD");
        }

            // Récupérer la liste actuelle des equipes
        ObservableList<Equipe> currentList = appli.getTableEquipe().getItems();
    
        // Trouver l'équipe avec le nom donné
       Equipe equipeASupprimer = null;
        for (Equipe equipe : currentList) {
            if (equipe.getNom().equals(nom)) {
                equipeASupprimer = equipe;
                break;
            }
        }
    
        // Si l'équipe est trouvé, le supprimer
        if (equipeASupprimer != null) {
            currentList.remove(equipeASupprimer);
            // Rafraîchir le TableView pour refléter les modifications
            appli.getTableEquipe().refresh();
            appli.pageEquipeAdministrateur();
        } else {
            System.err.println("L'équipe avec le nom " + nom + " n'a pas été trouvé.");
        }
    }
    
}
