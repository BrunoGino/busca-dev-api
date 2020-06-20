package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Page<UserDTO> allUsers(@PageableDefault(size = 20) Pageable pageable, @RequestParam(required = false) String profileType) {

        if (profileType != null) {
            return UserDTO.convertPage(userService.getByProfile(pageable, profileType));
        }
        return UserDTO.convertPage(userService.getAllUsers(pageable));
    }

    @GetMapping(value = "/{id}")
    public UserDTO userById(@PathVariable Long id) {
        return UserDTO.convert(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserForm userForm,
                                          UriComponentsBuilder uriComponentsBuilder) {
        UserDTO userDTO = new UserDTO(userService.createUser(userForm));
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserForm userForm, @PathVariable Long userId) {
        User user = userService.updateUser(userId, userForm);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UserDTO.convert(user));
    }

}
