package SufodRepository.SufodBoot.restController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Compte;
import SufodRepository.SufodBoot.entity.JsonViews;



@RestController
@CrossOrigin(origins = "*")
public class AuthRestController {
	@GetMapping("/api/auth")
	@JsonView(JsonViews.Common.class)
	public Compte authentification(@AuthenticationPrincipal Compte compte ) {
		return compte;
	}
}
