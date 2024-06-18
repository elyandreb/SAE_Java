package main.java.com.cdal;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class ControleurConnexion implements EventHandler<ActionEvent>{
    AppIUTO appli;
    
    public ControleurConnexion(AppIUTO app){
        this.appli = app;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String l=appli.getLogin();
        String m=appli.getMotDePasse();
        ConnexionBD connexionBD = appli.getConnexionBD();

        try {
            connexionBD.connecter(l, m);
	    if (connexionBD.isConnecte())
		appli.connexionReussie();	
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Echec !!!! ");
			alert.setResizable(true);
			alert.setWidth(500);
			alert.setHeaderText("Echec de la connexion au serveur");
			alert.setContentText("Voici le message envoyé par le serveur\n"+e.getMessage());
			alert.showAndWait();
        }

    }
}
