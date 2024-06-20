package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurLancerEpreuve implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurLancerEpreuve(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageLancerEpreuve();
    }
    
}
