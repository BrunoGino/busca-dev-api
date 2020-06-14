package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Query(value = "SELECT * FROM EXPERIENCE " +
            "WHERE USER_USER_ID = :id " +
            "ORDER BY END_DATE ASC", nativeQuery = true)
    Page<Experience> findAllByUserId(Pageable pageable, @Param("id") Long id);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM EXPERIENCE USER_USER_ID = :userId " +
            "AND TITLE = :title " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfExists(@Param("userId") Long userId, @Param("title") String title);

}
