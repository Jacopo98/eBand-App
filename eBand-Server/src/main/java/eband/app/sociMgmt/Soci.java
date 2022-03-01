package eband.app.sociMgmt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Soci {

	private @Id @GeneratedValue Long id; // questa variabile è chiave primaria ed è un valore generato dal server
	private String nome;
	private String cognome;
	private String dob;
	private String residenza;
	private String dataisc;
	private String ruolo1;
	private String ruolo2;

	/**
	 * Restituisce l'ID relativo al socio su cui viene richiesto
	 * 
	 * @return ID del Socio
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID relativo al socio su cui viene eseguito il metodo
	 * 
	 * @param id da impostare al Socio
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il Nome relativo al socio su cui viene richiesto
	 * 
	 * @return Nome del Socio
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome relativo al socio su cui viene eseguito il metodo
	 * 
	 * @param nome da impostare al Socio
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il Cognome relativo al socio su cui viene richiesto
	 * 
	 * @return Cognome del Socio
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Imposta il cognome relativo al socio su cui viene eseguito il metodo
	 * 
	 * @param cognome da impostare al Socio
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Restituisce la data di nascita relativa al socio su cui viene richiesto
	 * 
	 * @return data di nascita del Socio
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Imposta la data di nascita relativa al socio su cui viene eseguito il metodo
	 * 
	 * @param data di nascita da impostare al Socio
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Restituisce la residenza relativa al socio su cui viene richiesto
	 * 
	 * @return residenza del Socio
	 */
	public String getResidenza() {
		return residenza;
	}

	/**
	 * Imposta la residenza relativa al socio su cui viene eseguito il metodo
	 * 
	 * @param data di nascita da impostare al Socio
	 */
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	/**
	 * Restituisce la data d'iscrizione relativa al socio su cui viene richiesto
	 * 
	 * @return data iscrizione del Socio
	 */
	public String getDataisc() {
		return dataisc;
	}

	/**
	 * Imposta la data d'iscrizione relativa al socio su cui viene eseguito il
	 * metodo
	 * 
	 * @param data d'iscrizione da impostare al Socio
	 */
	public void setDataisc(String dataisc) {
		this.dataisc = dataisc;
	}

	/**
	 * Restituisce il ruolo1 relativo al socio su cui viene richiesto
	 * 
	 * @return ruolo1 del Socio
	 */
	public String getRuolo1() {
		return ruolo1;
	}

	/**
	 * Imposta il ruolo1 relativo al socio su cui viene eseguito il metodo
	 * 
	 * @param ruolo1 da impostare al Socio
	 */
	public void setRuolo1(String ruolo1) {
		this.ruolo1 = ruolo1;
	}

	/**
	 * Restituisce il ruolo2 relativo al socio su cui viene richiesto
	 * 
	 * @return ruolo2 del Socio
	 */
	public String getRuolo2() {
		return ruolo2;
	}

	/**
	 * Imposta il ruolo2 relativo al socio su cui viene eseguito il metodo
	 * 
	 * @param ruolo2 da impostare al Socio
	 */
	public void setRuolo2(String ruolo2) {
		this.ruolo2 = ruolo2;
	}

	Soci() {
	}

	public Soci(String nome, String cognome, String dob, String residenza, String dataisc, String ruolo1,
			String ruolo2) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.dataisc = dataisc;
		this.ruolo1 = ruolo1;
		this.ruolo2 = ruolo2;
	}

	public Soci(Long id, String nome, String cognome, String dob, String residenza, String dataisc, String ruolo1,
			String ruolo2) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.dataisc = dataisc;
		this.ruolo1 = ruolo1;
		this.ruolo2 = ruolo2;
	}

}
