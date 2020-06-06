package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query(value = "SELECT * FROM SKILL " +
            "WHERE PROFILE_ID = :profileId", nativeQuery = true)
    Page<Skill> findPageByProfile(@Param("profileId") Long profileId, Pageable pageable);

    @Query(value = "SELECT * FROM SKILL " +
            "WHERE SKILL_ID IN :skillIds", nativeQuery = true)
    List<Skill> findSkillsBySkillId(@Param("skillIds") List<Long> skillIds);

    Page<Skill> findByName(String name, Pageable pageable);
}
