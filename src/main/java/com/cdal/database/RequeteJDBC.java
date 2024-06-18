package src.main.java.com.cdal.database;
import java.sql.*;
import java.util.ArrayList;

public class RequeteJDBC {
    private ConnexionMySql laConnexion;
    private Statement st;
    
    public RequeteJDBC (ConnexionMySql mysql){
        this.laConnexion = mysql;
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
            res += cpt + r.getString(0) + r.getInt(1) + r.getInt(2) + r.getInt(3);
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
        classement.add(r.getString(0));
        while(r.next()){
            st.close();
            res += cpt+ r.getString(1) + r.getString(2) + r.getString(3) + r.getInt(4) ;
            cpt+=1;
        }   
    }
}