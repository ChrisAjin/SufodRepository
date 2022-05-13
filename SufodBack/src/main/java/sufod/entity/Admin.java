package sufod.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	@JsonView(JsonViews.AdminWithPersonnages.class)
	@OneToMany(mappedBy = "admin")
	private Set<Personnage> personnages;
	
	public Admin() {
	}
	
	public Admin(String pseudo, String prenom, String nom, String password, String mail) {
		super(pseudo, prenom, nom, password, mail);
	}
	public Set<Personnage> getPersonnages(){
		return personnages;
	}
	
	public void setPersonnage(Set<Personnage> personnages) {
		this.personnages = personnages;
	}
}