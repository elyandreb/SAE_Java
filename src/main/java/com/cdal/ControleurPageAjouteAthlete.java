package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageAjouteAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageAjouteAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteAthlete();
    }
    
}
