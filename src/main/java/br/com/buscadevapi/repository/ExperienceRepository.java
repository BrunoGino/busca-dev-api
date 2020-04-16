package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    public Page<Experience> findAll(Pageable pageable);
}
