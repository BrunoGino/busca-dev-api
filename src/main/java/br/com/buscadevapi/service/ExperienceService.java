package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ExperienceForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.repository.ExperienceRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private UserRepository userRepository;

    public Page<Experience> getExperiencesByUser(Pageable pageable, Long userId) {
        return experienceRepository.findAllByUserId(pageable, userId);
    }

    public Experience createExperience(ExperienceForm form) {
        Long userId = form.getUserId();
        String title = form.getTitle();
        if (!experienceExists(title, userId)) {
            return saveNewExperience(form);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + form.toString());
    }

    public Experience updateExperience(Long experienceId, ExperienceForm experienceForm) {
        Optional<Experience> optionalExperience = experienceRepository.findById(experienceId);
        if (optionalExperience.isPresent()) {
            Experience experience = optionalExperience.get();

            experience.setTitle(experienceForm.getTitle());
            experience.setDescription(experienceForm.getDescription());
            experience.setInitialDate(experienceForm.getInitialDate());
            experience.setEndDate(experienceForm.getEndDate());

            return experienceRepository.save(experience);
        }
        throw new DataIntegrityViolationException("Object doesn't exists in database: " + experienceForm.toString());
    }

    public boolean delete(Long experienceId) {
        Optional<Experience> experienceOptional = experienceRepository.findById(experienceId);
        if (experienceOptional.isPresent()) {
            experienceRepository.delete(experienceOptional.get());
            return true;
        } else {
            return false;
        }
    }

    private Experience saveNewExperience(ExperienceForm form) {
        Experience experience = new Experience();

        experience.setTitle(form.getTitle());
        experience.setDescription(form.getDescription());
        experience.setInitialDate(form.getInitialDate());
        experience.setEndDate(form.getEndDate());
        experience.setUser(userRepository.findById(form.getUserId()).get());

        return experienceRepository.save(experience);
    }

    public Optional<Experience> getExperienceById(Long experienceId) {
        return experienceRepository.findById(experienceId);
    }

    private boolean experienceExists(String experienceTitle, Long userId) {
        return experienceRepository.findIfExistsByTitleAndUser(experienceTitle, userId);
    }

}
