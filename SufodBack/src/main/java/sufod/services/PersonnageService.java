package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sufod.entity.Personnage;
import sufod.exception.PersonnageException;
import sufod.repository.PersonnageRepository;

@Service
public class PersonnageService {
	
	@Autowired
	private PersonnageRepository personnageRepository ;

	public List<Personnage> getAll(){
		return personnageRepository.findAll();
	}
	
	/*----------- findByID -----------*/
	public Personnage getById(Integer id) {
		return personnageRepository.findById(id).orElseThrow(PersonnageException::new);
	}
	/*----------- Create -----------*/
	public Personnage create(Personnage personnage) {
		return personnageRepository.save(personnage);
	}
	/*----------- Update -----------*/
	public Personnage update(Personnage personnage) {
		return personnageRepository.save(personnage);
	}
	/*----------- delete -----------*/
	public void delete(Personnage personnage) {
		personnageRepository.delete(personnage);
		
	}
	/*----------- deleteByID -----------*/
	public void deleteById(Integer id) {
		Personnage personnage = new Personnage();
		personnage.setId(id);
		delete(personnage);
	}

}
