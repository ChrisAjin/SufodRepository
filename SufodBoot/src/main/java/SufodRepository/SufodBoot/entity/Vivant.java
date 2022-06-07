	
package SufodRepository.SufodBoot.entity;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;



@MappedSuperclass
public abstract class Vivant {
	
	
	/*----------- Attributs -----------*/
	@Id
	@JsonView(JsonViews.Common.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_vivant", initialValue = 1, allocationSize = 1)
	protected Long id;
	
	@JsonView(JsonViews.Common.class)
	protected String nom;
	
	@JsonView(JsonViews.Common.class)
	protected String description;
	
	@JsonView(JsonViews.Common.class)
	protected int niveau;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.ORDINAL)
	protected Classe classe;
	
	@JsonView(JsonViews.Common.class)
	protected int pvMax;
	
	@JsonView(JsonViews.Common.class)
	protected int pv;
		
	
		
	@JsonView(JsonViews.Common.class)
	protected int defense;
	

	

	
	//@ManyToMany
	//@JoinTable(name = "attaque", joinColumns = @JoinColumn(name = "vivant_id", foreignKey = @ForeignKey(name = "ATTAQUE_VIVANT_ID_FK")), inverseJoinColumns = @JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "ATTAQUE_ATTAQUE_ID_FK")))

	

	/*----------- Constrictors -----------*/
	
	
	
	public Vivant() {
		
	}

	

	public Vivant(Long id, String nom, String description, int niveau, Classe classe, int pvMax
			 , int defense) {
	
		this.id = id;
		
		this.nom = nom;
		this.description = description;
		
		this.niveau = niveau;
		
		this.classe = classe;
		
		this.pvMax = pvMax;
		
		this.defense = defense;
		
	}
	
	public Vivant(String nom, String description, int niveau, Classe classe, int pvMax,
			 int defense) {		
		this.nom = nom;
		this.description = description;
		
		this.niveau = niveau;
		
		this.classe = classe;
		
		this.pvMax = pvMax;
		
		
		
		this.defense = defense;
		

	}
	
	/*----------- Getters & Setters -----------*/
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public int getPvMax() {
		return pvMax;
	}


	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}

	



	public int getDefense() {
		return defense;
	}



	public void setDefense(int defense) {
		this.defense = defense;
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
		Vivant other = (Vivant) obj;
		return id == other.id;
	}
	
	

}
