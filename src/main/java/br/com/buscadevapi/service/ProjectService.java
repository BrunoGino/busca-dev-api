package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ProjectForm;
import br.com.buscadevapi.model.*;
import br.com.buscadevapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SkillService skillService;
    @Autowired
    private UserService userService;

    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public boolean delete(Long projectId) {
        Optional<Project> optionalProfile = projectRepository.findById(projectId);
        if (optionalProfile.isPresent()) {
            projectRepository.delete(optionalProfile.get());
            return true;
        } else {
            return false;
        }
    }

    public Project update(ProjectForm projectForm){
        if(alreadyExists(projectForm)){
            Project project = new Project();

            project.setTitle(projectForm.getTitle());
            project.setDescription(projectForm.getDescription());
            project.setInitialDate(projectForm.getInitialDate());
            project.setEndingDate(projectForm.getEndingDate());

            User owner = userService.getUserById(projectForm.getOwnerId());

            project.setOwner(owner);

            List<String> skillNames = projectForm.getSkillNames();
            List<Skill> skillsBySkillNames = skillService.getSkillsBySkillNames(skillNames);
            project.setSkills(skillsBySkillNames);

            project.setStatus(projectForm.getStatus().toString());

            return saveProject(project);
        }
        throw new DataIntegrityViolationException("Object doesn't exists in database: " + projectForm.toString());
    }

    public Project createProject(ProjectForm projectForm) {
        if (!alreadyExists(projectForm)) {
            Project project = new Project();

            project.setTitle(projectForm.getTitle());
            project.setDescription(projectForm.getDescription());
            project.setInitialDate(projectForm.getInitialDate());
            project.setEndingDate(projectForm.getEndingDate());


            User owner = userService.getUserById(projectForm.getOwnerId());

            project.setOwner(owner);

            List<String> skillNames = projectForm.getSkillNames();
            List<Skill> skillsBySkillNames = skillService.getSkillsBySkillNames(skillNames);
            project.setSkills(skillsBySkillNames);

            project.setStatus(Status.CREATED.getDescription());

            Project savedProject = saveProject(project);

            savedProject.getSkills().forEach(skill -> {
                if (skill != null) {
                    skillService.addProjectToSkill(skill.getId(), savedProject.getId());
                }
            });

            return savedProject;
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + projectForm.toString());
    }

    private boolean alreadyExists(ProjectForm projectForm) {
        return projectRepository.findIfExists(projectForm.getTitle());
    }
    private Project saveProject(Project project) {
        return projectRepository.save(project);
    }

}
