package sufod.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "move")
public class Move {

	private int pa;
	@EmbeddedId
	private MoveKey key;
	
	
	
	public Move() {

	}

	public Move(int pa, MoveKey key) {
		super();
		this.pa = pa;
		this.key = key;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	public void useMove() {
		if (pa > 0) {
			pa--;
		} else {
			System.out.println("Vous n'avez plus de PA pour cette attaque !");
		}
	}

	public MoveKey getKey() {
		return key;
	}

	public void setKey(MoveKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		return Objects.equals(key, other.key);
	}

}
