package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ExperienceForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.model.Link;
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
        if (!experienceExists(userId, title)) {
            return saveExperience(form);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + form.toString());
    }

    public Experience updateExperience(ExperienceForm experienceForm) {
        Long userId = experienceForm.getUserId();
        String title = experienceForm.getTitle();
        if (experienceExists(userId, title)) {
            return saveExperience(experienceForm);
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

    private boolean experienceExists(Long userId, String title) {
        return experienceRepository.findIfExists(userId, title);
    }

    private Experience saveExperience(ExperienceForm form) {
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
}
