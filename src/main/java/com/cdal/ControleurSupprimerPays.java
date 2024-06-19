package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurSupprimerPays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageSupprimePays();
    }
    
}
