package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.ExperienceRepository;
import br.com.buscadevapi.repository.LinkRepository;
import br.com.buscadevapi.repository.ProfileRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

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


        Profile profile = profileRepository.findByName(form.getProfileName()).get();
        user.setProfile(profile);

        Page<Experience> experiences = experienceRepository.findAllByUserId(pageable, user.getId());
        user.setExperiences(experiences.getContent());

        List<Link> links = linkRepository.findPagedLinksByUser(pageable, user.getId()).getContent();
        user.setLink(links);

        userRepository.save(user);

        return user;
    }


    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
