package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ProfileForm;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	
	public Page<Profile> getAll(Pageable pageable){
		return profileRepository.findAll(pageable);
	}
	
	public Profile createProfile(ProfileForm form ) {
		Profile profile = new Profile();
		
		profile.setName(form.getName());
		profile.setDescription(form.getDescription());
		
		profileRepository.save(profile);
		
		return profile;
	}

	public Optional<Profile> getProfileByName(String profileName) {
		return profileRepository.findByName(profileName.toUpperCase());
	}
}
