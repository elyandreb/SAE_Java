package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurSport(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        String l = appli.getLogin();
        if(l.charAt(l.length()-1)=='J'){
            appli.pageSportJournaliste();
        }
        else if(l.charAt(l.length()-1)=='O'){
            appli.pageSportOrganisateur();
        }
        else if(l.charAt(l.length()-1)=='A'){
            appli.pageSportAdministrateur();
        }
    }
    
}
