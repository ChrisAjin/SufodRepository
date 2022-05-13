package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.Monstre;
import sufod.services.MonstreService;
import sufod.entity.JsonViews;

@RestController
@RequestMapping("/api/monstres")
public class MonstreRestController {

	@Autowired
		private MonstreService monstreService  ;
		
		@JsonView(JsonViews.Common.class)
		@GetMapping("")
		public List<Monstre> getAll() {
			return monstreService.getAll();
		}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Monstre create(@RequestBody Monstre monstre) {
		return monstreService.create(monstre);
	}
}
