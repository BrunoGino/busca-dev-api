package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Optional<Profile> findByName(String name);

}
