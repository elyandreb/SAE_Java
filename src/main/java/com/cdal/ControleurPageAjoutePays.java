package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageAjoutePays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageAjoutePays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAjoutePays();
    }
    
}
