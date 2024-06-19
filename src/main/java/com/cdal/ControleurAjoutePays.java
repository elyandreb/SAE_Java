package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjoutePays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAjoutePays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjoutePays();
    }
    
}
