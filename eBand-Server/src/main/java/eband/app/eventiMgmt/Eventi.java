package eband.app.eventiMgmt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Eventi {

	private @Id @GeneratedValue Long id; // questa variabile è chiave primaria ed è un valore generato dal server
	private String tipologia;
	private String data;
	private String ora;

	/**
	 * Restituisce l'ID dell'evento su cui è eseguito il metodo
	 * 
	 * @return ID dell'evento
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID dell'evento
	 * 
	 * @param id da impostare all'evento
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce la tipologia dell'evento su cui è eseguito il metodo
	 * 
	 * @return Tipologia dell'evento
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * Imposta la tipologia dell'evento
	 * 
	 * @param tipologia da impostare all'evento
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * Restituisce la data dell'evento su cui è eseguito il metodo
	 * 
	 * @return data dell'evento
	 */
	public String getData() {
		return data;
	}

	/**
	 * Imposta la data dell'evento
	 * 
	 * @param data da impostare all'evento
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Restituisce l'ora dell'evento su cui è eseguito il metodo
	 * 
	 * @return ora dell'evento
	 */
	public String getOra() {
		return ora;
	}

	/**
	 * Imposta l'ora dell'evento
	 * 
	 * @param ora da impostare all'evento
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}

	Eventi() {
	}

	public Eventi(String tipologia, String data, String ora) {
		super();
		this.tipologia = tipologia;
		this.data = data;
		this.ora = ora;
	}

}
