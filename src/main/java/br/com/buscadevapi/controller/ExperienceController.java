package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ExperienceDTO;
import br.com.buscadevapi.controller.form.ExperienceForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.service.ExperienceService;
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
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public Page<ExperienceDTO> allExperiencesByUser(@PageableDefault Pageable pageable, @RequestParam Long userId) {
        return ExperienceDTO.convertPage(experienceService.getExperiencesByUser(pageable, userId));
    }

    @GetMapping("/{experienceId}")
    public ResponseEntity<ExperienceDTO> experienceById(@PathVariable Long experienceId) {
        Optional<Experience> experienceOptional = experienceService.getExperienceById(experienceId);
        return experienceOptional.map(experience -> ResponseEntity.ok(new ExperienceDTO(experience)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExperienceDTO> createNewExperience(@RequestBody @Valid ExperienceForm experienceForm,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        try {
            Experience experience = experienceService.createExperience(experienceForm);
            ExperienceDTO experienceDTO = new ExperienceDTO(experience);
            URI uri = uriComponentsBuilder.path("/experience/{id}").buildAndExpand(experienceDTO.getId()).toUri();
            return ResponseEntity.created(uri).body(experienceDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{experienceId}")
    public ResponseEntity<?> updateExperience(@RequestBody @Valid ExperienceForm experienceForm,
                                              @PathVariable Long experienceId) {
        try {
            Experience experience = experienceService.updateExperience(experienceId, experienceForm);
            return ResponseEntity.ok(new ExperienceDTO(experience));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{experienceId}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long experienceId) {
        return experienceService.delete(experienceId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
