
package sufod.entity;


import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqAttaque", sequenceName = "seq_attaque", allocationSize = 1, initialValue = 10)
public class Attaque {
	
	@JsonView(JsonViews.AttaquesWithMonstre.class)
	@ManyToMany	 (mappedBy = "attaques")
	Set<Monstre> monstres;
	
	@JsonView(JsonViews.AttaquesWithPersonnage.class)
	@ManyToMany (mappedBy = "attaques")	
	Set<Personnage> personnages;
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	private int degats;
	
	@JsonView(JsonViews.Common.class)
	private int paBase;
	
	@JsonView(JsonViews.Common.class)
	private int precision;
	
	@JsonView(JsonViews.Common.class)
	private int coupcritique;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	private TypeAtt type;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAttaque")
	private Long id;

	public Attaque() {

	}

	public Attaque(TypeAtt type, String nom, int degats, int paBase, int precision,int coupcritique) {
		this.nom = nom;
		this.degats = degats;
		this.paBase = paBase;
		this.precision = precision;
		this.type = type;
		this.coupcritique = coupcritique;
	}

	public Attaque(Long id, String nom, int degats, int paBase, int precision, TypeAtt type,int coupcritique) {
		this.id = id;
		this.nom = nom;
		this.degats = degats;
		this.paBase = paBase;
		this.precision = precision;
		this.type = type;
		this.coupcritique = coupcritique;
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

	public int getPaBase() {
		return paBase;
	}

	public void setPaBase(int paBase) {
		this.paBase = paBase;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
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
	

	public int getCoupcritique() {
		return coupcritique;
	}

	public void setCoupcritique(int coupcritique) {
		this.coupcritique = coupcritique;
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
