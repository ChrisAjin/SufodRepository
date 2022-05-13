package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.Compte;
import sufod.entity.Ingredient;
import sufod.services.CompteServices;
@RestController
@RequestMapping("/api/compte/joueur")
public class JoueurRestController {

		
		@Autowired
		private CompteServices compteServices ;
		
		@JsonView(JsonViews.Common.class)
		@GetMapping("")
		public List<Joueur> getAll() {
			return compteServices.getAllJoueur();
		}
		
		@GetMapping("/{id}")
		@JsonView(JsonViews.Common.class)
		public Joueur getById(@PathVariable Long id) {
			return (Joueur) compteServices.getById(id);
		}

		@JsonView(JsonViews.Common.class)
		@PostMapping("")
		public Joueur create(@RequestBody Joueur joueur) {
			return compteServices.create(joueur);
		}
}
