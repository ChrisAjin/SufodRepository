package sufod.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="monstre")
@SequenceGenerator(name = "seqMonstre", sequenceName = "seq_monstre", initialValue = 10, allocationSize = 1)
public class Monstre extends Vivant{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMonstre")
	/*----------- Attributs -----------*/
	
	private int Drop;
	
	@OneToMany(mappedBy="key.monstre")
	private Set<Move> moveSet;
	
	
	
	
	/*----------- Constrictors -----------*/	
	
	public Monstre(){
	}


	/*----------- Getters & Setters -----------*/

	public int getDrop() {
		return Drop;
	}


	public void setDrop(int drop) {
		Drop = drop;
	}


	public Set<Move> getMoveSet() {
		return moveSet;
	}


	public void setMoveSet(Set<Move> moveSet) {
		this.moveSet = moveSet;
	}
	
	

}
