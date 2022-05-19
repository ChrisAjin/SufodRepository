package sufod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sufod.entity.Attaque;
import sufod.entity.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
	
	@Query("select p from Personnage p left join fetch p.joueur where p.id=:id")
	List<Personnage> findPersonnagesByIdCompte(@Param("id") Long id);
	
	@Query("select p from Personnage p where p.id=:id")
	Optional<Personnage> findPersonnagesById(@Param("id") Long id);
	
	@Query("select p from Personnage p where p.att_1=:id or p.att_2=:id or p.att_3=:id or p.att_4=:id ")
	List<Personnage> findPersonnagesByIdAttaque(@Param("id") Long id);
	
	@Query("select p from Personnage p where p.equip_tete=:id or p.equip_plastron=:id or p.equip_cou=:id or p.equip_main=:id or p.equip_poignet=:id or p.equip_pied=:id or p.equip_jambe=:id or p.equip_bras=:id ")
	List<Personnage> findPersonnagesByIdEquipement(@Param("id") Long id);
	
		
	@Query("select p from Personnage p")
	List<Personnage> findAllPersonnage();
}
