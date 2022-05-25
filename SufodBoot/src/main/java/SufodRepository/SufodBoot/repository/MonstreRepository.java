package SufodRepository.SufodBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import SufodRepository.SufodBoot.entity.Monstre;

public interface MonstreRepository extends JpaRepository<Monstre, Integer>{
	
	

}
