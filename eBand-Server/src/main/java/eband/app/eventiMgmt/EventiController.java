package eband.app.eventiMgmt;

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
public class EventiController implements GestioneEventiIF {

	private final EventiRepository eventiRepository;

	public EventiController(EventiRepository repository) {
		eventiRepository = repository;
	}

	@GetMapping("/eventi")
	public Iterable<Eventi> getEventi() {
		return eventiRepository.findAll();
	}

	@GetMapping("/eventi/{eventiId}") // parametro tra graffe
	public Eventi getEventi(@PathVariable Long eventiId) { // il parametro lo recuoperi dal path
		return eventiRepository.findById(eventiId).orElseThrow();
	}

	@PostMapping("/eventi") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public Eventi createEvento(@RequestBody Eventi newEventi) {
		return eventiRepository.save(newEventi);
	}

	@PutMapping("/eventi/{eventiId}") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public Eventi updateEvento(@PathVariable Long eventiId, @RequestBody Eventi Evento) {
		Eventi eventoToUpdate = eventiRepository.findById(eventiId).orElseThrow();
		eventoToUpdate.setTipologia(Evento.getTipologia());
		eventoToUpdate.setData(Evento.getData());
		eventoToUpdate.setOra(Evento.getOra());
		return eventiRepository.save(eventoToUpdate);
	}

	@DeleteMapping("/eventi/{eventiId}") // quando viene fatto un post a questa uri viene ritornato questo metodo
	public void deleteEvento(@PathVariable Long eventiId) {
		eventiRepository.deleteById(eventiId);
	}

}
