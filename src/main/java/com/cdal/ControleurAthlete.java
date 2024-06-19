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
        appli.pageAthleteOrganisateur();
    }
    
}
