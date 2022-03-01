package eband.app.algoritmoMgmt;

public class ResAlgoritmo {
	Long id;
	String cognome;
	String nome;
	String ruolo;

	public ResAlgoritmo(Long id, String cognome, String nome, String ruolo) {
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
	}

	/**
	 * Restituisce l'ID del socio
	 * 
	 * @return ID del socio
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Restituisce il Ruolo assegnato al socio per l'evento in questione
	 * 
	 * @return Ruolo
	 */
	public String getRuolo() {
		return ruolo;
	}

	/**
	 * Restituisce il cognome del socio
	 * 
	 * @return Cognome del socio
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Restituisce il nome del socio
	 * 
	 * @return Nome del socio
	 */
	public String getNome() {
		return nome;
	}

}
