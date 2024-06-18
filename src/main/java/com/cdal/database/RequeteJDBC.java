package src.main.java.com.cdal.database;
import java.sql.*;
import java.util.ArrayList;

import src.main.java.com.cdal.Athlete;

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

    public ArrayList<String> ClassementEpreuve(String nomE, String sexeA) throws SQLException {
        int cpt = 0;
        ArrayList<String>  classement =  new ArrayList<>();
        String res = null;
        PreparedStatement ps = this.laConnexion.preparedStatement("Select nomEp, prenomA, nomA, nomP, resultats"+" FROM ATHLETE NATURAL JOIN PAYS NATURAL JOIN EPREUVE NATURAL JOIN SCORE"+
        "where nomEp = ? and sexeA = ? ORDER BY resultats");
        ps.setString(1, nomE);
        ps.setString(2, sexeA);
        ResultSet r = ps.executeQuery();
        classement.add(r.getString(1));
        while(r.next()){
            st.close();
            res += cpt+ r.getString(2) + r.getString(3) + r.getString(4) + r.getInt(5) ;
            cpt+=1;
        }   
    }


    public int ajoutAthlete(Athlete a, String nomEq, String nomP){
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into ATHLETE values (?,?,?,?,?,?,?,?,?)");
        int id = maxNumAthlete() + 1;
        ps.setInt(1,id);
        ps.setString(2,a.obtenirNom());
        ps.setString(3,a.getPrenom());
        ps.setString(4,a.obtenirSexe());
        ps.setInt(5,a.getForce());
        ps.setInt(6,a.getAgilite());
        ps.setInt(7,a.getEndurance());
        ps.setString(8, nomEq);
        ps.setString(9,nomP);
        ps.execute();
        return maxNumAthlete();
    }


    public void effacerAthlete(int id) throws SQLException {
		PreparedStatement ps = this.laConnexion.prepareStatement("delete from ATHLETE where idA = ?");
		ps.setInt(1, id);
		ps.execute();
	}

    public void MajAthlete(ind id) throws SQLException {
        PreparedStatement ps = this.laConnexion.preparedStatement("")
    }


}