package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProjectDTO;
import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public Page<ProjectDTO> allProject(@RequestParam(required = false) String title,
                                       @PageableDefault(sort = "title", direction = Sort.Direction.ASC,
                                               size = 20) Pageable pageable) {
        if (title == null) {
            Page<Project> projects = repository.findAll(pageable);
            return ProjectDTO.convert(projects);
        } else {
            Page<Project> projects = repository.findAllByTitle(pageable, title);
            return ProjectDTO.convert(projects);
        }
    }

}
