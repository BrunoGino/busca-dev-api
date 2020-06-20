package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "SELECT * FROM PROJECT " +
            "ORDER BY ENDING_DATE ASC", nativeQuery = true)
    public Page<Project> findAll(Pageable pageable);

    public Page<Project> findAllByTitle(Pageable pageable, String title);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM PROJECT WHERE TITLE :projectTitle " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfExists(@Param("projectTitle") String projectTitle);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM PROJECT WHERE PROJECT_ID = :projectId " +
            "LIMIT 1", nativeQuery = true)
    boolean findIfExistsById(Long projectId);

}
