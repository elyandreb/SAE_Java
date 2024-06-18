import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurVisibilter implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    
    public ControleurVisibilter(AppIUTO appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent e){
        appli.mdpVisible();
    }
    
}
