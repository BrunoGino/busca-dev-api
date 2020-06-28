package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.controller.form.UserForm;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

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
    public ResponseEntity<UserDTO> userById(@PathVariable String id) {
        Optional<User> userById = userService.getUserById(id);
        return userById.map(user -> ResponseEntity.ok(new UserDTO(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriComponentsBuilder) {
        try {
            User user = userService.createUser(userForm);
            UserDTO userDTO = new UserDTO(user);
            URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userDTO.getId()).toUri();
            return ResponseEntity.created(uri).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserForm userForm, @PathVariable String userId) {
        try {
            User user = userService.updateUser(userId, userForm);
            return ResponseEntity.ok(new UserDTO(user));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
