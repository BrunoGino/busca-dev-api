package br.com.userprofiles.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.userprofiles.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT * FROM USER U "
			+ "INNER JOIN PROFILE P ON (P.name = :type)")
	Page<User> findByProfileType(Pageable pageable, String type);
}
