package main.java.com.cdal;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteEquipe implements EventHandler<ActionEvent> {
    
     private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurAjouteEquipe(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        try {
            String nom = appli.getTextEquipeNom();

            int choixPaysR = (int)(10*Math.random());
            Pays pays = null;
            if(choixPaysR == 0 || choixPaysR == 1 || choixPaysR == 2){pays = new Pays("Maroc", 0,0,0);}
            else if((choixPaysR == 3 || choixPaysR == 4)){pays = new Pays("France", 0,0,0);}
            else if((choixPaysR == 5 || choixPaysR == 6)){pays = new Pays("Allemagne", 0,0,0);}
            else if((choixPaysR == 7 || choixPaysR == 8)){pays = new Pays("Japon", 0,0,0);}
            else if((choixPaysR == 9 || choixPaysR == 10)){pays = new Pays("Corée", 0,0,0);}
            boolean paysc = requetes.cherchePays(pays.getNom());
            if(paysc == false){requetes.ajoutPays(pays);}
            
            Equipe eq = new Equipe(nom, pays);
            requetes.ajoutEquipe(eq, pays);

            ObservableList<Equipe> currentList = appli.getTableEquipe().getItems();

            if (currentList.contains(eq)) {
                appli.setErreurMessage("Le pays est déjà présent dans le tableau");
            } else {
                currentList.add(eq); // Ajoute le nouveau pays à la liste existante
            }

            appli.getTableEquipe().refresh();
            appli.pageEquipeAdministrateur();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    
}
