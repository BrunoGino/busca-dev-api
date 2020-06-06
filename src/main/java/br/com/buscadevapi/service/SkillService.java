package br.com.buscadevapi.service;

import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Page<Skill> getSkillsByProfile(Pageable pageable, Profile profile) {
        Long profileId = profile.getId();
        return skillRepository.findPageByProfile(profileId, pageable);
    }

    public List<Skill> getSkillsById(List<Long> skillIds) {
        return skillRepository.findAllById(skillIds);
    }

    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }
}
