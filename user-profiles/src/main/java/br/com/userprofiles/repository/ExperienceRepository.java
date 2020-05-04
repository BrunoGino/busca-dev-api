package br.com.userprofiles.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.userprofiles.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

	@Query(value = "SELECT * FROM EXPERIENCE WHERE USER_ID = :id", nativeQuery = true)
	Page<Experience> findAllByUserId(Pageable pageable, Long id);

}
