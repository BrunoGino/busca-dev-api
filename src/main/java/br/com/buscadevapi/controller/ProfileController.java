package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProfileDTO;
import br.com.buscadevapi.controller.form.ProfileForm;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Page<ProfileDTO> allProfiles(@PageableDefault(size = 20) Pageable pageable) {
        return ProfileDTO.convertPage(profileService.getAll(pageable));
    }

    @GetMapping(value = "/{profileName}")
    public ResponseEntity<ProfileDTO> profileByName(@PathVariable String profileName) {
        Optional<Profile> profileByName = profileService.getProfileByName(profileName);
        return profileByName.map(profile -> ResponseEntity.ok(ProfileDTO.convert(profile)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProfileDTO createNewProfile(@RequestBody @Valid ProfileForm profileForm) {
        return ProfileDTO.convert(profileService.createProfile(profileForm));
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody @Valid ProfileForm profileForm) {
        Profile profile = profileService.updateProfile(profileForm);

        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProfileDTO.convert(profile));
    }

    @DeleteMapping(value = "/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long profileId){
        return profileService.delete(profileId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
