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
        try {
            String motDePasseStr = appli.getMotDePasse();
            if (motDePasseStr != null && !motDePasseStr.isEmpty()) {
                int m = Integer.valueOf(motDePasseStr);
                ConnexionBD connexionBD = appli.getConnexionBD();
                if(l.charAt(l.length()-1)=='J'){
                    if(0<=m && m<1000){appli.pageAccueilJournaliste();}
                    else{System.out.println("Mot de passe incorrect pour le journaliste");}
                }
                else if(l.charAt(l.length()-1)=='O'){
                    if(1000<=m && m<2000){appli.pageAccueilJournaliste();}
                    else{System.out.println("Mot de passe incorrect pour l'organisateur");}
                }
                else if(l.charAt(l.length()-1)=='A'){
                    if(2000<=m && m<3000){appli.pageAccueilJournaliste();}
                    else{System.out.println("Mot de passe incorrect pour l'administrateur");}
                }
                else{System.out.println("Identifiant incorrect");}
            } else {
                System.out.println("Le mot de passe est null ou vide");
            }
        } catch (NumberFormatException e) {
            System.out.println("Le mot de passe ne peut pas être converti en entier : " + e.getMessage());
        }

    }
}
