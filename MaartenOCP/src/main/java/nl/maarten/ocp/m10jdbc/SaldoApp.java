package nl.maarten.ocp.m10jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaldoApp {

	public static void main(String[] args) {
		int id;
		int klantnr;
		double mutatie;
		try (Connection con = MyConnection.connect();
			     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 PreparedStatement ps = con.prepareStatement("update j_klanten set opensaldo = opensaldo + ? where klantnr = ?");
				 ResultSet rset = stmt.executeQuery("select id, klantnr, mutatie, uitgevoerd from j_saldomutatie where uitgevoerd=0");
				 
					) {
				while (rset.next()) {
					// Bijwerken saldo
					ps.setDouble(1,rset.getDouble("mutatie"));
					ps.setInt(2, rset.getInt("klantnr"));
					ps.execute();
					// Bijwerken saldomutatie
					rset.updateInt("uitgevoerd",1);
					rset.updateRow();
				}
				// Uitvoeren commit
				con.commit();
			} catch (SQLException e) {
				System.err.println(e);
			}	
    
	}

}
class MyConnection {
	 private final static String url = 
			 "jdbc:mysql://localhost:3306/javacursus?useSSL=false&useJDBCCompliantTimezoneShift=true&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=CET";
	        //protocol:vendor//locatie:poort/database
	 public static Connection connect() {
		 try {
			 Connection conn = DriverManager.getConnection(url,"cursist","vh_cursus");
			 conn.setAutoCommit(false);
			 return conn;
		 } catch (SQLException e) {
			 System.err.println("Fout bij inloggen "+e.getMessage());
			 return null;
		 }
	 }
}
