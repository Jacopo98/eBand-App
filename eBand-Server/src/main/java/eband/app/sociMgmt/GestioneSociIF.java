package eband.app.sociMgmt;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface GestioneSociIF {

	public Iterable<Soci> getSoci();

	public Soci getSoci(@PathVariable Long sociId);

	public Soci createSocio(@RequestBody Soci newSoci);

	public Soci updateSocio(@PathVariable Long sociId, @RequestBody Soci Socio);

	public void deleteSocio(@PathVariable Long sociId);

}
