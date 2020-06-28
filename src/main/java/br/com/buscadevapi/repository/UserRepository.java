package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM B_USER U "
            + "INNER JOIN PROFILE P ON (P.PROFILE_ID = U.PROFILE_PROFILE_ID) " +
            "WHERE P.NAME = :type", nativeQuery = true)
    Page<User> findByProfileType(Pageable pageable, @Param("type") String type);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM B_USER WHERE EMAIL = :email " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfExistsByEmail(@Param("email") String email);
}
