package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sufod.entity.Compte;
import sufod.exception.CompteException;
import sufod.repository.CompteRepository;

@Service
public class CompteServices {
	
	
	@Autowired
	private CompteRepository compteRepo;
	
	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	public Compte getById(Long id) {
		return compteRepo.findById(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});
	}

	public Compte update(Compte compte) {
		if (compte.getId() == null) {
			throw new CompteException("id obligatoire");
		}
		Compte compteEnBase = getById(compte.getId());
		compte.setVersion(compteEnBase.getVersion());
		return compteRepo.save(compte);
	}

	public Compte create(Compte admin) {
		if (admin.getId() != null) {
			throw new CompteException("id auto");
		}
		return compteRepo.save(admin);
	}

	public void delete(Compte compte) {
		delete(compte.getId());
	}

	public void delete(Long id) {
		Compte compte = getById(id);
		compteRepo.delete(compte);
	}

}
