package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageAjouteEquipe implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageAjouteEquipe(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteEquipe();
    }
    
}
