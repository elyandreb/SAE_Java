package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerSport implements EventHandler<ActionEvent> {
    
     private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurSupprimerSport(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        String nomS = appli.getTextNomSport();
        String nomE = appli.getTextNomEpreuve();

        try {
            requetes.effacerEpreuve(nomE, nomS);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

            // Récupérer la liste actuelle des épreuves
        ObservableList<Epreuve> currentList = appli.getTableSport().getItems();
    
        // Trouver l'épreuve avec les noms donnés
        Epreuve epreuveASupprimer = null;
        for (Epreuve epreuve : currentList) {
            if (epreuve.getNom().equals(nomE) && epreuve.getSport().getNom().equals(nomS)) {
                epreuveASupprimer = epreuve;
                break;
            }
        }
    
        // Si le pays est trouvé, le supprimer
        if (epreuveASupprimer != null) {
            currentList.remove(epreuveASupprimer);
            // Rafraîchir le TableView pour refléter les modifications
            appli.getTableSport().refresh();
            appli.pageSportAdministrateur();
        } else {
            System.err.println("L'épreuve avec le nom " + nomE + " n'a pas été trouvé.");
        }
    }
    
}
