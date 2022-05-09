package sufod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sufod.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
