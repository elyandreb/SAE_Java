package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouteSport implements EventHandler<ActionEvent> {
    
    private AppIUTO appli;
    private ConnexionBD connexionBD;
    private RequeteJDBC requetes;
    
    public ControleurAjouteSport(AppIUTO appli, ConnexionBD connexionBD, RequeteJDBC requetes){
        this.appli = appli;
        this.connexionBD = connexionBD;
        this.requetes = requetes;
    }
    
    @Override
    public void handle(ActionEvent e) {
        try {
            String nomEp = appli.getTextNomEpreuve();
            String nomS = appli.getTextNomSport();

            int choixSexeR = 10*Math.random();
            String choixSexe = null;
            if(choixSexeR>=5){choixSexe = "M";}else{choixSexe = "F";}

            int choixSportR = 10*Math.random();
            String choix = null;
            int nbj = 1;
            if(choixSportR>=5){choix = "Individuel";}else{choix = "Collectif";}
            if(choix.equals("Collectif")){nbj = Math.Random()*10;}
            
            Epreuve ep = new Epreuve(nomEp, choixSexe, nbj);

            requetes.ajoutEpreuve(ep);

            ObservableList<ep> currentList = appli.getTableSport().getItems();

            if (currentList.contains(ep)) {
                throw new IllegalArgumentException("L'épreuve est déjà présente dans la liste.");
            } else {
                currentList.add(ep); // Ajoute la nouvelle epreuve à la liste existante
            }

            appli.getTableSport().refresh();
            appli.pageSportAdministrateur();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    
}
