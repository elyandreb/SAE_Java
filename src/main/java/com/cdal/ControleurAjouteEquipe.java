package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAjouteEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteEquipe();
    }
    
}
