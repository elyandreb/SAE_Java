import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAnnuler implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurAnnuler(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.effacerText();
    }
    
}
