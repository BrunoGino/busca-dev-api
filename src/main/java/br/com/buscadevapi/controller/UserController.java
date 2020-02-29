package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.controller.form.ContactForm;
import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.controller.form.UserProfileForm;
import br.com.buscadevapi.model.Contact;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.ProfileRepository;
import br.com.buscadevapi.repository.SkillRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public Page<UserDTO> allUsers(@RequestParam(required = false) String firstName,
                                  @PageableDefault(sort = "firstName", direction = Sort.Direction.ASC,
                                          page = 0, size = 10) Pageable pageable) {
        if (firstName == null) {
            Page<User> users = userRepository.findAll(pageable);
            return UserDTO.convert(users);
        } else {
            Page<User> users = userRepository.findByFirstName(firstName, pageable);
            return UserDTO.convert(users);
        }
    }


    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> newUser(@RequestBody @Valid UserForm userForm, @RequestBody @Valid ContactForm contactForm,
                                           @RequestBody @Valid UserProfileForm userProfileForm,
                                           UriComponentsBuilder uriComponentsBuilder) {
//        User user = userForm.convert();
//
//        Contact contact = contactForm.convert(userRepository);
//        user.setContact(contact);
//
//        Profile profile = userProfileForm.convert(profileRepository, skillRepository, userRepository);
//        user.setProfile(profile);
//
//        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
//        return ResponseEntity.created(uri).body(new UserDTO(user));
        return null;
    }

}
