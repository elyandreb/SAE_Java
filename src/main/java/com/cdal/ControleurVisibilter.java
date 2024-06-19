package main.java.com.cdal;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class ControleurVisibilter implements EventHandler<MouseEvent> {
    
    private AppIUTO appli;
    
    public ControleurVisibilter(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(MouseEvent e){
        appli.mdpVisible();
    }
    
}
