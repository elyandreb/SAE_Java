package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageSupprimeAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageSupprimeAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeAthlete();
    }
    
}
