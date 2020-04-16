package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Page<UserDTO> allUsers(@RequestParam(required = false) String firstName,
                                  @PageableDefault(sort = "firstName", direction = Sort.Direction.ASC,
                                          size = 20) Pageable pageable) {
        if (firstName == null) {
            Page<User> users = userRepository.findAll(pageable);
            return UserDTO.convert(users);
        } else {
            Page<User> users = userRepository.findByFirstName(firstName, pageable);
            return UserDTO.convert(users);
        }
    }
}
