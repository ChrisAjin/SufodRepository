package SufodRepository.SufodBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SufodRepository.SufodBoot.entity.Monstre;
import SufodRepository.SufodBoot.entity.Personnage;
import SufodRepository.SufodBoot.exception.MonstreException;
import SufodRepository.SufodBoot.repository.MonstreRepository;

@Service
public class MonstreService {
	
	@Autowired
	private MonstreRepository monstreRepository;

	public List<Monstre> getAll(){
		return monstreRepository.findAll();
	}
	
	public List<Monstre> getAllMonstreByAttaqueId(Long id) {
		return monstreRepository.findMonstresByIdAttaque(id);
	}
	
	/*----------- findByID -----------*/
	public Monstre getById(Long id) {
		return monstreRepository.findById(id).orElseThrow(MonstreException::new);
	}
	/*----------- Create -----------*/
	public Monstre create(Monstre monstre) {
		return monstreRepository.save(monstre);
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
	public void deleteById(Long id) {
		Monstre monstre = new Monstre();
		monstre.setId(id);
		delete(monstre);
	}

}
