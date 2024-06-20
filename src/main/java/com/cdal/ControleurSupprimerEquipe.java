package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurSupprimerEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeEquipe();
    }
    
}
