package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjoutePays implements EventHandler<ActionEvent> {
    
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
            int nbOr = appli.getOrSpinner();
            int nbArgent = appli.getArgentSpinner();
            int nbBronze = appli.getBronzeSpinner();
            
            Pays pays = new Pays(nom, nbOr, nbArgent, nbBronze);
            try{
            requetes.ajoutPays(pays);}
            catch(SQLException e1){
                System.err.println("Le pays est déjà présent dans la BD");
            }

            ObservableList<Pays> currentList = appli.getTablePays().getItems();

            if (currentList.contains(pays)) {
                throw new IllegalArgumentException("Le pays est déjà présent dans la liste.");
            } else {
                currentList.add(pays); // Ajoute le nouveau pays à la liste existante
            }

            appli.getTablePays().refresh();
            appli.pagePaysAdministrateur();
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    
}
