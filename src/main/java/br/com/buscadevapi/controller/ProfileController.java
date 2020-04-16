package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.ProfileDTO;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.repository.ProfileRepository;
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
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileRepository repository;

    @GetMapping
    public Page<ProfileDTO> allProfile(@RequestParam(required = false) String name,
                                       @PageableDefault(sort = "name", direction = Sort.Direction.ASC, size = 20)
                                       Pageable pageable){
        if(name == null){
            Page<Profile> profiles = repository.findAll(pageable);
            return ProfileDTO.convertMany(profiles);
        }else{
            Page<Profile> profilesByTitle = repository.findByName(name, pageable);
            return ProfileDTO.convertMany(profilesByTitle);
        }
    }
}
