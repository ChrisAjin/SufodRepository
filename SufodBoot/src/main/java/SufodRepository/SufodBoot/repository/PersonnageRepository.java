package SufodRepository.SufodBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
	
	@Query("select p from Personnage p left join fetch p.compte where p.id=:id")
	List<Personnage> findPersonnagesByIdCompte(@Param("id") Long id);
		
	@Query("select p from Personnage p left join fetch p.attaques where p.id=:id ")
	List<Personnage> findPersonnagesByIdAttaque(@Param("id") Long id);
	
	@Query("select p from Personnage p left join fetch p.items where p.id=:id ")
	List<Personnage> findPersonnagesByIdItems(@Param("id") Long id);
	

}
