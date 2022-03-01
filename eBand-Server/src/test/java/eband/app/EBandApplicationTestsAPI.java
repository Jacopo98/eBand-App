package eband.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eband.app.eventiMgmt.Eventi;
import eband.app.eventiMgmt.EventiController;
import eband.app.eventiMgmt.EventiRepository;
import eband.app.sociMgmt.Soci;
import eband.app.sociMgmt.SociController;
import eband.app.sociMgmt.SociRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EBandApplicationTestsAPI {

	// Test Rest API Soci
	SociRepository repo;
	@Autowired
	SociController sc1 = new SociController(repo);

	Soci s1 = new Soci("Ilaria", "Boffelli", "11/10/1998", "Sedrina", "12/10/2019", "sax", "tromba");

	@Test
	public void getSociTest() {
		assertNotNull(sc1.getSoci());
	}

	@Test
	public void getSociID() {
		assertNotNull(sc1.getSoci((long) 20));
	}

	@Test
	public void createSocio() {
		assertNotNull(sc1.createSocio(s1));
	}

	@Test
	public void updateSocio() {
		assertNotNull(sc1.updateSocio((long) 67, s1));
	}

	@Test
	public void deleteSocio() {
		Iterable<Soci> i1 = sc1.getSoci();
		long size = i1.spliterator().getExactSizeIfKnown();
		sc1.deleteSocio((long) 76);
		Iterable<Soci> i2 = sc1.getSoci();
		long sizeafter = i2.spliterator().getExactSizeIfKnown();
		System.out.println(sizeafter);
		assertEquals(size - 1, sizeafter);
	}

	// Test Rest API Eventi
	EventiRepository repo2;
	@Autowired
	EventiController er1 = new EventiController(repo2);

	Eventi e1 = new Eventi("Festa", "11/02/2022", "14:00");

	@Test
	public void getEvents() {
		assertNotNull(er1.getEventi());
	}

	@Test
	public void getEventID() {
		assertNotNull(er1.getEventi((long) 44));
	}

	@Test
	public void createEvento() {
		assertNotNull(er1.createEvento(e1));
	}

	@Test
	public void updateEvento() {
		assertNotNull(er1.updateEvento((long) 72, e1));
	}

	@Test
	public void deleteEvento() {
		Iterable<Eventi> i1 = er1.getEventi();
		long size = i1.spliterator().getExactSizeIfKnown();
		System.out.println(size);
		er1.deleteEvento((long) 79);
		Iterable<Eventi> i2 = er1.getEventi();
		long sizeafter = i2.spliterator().getExactSizeIfKnown();
		System.out.println(sizeafter);
		assertEquals(size - 1, sizeafter);
	}

}
