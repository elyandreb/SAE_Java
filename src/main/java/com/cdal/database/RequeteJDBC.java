package main.java.com.cdal.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.cdal.*;

public class RequeteJDBC {
    private ConnexionBD laConnexion;
    private Statement st;
    
    public RequeteJDBC (ConnexionBD mysql){
        this.laConnexion = mysql;
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
		return 0;
	}
    public ArrayList<String> ClassementPays() throws SQLException {
        ArrayList<String> listePays = new ArrayList<>();
        String res  = null;
        int cpt = 0;
        this.st = laConnexion.createStatement();
        ResultSet r = this.st.executeQuery("SELECT nomP, medailleOR, medailleARGENT, medailleBRONZE, " +
        "(medailleOR + medailleARGENT + medailleBRONZE) as total " +
        "FROM PAYS " +
        "ORDER BY totalMedals DESC");
        while(r.next()){
            st.close();
            res += cpt + r.getString(1) + r.getInt(2) + r.getInt(3) + r.getInt(4);
            cpt+=1;
            listePays.add(res);
        }
        return listePays;

    }

    public ArrayList<String> ClassementEpreuve(Equipe e, Athlete a) throws SQLException {
        int cpt = 0;
        ArrayList<String>  classement =  new ArrayList<>();
        String res = null;
        PreparedStatement ps = this.laConnexion.prepareStatement("Select nomEp, prenomA, nomA, nomP, resultats"+" FROM ATHLETE NATURAL JOIN PAYS NATURAL JOIN EPREUVE NATURAL JOIN SCORE"+
        "where nomEp = ? and sexeA = ? ORDER BY resultats");
        ps.setString(1, e.obtenirNom());
        ps.setString(2, a.obtenirSexe());
        ResultSet r = ps.executeQuery();
        classement.add(r.getString(1));
        while(r.next()){
            st.close();
            res += cpt+ r.getString(2) + r.getString(3) + r.getString(4) + r.getInt(5) ;
            cpt+=1;
        }  
        return classement; 
    }


    public int ajoutAthlete(Athlete a, Equipe e, Pays p) throws SQLException {
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

    public void MajAthlete(Athlete a, Equipe e, Pays p) throws SQLException {
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


    public void AjoutEquipe(Equipe e,Pays p) throws SQLException {
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
    public void MaJEquipe(Equipe e,Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(" update IGNORE EQUIPE set nomEq = ?,"+"sexeE = ?,"+"nomP = ?");
        ps.setString(1, e.obtenirNom());
        ps.setString(2, e.obtenirSexe());
        ps.setString(3,p.getNom());
        ps.executeUpdate();
    }

    public void AjoutPays(Pays p) throws SQLException {
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

    public void MaJPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("upadte IGNORE PAYS set nomP = ?,"+"medailleOR = ?,"+"medailleARGENT = ?,"+"medailleBRONZE = ?");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.getNbMedaillesOr());
        ps.setInt(3, p.getNbMedaillesArgent());
        ps.setInt(4, p.getNbMedaillesBronze());
        ps.executeUpdate();
    }



}