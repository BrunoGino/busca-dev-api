package br.com.userprofiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.userprofiles.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Profile findByName(String name);

}
