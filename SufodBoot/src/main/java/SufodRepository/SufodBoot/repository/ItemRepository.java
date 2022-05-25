package SufodRepository.SufodBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Equipement;
import SufodRepository.SufodBoot.entity.Ingredient;
import SufodRepository.SufodBoot.entity.Item;
import SufodRepository.SufodBoot.entity.Joueur;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("Select i from Item i where i.libelle=:libelle")
	List<Item> findByNom(@Param("libelle") String libelle);

		@Query("Select i from Item i left join fetch i.personnages where i.id=:id")
	List<Item> findItemsByPersonnageId(Long id);

	@Query("Select e from Equipement e left join fetch  e.personnages where e.id=:id")
	List<Equipement> findEquipementsByPersonnageId(Long id);

	@Query("Select i from Ingredient i left join fetch  i.personnages where i.id=:id")
	List<Ingredient> findIngredientsByPersonnageId(Long id);

	@Query("Select e from Equipement e")
	List<Equipement> findAllEquipements();
	
	@Query("Select e from Equipement e where e.id=:id")
	Optional<Equipement> findEquipementById(@Param("id") Long id);
	
	@Query("Select i from Ingredient i where i.id=:id")
	Optional<Ingredient> findIngredientById(@Param("id") Long id);

	@Query("Select i from Ingredient i")
	List<Ingredient> findAllIngredients();

	@Query("select i from Item i where i.id=:id")
	Optional<Item> findItemsById(@Param("id") Long id);

	
	
	@Query("select e from Equipement e where e.localisation=:localisation")
	List<Equipement> findByBodyPart(@Param("localisation") String localisation);

}
