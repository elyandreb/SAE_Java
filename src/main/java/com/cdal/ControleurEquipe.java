package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        String l = appli.getLogin();
        if(l.charAt(l.length()-1)=='J'){
            appli.pageEquipeJournaliste();
        }
        else if(l.charAt(l.length()-1)=='O'){
            appli.pageEquipeOrganisateur();
        }
        else if(l.charAt(l.length()-1)=='A'){
            appli.pageEquipeAdministrateur();
        }
    }
    
}
