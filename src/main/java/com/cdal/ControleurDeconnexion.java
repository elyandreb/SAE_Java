package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurDeconnexion(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageConnexion();
    }
    
}
