package SufodRepository.SufodBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Monstre;

public interface MonstreRepository extends JpaRepository<Monstre, Long>{
	
	@Query("select distinct m from Monstre m left join fetch m.attaques as a where a.id=:id")
	List<Monstre> findMonstresByIdAttaque(@Param("id") Long id);
	

}
