package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAjouteAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteAthlete();
    }
    
}
