package sufod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sufod.entity.Attaque;

public interface AttaqueRepository extends JpaRepository<Attaque, Long>{
	
	@Query("select a from Attaque a left join fetch a.personnage where a.id=:id")
	List<Attaque> findAttaquesByPersonnageId (@Param("id")Long id);
	
	@Query("select a form Attaque a left join fetch a.monstres where a.id=:id")
	List<Attaque> findAttaquesByMonstreId (@Param("id")Long id);

}
