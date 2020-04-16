package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByDescription(String description);

    Page<Profile> findByName(String name, Pageable pageable);
}
