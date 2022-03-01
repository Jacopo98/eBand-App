package eband.app.algoritmoMgmt;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AlgoritmoController implements GestioneAlgoritmoIF {

	@Autowired
	private AlgoritmoService algoritmoService = new AlgoritmoService();

	AtomicLong id = new AtomicLong();

	@GetMapping("/esegui")
	public ArrayList<ResAlgoritmo> creaFormazioneEvento(int id) {
		return algoritmoService.creaFormazione(id);
	}

	@GetMapping("/datiformazione")
	public ArrayList<ResDatiFormazione> ottieniDatiFormazione(int id) {
		return algoritmoService.ottieniDati(id);
	}

}