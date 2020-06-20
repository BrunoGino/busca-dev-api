package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.SkillDTO;
import br.com.buscadevapi.controller.form.SkillForm;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.service.ProfileService;
import br.com.buscadevapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Page<SkillDTO> allSkills(@RequestParam(required = false) String profileName,
                                    @PageableDefault(sort = "name", direction = Sort.Direction.ASC,
                                            size = 20) Pageable pageable) {
        if (profileName != null) {
            return getSkillsByProfileName(profileName, pageable);
        }
        return SkillDTO.convertPage(skillService.getSkills(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getSkill(@PathVariable("id") Long skillId) {
        Optional<Skill> optionalSkill = skillService.getSkillById(skillId);
        return optionalSkill.map(skill -> ResponseEntity.ok(new SkillDTO(skill)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createSkill(@RequestBody @Valid SkillForm skillForm,
                                         UriComponentsBuilder uriComponentsBuilder) {
        SkillDTO skillDTO = new SkillDTO(skillService.createSkill(skillForm));
        URI uri = uriComponentsBuilder.path("/skill/{id}").buildAndExpand(skillDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(skillDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateSkill(@RequestBody @Valid SkillForm skillForm) {
        Skill updatedSkill = skillService.updateSkill(skillForm);
        if (updatedSkill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new SkillDTO(updatedSkill));
    }

    private Page<SkillDTO> getSkillsByProfileName(String profileName, Pageable pageable) {
        Optional<Profile> foundProfile = profileService.getProfileByName(profileName.toUpperCase());
        return foundProfile.map(profile -> SkillDTO.convertPage(skillService.getSkillsByProfile(pageable, profile)))
                .orElseGet(() -> SkillDTO.convertPage(skillService.getSkills(pageable)));
    }

}
