package eband.app.algoritmoMgmt;

import eband.app.sociMgmt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class AlgoritmoService {
	
	/**
	 * Il metodo dopo aver eseguito la connessione con il database e aver salvato in un Array tutti i cosi che hanno confermato
	 * la presenza all'evento specificato con l'ID richiama l'esecuzione dell'algoritmo per il calcolo dei dati della formazione.
	 * @param id che rappresenta il codice dell'evento di cui calcolare la formazione
	 * @return ArrayList di tipo ResDatiFormazione che fornisce tutti i dati relativi alla formazione calcolata.
	 */
	public ArrayList<ResDatiFormazione> ottieniDati(int id) {
		
		ArrayList<Soci> arrayFormazione = new ArrayList<Soci>();
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebanddb", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id, cognome, nome, ruolo1, ruolo2 FROM `soci` JOIN `gestionepresenze` WHERE soci.id=gestionepresenze.id_socio AND id_evento="+id); 
			
			while(resultSet.next()) {
				
				arrayFormazione.add(new Soci(resultSet.getLong("id"),
											resultSet.getString("nome"), 
											resultSet.getString("cognome"),
											null, null, null, 
											resultSet.getString("ruolo1"), 
											resultSet.getString("ruolo2")
								));
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return new Algoritmo().datiFormazione(arrayFormazione);
	}
	
	/**
	 * Il metodo dopo aver eseguito la connessione con il database e aver salvato in un Array tutti i cosi che hanno confermato
	 * la presenza all'evento specificato con l'ID richiama l'esecuzione dell'algoritmo per il calcolo della formazione.
	 * @param int che rappresenta il codice dell'evento di cui calcolare la formazione
	 * @return ArrayList di tipo ResAlgoritmo che fornisce l'elenco dei Soci della formazione calcolata ognuno con il relativo ruolo indicato.
	 */
	public ArrayList<ResAlgoritmo> creaFormazione(int idevento) {
		
		ArrayList<Soci> arrayFormazione = new ArrayList<Soci>();
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebanddb", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id, cognome, nome, ruolo1, ruolo2 FROM `soci` JOIN `gestionepresenze` WHERE soci.id=gestionepresenze.id_socio AND id_evento="+idevento); 
			
			while(resultSet.next()) {
				
				arrayFormazione.add(new Soci(	resultSet.getLong("id"),
												resultSet.getString("nome"), 
												resultSet.getString("cognome"),
												null, null, null, 
												resultSet.getString("ruolo1"), 
												resultSet.getString("ruolo2")
											));
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return new Algoritmo().eseguiAlgoritmo(arrayFormazione);
	}
}