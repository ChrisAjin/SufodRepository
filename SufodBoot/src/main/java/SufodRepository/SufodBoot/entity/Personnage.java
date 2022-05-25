package SufodRepository.SufodBoot.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.JsonViews.PersonnagesWithAttaque;

@Entity
@SequenceGenerator(sequenceName = "seqPersonnage", name = "seqPersonnageJPA")
public class Personnage extends Vivant {

	/*----------- Attributs -----------*/
	@JsonView(JsonViews.Common.class)
	protected int pc;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.ORDINAL)
	protected Metier metier;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipTete;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipPlastron;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipCou;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipMain;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipPoignet;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipPied;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipJambe;
	
	@JsonView(JsonViews.Common.class)
	protected Long equipBras;
	
	@JsonView(JsonViews.Common.class)
	private int xp;

	@JsonView(JsonViews.PersonnagesWithCompte.class)
	@ManyToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "personnage_compte_id_fk"))
	private Compte compte;
	
	@JsonView(JsonViews.PersonnagesWithAttaque.class)
	@ManyToMany
	@JoinTable(name = "personnage_attaque", 
	joinColumns = @JoinColumn(name = "personnage_id", foreignKey = @ForeignKey(name = "personnage_attaque_id_fk")), 
	inverseJoinColumns = @JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "attaque_attaque_id_fk")))
	Set<Attaque> attaques;
	
	@ManyToMany
	@JoinTable(name = "personnage_item", 
	joinColumns = @JoinColumn(name = "personnage_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	@JsonView(JsonViews.PersonnageWithItem.class)
	Set<Item> items;

	/*----------- Constrictors -----------*/

	public Personnage() {

	}

	public Personnage(Long id, String nom, String description, int niveau, Classe classe, int pvMax, int esquive,
			int vitesse, int paMax, int pmMax, int attMagique, int attPhysique, int attDistance, int defMagique,
			int defPhysique, int defDistance, int pc, Metier metier) {

		super(id, nom, description, niveau, classe, pvMax, esquive, vitesse, paMax, pmMax, attMagique, attPhysique,
				attDistance, defMagique, defPhysique, defDistance);

		this.pc = pc;

		this.metier = metier;
	}

	public Personnage(String nom, String description, int niveau, Classe classe, int pvMax, int esquive, int vitesse,
			int paMax, int pmMax, int attMagique, int attPhysique, int attDistance, int defMagique, int defPhysique,
			int defDistance, int pc, Metier metier) {

		super(nom, description, niveau, classe, pvMax, esquive, vitesse, paMax, pmMax, attMagique, attPhysique,
				attDistance, defMagique, defPhysique, defDistance);

		this.pc = pc;

		this.metier = metier;
	}

	/*----------- Getters & Setters -----------*/

	public int getPc() {
		return pc;
	}


	public void setPc(int pc) {
		this.pc = pc;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public Long getEquipTete() {
		return equipTete;
	}

	public void setEquipTete(Long equipTete) {
		this.equipTete = equipTete;
	}

	public Long getEquipPlastron() {
		return equipPlastron;
	}

	public void setEquipPlastron(Long equipPlastron) {
		this.equipPlastron = equipPlastron;
	}

	public Long getEquipCou() {
		return equipCou;
	}

	public void setEquipCou(Long equipCou) {
		this.equipCou = equipCou;
	}

	public Long getEquipMain() {
		return equipMain;
	}

	public void setEquipMain(Long equipMain) {
		this.equipMain = equipMain;
	}

	public Long getEquipPoignet() {
		return equipPoignet;
	}

	public void setEquipPoignet(Long equipPoignet) {
		this.equipPoignet = equipPoignet;
	}

	public Long getEquipPied() {
		return equipPied;
	}

	public void setEquipPied(Long equipPied) {
		this.equipPied = equipPied;
	}

	public Long getEquipJambe() {
		return equipJambe;
	}

	public void setEquipJambe(Long equipJambe) {
		this.equipJambe = equipJambe;
	}

	public Long getEquipBras() {
		return equipBras;
	}

	public void setEquipBras(Long equipBras) {
		this.equipBras = equipBras;
	}

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

	public Set<Attaque> getAttaques() {
		return attaques;
	}

	public void setAttaques(Set<Attaque> attaques) {
		this.attaques = attaques;
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
		result = prime * result + Objects.hash(attaques, compte, equipBras, equipCou, equipJambe, equipMain, equipPied,
				equipPlastron, equipPoignet, equipTete, items, metier, pc, xp);
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
		return Objects.equals(attaques, other.attaques) && Objects.equals(compte, other.compte)
				&& equipBras == other.equipBras && equipCou == other.equipCou && equipJambe == other.equipJambe
				&& equipMain == other.equipMain && equipPied == other.equipPied && equipPlastron == other.equipPlastron
				&& equipPoignet == other.equipPoignet && equipTete == other.equipTete
				&& Objects.equals(items, other.items) && metier == other.metier && pc == other.pc && xp == other.xp;
	}
	
	

}
