package eband.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import eband.app.sociMgmt.Soci;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EBandApplicationTestsGetAndSet {

	Soci s1 = new Soci("Ilaria", "Boffelli", "11/10/1998", "Sedrina", "12/10/2019", "sax", "percussioni");

	@Test
	public void getNomeTest() {
		assertEquals("Ilaria", s1.getNome());
	}

	@Test
	public void setNomeTest() {
		s1.setNome("Jacopo");
		assertEquals("Jacopo", s1.getNome());
	}

	@Test
	public void getCognomeTest() {
		assertEquals("Boffelli", s1.getCognome());
	}

	@Test
	public void setCognomeTest() {
		s1.setCognome("Salvi");
		assertEquals("Salvi", s1.getCognome());
	}

	@Test
	public void getDataTest() {
		assertEquals("11/10/1998", s1.getDob());
	}

	@Test
	public void setDataTest() {
		s1.setDob("1/1/2000");
		assertEquals("1/1/2000", s1.getDob());
	}

	@Test
	public void getResidenzaTest() {
		assertEquals("Sedrina", s1.getResidenza());
	}

	@Test
	public void setResidenzaTest() {
		s1.setResidenza("Botta");
		assertEquals("Botta", s1.getResidenza());
	}

	@Test
	public void getIscrizioneTest() {
		assertEquals("12/10/2019", s1.getDataisc());
	}

	@Test
	public void setIscrizioneTest() {
		s1.setDataisc("1/1/2010");
		assertEquals("1/1/2010", s1.getDataisc());
	}

	@Test
	public void getRuolo1Test() {
		assertEquals("sax", s1.getRuolo1());
	}

	@Test
	public void setRuolo1Test() {
		s1.setRuolo1("tromba");
		assertEquals("tromba", s1.getRuolo1());
	}

	@Test
	public void getRuolo2Test() {
		assertEquals("percussioni", s1.getRuolo2());
	}

	@Test
	public void setRuolo2Test() {
		s1.setRuolo2("tuba");
		assertEquals("tuba", s1.getRuolo2());
	}

}
