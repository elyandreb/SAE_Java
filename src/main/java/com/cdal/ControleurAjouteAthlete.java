package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurAjouteAthlete(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        try {
            String nom = appli.getTextAthleteNom();
            String prenom = appli.getTextAthletePrenom();
            String sexe = appli.getSexeAthlete();
            int nbAgi = appli.getAgiliteSpinner();
            int nbEnd = appli.getEnduranceSpinner();
            int nbFor = appli.getForceSpinner();
            
            int choixEquipeR = (int)(10*Math.random());
            Boolean choixEquipe = null;
            if(choixEquipeR>=5){choixEquipe = true;}else{choixEquipe = false;}
            int choixPaysR = (int)(10*Math.random());
            
            Pays pays = null;
            if(choixPaysR == 0 || choixPaysR == 1 || choixPaysR == 2){pays = new Pays("Maroc", 0,0,0);}
            else if((choixPaysR == 3 || choixPaysR == 4)){pays = new Pays("France", 0,0,0);}
            else if((choixPaysR == 5 || choixPaysR == 6)){pays = new Pays("Allemagne", 0,0,0);}
            else if((choixPaysR == 7 || choixPaysR == 8)){pays = new Pays("Japon", 0,0,0);}
            else if((choixPaysR == 9 || choixPaysR == 10)){pays = new Pays("Corée", 0,0,0);}
            
            Athlete athlete = new Athlete(nom, prenom, sexe, nbFor, nbAgi, nbEnd, pays, choixEquipe);

            requetes.ajoutAthlete(athlete, new Equipe(nom, pays), pays);

            ObservableList<Athlete> currentList = appli.getTableAthlete().getItems();

            if (currentList.contains(athlete)) {
                throw new IllegalArgumentException("L'athlète est déjà présent dans la liste.");
            } else {
                currentList.add(athlete); // Ajoute le nouveau pays à la liste existante
            }

            appli.getTableAthlete().refresh();
            appli.pageAthleteAdministrateur();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    
}
