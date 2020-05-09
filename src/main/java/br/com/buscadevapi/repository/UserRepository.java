package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT * FROM USER U "
			+ "INNER JOIN PROFILE P ON (P.name = :type)")
	Page<User> findByProfileType(Pageable pageable, String type);
}
