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

    public void chargerCSV(String nomdufichier) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(nomdufichier));
        scanner.nextLine();
        HashMap<Epreuve, List<Athlete>> dico = new HashMap<>();
        Sport sportt = null;
        Epreuve epr = null;
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
            if(sport.charAt(0)=='A'){sportt = new Athletisme(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='E'){sportt = new Escrime(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='H'){sportt = new Handball(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='N'){sportt = new Natation(sport, categorie, nbJoueurs);}
            if(sport.charAt(0)=='V'){sportt = new Volleyball(sport, categorie, nbJoueurs);}
            epr = new Epreuve(epreuve, categorie, sportt);
            this.manager.addAthlete(ath);
            this.manager.addPays(paysm);
            this.manager.addSport(sportt);
            List<Athlete> l = dico.get(epr);
            if(l==null){
                l=new ArrayList<Athlete>();
                dico.put(epr, l);}
            l.add(ath);
        }
        for(Sport spt: this.manager.getSports()){
            this.manager.createEpreuve(dico.get(epr), sportt);
        }
        scanner.close();
    }

    public void sauvegarderCSV(String nomdufichier) throws FileNotFoundException{
        File f = new File(nomdufichier);
        PrintWriter pw = new PrintWriter(f);
        Pays p = null;
        Epreuve e = null;
        pw.println("Nom,Prénom,Sexe,Pays,Sport,Épreuve,,Catégorie,NombreJoueurs,Force,Endurance,Agilite");
        for(Athlete a : manager.getAthletes()){
            for(Pays pays: this.manager.getPays()){
                if(!(pays.rechercheAthlete(a)==null)){p = pays;}
            }
            for(Epreuve epr: this.manager.getEpreuves()){
                if(!(epr.rechercheParticipantEpreuve(a)==null)){e = epr;}
            }
            pw.println(a.obtenirNom()+","+a.getPrenom()+","+a.obtenirSexe()+","+p.getNom()+","+e.getSport()+","+e.getNom()+","+e.getGenre()+","+e.getSport().getNbJoueur()+","+a.getForce()+","+a.getEndurance()+","+a.getAgilite());
        }
        pw.close();
    }

    public void chargerSQl(ConnexionBD connexionBD) throws SQLException{
        Statement st = connexionBD.createStatement();
        ResultSet pays = st.executeQuery("SELECT * FROM PAYS");

        while (pays.next()) {
            manager.addPays(new Pays(pays.getString(1), pays.getInt(2),pays.getInt(3),pays.getInt(4)));
        }

        ResultSet athletes = st.executeQuery("SELECT * FROM ATHLETE");

        while (athletes.next()) {
            manager.addAthlete(new Athlete(athletes.getString(2), athletes.getString(3), athletes.getString(4), athletes.getInt(5), athletes.getInt(6), athletes.getInt(7)));
        }

        ResultSet sports = st.executeQuery("SELECT * FROM SPORT WHERE nombreJoueurs=1");

        while (sports.next()) {
            if(sports.getString(2).charAt(0)=='A'){manager.addSport(new Athletisme(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='E'){manager.addSport(new Escrime(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='H'){manager.addSport(new Handball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='N'){manager.addSport(new Natation(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='V'){manager.addSport(new Volleyball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
        }

        ResultSet sportss = st.executeQuery("SELECT * FROM SPORT WHERE nombreJoueurs!=1");

        while(sportss.next()) {
            if(sports.getString(2).charAt(0)=='A'){manager.addSport(new Athletisme(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='E'){manager.addSport(new Escrime(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='H'){manager.addSport(new Handball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='N'){manager.addSport(new Natation(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='V'){manager.addSport(new Volleyball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
        }
    }
}