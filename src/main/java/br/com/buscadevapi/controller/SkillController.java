package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ErrorDTO;
import br.com.buscadevapi.controller.dto.ParamErrorDTO;
import br.com.buscadevapi.controller.dto.SkillDTO;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.service.ProfileService;
import br.com.buscadevapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        Optional<Profile> foundProfile = profileService.getProfileByName(profileName.toUpperCase());

        return foundProfile.map(profile -> SkillDTO.convertPage(skillService.getSkillsByProfile(pageable, profile)))
                .orElseGet(() -> SkillDTO.convertPage(skillService.getSkills(pageable)));
    }
}
