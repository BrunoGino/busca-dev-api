package br.com.userprofiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.userprofiles.form.ProfileForm;
import br.com.userprofiles.model.Profile;
import br.com.userprofiles.repository.ProfileRepository;

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
}
