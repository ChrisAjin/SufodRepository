package sufod.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "joueur")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_joueur", allocationSize = 1)
public class Joueur extends Compte{

	public Joueur() {
		super();
	}
	
	
	public Joueur(Long id) {
		super(id);
	}

}