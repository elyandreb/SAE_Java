package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurSupprimerPays(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        String nom = appli.getTextPaysAjoute();
            
        Pays pays = new Pays(nom, 0,0,0);

        try {
            requetes.effacerPays(pays);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

            // Récupérer la liste actuelle des pays
        ObservableList<Pays> currentList = appli.getTablePays().getItems();

        // Trouver le pays avec le nom donné
        Pays paysASupprimer = null;
        for (Pays pay : currentList) {
            if (pay.getNom().equals(nom)) {
                paysASupprimer = pay;
                break;
            }
        }

        // Si le pays est trouvé, le supprimer
        if (paysASupprimer != null) {
            currentList.remove(paysASupprimer);
            // Rafraîchir le TableView pour refléter les modifications
            appli.getTablePays().refresh();
        } else {
            System.err.println("Le pays avec le nom " + nom + " n'a pas été trouvé.");
        }

    }
}
    
    
