package sufod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sufod.entity.Equipement;
import sufod.entity.Ingredient;
import sufod.entity.Item;
import sufod.entity.Joueur;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByNom(String nom);

	List<Item> findByNomContaining(String nom);

	List<Item> findByJoueur(Joueur id);

	List<Equipement> findEquipementsByJoueur(Joueur id);

	List<Ingredient> findIngredientsByJoueur(Joueur id);

	@Query("Select e from Equipement e")
	List<Equipement> findAllEquipements();

	@Query("Select i from Ingredients i")
	List<Ingredient> findAllIngredients();

	@Query("select i from Item i left join fetch i.ingredients")
	Optional<Item> findIngredientsById(@Param("id") Long id);

	@Query("select i from Item i left join fetch i.equipements")
	Optional<Item> findEquipementsById(@Param("id") Long id);
	
	@Query("select e from Equipement e where e.bodypart=:bodypart")
	List<Equipement> findByBodyPart(@Param("bodypart") String bodypart);

}
