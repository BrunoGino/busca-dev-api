package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.SkillDTO;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.repository.SkillRepository;
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
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillRepository repository;

    @GetMapping
    public Page<SkillDTO> allSkills(@RequestParam(required = false) String name,
                                    @PageableDefault(sort = "name", direction = Sort.Direction.ASC,
                                            size = 20) Pageable pageable) {
        if(name == null){
            Page<Skill> skillPage = repository.findAll(pageable);
            return SkillDTO.convert(skillPage);
        }else{
            Page<Skill> skillPage = repository.findByName(name,pageable);
            return SkillDTO.convert(skillPage);
        }
    }
}
