package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProjectDTO;
import br.com.buscadevapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Page<ProjectDTO> allProject(@PageableDefault(size = 20) Pageable pageable) {
        return ProjectDTO.convertPage(projectService.getAllProjects(pageable));
    }

}
