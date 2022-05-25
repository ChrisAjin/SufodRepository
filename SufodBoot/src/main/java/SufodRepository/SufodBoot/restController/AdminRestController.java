package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.CompteServices;
@RestController
@RequestMapping("/api/compte/admin")
public class AdminRestController {
	@Autowired
	private CompteServices compteServices ;
	
	//OK
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Admin> getAll() {
		return compteServices.getAllAdmin();
	}
	
	//OK
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin getById(@PathVariable Long id) {
		return (Admin) compteServices.getById(id);
	}

	
}
