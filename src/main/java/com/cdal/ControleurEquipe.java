package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageEquipeAdministrateur();
    }
    
}
