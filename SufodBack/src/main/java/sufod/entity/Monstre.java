package sufod.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="monstre")
@SequenceGenerator(name = "seqMonstre", sequenceName = "seq_monstre", initialValue = 10, allocationSize = 1)
public class Monstre extends Vivant{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMonstre")
	/*----------- Attributs -----------*/
	@ManyToMany
	@JoinTable(name = "monstre_attaque", 
	joinColumns = @JoinColumn(name = "monstre_id"), 
	inverseJoinColumns = @JoinColumn(name = "attaque_id"))
	private List<Attaque> attaques;
	private int Drop;
	/*----------- Constrictors -----------*/	
	
	public Monstre(){
	}
	public Monstre(Long id, String nom, String description, int niveau, Classe classe, int pvMax, int esquive,
			int vitesse, int paMax, int pmMax, int attMagique, int attPhysique, int attDistance, int defMagique,
			int defPhysique, int defDistance) {
		
		super(id, nom, description, niveau, classe, pvMax, esquive, vitesse, paMax, pmMax, attMagique, attPhysique,
				attDistance, defMagique, defPhysique, defDistance);

	}
	



	/*----------- Getters & Setters -----------*/

	public int getDrop() {
		return Drop;
	}


	public void setDrop(int drop) {
		Drop = drop;
	}



	

}
