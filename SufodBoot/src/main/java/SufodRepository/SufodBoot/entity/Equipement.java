package SufodRepository.SufodBoot.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Equipement")
public class Equipement extends Item {

	
	@Column(name = "pv")
	@JsonView(JsonViews.Common.class)
	private int pv;
	
	@Column(name = "defense")
	@JsonView(JsonViews.Common.class)
	private double defense;
	
	@Column(name = "attaque")
	@JsonView(JsonViews.Common.class)
	private double attaque;

	
	@Column(name = "localisation")
	@JsonView(JsonViews.Common.class)
	@NotNull
	private PartieCorps localisation;

	public Equipement() {

	}

	public Equipement(int pv, double defense, double attaque, PartieCorps localisation) {
		this.pv = pv;
		this.defense = defense;
		this.attaque = attaque;
		this.localisation = localisation;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	
	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getAttaque() {
		return attaque;
	}

	public void setAttaque(double attaque) {
		this.attaque = attaque;
	}

	public PartieCorps getLocalisation() {
		return localisation;
	}

	public void setLocalisation(PartieCorps localisation) {
		this.localisation = localisation;
	}

}
