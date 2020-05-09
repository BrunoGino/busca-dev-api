package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ExperienceRepository extends JpaRepository<Experience, Long> {

	@Query(value = "SELECT * FROM EXPERIENCE WHERE USER_ID = :id", nativeQuery = true)
	Page<Experience> findAllByUserId(Pageable pageable, Long id);

}
