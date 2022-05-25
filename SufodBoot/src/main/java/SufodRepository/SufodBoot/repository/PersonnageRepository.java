package SufodRepository.SufodBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
	
	@Query("select distinct p from Personnage p left join fetch p.compte as c where c.id=:id")
	List<Personnage> findPersonnagesByIdCompte(@Param("id") Long id);
		
	@Query("select distinct p from Personnage p left join fetch p.attaques as a where a.id=:id")
	List<Personnage> findPersonnagesByIdAttaque(@Param("id") Long id);
	
	@Query("select distinct p from Personnage p left join fetch p.items as i where i.id=:id ")
	List<Personnage> findPersonnagesByIdItems(@Param("id") Long id);
	

}
