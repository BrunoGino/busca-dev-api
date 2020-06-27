package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProjectDTO;
import br.com.buscadevapi.controller.form.ProjectForm;
import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.service.ProjectService;
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
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Page<ProjectDTO> allProject(@PageableDefault(size = 20) Pageable pageable) {
        return ProjectDTO.convertPage(projectService.getAllProjects(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable("id") Long projectId) {
        Optional<Project> optionalProject = projectService.getProjectById(projectId);
        return optionalProject.map(project -> ResponseEntity.ok(new ProjectDTO(project)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProjectForm projectForm,
                                    UriComponentsBuilder uriComponentsBuilder) {
        try {
            ProjectDTO projectDTO = new ProjectDTO(projectService.createProject(projectForm));
            URI uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(projectDTO.getId()).toUri();
            return ResponseEntity.created(uri).body(projectDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{projectId}")
    public ResponseEntity<?> updateProject(@RequestBody @Valid ProjectForm projectForm, @PathVariable Long projectId) {
        try {
            Project project = projectService.update(projectId, projectForm);
            return ResponseEntity.ok(new ProjectDTO(project));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{projectId}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long projectId) {
        return projectService.delete(projectId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
