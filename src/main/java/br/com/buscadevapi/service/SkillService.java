package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.SkillForm;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProjectService projectService;

    public Page<Skill> getSkillsByProfile(Pageable pageable, Profile profile) {
        Long profileId = profile.getId();
        return skillRepository.findPageByProfile(profileId, pageable);
    }

    public List<Skill> getSkillsById(List<Long> skillIds) {
        return skillRepository.findAllById(skillIds);
    }

    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }


    public Skill createSkill(SkillForm skillForm) {
        if (!alreadyExists(skillForm)) {
            Skill skill = new Skill();

            skill.setName(skillForm.getName());
            skill.setDescription(skillForm.getDescription());
            setExistingProfileToSkill(skillForm.getProfileName(), skill);

            return saveSkill(skill);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + skillForm.toString());
    }

    public Skill updateSkill(SkillForm skillForm) {
        if (alreadyExists(skillForm)) {
            Skill skill = skillRepository.findByName(skillForm.getName());

            skill.setName(skillForm.getName());
            skill.setDescription(skillForm.getDescription());
            setExistingProfileToSkill(skillForm.getProfileName(), skill);

            return saveSkill(skill);
        }
        throw new DataIntegrityViolationException("Object doesn't exist in database: " + skillForm.toString());
    }

    public Skill addProjectToSkill(Long skillId, Long projectId) {
        Optional<Skill> foundSkill = skillRepository.findById(skillId);
        Optional<Project> optionalProject = projectService.getProjectById(projectId);
        if (foundSkill.isPresent() && optionalProject.isPresent()) {
            Skill skill = foundSkill.get();
            skill.addProjectToSkill(optionalProject.get());
            return saveSkill(skill);
        }
        throw new DataIntegrityViolationException("Object with id " + skillId + " doesn't exist in database");
    }

    public boolean deleteSkill(Long id) {
        Optional<Skill> foundSkill = skillRepository.findById(id);
        if (foundSkill.isPresent()) {
            skillRepository.delete(foundSkill.get());
            return true;
        } else {
            return false;
        }
    }

    private Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    private void setExistingProfileToSkill(String profileName, Skill skill) {
        Optional<Profile> foundProfile = profileService.getProfileByName(profileName);
        if (foundProfile.isPresent()) {
            skill.setProfile(foundProfile.get());
        } else {
            throw new IllegalArgumentException("Profile doesn't exist : " + profileName);
        }
    }

    private boolean alreadyExists(SkillForm skillForm) {
        return skillRepository.findIfExists(skillForm.getName());
    }

    public Optional<Skill> getSkillById(Long skillId) {
        return skillRepository.findById(skillId);
    }

    public List<Skill> getSkillsBySkillNames(List<String> skillNames){
        return skillRepository.findByAllSkillNames(skillNames);
    }

}
