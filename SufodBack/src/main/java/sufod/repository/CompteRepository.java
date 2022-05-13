package sufod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sufod.entity.Admin;
import sufod.entity.Compte;
import sufod.entity.Joueur;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("Select c from Compte c where c.login=:login and c.password=:password")
	Optional<Compte> seConnecter(@Param("login") String login,@Param("password") String password);

@Query("Select s from Admin s")
	List<Admin> findAllAdmins();
	
	@Query("Select f from Joueur f")
	List<Joueur> findAllJoueurs();
}
