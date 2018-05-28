package nl.maarten.ocp.m10jdbc;

import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = MyConnectiona.connect();
		     Statement stmt = con.createStatement();
			 ResultSet rset = stmt.executeQuery("select naam from j_klanten");
				) {
			while (rset.next()) {
				System.out.println(rset.getString("naam"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}	
	}

}
 class MyConnectiona {
	 private final static String url = 
			 "jdbc:mysql://localhost:3306/javacursus?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CET";
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
 