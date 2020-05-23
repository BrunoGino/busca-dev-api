package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.UserDTO;
import br.com.buscadevapi.service.UserService;
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
    private UserService userService;

    @GetMapping
    public Page<UserDTO> allUsers(@PageableDefault(sort = "FIRST_NAME", direction = Sort.Direction.ASC,
            size = 20) Pageable pageable, @RequestParam String profileType) {
        return UserDTO.convertPage(userService.getByProfile(pageable, profileType));
    }
}
