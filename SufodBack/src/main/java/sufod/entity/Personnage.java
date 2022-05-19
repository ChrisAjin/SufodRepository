package sufod.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "seqPersonnage", name = "seqPersonnageJPA")
public class Personnage extends Vivant {

	/*----------- Attributs -----------*/

	protected int pc;
	@Enumerated(EnumType.ORDINAL)
	protected Metier metier;

	protected int equipTete;
	protected int equipPlastron;
	protected int equipCou;
	protected int equipMain;
	protected int equipPoignet;
	protected int equipPied;
	protected int equipJambe;
	protected int equipBras;
	private int xp;

//	@JsonView(JsonView.PersonnageWithEquipement.class)
	@ManyToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "personnage_compte_id_fk"))
	private Compte compte;
	
	@ManyToMany
	@JoinTable(name = "personnage_attaque_test", 
	joinColumns = @JoinColumn(name = "personnage_id", foreignKey = @ForeignKey(name = "personnage_attaque_id_fk")), 
	inverseJoinColumns = @JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "attaque_attaque_id_fk")))
	Set<Attaque> attaques;
	@ManyToMany
	@JoinTable(name = "personnage_item_test", 
	joinColumns = @JoinColumn(name = "personnage_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
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

	public int getEquipTete() {
		return equipTete;
	}

	public void setEquipTete(int equipTete) {
		this.equipTete = equipTete;
	}

	public int getEquipPlastron() {
		return equipPlastron;
	}

	public void setEquipPlastron(int equipPlastron) {
		this.equipPlastron = equipPlastron;
	}

	public int getEquipCou() {
		return equipCou;
	}

	public void setEquipCou(int equipCou) {
		this.equipCou = equipCou;
	}

	public int getEquipMain() {
		return equipMain;
	}

	public void setEquipMain(int equipMain) {
		this.equipMain = equipMain;
	}

	public int getEquipPoignet() {
		return equipPoignet;
	}

	public void setEquipPoignet(int equipPoignet) {
		this.equipPoignet = equipPoignet;
	}

	public int getEquipPied() {
		return equipPied;
	}

	public void setEquipPied(int equipPied) {
		this.equipPied = equipPied;
	}

	public int getEquipJambe() {
		return equipJambe;
	}

	public void setEquipJambe(int equipJambe) {
		this.equipJambe = equipJambe;
	}

	public int getEquipBras() {
		return equipBras;
	}

	public void setEquipBras(int equipBras) {
		this.equipBras = equipBras;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

}
