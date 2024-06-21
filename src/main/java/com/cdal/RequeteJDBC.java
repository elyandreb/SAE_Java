package main.java.com.cdal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequeteJDBC {
    private AppIUTO appli;
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

    public int maxNumSport() throws SQLException {
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select max(idA) from SPORT");
		if (rs.next()) {
			int maxNum = rs.getInt(1);
			rs.close();
			return maxNum;
		}
		rs.close();
		return 0;
	}

    public int maxNumEquipe() throws SQLException {
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select max(idEq) from EQUIPE");
		if (rs.next()) {
			int maxNum = rs.getInt(1);
			rs.close();
			return maxNum;
		}
		rs.close();
		return 0;
	}
    public ArrayList<String> classementPays() throws SQLException {
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

    public ArrayList<String> classementEpreuve(Equipe e, Athlete a) throws SQLException {
        int cpt = 0;
        ArrayList<String>  classement =  new ArrayList<>();
        String res = null;
        PreparedStatement ps = this.laConnexion.prepareStatement("Select nomEp, prenomA, nomA, nomP, resultats"+" FROM ATHLETE NATURAL JOIN PAYS NATURAL JOIN EPREUVE NATURAL JOIN SCORE"+
        "where nomEp = ? and sexeA = ? ORDER BY resultats");
        ps.setString(1, e.getNom());
        ps.setString(2, a.getSexe());
        ResultSet r = ps.executeQuery();
        classement.add(r.getString(1));
        while(r.next()){
            st.close();
            res += cpt+ r.getString(2) + r.getString(3) + r.getString(4) + r.getInt(5) ;
            cpt+=1;
        }  
        return classement; 
    }


    public int ajoutAthlete(Athlete a, Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into ATHLETE values (?,?,?,?,?,?,?,?)");
        int id = maxNumAthlete() + 1;
        ps.setInt(1,id);
        ps.setString(2,a.getNom());
        ps.setString(3,a.getPrenom());
        ps.setString(4,a.getSexe());
        ps.setInt(5,a.getForce());
        ps.setInt(6,a.getAgilite());
        ps.setInt(7,a.getEndurance());
        ps.setString(8,p.getNom());
        ps.execute();
        return maxNumAthlete();
    }


    public void effacerAthlete(String nom, String prenom) throws SQLException {
		PreparedStatement ps = this.laConnexion.prepareStatement("delete from ATHLETE where nomA = ? and prenomA = ?");
		ps.setString(1, nom);
	    ps.setString(2, prenom);
		ps.execute();
	}

    public void majAthlete(Athlete a, Equipe e, Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("update IGNORE ATHLETE set idA = ?,"+"nomA = ?,"+"prenomA= ?,"+"sexeA = ?,"+"force = ?,"+"agilite = ?,"+"endurance = ?,"+"nomEq = nomEq,"+"nomP = nomP");
        int id = maxNumAthlete() + 1;
        ps.setInt(1,id);
        ps.setString(2,a.getNom());
        ps.setString(3,a.getPrenom());
        ps.setString(4,a.getSexe());
        ps.setInt(5,a.getForce());
        ps.setInt(6,a.getAgilite());
        ps.setInt(7,a.getEndurance());
        ps.setString(8, e.getNom());
        ps.setString(9,p.getNom());
        ps.executeUpdate();
    }


    public void ajoutEquipe(Equipe e,Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into EQUIPE values (?,?,?)");
        ps.setInt(1, maxNumEquipe() + 1);
        ps.setString(2,e.getNom());
        ps.setString(3,p.getNom() );
        ps.execute();
    }

    public void effacerEquipe(String nomEq) throws SQLException {
		PreparedStatement ps = this.laConnexion.prepareStatement("delete from EQUIPE where nomEq = ?");
		ps.setString(1, nomEq);
		ps.execute();
	}

    public void maJEquipe(Equipe e,Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(" update IGNORE EQUIPE set nomEq = ?,"+"nomP = ?");
        ps.setString(1, e.getNom());
        ps.setString(2,p.getNom());
        ps.executeUpdate();
    }

    public void ajoutPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("Insert into PAYS values (?,?,?,?)");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.getNbMedaillesOr());
        ps.setInt(3, p.getNbMedaillesArgent());
        ps.setInt(4, p.getNbMedaillesBronze());
        ps.execute();
    }

    public void effacerPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("delete from PAYS where nomP = ?");
        ps.setString(1, p.getNom());
        ps.execute();
    }

    public void maJPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("update IGNORE PAYS set nomP = ?,"+"medailleOR = ?,"+"medailleARGENT = ?,"+"medailleBRONZE = ?");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.getNbMedaillesOr());
        ps.setInt(3, p.getNbMedaillesArgent());
        ps.setInt(4, p.getNbMedaillesBronze());
        ps.executeUpdate();
    }

    public boolean cherchePays(String nom) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("select * from PAYS where nomP = ?");
        ps.setString(1, nom);
        ResultSet r = ps.executeQuery();
        while(r.next()){
            return true;
        }  
        return false; 
    }

    public void ajoutSport(String nom, String catégorie, int nbj) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("insert into SPORT values (?,?,?,?)");
        ps.setInt(1, maxNumSport()+1);
        ps.setString(2, nom);
        ps.setString(3, catégorie);
        ps.setInt(4, nbj);
        ps.execute();
    }

    public void effacerSport(int id) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("delete from SPORT where idS = ?");
        ps.setInt(1, id);
        ps.execute();
    }

    public void majSport(String nom, String catégorie, int nbj) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("update IGNORE SPORT set nomS = ?,"+"categorieS = ?,"+"nbJ = ?");
        ps.setString(2, nom);
        ps.setString(3, catégorie);
        ps.setInt(4, nbj);
        ps.executeUpdate();
    }

    public void ajoutEpreuve(Epreuve e) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("Select idS FROM SPORT where nomS = ? and categorie = ? and nombreJoueurs = ?");
        ps.setString(1, e.getNom());
        ps.setString(2, e.getGenre());
        ps.setInt(3, e.getSport().getNbJoueur());
        ResultSet r = ps.executeQuery();
        while(r.next()){
            PreparedStatement pss = this.laConnexion.prepareStatement("insert into EPREUVE values (?,?,?)");
            pss.setString(1, e.getNom());
            pss.setString(2, e.getGenre());
            pss.setInt(3, r.getInt(1));
            pss.execute();
        }
    }
    public void effacerEpreuve(String nomE, String nomS) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("DELETE FROM EPREUVE WHERE nomEp = ? AND EXISTS (SELECT 1 FROM SPORT WHERE SPORT.nomS = ? AND SPORT.idS = EPREUVE.idS)");
        ps.setString(1, nomE);
	    ps.setString(2, nomS);
        ps.execute();
    }

    public void majEpreuve(String nom, String genre, Sport sport) throws SQLException{
        PreparedStatement ps = this.laConnexion.prepareStatement("Select idS FROM SPORT where nomS = ? and categorie = ? and nombreJoueurs = ?");
        ps.setString(1, sport.getNom());
        ps.setString(2, sport.getCategorie());
        ps.setInt(3, sport.getNbJoueur());
        ResultSet r = ps.executeQuery();
        while(r.next()){
            PreparedStatement pss = this.laConnexion.prepareStatement("update IGNORE EPREUVE set nomE = ?,"+"genreE = ?,"+"idS = ?");
            pss.setString(1, nom);
            pss.setString(2, genre);
            pss.setInt(3, r.getInt(1));
            pss.executeUpdate();
        }
    }



}
