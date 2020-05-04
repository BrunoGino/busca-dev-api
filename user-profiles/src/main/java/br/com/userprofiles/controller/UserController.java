package br.com.userprofiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.userprofiles.dto.UserDTO;
import br.com.userprofiles.model.User;
import br.com.userprofiles.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/devs")
	public Page<UserDTO> getDevs(@PageableDefault(sort = "id", direction = Direction.ASC) Pageable pageable) {
		Page<User> users = userService.getByProfile(pageable, "Desenvolvedores");
		return UserDTO.convertPage(users);
	}

}
