package SufodRepository.SufodBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.Compte;
import SufodRepository.SufodBoot.entity.Joueur;
import SufodRepository.SufodBoot.exception.CompteException;
import SufodRepository.SufodBoot.repository.CompteRepository;

@Service
public class CompteServices {
	
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Compte getByPseudo(String pseudo) {
		return compteRepository.findByPseudo(pseudo).orElseThrow(CompteException::new);
	}
	
	public boolean checkPseudoExist(String login) {
		return compteRepository.findByPseudo(login).isPresent();
	}

	public List<Compte> getAll() {
		return compteRepository.findAll();
	}

	public List<Admin> getAllAdmin() {
		return compteRepository.findAllAdmins();
	}
	
	public Compte getCompteByPersonnageId(Long id) {
		return compteRepository.findCompteByPersonnageId(id).orElseThrow(CompteException::new);
	}

	public List<Joueur> getAllJoueurs() {
		return compteRepository.findAllJoueurs();
	}

	public Compte getById(Long id) {
		return compteRepository.findById(id).orElseThrow(CompteException::new);
	}

	public Compte seConnecter(String login, String password) {
		return compteRepository.seConnecter(login, password).orElseThrow(CompteException::new);
	}

	public Compte create(Compte compte) {
		compte.setPassword(passwordEncoder.encode( compte.getPassword()));
		return compteRepository.save(compte);
	}

	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
		compteEnBase.setPseudo(compte.getPseudo());
		compteEnBase.setNom(compte.getNom());
		compteEnBase.setPrenom(compte.getPrenom());
		compteEnBase.setMail(compte.getMail());
		return compteRepository.save(compteEnBase);
	}

//	public Compte updatePassword() {
//		
//	}

	public void delete(Compte compte) {
		compteRepository.delete(compte);
	}

	public void deleteById(Long id) {
		Compte compte = getById(id);
		compteRepository.delete(compte);
	}
	

}
