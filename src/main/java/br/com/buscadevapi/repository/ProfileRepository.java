package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByName(String name);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM PROFILE WHERE NAME = :name " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfExists(@Param("name") String name);
}
