package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAccueil implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAccueil(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        String l = appli.getLogin();
        if(l.charAt(l.length()-1)=='J'){
            appli.pageAccueilJournaliste();
        }
        else if(l.charAt(l.length()-1)=='O'){
            appli.pageAccueilOrganisateur();
        }
        else if(l.charAt(l.length()-1)=='A'){
            appli.pageAccueilAdministrateur();
        }
    }
    
}
