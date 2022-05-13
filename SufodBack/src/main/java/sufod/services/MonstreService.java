package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sufod.entity.Monstre;
import sufod.exception.MonstreException;
import sufod.repository.AttaqueRepository;
import sufod.repository.MonstreRepository;

@Service
public class MonstreService {
	
	@Autowired
	private MonstreRepository monstreRepository;

	public List<Monstre> getAll(){
		return monstreRepository.findAll();
	}
	
	/*----------- findByID -----------*/
	public Monstre getById(Integer id) {
		return monstreRepository.findById(id).orElseThrow(MonstreException::new);
	}
	/*----------- Create -----------*/
	public void create(Monstre monstre) {
		monstreRepository.save(monstre);
	}
	/*----------- Update -----------*/
	public Monstre update(Monstre monstre) {
		return monstreRepository.save(monstre);
	}
	/*----------- delete -----------*/
	public void delete(Monstre monstre) {
		monstreRepository.delete(monstre);
		
	}
	/*----------- deleteByID -----------*/
	public void deleteById(Integer id) {
		Monstre monstre = new Monstre();
		monstre.setId(id);
		delete(monstre);
	}

}
