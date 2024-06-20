package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurEnregistrerEpreuve implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurEnregistrerEpreuve(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageEnregistrerEpreuve();
    }
    
}
