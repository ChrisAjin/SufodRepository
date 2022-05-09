	
package sufod.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@MappedSuperclass
public abstract class Vivant {
	
	
	/*----------- Attributs -----------*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_vivant", initialValue = 1, allocationSize = 1)
	protected int id;
	protected String nom;
	protected String description;
	
	protected int niveau;
	
	@Enumerated(EnumType.ORDINAL)
	protected Classe classe;
	
	protected int pvMax;
	protected int pv;
	
	protected int esquive;
	protected int vitesse;
	
	protected int pa;
	protected int paMax;
	protected int pm;
	protected int pmMax;
	
	protected int attMagique;
	protected int attPhysique;
	protected int attDistance;
	
	protected int defMagique;
	protected int defPhysique;
	protected int defDistance;
	
	//@ManyToMany
	//@JoinTable(name = "attaque", joinColumns = @JoinColumn(name = "vivant_id", foreignKey = @ForeignKey(name = "ATTAQUE_VIVANT_ID_FK")), inverseJoinColumns = @JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "ATTAQUE_ATTAQUE_ID_FK")))

	

	/*----------- Constrictors -----------*/
	
	
	
	public Vivant() {
		
	}

	

	public Vivant(int id, String nom, String description, int niveau, Classe classe, int pvMax, int esquive,
			int vitesse, int paMax, int pmMax, int attMagique, int attPhysique, int attDistance, int defMagique,
			int defPhysique, int defDistance) {
	
		this.id = id;
		
		this.nom = nom;
		this.description = description;
		
		this.niveau = niveau;
		
		this.classe = classe;
		
		this.pvMax = pvMax;
		
		this.esquive = esquive;
		this.vitesse = vitesse;
		
		this.paMax = paMax;
		this.pmMax = pmMax;
		
		this.attMagique = attMagique;
		this.attPhysique = attPhysique;
		this.attDistance = attDistance;
		
		this.defMagique = defMagique;
		this.defPhysique = defPhysique;
		this.defDistance = defDistance;
	}
	
	public Vivant(String nom, String description, int niveau, Classe classe, int pvMax, int esquive,
			int vitesse, int paMax, int pmMax, int attMagique, int attPhysique, int attDistance, int defMagique,
			int defPhysique, int defDistance) {		
		this.nom = nom;
		this.description = description;
		
		this.niveau = niveau;
		
		this.classe = classe;
		
		this.pvMax = pvMax;
		
		this.esquive = esquive;
		this.vitesse = vitesse;
		
		this.paMax = paMax;
		this.pmMax = pmMax;
		
		this.attMagique = attMagique;
		this.attPhysique = attPhysique;
		this.attDistance = attDistance;
		
		this.defMagique = defMagique;
		this.defPhysique = defPhysique;
		this.defDistance = defDistance;
		
		this.attaques = attaques;
	}
	
	/*----------- Getters & Setters -----------*/
	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getEsquive() {
		return esquive;
	}


	public void setEsquive(int esquive) {
		this.esquive = esquive;
	}


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}


	public int getPa() {
		return pa;
	}


	public void setPa(int pa) {
		this.pa = pa;
	}


	public int getPaMax() {
		return paMax;
	}


	public void setPaMax(int paMax) {
		this.paMax = paMax;
	}


	public int getPm() {
		return pm;
	}


	public void setPm(int pm) {
		this.pm = pm;
	}


	public int getPmMax() {
		return pmMax;
	}


	public void setPmMax(int pmMax) {
		this.pmMax = pmMax;
	}


	public int getAttMagique() {
		return attMagique;
	}


	public void setAttMagique(int attMagique) {
		this.attMagique = attMagique;
	}


	public int getAttPhysique() {
		return attPhysique;
	}


	public void setAttPhysique(int attPhysique) {
		this.attPhysique = attPhysique;
	}


	public int getAttDistance() {
		return attDistance;
	}


	public void setAttDistance(int attDistance) {
		this.attDistance = attDistance;
	}


	public int getDefMagique() {
		return defMagique;
	}


	public void setDefMagique(int defMagique) {
		this.defMagique = defMagique;
	}


	public int getDefPhysique() {
		return defPhysique;
	}


	public void setDefPhysique(int defPhysique) {
		this.defPhysique = defPhysique;
	}


	public int getDefDistance() {
		return defDistance;
	}


	public void setDefDistance(int defDistance) {
		this.defDistance = defDistance;
	}


	public List<Attaque> getAttaques() {
		return attaques;
	}


	public void setAttaques(List<Attaque> attaques) {
		this.attaques = attaques;
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
