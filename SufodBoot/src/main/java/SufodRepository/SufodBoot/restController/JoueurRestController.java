package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.Compte;
import SufodRepository.SufodBoot.entity.Joueur;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.CompteServices;
@RestController
@RequestMapping("/api/compte/joueur")
public class JoueurRestController {

		
		@Autowired
		private CompteServices compteServices ;
		
		//Ok
		@JsonView(JsonViews.Common.class)
		@GetMapping("")
		public List<Joueur> getAll() {
			return compteServices.getAllJoueurs();
		}
		
		//Ok
		@GetMapping("/{id}")
		@JsonView(JsonViews.Common.class)
		public Joueur getById(@PathVariable Long id) {
			return (Joueur) compteServices.getById(id);
		}
		
		
		
		//Ok !!Bien mettre un mdp lors de la creation car pas visible (pas de jsonview)
		@JsonView(JsonViews.Common.class)
		@PostMapping("")
		public Joueur create(@RequestBody Joueur joueur) {
			return (Joueur) compteServices.create(joueur);
		}

	
}
