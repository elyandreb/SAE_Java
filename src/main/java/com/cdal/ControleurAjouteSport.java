package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAjouteSport(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteSport();
    }
    
}
