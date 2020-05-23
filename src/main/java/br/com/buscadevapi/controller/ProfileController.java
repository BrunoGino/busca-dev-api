package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProfileDTO;
import br.com.buscadevapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Page<ProfileDTO> allProfiles(@PageableDefault(size = 20) Pageable pageable) {
        return ProfileDTO.convertPage(profileService.getAll(pageable));
    }
}
