package SufodRepository.SufodBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@SequenceGenerator(sequenceName = "seqPersonnage", name = "seqPersonnageJPA")
public class Personnage extends Vivant {

	/*----------- Attributs -----------*/

	
	@JsonView(JsonViews.Common.class)
	private int xp;

	@JsonView({JsonViews.PersonnagesWithCompte.class,JsonViews.Personnage.class})
	@ManyToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "personnage_compte_id_fk"))
	private Compte compte;
	
	@JsonView({JsonViews.PersonnagesWithAttaque.class, JsonViews.Personnage.class})
	@ManyToOne
	@JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "personnage_attaque_id_fk"))
	private Attaque attaque;
	
	@ManyToMany
	@JoinTable(name = "personnage_item", 
	joinColumns = @JoinColumn(name = "personnage_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	@JsonView({JsonViews.PersonnageWithItem.class, JsonViews.Personnage.class})
	Set<Item> items;

	/*----------- Constrictors -----------*/

	public Personnage() {

	}

	public Personnage(Long id, String nom, String description, int niveau, Classe classe, int pvMax, 
		 Attaque attaque, int defense, Compte compte) {

		super(id, nom, description, niveau, classe, pvMax, defense);
		this.compte = compte;	
	}

	public Personnage(String nom, String description, int niveau, Classe classe, int pvMax,
			int attaque, int defense, Compte compte) {

		super(nom, description, niveau, classe, pvMax,defense);
		this.compte = compte;
	
	}

	/*----------- Getters & Setters -----------*/





	

	

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	

	public Attaque getAttaque() {
		return attaque;
	}

	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(attaque, compte, items,xp);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnage other = (Personnage) obj;
		return Objects.equals(attaque, other.attaque) && Objects.equals(compte, other.compte)
				&& Objects.equals(items, other.items)&& xp == other.xp;
	}

	
	
	

}
