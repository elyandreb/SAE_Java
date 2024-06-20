package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageSupprimerSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageSupprimerSport(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimeSport();
    }
    
}
