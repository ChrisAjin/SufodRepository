package SufodRepository.SufodBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;




@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte")
@Table(name = "account")
@SequenceGenerator(sequenceName = "seqAccount", name = "seqAccountJPA")
@JsonTypeInfo(
		use=JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type"
		)
@JsonSubTypes({
	@Type(value=Admin.class,name="admin"),
	@Type(value=Joueur.class,name="joueur")
})
public abstract class Compte {

	
/*----------- Attributs -----------*/
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAccountJPA")
	protected Long id;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "pas de pseudo:merci de mettre un pseudo")
	@Size(min = 2)
	protected String pseudo;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	protected String prenom;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	protected String nom;
	
	@NotEmpty
	protected String password;
	
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	protected String mail;
	
	@JsonView(JsonViews.CompteWithPersonnage.class)
	@OneToMany(mappedBy = "compte")
	private Set<Personnage> personnages;
	

/*----------- Constructors -----------*/
	
	public Compte() {
	}
	
	
	public Compte(String pseudo, String prenom, String nom, String password, String mail) {
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.mail = mail;
	}

	/*----------- Getters & Setters -----------*/	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Set<Personnage> getPersonnages(){
		return personnages;
	}
	
	public void setPersonnage(Set<Personnage> personnages) {
		this.personnages = personnages;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}




	

}