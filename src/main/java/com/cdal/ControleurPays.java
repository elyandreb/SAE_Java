package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pagePaysJournaliste();
    }
    
}
