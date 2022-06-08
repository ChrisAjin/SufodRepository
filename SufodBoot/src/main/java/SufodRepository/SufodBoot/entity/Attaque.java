package SufodRepository.SufodBoot.entity;


import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqAttaque", sequenceName = "seq_attaque", allocationSize = 1, initialValue = 10)
public class Attaque {
	
	@JsonView({JsonViews.AttaquesWithMonstre.class,JsonViews.Attaque.class})
	@OneToMany	 (mappedBy = "attaque")
	Set<Monstre> monstres;
	
	@JsonView({JsonViews.AttaquesWithPersonnage.class,JsonViews.Attaque.class})
	@OneToMany (mappedBy = "attaque")	
	Set<Personnage> personnages;
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	private int degats;
		
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	private TypeAtt type;
	
	@Id
	@JsonView(JsonViews.Common.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAttaque")
	private Long id;

	public Attaque() {

	}

	public Attaque(TypeAtt type, String nom, int degats) {
		this.nom = nom;
		this.degats = degats;
		this.type = type;
		
	}

	public Attaque(Long id, String nom, int degats, TypeAtt type) {
		this.id = id;
		this.nom = nom;
		this.degats = degats;
		this.type = type;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	

	public TypeAtt getType() {
		return type;
	}

	public void setType(TypeAtt type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	

	public Set<Monstre> getMonstres() {
		return monstres;
	}

	public void setMonstres(Set<Monstre> monstres) {
		this.monstres = monstres;
	}

	public Set<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(Set<Personnage> personnages) {
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
		Attaque other = (Attaque) obj;
		return Objects.equals(id, other.id);
	}

}
