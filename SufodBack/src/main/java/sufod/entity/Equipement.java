package sufod.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue("e")
public class Equipement extends Item {

	@Column(name = "pv", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "PV manquant")
	private int pv;
	@Column(name = "def_magique", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Défense Magique manquante")
	private double defMagique;
	@Column(name = "def_physique", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Défense Physique manquante")
	private double defPhysique;
	@Column(name = "def_distance", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Défense Distance manquante")
	private double defDistance;
	@Column(name = "attaque_magique", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Attaque Magique manquante")
	private double attMagique;
	@Column(name = "attaque_physique", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Attaque Physique manquante")
	private double attPhysique;
	@Column(name = "attaque_distance", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Attaque Distance manquante")
	private double attDistance;
	@Column(name = "esquive", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Esquive manquante")
	private double Esquive;
	@Column(name = "localisation", nullable = false)
//	@JsonView(JsonViews.Common.class)
	@NotEmpty(message = "Localisation manquante")
	PartieCorps localisation;

	public Equipement() {

	}

	public Equipement(int pv, double defMagique, double defPhysique, double defDistance, double attMagique,
			double attPhysique, double attDistance, double esquive, PartieCorps localisation) {
		this.pv = pv;
		this.defMagique = defMagique;
		this.defPhysique = defPhysique;
		this.defDistance = defDistance;
		this.attMagique = attMagique;
		this.attPhysique = attPhysique;
		this.attDistance = attDistance;
		this.Esquive = esquive;
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

	public double getEsquive() {
		return Esquive;
	}

	public void setEsquive(double esquive) {
		Esquive = esquive;
	}

	public PartieCorps getLocalisation() {
		return localisation;
	}

	public void setLocalisation(PartieCorps localisation) {
		this.localisation = localisation;
	}

}
