package SufodRepository.SufodBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.Compte;
import SufodRepository.SufodBoot.entity.Joueur;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("Select c from Compte c where c.pseudo=:pseudo and c.password=:password")
	Optional<Compte> seConnecter(@Param("pseudo") String pseudo,@Param("password") String password);

	@Query("Select s from Admin s")
	List<Admin> findAllAdmins();
	
	@Query("Select f from Joueur f")
	List<Joueur> findAllJoueurs();
	
	@Query("Select distinct c from Compte c left join fetch c.personnages as p where p.id=:id")
	Optional<Compte> findCompteByPersonnageId (@Param("id")Long id);
	
	Optional<Compte> findByPseudo(String pseudo);
		
}