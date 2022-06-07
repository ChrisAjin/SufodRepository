package SufodRepository.SufodBoot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.Monstre;

public interface MonstreRepository extends JpaRepository<Monstre, Long>{
	
	@Query("select distinct m from Monstre m left join fetch m.attaque as a where a.id=:id")
	List<Monstre> findMonstresByIdAttaque(@Param("id") Long id);
	@Modifying
	@Transactional
	@Query("update Monstre m set m.attaque=null where m.attaque=:attaque")
	public void setAttaqueToNull(@Param("attaque") Attaque attaque);

}
