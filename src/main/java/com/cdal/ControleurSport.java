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
        appli.pageSportAdministrateur();
    }
    
}
