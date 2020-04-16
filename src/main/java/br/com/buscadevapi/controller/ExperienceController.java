package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ExperienceDTO;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceRepository repository;

    @GetMapping
    public Page<ExperienceDTO> allExperiences(@PageableDefault Pageable pageable) {
        Page<Experience> experiences = repository.findAll(pageable);
        return ExperienceDTO.convertMany(experiences);
    }


}
