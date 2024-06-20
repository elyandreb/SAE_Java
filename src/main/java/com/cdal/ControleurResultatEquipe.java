package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurResultatEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurResultatEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageResultatEquipe();
    }
    
}
