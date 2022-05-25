package SufodRepository.SufodBoot.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

//import sufod.entity.JsonViews;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "item")
@SequenceGenerator(sequenceName = "seqItem", name = "seqItemSufod")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Equipement.class, name = "equipement"),
		@Type(value = Ingredient.class, name = "ingredient") })

public abstract class Item {
	
	@ManyToMany(mappedBy = "items")
	List<Personnage> personnages;
	@JsonView({ JsonViews.Common.class })
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seqItemSufod")
	@Id
	protected Long id;
	@Column(name = "libelle", nullable = false, length = 30)
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Libelle manquant")
	protected String libelle;
	@Column(name = "description", nullable = false, length = 500)
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Description manquante")
	protected String description;
	@NotEmpty(message = "aucune chance de drop?")
	@JsonView(JsonViews.Common.class)
	@Column(name = "drop_chance")
	protected double dropChance;

	public Item() {

	}

	public Item(String libelle, Long id, String description, double dropChance) {
		this.libelle = libelle;
		this.id = id;
	}

	public Item(String libelle) {
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDropChance() {
		return dropChance;
	}

	public void setDropChance(double dropChance) {
		this.dropChance = dropChance;
	}
	

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, dropChance, id, libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(dropChance) == Double.doubleToLongBits(other.dropChance)
				&& Objects.equals(id, other.id) && Objects.equals(libelle, other.libelle);
	}

}
