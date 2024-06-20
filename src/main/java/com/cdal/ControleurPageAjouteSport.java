package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageAjouteSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageAjouteSport(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjouteSport();
    }
    
}
