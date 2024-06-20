package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        String l = appli.getLogin();
        if(l.charAt(l.length()-1)=='J'){
            appli.pagePaysJournaliste();
        }
        else if(l.charAt(l.length()-1)=='O'){
            appli.pagePaysOrganisateur();
        }
        else if(l.charAt(l.length()-1)=='A'){
            appli.pagePaysAdministrateur();
        }
    }
    
}
