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
    public void handle(ActionEvent e) {
        String l = appli.getLogin();
        try {
            String motDePasseStr = appli.getMotDePasse();
            if (motDePasseStr != null && !motDePasseStr.isEmpty()) {
                int m = Integer.valueOf(motDePasseStr);
                ConnexionBD connexionBD = appli.getConnexionBD();
                if (l.charAt(l.length() - 1) == 'J') {
                    if (0 <= m && m < 1000) {
                        appli.pageAccueilJournaliste();
                        appli.effacerMessageErreur();
                    } else {
                        appli.setErreurMessage("Mot de passe incorrect pour le journaliste");
                    }
                } else if (l.charAt(l.length() - 1) == 'O') {
                    if (1000 <= m && m < 2000) {
                        appli.pageAccueilOrganisateur();
                        appli.effacerMessageErreur();
                    } else {
                        appli.setErreurMessage("Mot de passe incorrect pour l'organisateur");
                    }
                } else if (l.charAt(l.length() - 1) == 'A') {
                    if (2000 <= m && m < 3000) {
                        appli.pageAccueilAdministrateur();
                        appli.effacerMessageErreur();
                    } else {
                        appli.setErreurMessage("Mot de passe incorrect pour l'administrateur");
                    }
                } else {
                    appli.setErreurMessage("Identifiant incorrect");
                }
            } else {
                appli.setErreurMessage("Le mot de passe ou l'identifiant est vide");
            }
        } catch (NumberFormatException e1) {
            appli.setErreurMessage("Le mot de passe doit être un entier");
        }
    }

}
