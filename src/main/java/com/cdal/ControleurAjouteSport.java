package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurAjouteSport(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        try {
            String nomEp = appli.getTextNomEpreuve();
            String nomS = appli.getTextNomSport();

            String choixSexe = appli.getSexeEpreuve();

            int choixSportR = (int)(10*Math.random());
            String choix = null;
            double nbj = 1;
            if(choixSportR>=5){choix = "Individuel";}else{choix = "Collectif";}
            if(choix.equals("Collectif")){nbj = Math.random()*10 +1;}
            Sport sport = null;
            if(nomS.charAt(0)=='A'){sport = new Athletisme(nomS, choixSexe, (int)nbj);}
            if(nomS.charAt(0)=='E'){sport = new Escrime(nomS, choixSexe, (int)nbj);}
            if(nomS.charAt(0)=='H'){sport = new Handball(nomS, choixSexe, (int)nbj);}
            if(nomS.charAt(0)=='N'){sport = new Natation(nomS, choixSexe, (int)nbj);}
            else{sport = new Volleyball(nomS, choix, (int)nbj);}
            
            Epreuve ep = new Epreuve(nomEp, choixSexe, sport);

            requetes.ajoutEpreuve(ep);

            ObservableList<Epreuve> currentList = appli.getTableSport().getItems();

            if (currentList.contains(ep)) {
                throw new IllegalArgumentException("L'épreuve est déjà présente dans la liste.");
            } else {
                currentList.add(ep); // Ajoute la nouvelle epreuve à la liste existante
            }

            appli.getTableSport().refresh();
            appli.pageSportAdministrateur();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    
}
