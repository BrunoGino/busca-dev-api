package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{userId}")
    public UserDTO userById(@PathVariable Long userId) {
        return UserDTO.convert(userService.getUserById(userId));
    }

}
