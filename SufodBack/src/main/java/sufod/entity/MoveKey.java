package sufod.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MoveKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "attaque_id", foreignKey = @ForeignKey(name = "move_attaque_id_fk"))
	private Attaque attaque;
	
	@ManyToOne
	@JoinColumn(name = "monstre_id", foreignKey = @ForeignKey(name = "move_monstre_id_fk"))
	private Monstre monstre;

	public MoveKey() {

	}

	public MoveKey(Attaque attaque, Monstre monstre) {
		super();
		this.attaque = attaque;
		this.monstre = monstre;
	}
	

	public Attaque getAttaque() {
		return attaque;
	}

	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	public Vivant getMonstre() {
		return monstre;
	}

	public void setVivant(Monstre monstre) {
		this.monstre = monstre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attaque, monstre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveKey other = (MoveKey) obj;
		return Objects.equals(attaque, other.attaque) && Objects.equals(monstre, other.monstre);
	}

}
