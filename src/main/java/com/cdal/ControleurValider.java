package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurValider implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurValider(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageAccueilJournaliste();
    }
    
}
