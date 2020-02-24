package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByIdIn(List<Integer> list);
}
