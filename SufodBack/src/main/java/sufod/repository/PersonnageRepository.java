package sufod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sufod.entity.Attaque;
import sufod.entity.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
	
	@Query("select p from Personnage p left join fetch p.compte where p.id=:id")
	List<Personnage> findPersonnagesByIdCompte(@Param("id") Long id);
	
	@Query("select p from Personnage p where p.id=:id")
	Optional<Personnage> findPersonnagesById(@Param("id") Long id);
	
	@Query("select p from Personnage p left join fetch p.attaques where p.id=:id ")
	List<Personnage> findPersonnagesByIdAttaque(@Param("id") Long id);
	
	@Query("select p from Personnage p left join fetch p.items where p.id=:id ")
	List<Personnage> findPersonnagesByIdItems(@Param("id") Long id);
	
		
	@Query("select p from Personnage p")
	List<Personnage> findAllPersonnage();
}
