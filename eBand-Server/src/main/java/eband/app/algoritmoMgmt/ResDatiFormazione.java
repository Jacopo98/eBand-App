package eband.app.algoritmoMgmt;

public class ResDatiFormazione {

	int n_tot;
	int n_flauti;
	int n_clarinetti;
	int n_trombe;
	int n_sax;
	int n_tube;
	int n_percussioni;

	public ResDatiFormazione(int n_tot, int n_flauti, int n_clarinetti, int n_trombe, int n_sax, int n_tube,
			int n_percussioni) {
		super();
		this.n_tot = n_tot;
		this.n_flauti = n_flauti;
		this.n_clarinetti = n_clarinetti;
		this.n_trombe = n_trombe;
		this.n_sax = n_sax;
		this.n_tube = n_tube;
		this.n_percussioni = n_percussioni;
	}

	/**
	 * Restituisce il numero totale di musicisti
	 * 
	 * @return Numero totale di musicisti
	 */
	public int getN_tot() {
		return n_tot;
	}

	/**
	 * Restituisce il numero di fluati in formazione
	 * 
	 * @return Numero di fluati in formazione
	 */
	public int getN_flauti() {
		return n_flauti;
	}

	/**
	 * Restituisce il numero di clarinetti in formazione
	 * 
	 * @return Numero di clarinetti in formazione
	 */
	public int getN_clarinetti() {
		return n_clarinetti;
	}

	/**
	 * Restituisce il numero di trombe in formazione
	 * 
	 * @return Numero di trombe in formazione
	 */
	public int getN_trombe() {
		return n_trombe;
	}

	/**
	 * Restituisce il numero di sax in formazione
	 * 
	 * @return Numero di sax in formazione
	 */
	public int getN_sax() {
		return n_sax;
	}

	/**
	 * Restituisce il numero di tube in formazione
	 * 
	 * @return Numero di tube in formazione
	 */
	public int getN_tube() {
		return n_tube;
	}

	/**
	 * Restituisce il numero di percussioni in formazione
	 * 
	 * @return Numero di percussioni in formazione
	 */
	public int getN_percussioni() {
		return n_percussioni;
	}

}
