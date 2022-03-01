package eband.app.algoritmoMgmt;

import eband.app.sociMgmt.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Algoritmo {

	public Algoritmo() {
	}

	/**
	 * Algoritmo di calcolo della formazione per l'evento selezionato, restituisce
	 * l'elenco dei Soci: ID, cognome, nome e ruolo selezionato.
	 * 
	 * @param ArrayList di Soci
	 * @return ArrayList di tipo ResAlgoritmo che fornisce l'elenco dei Soci della
	 *         formazione calcolata ognuno con il relativo ruolo indicato.
	 */
	public ArrayList<ResAlgoritmo> eseguiAlgoritmo(ArrayList<Soci> arrayInput) {

		ArrayList<ResAlgoritmo> arrayFormazione = new ArrayList<>();

		int N_flauti = 0;
		int N_clarinetti = 0;
		int N_trombe = 0;
		int N_sax = 0;
		int N_tube = 0;
		int N_percussioni = 0;

		// Inizio ad inserire in formazione coloro che hanno solo un ruolo cosicché non
		// assegno una posizione ad un musicista che potrebbe ricoprirne una dove non si raggiunge il numero minimo.

		Soci socioTemp = null;
		// Questo iterator consente di cancellare elementi dall'array mentre l'iterazione è ancora in corso.
		ListIterator<Soci> iterator = arrayInput.listIterator();
		while (iterator.hasNext()) {
			socioTemp = iterator.next();
			if (socioTemp.getRuolo2().isEmpty()) { // siamo nel caso di un socio con ruolo unico
				arrayFormazione.add(new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(), socioTemp.getRuolo1()));
				switch (socioTemp.getRuolo1()) {
				case "flauto":
					N_flauti++;
					break;
				case "clarinetto":
					N_clarinetti++;
					break;
				case "tromba":
					N_trombe++;
					break;
				case "sax":
					N_sax++;
					break;
				case "tuba":
					N_tube++;
					break;
				case "percussioni":
					N_percussioni++;
					break;
				}
				iterator.remove(); // Una volta "salvato" il socio, lo posso rimuovere dalla lista temporanea
			}
		}

		// Procedo inserendo in ordine fino a che un gruppo è completo, a quel punto non
		// aggiungo altri musicisti al gruppo fino a che tutti gli altri gruppi sono completi
		// NB: precedenza sempre al ruolo1 che si presuppone essere quello di specializzazione.

		for (int x = 0; x < 2; x++) { // faccio ripetere tutto due volte, al secondo giro provo a rimepire le mancanze
									  // nei gruppi usando i ruoli secondari

			iterator = arrayInput.listIterator(); // Resetta l'iteratore alla posizione iniziale della lista
			while (iterator.hasNext()) {
				String ruolo;
				socioTemp = iterator.next();
				if (x == 0)
					ruolo = socioTemp.getRuolo1();
				else
					ruolo = socioTemp.getRuolo2();

				if (ruolo.equals("flauto") && N_flauti == 3)
					continue;
				if (ruolo.equals("clarinetto") && N_clarinetti == 3)
					continue;
				if (ruolo.equals("tromba") && N_trombe == 3)
					continue;
				if (ruolo.equals("sax") && N_sax == 3)
					continue;
				if (ruolo.equals("tuba") && N_tube == 3)
					continue;
				if (ruolo.equals("percussioni") && N_percussioni == 3)
					continue;

				if (notInFormazione(socioTemp.getId(), arrayFormazione)) { // aggiunto se non gia presente in formazione

					arrayFormazione.add(
							new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(), ruolo));
					switch (ruolo) {
					case "flauto":
						N_flauti++;
						break;
					case "clarinetto":
						N_clarinetti++;
						break;
					case "tromba":
						N_trombe++;
						break;
					case "sax":
						N_sax++;
						break;
					case "tuba":
						N_tube++;
						break;
					case "percussioni":
						N_percussioni++;
						break;
					}
					iterator.remove(); // Una volta "salvato" il socio, lo posso rimuovere dalla lista temporanea
				}
			}
		}

		System.out.println();

		// Verifica fattibilità evento:
		if (arrayFormazione.size() < 18) {
			System.out.println("ATTENZIONE! \nNon possibile fare l'evento. Non si dispone"
					+ "del numero minimo di componenti per ogni strumento.\n");

			// A questo punto analizzando i ruoli principali ho riempito dove possibile i gruppi di ogni
			// strumento e con i rimanenti, basandomi sui ruoli secondari, ho riempito le
			// mancanze di ogni gruppo. Se alla fine di questa fase non sono raggiunti i numeri
			// minimi l'evento di quella data non è fattibile e viene mostrato in output.

			// A questo punto se ho a disposizione ancora musicisti li convoco sulla base
			// del loro ruolo primario.
			
		} else {
			iterator = arrayInput.listIterator();
			while (iterator.hasNext()) {
				socioTemp = iterator.next();
				String ruolo = socioTemp.getRuolo1();

				if (notInFormazione(socioTemp.getId(), arrayFormazione)) { // aggiunto se non gia presente in formazione

					arrayFormazione.add(
							new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(), ruolo));
					switch (ruolo) {
					case "flauto":
						N_flauti++;
						break;
					case "clarinetto":
						N_clarinetti++;
						break;
					case "tromba":
						N_trombe++;
						break;
					case "sax":
						N_sax++;
						break;
					case "tuba":
						N_tube++;
						break;
					case "percussioni":
						N_percussioni++;
						break;
					}
					// Qui non serve più rimuovere l'i-esimo socio perchè è l'ultimo ciclo dell'algoritmo
				}
			}
		}
		return arrayFormazione;
	}

	/**
	 * Verifica della presenza dell'ID specificto nell'Array che consituisce la formazione. 
	 * Restituisce TRUE se non è presente e FALSE se è presente.
	 * @param Long ID
	 * @param ArrayList di ResAloritmo
	 * @return False o True in base al fatto che sia rispettivamente già inserito o meno un socio
	 *         nella formazione della banda per l'evento della data selezionata.
	 */
	static boolean notInFormazione(Long idDaControllare, ArrayList<ResAlgoritmo> arrayFormazione) {
		for (int i = 0; i < arrayFormazione.size(); i++) {
			if (idDaControllare == arrayFormazione.get(i).getId()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Algoritmo di calcolo della formazione per l'evento selezionato, restituisce
	 * i dati relativi ai gruppi formati per ogni strumento.
	 * @param ArrayList di Soci
	 * @return ArrayList di tipo ResDatiFormazione che fornisce tutti i dati
	 *         relativi alla formazione calcolata.
	 */
	public ArrayList<ResDatiFormazione> datiFormazione(ArrayList<Soci> arrayInput) {

		ArrayList<ResAlgoritmo> arrayFormazione = new ArrayList<>();

		int N_flauti = 0;
		int N_clarinetti = 0;
		int N_trombe = 0;
		int N_sax = 0;
		int N_tube = 0;
		int N_percussioni = 0;

		// Inizio ad inserire in formazione coloro che hanno solo un ruolo cosicché non
		// assegno una posizione ad un musicista che potrebbe ricoprirne una dove non si
		// raggiunge il numero minimo.
		ListIterator<Soci> iterator = arrayInput.listIterator();
		Soci socioTemp = null;

		while (iterator.hasNext()) {
			socioTemp = iterator.next();
			if (socioTemp.getRuolo2().isEmpty()) { // siamo nel caso di un socio con ruolo unico

				arrayFormazione.add(new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(),
						socioTemp.getRuolo1()));

				switch (socioTemp.getRuolo1()) {
				case "flauto":
					N_flauti++;
					break;
				case "clarinetto":
					N_clarinetti++;
					break;
				case "tromba":
					N_trombe++;
					break;
				case "sax":
					N_sax++;
					break;
				case "tuba":
					N_tube++;
					break;
				case "percussioni":
					N_percussioni++;
					break;
				}
				iterator.remove();
			}
		}

		// Procedo inserendo in ordine fino a che un gruppo � completo, a quel punto non
		// aggiungo altri musicisti al gruppo fino a che tutti gli altri gruppi sono
		// completi
		// NB: precedenza sempre al ruolo1 che si presuppone essere quello di
		// specializzazione.

		for (int x = 0; x < 2; x++) { // faccio ripetere tutto due volte, al secondo giro provo a rimepire le mancanze
									  // nei gruppi usando i ruoli secondari

			iterator = arrayInput.listIterator(); // Resetta l'iteratore alla posizione iniziale della lista
			while (iterator.hasNext()) {
				String ruolo;
				socioTemp = iterator.next();
				if (x == 0)
					ruolo = socioTemp.getRuolo1();
				else
					ruolo = socioTemp.getRuolo2();

				if (ruolo.equals("flauto") && N_flauti == 3)
					continue;
				if (ruolo.equals("clarinetto") && N_clarinetti == 3)
					continue;
				if (ruolo.equals("tromba") && N_trombe == 3)
					continue;
				if (ruolo.equals("sax") && N_sax == 3)
					continue;
				if (ruolo.equals("tuba") && N_tube == 3)
					continue;
				if (ruolo.equals("percussioni") && N_percussioni == 3)
					continue;

				if (notInFormazione(socioTemp.getId(), arrayFormazione)) { // aggiunto se non gia presente in formazione
					arrayFormazione.add(
							new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(), ruolo));
					switch (ruolo) {
					case "flauto":
						N_flauti++;
						break;
					case "clarinetto":
						N_clarinetti++;
						break;
					case "tromba":
						N_trombe++;
						break;
					case "sax":
						N_sax++;
						break;
					case "tuba":
						N_tube++;
						break;
					case "percussioni":
						N_percussioni++;
						break;
					}
					iterator.remove();
				}
			}
		}

		System.out.println();

		// Verifica fattibilità evento:
		if (arrayFormazione.size() < 18)
			System.out.println("ATTENZIONE! \nNon è possibile fare l'evento. Non si dispone"
					+ "del numero minimo di componenti per ogni strumento.\n");

		// A questo punto analizzando i ruoli principali ho riempito dove possibile i gruppi di ogni
		// strumento e con i rimanenti, basandomi sui ruoli secondari, ho riempito le mancanze
		// di ogni gruppo. Se alla fine di questa fase non sono raggiunti i numeri minimi
		// l'evento di quella data non è fattibile e viene mostrato in output.

		// A questo punto se ho a disposizione ancora musicisti li convoco sulla base
		// del loro ruolo primario.

		else {
			iterator = arrayInput.listIterator();
			while (iterator.hasNext()) {
				socioTemp = iterator.next();
				String ruolo = socioTemp.getRuolo1();

				if (notInFormazione(socioTemp.getId(), arrayFormazione)) { // aggiunto se non gia presente in formazione

					arrayFormazione.add(
							new ResAlgoritmo(socioTemp.getId(), socioTemp.getCognome(), socioTemp.getNome(), ruolo));
					switch (ruolo) {
					case "flauto":
						N_flauti++;
						break;
					case "clarinetto":
						N_clarinetti++;
						break;
					case "tromba":
						N_trombe++;
						break;
					case "sax":
						N_sax++;
						break;
					case "tuba":
						N_tube++;
						break;
					case "percussioni":
						N_percussioni++;
						break;
					}
					// Qui non serve più rimuovere l'i-esimo socio perchè è l'ultimo ciclo dell'algoritmo
				}
			}
		}

		int tot = N_flauti + N_clarinetti + N_trombe + N_sax + N_tube + N_percussioni;
		ResDatiFormazione res = new ResDatiFormazione(tot, N_flauti, N_clarinetti, N_trombe, N_sax, N_tube,
				N_percussioni);
		ArrayList<ResDatiFormazione> array = new ArrayList<>();
		array.add(res);

		return array;

	}

}
