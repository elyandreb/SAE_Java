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
                    else{this.popUpMdpErrone().show();this.appli.resetMdp();}
                }
                else if(l.charAt(l.length()-1)=='O'){
                    if(1000<=m && m<2000){appli.pageAccueilJournaliste();}
                    else{this.popUpMdpErrone().show();this.appli.resetMdp();}
                }
                else if(l.charAt(l.length()-1)=='A'){
                    if(2000<=m && m<3000){appli.pageAccueilJournaliste();}
                    else{this.popUpMdpErrone().show();this.appli.resetMdp();}
                }
                else{this.popUpIdErrone().show();}
            } else {
                System.out.println("Le mot de passe est null ou vide");
            }
        } catch (NumberFormatException e) {
            System.out.println("Le mot de passe ne peut pas être converti en entier : " + e.getMessage());
            this.popUpMdpErrone2().show();
            this.appli.resetMdp();

        }

    }
    public Alert popUpMdpErrone(){    
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Votre mot de passe doit contenir\n un nombre entre 1 et 9999  ");
        return alert;
    }

    public Alert popUpIdErrone(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Votre identifiant doit être de la forme\n XXXXJ, XXXXO ou XXXXA");
        return alert;
    }

    public Alert popUpMdpErrone2(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Votre mot de passe uniquement des chiffres ");
        return alert;
    }

}
