package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimeAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurSupprimeAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeAthlete();
    }
    
}
