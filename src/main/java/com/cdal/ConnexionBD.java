package main.java.com.cdal;

import java.sql.*;


public class ConnexionBD {
	private Connection mysql=null;
	private boolean connecte=false;
	public ConnexionBD() throws ClassNotFoundException{
		Class.forName("org.mariadb.jdbc.Driver");
	}

	public void connecter() throws SQLException {
		this.mysql = DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/DBdumas","dumas","dumas");
		this.connecte=mysql!=null;
	}
	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}

    	public boolean isConnecte() { return this.connecte;}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
	
}
