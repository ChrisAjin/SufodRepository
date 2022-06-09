package SufodRepository.SufodBoot.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="monstre")
@SequenceGenerator(name = "seqMonstre", sequenceName = "seq_monstre", initialValue = 10, allocationSize = 1)
public class Monstre extends Vivant{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMonstre")
	/*----------- Attributs -----------*/
	@ManyToOne
	@JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "monstre_attaque_id_fk"))
	@JsonView(JsonViews.Common.class)
	private Attaque attaque;
	
	@JsonView(JsonViews.Common.class)
	private int Drop;
	/*----------- Constrictors -----------*/	
	
	public Monstre(){
	}
	public Monstre(Long id, String nom, String description, int niveau, Classe classe, int pvMax,
	 int attaque, int defense) {
		
		super(id, nom, description, niveau, classe, pvMax,defense);
	
	}
	



	/*----------- Getters & Setters -----------*/

	public int getDrop() {
		return Drop;
	}


	public void setDrop(int drop) {
		Drop = drop;
	}
	public Attaque getAttaque() {
		return attaque;
	}
	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}
	



	

}
