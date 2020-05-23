package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ExperienceDTO;
import br.com.buscadevapi.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public Page<ExperienceDTO> allExperiencesByUser(@PageableDefault Pageable pageable, @RequestParam Long userId) {
        return ExperienceDTO.convertPage(experienceService.getExperiencesByUser(pageable, userId));
    }
}
