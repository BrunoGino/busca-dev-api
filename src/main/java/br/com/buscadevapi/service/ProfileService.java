package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ProfileForm;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Page<Profile> getAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    public Profile createProfile(ProfileForm form) {
        if (!profileExists(form)) {
            return saveProfile(form);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + form.toString());
    }

    public Profile updateProfile(ProfileForm profile) {
        if (profileExists(profile)) {
            return saveProfile(profile);
        }
        throw new DataIntegrityViolationException("Object doesn't exists in database: " + profile.toString());
    }

    private boolean profileExists(ProfileForm form) {
        return profileRepository.findIfExists(form.getName());
    }

    private Profile saveProfile(ProfileForm form) {
        Profile profile = new Profile();

        profile.setName(form.getName());
        profile.setDescription(form.getDescription());

        profileRepository.save(profile);

        return profile;
    }

    public Optional<Profile> getProfileByName(String profileName) {
        return profileRepository.findByName(profileName.toUpperCase());
    }

    public boolean delete(Long profileId) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);
        if (optionalProfile.isPresent()) {
            profileRepository.delete(optionalProfile.get());
            return true;
        } else {
            return false;
        }
    }
}
