package SufodRepository.SufodBoot.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("joueur")
public class Joueur extends Compte{

	
	
	
	public Joueur() {
		super();
	}
	
	public Joueur(String pseudo, String prenom, String nom, String password, String mail) {
		super(pseudo, prenom, nom, password, mail);
	}

	

}