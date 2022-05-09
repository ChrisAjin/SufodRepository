package sufod.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_admin", allocationSize = 1)
public class Admin extends Compte {
	
	public Admin() {
	}
	
	public Admin(Long id) {
		super(id);
	}
}