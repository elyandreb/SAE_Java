package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurSupprimerSport(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeSport();
    }
    
}
