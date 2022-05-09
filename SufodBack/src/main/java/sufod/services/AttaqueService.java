package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sufod.entity.Attaque;
import sufod.exception.AttaqueException;
import sufod.repository.AttaqueRepository;

public class AttaqueService {
	
	@Autowired
	private AttaqueRepository attaqueRepository;

	
	public List<Attaque> getAll(){
		return attaqueRepository.findAll();
	}
	
	/*----------- findByID -----------*/
	public Attaque getById(Integer id) {
		return attaqueRepository.findById(id).orElseThrow(AttaqueException::new);
	}
	/*----------- Create -----------*/
	public void create(Attaque attaque) {
		if (attaque.getNom() == null || attaque.getNom().isEmpty()) {
			throw new AttaqueException();
		}
		attaqueRepository.save(attaque);
	}
	/*----------- Update -----------*/
	public Attaque update(Attaque attaque) {
		Attaque attaqueEnBase = getById(attaque.getId());
		attaqueEnBase.setNom(attaque.getNom());
		attaqueEnBase.setDegats(attaque.getDegats());
		return attaqueRepository.save(attaqueEnBase);
	}
	/*----------- delete -----------*/
	public void delete(Attaque attaque) {
		attaqueRepository.delete(attaque);
		
	}
	/*----------- deleteByID -----------*/
	public void deleteById(Integer id) {
		Attaque attaque = new Attaque();
		attaque.setId(id);
		delete(attaque);
	}
}
