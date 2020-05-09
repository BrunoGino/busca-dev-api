package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.ExperienceForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.repository.ExperienceRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
		Experience experience = new Experience();

		experience.setTitle(form.getTitle());
		experience.setDescription(form.getDescription());
		experience.setInitialDate(form.getInitialDate());
		experience.setEndDate(form.getEndDate());
		experience.setUser(userRepository.findById(form.getUserId()).get());

		experienceRepository.save(experience);

		return experience;
	}
}
