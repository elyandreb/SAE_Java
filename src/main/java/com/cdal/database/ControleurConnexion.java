
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.sql.SQLException;

import main.java.com.cdal.*;

public class ControleurConnexion implements EventHandler<ActionEvent>{
    IUTOAppli appli;
    
    public ControleurConnexion(IUTOAppli app){
        this.appli = app;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        IUTOAppli l=appli.getLoginBD();
        ConnexionBD connexionBD = appli.getConnexionBD();

        try {
            connexionBD.connecter(l.getLogin(), l.getMotDePasse());
	    if (connexionBD.isConnecte())
		appli.connexionReussie();
	    else
		appli.setMessage("Vous n'êtes pas connecté");	
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Echec !!!! ");
			alert.setResizable(true);
			alert.setWidth(500);
			alert.setHeaderText("Echec de la connexion au serveur");
			alert.setContentText("Voici le message envoyé par le serveur\n"+e.getMessage());
			alert.showAndWait();
			appli.setMessage("Vous n'êtes pas connecté");
        }

    }
}