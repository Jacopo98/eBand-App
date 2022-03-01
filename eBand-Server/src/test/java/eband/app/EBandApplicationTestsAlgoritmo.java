package eband.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import eband.app.algoritmoMgmt.AlgoritmoController;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EBandApplicationTestsAlgoritmo {

	// Test dell'algoritmo
	AlgoritmoController ac = new AlgoritmoController();

	@Test
	public void formazioneTest() {
		assertNotNull(ac.creaFormazioneEvento(26));
	}

	@Test
	public void datiFormazioneTest() {
		assertNotNull(ac.ottieniDatiFormazione(26));
	}

}
