package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.model.*;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User updateUser(String userId, UserForm userForm) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userForm.getFirstName());
            user.setLastName(userForm.getLastName());
            // Needs email validation. Email is an unique property
            user.setEmail(userForm.getEmail());
            user.setBirthDate(userForm.getBirthDate());
            user.setCellphone(userForm.getCellphone());
            user.setTelephone(userForm.getTelephone());

            List<Skill> skills = skillService.getSkillsBySkillNames(userForm.getSkills());
            user.setSkills(skills);

            return userRepository.save(user);
        }
        throw new DataIntegrityViolationException("Object with ID " + userId + " doesn't exist in database");
    }

    public User createUser(UserForm form) {
        if (!alreadyExists(form)) {
            return createNewUser(form);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + form.toString());
    }

    private boolean alreadyExists(UserForm form) {
        return userRepository.findIfExistsByEmail(form.getEmail());
    }

    private User createNewUser(UserForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setEmail(form.getEmail());
        user.setBirthDate(form.getBirthDate());
        user.setCellphone(form.getCellphone());
        user.setTelephone(form.getTelephone());

        Profile profile = profileService.getProfileByName(form.getProfileName()).get();
        user.setProfile(profile);

        List<Experience> createdExperiences = createUserExperiences(form, user.getUserId());
        user.setExperiences(createdExperiences);

        List<Skill> skills = skillService.getSkillsBySkillNames(form.getSkills());
        user.setSkills(skills);

        List<Link> createdLinks = createUserLinks(form, user.getUserId());
        user.setLinks(createdLinks);

        return userRepository.save(user);
    }

    private List<Link> createUserLinks(UserForm form, String userId) {
        form.getLinks().forEach(linkForm -> {
            linkForm.setUserId(userId);
            linkService.createLink(linkForm);
        });
        return linkService.getLinksByUser(Pageable.unpaged(), userId).getContent();
    }

    private List<Experience> createUserExperiences(UserForm form, String userId) {
        form.getExperiences().forEach(experienceForm -> {
            experienceForm.setUserId(userId);
            experienceService.createExperience(experienceForm);
        });
        return experienceService.getExperiencesByUser(Pageable.unpaged(), userId).getContent();
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
