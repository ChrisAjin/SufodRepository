package sufod.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@MappedSuperclass
public class Compte {

	
/*----------- Attributs -----------*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 200)
	private String prenom;
	@Column(name = "last_name")
	private String nom;
	
	@Column(name = "mail", unique = true)
	private String mail;
	
	@Column(name = "surname")
	private String pseudo;
	
	@OneToMany(mappedBy = "key.compte")
	private Set<Personnage> personnages;
	
	@Version
	long version;

	
/*----------- Constructors -----------*/
	
	public Compte() {
	}
	
	
	public Compte(Long id) {
		this.id = id;
	}


/*----------- Getters & Setters -----------*/	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public Set<Personnage> getJoueurs() {
		return personnages;
	}


	public void setJoueurs(Set<Personnage> personnages) {
		this.personnages = personnages;
	}


	public Long getId() {
		return id;
	}
	
	
	public Set<Personnage> getPersonnages() {
		return personnages;
	}


	public void setPersonnages(Set<Personnage> personnages) {
		this.personnages = personnages;
	}


	public void setId(Long id) {
		this.id = id;
	}
		
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	
	
	/*----------- hashCode & equals -----------*/

	@Override
	public int hashCode() {
		return Objects.hash(id, version);
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
		return Objects.equals(id, other.id) && version == other.version;
	}	

}