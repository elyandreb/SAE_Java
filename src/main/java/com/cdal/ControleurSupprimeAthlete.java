package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimeAthlete implements EventHandler<ActionEvent> {
    
     private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurSupprimeAthlete(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
            String nom = appli.getTextAthleteNom();
            String prenom = appli.getTextAthletePrenom();

            requetes.effacerAthlete(nom, prenom);

            // Récupérer la liste actuelle des pays
            ObservableList<Athlete> currentList = appli.getTableAthlete().getItems();
        
            // Trouver le pays avec le nom donné
            Athlete athleteASupprimer = null;
            for (Athlete a : currentList) {
                if (a.obetnirNom().equals(nom)&&a.getPrenom().equals(prenom)) {
                    athleteASupprimer = a;
                    break;
                }
            }
        
            // Si l'athlète est trouvé, le supprimer
            if (athleteASupprimer != null) {
                currentList.remove(athleteASupprimer);
                // Rafraîchir le TableView pour refléter les modifications
                appli.getTableAthlete().refresh();
            } else {
                System.err.println("L'athlète " + prenom + nom + " n'a pas été trouvé.");
            }
    }
    
}
