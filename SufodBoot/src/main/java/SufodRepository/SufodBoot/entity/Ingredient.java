package SufodRepository.SufodBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ingredient")
public class Ingredient extends Item {

	public Ingredient() {
		super();
	}

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Override
	public String getDescription() {
		return super.getDescription();
	}

	@Override
	public void setDescription(String Description) {
		super.setDescription(Description);
	}

}
