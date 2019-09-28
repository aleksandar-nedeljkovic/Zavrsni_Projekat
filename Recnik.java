package zavrsniprojekat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Recnik {
	private HashMap<String, String> recnik;
	private String connString = "jdbc:sqlite:C:\\Users\\nedel\\OneDrive\\Desktop\\Zavrsni Projekat\\Dictionary.db";

	public Recnik() {
		recnik = new HashMap<String, String>();
		novaTabela();
	}

	private void novaTabela() {
		try (Connection con = DriverManager.getConnection(connString)) {
			Statement stm = con.createStatement();
			
			String upit = "CREATE TABLE IF NOT EXISTS noveReci (word varchar(30) NOT NULL)";
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void popuniRecnik() {
		try (Connection con = DriverManager.getConnection(connString)) {
			
			Statement stm = con.createStatement();
			
			String upit = "SELECT word, definition "
					+ " FROM entries";
			
			ResultSet rs = stm.executeQuery(upit);
			while (rs.next()) {
				String rec = rs.getString("word").toLowerCase();
				String definicija = rs.getString("definition");
				recnik.put(rec, definicija);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dodajNovuRec(String s) {
		s = s.toLowerCase();
		try (Connection con = DriverManager.getConnection(connString)) {
			
			Statement stm1 = con.createStatement();
	
			String upit1 = "SELECT word "
					+ " FROM noveReci "
					+ " WHERE word = '" + s + "'";
			
			ResultSet rs = stm1.executeQuery(upit1);

			if (rs.next() == false) {
	
				Statement stm2 = con.createStatement();
				
				String upit2 = "INSERT INTO NoveReci (word) "
						+ " VALUES ('" + s + "')";
				
				stm2.executeUpdate(upit2);
				stm2.close();
			}
			stm1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean nadjiRec(String s) {
		s = s.toLowerCase();
		if (recnik.containsKey(s))
			return true;
		else
			return false;
	}

	public HashMap<String, String> getRecnik() {
		return recnik;
	}
	
}
