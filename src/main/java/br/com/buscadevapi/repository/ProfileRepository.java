package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Profile findByName(String name);

}
