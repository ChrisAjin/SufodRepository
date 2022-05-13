package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.services.CompteServices;
@RestController
@RequestMapping("/api/compte/admin")
public class AdminRestController {
	@Autowired
	private CompteServices compteServices ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Admin> getAll() {
		return compteServices.getAllAdmin();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin getById(@PathVariable Long id) {
		return (Admin) compteServices.getById(id);
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Admin create(@RequestBody Admin admin) {
		return compteServices.create(admin);
	}
}
