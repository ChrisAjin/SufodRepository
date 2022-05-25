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
	
	@Column(name = "def_magique")
	@JsonView(JsonViews.Common.class)
	private double defMagique;
	
	@Column(name = "def_physique")
	@JsonView(JsonViews.Common.class)
	private double defPhysique;
	
	@Column(name = "def_distance")
	@JsonView(JsonViews.Common.class)
	private double defDistance;
	
	@Column(name = "attaque_magique")
	@JsonView(JsonViews.Common.class)
	private double attMagique;
	
	@Column(name = "attaque_physique")
	@JsonView(JsonViews.Common.class)
	private double attPhysique;
	
	@Column(name = "attaque_distance")
	@JsonView(JsonViews.Common.class)
	private double attDistance;

	
	@Column(name = "localisation")
	@JsonView(JsonViews.Common.class)
	@NotNull
	private PartieCorps localisation;

	public Equipement() {

	}

	public Equipement(int pv, double defMagique, double defPhysique, double defDistance, double attMagique,
			double attPhysique, double attDistance, PartieCorps localisation) {
		this.pv = pv;
		this.defMagique = defMagique;
		this.defPhysique = defPhysique;
		this.defDistance = defDistance;
		this.attMagique = attMagique;
		this.attPhysique = attPhysique;
		this.attDistance = attDistance;
		this.localisation = localisation;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public double getDefMagique() {
		return defMagique;
	}

	public void setDefMagique(double defMagique) {
		this.defMagique = defMagique;
	}

	public double getDefPhysique() {
		return defPhysique;
	}

	public void setDefPhysique(double defPhysique) {
		this.defPhysique = defPhysique;
	}

	public double getDefDistance() {
		return defDistance;
	}

	public void setDefDistance(double defDistance) {
		this.defDistance = defDistance;
	}

	public double getAttMagique() {
		return attMagique;
	}

	public void setAttMagique(double attMagique) {
		this.attMagique = attMagique;
	}

	public double getAttPhysique() {
		return attPhysique;
	}

	public void setAttPhysique(double attPhysique) {
		this.attPhysique = attPhysique;
	}

	public double getAttDistance() {
		return attDistance;
	}

	public void setAttDistance(double attDistance) {
		this.attDistance = attDistance;
	}

	public PartieCorps getLocalisation() {
		return localisation;
	}

	public void setLocalisation(PartieCorps localisation) {
		this.localisation = localisation;
	}

}
