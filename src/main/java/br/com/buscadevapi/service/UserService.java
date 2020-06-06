package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.dto.SkillDTO;
import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private SkillService skillService;

    public Page<User> getByProfile(Pageable pageable, String profileType) {
        return userRepository.findByProfileType(pageable, profileType.toUpperCase());
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    public User createUser(UserForm form, Pageable pageable) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setEmail(form.getEmail());
        user.setBirthDate(form.getBirthDate());
        user.setCellphone(form.getCellphone());
        user.setTelephone(form.getTelephone());

        Profile profile = profileService.getProfileByName(form.getProfileName()).get();
        user.setProfile(profile);

        List<Experience> createdExperiences = createUserExperiences(form, pageable, user.getId());
        user.setExperiences(createdExperiences);

        List<Long> skillIds = form.getSkills().stream().map(SkillDTO::getId).collect(Collectors.toList());
        user.setSkills(skillService.getSkillsById(skillIds));


        List<Link> createdLinks = createUserLinks(form, pageable, user.getId());
        user.setLinks(createdLinks);

        userRepository.save(user);

        return user;
    }

    private List<Link> createUserLinks(UserForm form, Pageable pageable, Long userId) {
        form.getLinks().forEach(linkForm -> {
            linkForm.setUserId(userId);
            linkService.createLink(linkForm);
        });
        return linkService.getLinksByUser(pageable, userId).getContent();
    }

    private List<Experience> createUserExperiences(UserForm form, Pageable pageable, Long userId) {
        form.getExperiences().forEach(experienceForm -> {
            experienceForm.setUserId(userId);
            experienceService.createExperience(experienceForm);
        });
        return experienceService.getExperiencesByUser(pageable, userId).getContent();
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
