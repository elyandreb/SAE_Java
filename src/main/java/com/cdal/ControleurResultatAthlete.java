package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurResultatAthlete implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurResultatAthlete(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageResultatAthlete();
    }
    
}
