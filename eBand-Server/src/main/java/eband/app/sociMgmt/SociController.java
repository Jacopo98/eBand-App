package eband.app.sociMgmt;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SociController implements GestioneSociIF {

	private final SociRepository sociRepository;

	public SociController(SociRepository repository) {
		sociRepository = repository;
	}

	@GetMapping("/soci")
	public Iterable<Soci> getSoci() {
		return sociRepository.findAll();
	}

	@GetMapping("/soci/{sociId}") // parametro tra graffe
	public Soci getSoci(@PathVariable Long sociId) { // il parametro lo recuoperi dal path
		return sociRepository.findById(sociId).orElseThrow();
	}

	@PostMapping("/soci") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public Soci createSocio(@RequestBody Soci newSoci) {
		return sociRepository.save(newSoci);
	}

	@PutMapping("/soci/{sociId}") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public Soci updateSocio(@PathVariable Long sociId, @RequestBody Soci Socio) {
		Soci socioToUpdate = sociRepository.findById(sociId).orElseThrow();
		socioToUpdate.setCognome(Socio.getCognome());
		socioToUpdate.setNome(Socio.getNome());
		socioToUpdate.setDob(Socio.getDob());
		socioToUpdate.setResidenza(Socio.getResidenza());
		socioToUpdate.setDataisc(Socio.getDataisc());
		socioToUpdate.setRuolo1(Socio.getRuolo1());
		socioToUpdate.setRuolo2(Socio.getRuolo2());
		return sociRepository.save(socioToUpdate);
	}

	@DeleteMapping("/soci/{sociId}") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public void deleteSocio(@PathVariable Long sociId) {
		sociRepository.deleteById(sociId);
	}

}
