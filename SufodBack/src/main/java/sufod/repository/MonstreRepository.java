package sufod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sufod.entity.Monstre;

public interface MonstreRepository extends JpaRepository<Monstre, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Monstre m set m.attaque=null where m.attaque=:attaque")
	void deleteByMaitre(@Param("attaque") Monstre attaque);

}
