package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAccueil implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAccueil(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAccueilOrganisateur();
    }
    
}
