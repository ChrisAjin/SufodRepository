package sufod.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	
	
	
	public Admin() {
		super();
	}
	
	public Admin(String pseudo, String prenom, String nom, String password, String mail) {
		super(pseudo, prenom, nom, password, mail);
	}
	
}