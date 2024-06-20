package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageSupprimerEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageSupprimerEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeEquipe();
    }
    
}
