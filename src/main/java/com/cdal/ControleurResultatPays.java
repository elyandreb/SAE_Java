package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurResultatPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurResultatPays(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.pageResultatPays();
    }
    
}
