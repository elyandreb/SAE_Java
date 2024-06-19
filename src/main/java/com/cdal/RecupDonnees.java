package main.java.com.cdal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RecupDonnees {
    private DataManager manager;

    public RecupDonnees(DataManager manager) {
        this.manager = manager;
    }

    @SuppressWarnings("unchecked")
    public void chargerCSV(String nomdufichier) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(nomdufichier));
        scanner.nextLine();
        HashMap<Epreuve, List<Athlete>> dico = new HashMap<>();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            String nom = data[0];
            String prenom = data[1];
            String sexe = data[2];
            String pays = data[3];
            String sport = data[4];
            String epreuve = data[5];
            String categorie = data[6];
            int nbJoueurs = Integer.parseInt(data[7]);
            int force = Integer.parseInt(data[8]);
            int endurance = Integer.parseInt(data[9]);
            int agilite = Integer.parseInt(data[10]);
            Athlete ath = new Athlete(nom, prenom, sexe, force, agilite, endurance);
            Pays paysm = new Pays(pays, 0,0,0);
            Sport sportt = null;
            if(sport.charAt(0)=='A'){sportt = new Athletisme(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='E'){sportt = new Escrime(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='H'){sportt = new Handball(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='N'){sportt = new Natation(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='V'){sportt = new Volleyball(sport, categorie, nbJoueurs);}
            Epreuve epr = new Epreuve(epreuve, categorie, sportt);
            this.manager.addAthlete(ath);
            this.manager.addPays(paysm);
            this.manager.addSport(sportt);
            List<Athlete> l = dico.get(epr);
            if(l==null){
                l=new ArrayList<Athlete>();
                dico.put(epr, l);}
            l.add(ath);
            this.manager.createEpreuve(dico.get(epr), sportt);
    }
}
}