package main.java.com.cdal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RecupDonnees {
    private GestionDonnees gestion;
    private Statement st;
    private ConnexionBD laConnexion;

    public RecupDonnees(GestionDonnees gestion) {
        this.gestion = gestion;
    }

    public int maxNumAthlete() throws SQLException {
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select max(idA) from ATHLETE");
		if (rs.next()) {
			int maxNum = rs.getInt(1);
			rs.close();
			return maxNum;
		}
		rs.close();
		return 0;}

    /*
     * Permet de passer du csv vers du java
     */
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
            this.gestion.addAthlete(ath);
            this.gestion.addPays(paysm);
            this.gestion.addSport(sportt);
            List<Athlete> l = dico.get(epr);
            if(l==null){
                l=new ArrayList<Athlete>();
                dico.put(epr, l);}
            l.add(ath);
        }
        for(Sport spt: this.gestion.getSports()){
            this.gestion.createEpreuve(dico.get(epr), sportt);
        }
        scanner.close();
    }

    /*
     * Permet de passer java vers du csv
     */
    public void sauvegarderCSV(String nomdufichier) throws FileNotFoundException{
        File f = new File(nomdufichier);
        PrintWriter pw = new PrintWriter(f);
        Pays p = null;
        Epreuve e = null;
        pw.println("Nom,Prénom,Sexe,Pays,Sport,Épreuve,Catégorie,NombreJoueurs,Force,Endurance,Agilite");
        for(Athlete a : gestion.getAthletes()){
            for(Pays pays: this.gestion.getPays()){
                if(!(pays.rechercheAthlete(a)==null)){p = pays;}
            }
            for(Epreuve epr: this.gestion.getEpreuves()){
                if(!(epr.rechercheParticipantEpreuve(a)==null)){e = epr;}
            }
            pw.println(a.obtenirNom()+","+a.getPrenom()+","+a.obtenirSexe()+","+p.getNom()+","+e.getSport()+","+e.getNom()+","+e.getGenre()+","+e.getSport().getNbJoueur()+","+a.getForce()+","+a.getEndurance()+","+a.getAgilite());
        }
        pw.close();
    }

    /*
     * Permet de passer sql vers du java
     */
    public void chargerSQl() throws SQLException{
        Statement st = laConnexion.createStatement();
        ResultSet pays = st.executeQuery("SELECT * FROM PAYS");

        while (pays.next()) {
            gestion.addPays(new Pays(pays.getString(1), pays.getInt(2),pays.getInt(3),pays.getInt(4)));
        }

        ResultSet athletes = st.executeQuery("SELECT * FROM ATHLETE");

        while (athletes.next()) {
            gestion.addAthlete(new Athlete(athletes.getString(2), athletes.getString(3), athletes.getString(4), athletes.getInt(5), athletes.getInt(6), athletes.getInt(7)));
        }

        ResultSet sports = st.executeQuery("SELECT * FROM SPORT WHERE nombreJoueurs=1");

        while (sports.next()) {
            if(sports.getString(2).charAt(0)=='A'){gestion.addSport(new Athletisme(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='E'){gestion.addSport(new Escrime(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='H'){gestion.addSport(new Handball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='N'){gestion.addSport(new Natation(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='V'){gestion.addSport(new Volleyball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
        }

        ResultSet sportss = st.executeQuery("SELECT * FROM SPORT WHERE nombreJoueurs!=1");

        while(sportss.next()) {
            if(sports.getString(2).charAt(0)=='A'){gestion.addSport(new Athletisme(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='E'){gestion.addSport(new Escrime(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='H'){gestion.addSport(new Handball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='N'){gestion.addSport(new Natation(sports.getString(2), sports.getString(3), sports.getInt(4)));}
            if(sports.getString(2).charAt(0)=='V'){gestion.addSport(new Volleyball(sports.getString(2), sports.getString(3), sports.getInt(4)));}
        }
    }

    /*
     * Permet de passer du java vers du sql
     */
    public void sauvegarderSQL() throws SQLException{
        HashMap<Pair<String, String>, List<Athlete>> dico = new HashMap<>();
        Pays p = null;
        Epreuve ep = null;
        for(Athlete a : gestion.getAthletes()){
            for(Pays pays: this.gestion.getPays()){
                if(!(pays.rechercheAthlete(a)==null)){p = pays;}
            }
            for(Epreuve epr: this.gestion.getEpreuves()){
                if(!(epr.rechercheParticipantEpreuve(a)==null)){ep = epr;}
            }
            List<Athlete> l = dico.get(new Pair<>(ep.getNom(), a.obtenirSexe()));
            if(l==null){
                l=new ArrayList<Athlete>();
                dico.put(new Pair<>(ep.getNom(), a.obtenirSexe()), l);}
            l.add(a);
            for(Epreuve e : this.gestion.getEpreuves()){
                
            }
            ajouteAthlete(a, null, p);
            ajoutePays(p);
            ajouteEquipe(null, p);
        }
    }

    public int ajouteAthlete(Athlete a, Equipe e, Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into ATHLETE values (?,?,?,?,?,?,?,?,?)");
        int id = maxNumAthlete() + 1;
        ps.setInt(1,id);
        ps.setString(2,a.obtenirNom());
        ps.setString(3,a.getPrenom());
        ps.setString(4,a.obtenirSexe());
        ps.setInt(5,a.getForce());
        ps.setInt(6,a.getAgilite());
        ps.setInt(7,a.getEndurance());
        ps.setString(8, e.obtenirNom());
        ps.setString(9,p.getNom());
        ps.execute();
        return maxNumAthlete();
    }


    public void effacerAthlete(int id) throws SQLException {
		PreparedStatement ps = this.laConnexion.prepareStatement("delete from ATHLETE where idA = ?");
		ps.setInt(1, id);
		ps.execute();
	}

    public void majAthlete(Athlete a, Equipe e, Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("update IGNORE ATHLETE set idA = ?,"+"nomA = ?,"+"prenomA= ?,"+"sexeA = ?,"+"force = ?,"+"agilite = ?,"+"endurance = ?,"+"nomEq = nomEq,"+"nomP = nomP");
        int id = maxNumAthlete() + 1;
        ps.setInt(1,id);
        ps.setString(2,a.obtenirNom());
        ps.setString(3,a.getPrenom());
        ps.setString(4,a.obtenirSexe());
        ps.setInt(5,a.getForce());
        ps.setInt(6,a.getAgilite());
        ps.setInt(7,a.getEndurance());
        ps.setString(8, e.obtenirNom());
        ps.setString(9,p.getNom());
        ps.executeUpdate();
    }


    public void ajouteEquipe(Equipe e,Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into EQUIPE values (?,?,?)");
        ps.setString(1,e.obtenirNom());
        ps.setString(2, e.obtenirSexe());
        ps.setString(3,p.getNom() );
        ps.execute();
    }

    public void effacerEquipe(Equipe e) throws SQLException {
		PreparedStatement ps = this.laConnexion.prepareStatement("delete from EQUIPE where nomEq = ?");
		ps.setString(1, e.obtenirNom());
		ps.execute();
	}
    public void maJEquipe(Equipe e,Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("update IGNORE EQUIPE set nomEq = ?,"+"sexeE = ?,"+"nomP = ?");
        ps.setString(1, e.obtenirNom());
        ps.setString(2, e.obtenirSexe());
        ps.setString(3,p.getNom());
        ps.executeUpdate();
    }

    public void ajoutePays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("Insert into PAYS values (?,?,?,?)");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.getNbMedaillesOr());
        ps.setInt(3, p.getNbMedaillesArgent());
        ps.setInt(4, p.getNbMedaillesBronze());
        ps.execute();
    }

    public void effacerPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("delete from PAYS where nomP = ?");
        ps.setString(0, p.getNom());
        ps.execute();
    }

    public void maJPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("upadte IGNORE PAYS set nomP = ?,"+"medailleOR = ?,"+"medailleARGENT = ?,"+"medailleBRONZE = ?");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.getNbMedaillesOr());
        ps.setInt(3, p.getNbMedaillesArgent());
        ps.setInt(4, p.getNbMedaillesBronze());
        ps.executeUpdate();
    }

    public void lancegcsv(){
    try {
        String pythonInterpreter = "python3";
        String pythonScriptPath = "gcsv.py";
        ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, pythonScriptPath);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        //while ((line = reader.readLine()) != null) {
        //    System.out.println(line);
        //}
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}