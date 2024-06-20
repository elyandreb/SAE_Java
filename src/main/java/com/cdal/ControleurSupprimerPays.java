package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerPays implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurAjoutePays(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        try {
            String nom = appli.getTextPaysAjoute();
            
            Pays pays = new Pays(nom, 0,0,0);

            requetes.effacerPays(pays);

            // Récupérer la liste actuelle des pays
    ObservableList<Pays> currentList = appli.getTablePays().getItems();

    // Trouver le pays avec le nom donné
    Pays paysASupprimer = null;
    for (Pays pays : currentList) {
        if (pays.getNom().equals(nom)) {
            paysASupprimer = pays;
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
