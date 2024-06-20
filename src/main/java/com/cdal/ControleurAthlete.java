package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        String l = appli.getLogin();
        if(l.charAt(l.length()-1)=='J'){
            appli.pageAthleteJournaliste();
        }
        else if(l.charAt(l.length()-1)=='O'){
            appli.pageAthleteOrganisateur();
        }
        else if(l.charAt(l.length()-1)=='A'){
            appli.pageAthleteAdministrateur();
        }
    }
    
}
