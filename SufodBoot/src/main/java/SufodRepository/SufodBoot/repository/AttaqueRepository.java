package SufodRepository.SufodBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import SufodRepository.SufodBoot.entity.Attaque;

public interface AttaqueRepository extends JpaRepository<Attaque, Long>{
	
	@Query("select distinct a from Attaque a left join fetch a.personnages as p where p.id=:id")
	List<Attaque> findAttaquesByPersonnageId (@Param("id")Long id);
	
	@Query("select distinct a from Attaque a left join fetch a.monstres as m where m.id=:id")
	List<Attaque> findAttaquesByMonstreId (@Param("id")Long id);
	

}
