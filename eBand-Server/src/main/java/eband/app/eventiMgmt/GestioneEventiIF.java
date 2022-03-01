package eband.app.eventiMgmt;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface GestioneEventiIF {

	public Iterable<Eventi> getEventi();

	public Eventi getEventi(@PathVariable Long eventiId);

	public Eventi createEvento(@RequestBody Eventi newEventi);

	public Eventi updateEvento(@PathVariable Long eventiId, @RequestBody Eventi Evento);

	public void deleteEvento(@PathVariable Long eventiId);

}
