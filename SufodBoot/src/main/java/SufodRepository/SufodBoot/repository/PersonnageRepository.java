package SufodRepository.SufodBoot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
	
	@Query("select distinct p from Personnage p left join fetch p.compte as c where c.id=:id")
	List<Personnage> findPersonnagesByIdCompte(@Param("id") Long id);
		
	@Query("select distinct p from Personnage p left join fetch p.attaque as a where a.id=:id")
	List<Personnage> findPersonnagesByIdAttaque(@Param("id") Long id);
	
	@Query("select distinct p from Personnage p left join fetch p.items as i where i.id=:id ")
	List<Personnage> findPersonnagesByIdItems(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update Personnage p set p.attaque=null where p.attaque=:attaque")
	public void setAttaqueToNull(@Param("attaque") Attaque attaque);

}
