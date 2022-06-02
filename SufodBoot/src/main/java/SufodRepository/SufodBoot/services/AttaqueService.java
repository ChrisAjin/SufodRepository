package SufodRepository.SufodBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.Monstre;
import SufodRepository.SufodBoot.entity.Personnage;
import SufodRepository.SufodBoot.exception.AttaqueException;
import SufodRepository.SufodBoot.repository.AttaqueRepository;


@Service
public class AttaqueService {
	
	@Autowired
	private AttaqueRepository attaqueRepository;

	
	public List<Attaque> getAll(){
		return attaqueRepository.findAll();
	}
	
	
	public List<Attaque> getAttaquesByPersonnageId(Long id){
		return attaqueRepository.findAttaquesByPersonnageId(id);
	}
	
	public List<Attaque> getAttaquesByMonstreId(Long id){
		return attaqueRepository.findAttaquesByMonstreId(id);
	}
	
	/*----------- findByID -----------*/
	public Attaque getById(Long id) {
		return attaqueRepository.findById(id).orElseThrow(AttaqueException::new);
	}
	/*----------- Create -----------*/
	public Attaque create(Attaque attaque) {
		if (attaque.getNom() == null || attaque.getNom().isEmpty()) {
			throw new AttaqueException();
		}
		return attaqueRepository.save(attaque);
	}
	/*----------- Update -----------*/
	public Attaque update(Attaque attaque) {
		Attaque attaqueEnBase = getById(attaque.getId());
		attaqueEnBase.setNom(attaque.getNom());
		attaqueEnBase.setDegats(attaque.getDegats());
		attaqueEnBase.setType(attaque.getType());
		return attaqueRepository.save(attaque);
	}
	
	
	/*----------- delete -----------*/
	public void delete(Attaque attaque) {
		
		Attaque attaqueEnBase = getById(attaque.getId());
		
		if (!attaqueEnBase.getMonstres().isEmpty()){
		for (Monstre monstre : attaqueEnBase.getMonstres()){
            monstre.getAttaques().remove(attaqueEnBase);
        }
        }
        
        if (!attaqueEnBase.getPersonnages().isEmpty()){
        for (Personnage personnage : attaqueEnBase.getPersonnages()){
            personnage.getAttaques().remove(attaqueEnBase);
        }
        }
		
		
		
		attaqueRepository.delete(attaqueEnBase);
		
	
	}
	/*----------- deleteByID -----------*/
	public void deleteById(Long id) {
		Attaque attaque = new Attaque();
		attaque.setId(id);
		delete(attaque);
	}
}
