package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurPageSupprimerPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurPageSupprimerPays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimePays();
    }
    
}
