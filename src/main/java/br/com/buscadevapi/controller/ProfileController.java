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
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/{profileName}")
    public ResponseEntity<ProfileDTO> profileByName(@PathVariable("profileName") String profileName) {
        Optional<Profile> profileByName = profileService.getProfileByName(profileName);
        return profileByName.map(profile -> ResponseEntity.ok(new ProfileDTO(profile)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createNewProfile(@RequestBody @Valid ProfileForm profileForm,
                                              UriComponentsBuilder uriComponentsBuilder) {
        try {
            ProfileDTO profileDTO = new ProfileDTO(profileService.createProfile(profileForm));
            URI uri = uriComponentsBuilder.path("/profile/{id}").buildAndExpand(profileDTO.getId()).toUri();
            return ResponseEntity.created(uri).body(profileDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{profileId}")
    public ResponseEntity<?> updateProfile(@RequestBody @Valid ProfileForm profileForm, @PathVariable Long profileId) {
        try {
            Profile profile = profileService.updateProfile(profileId, profileForm);
            return ResponseEntity.ok(new ProfileDTO(profile));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long profileId) {
        return profileService.delete(profileId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
