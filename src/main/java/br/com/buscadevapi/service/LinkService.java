package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.LinkForm;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.model.LinkType;
import br.com.buscadevapi.repository.LinkRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private UserRepository userRepository;


    public Page<Link> getLinksByUser(Pageable pageable, Long userId) {
        return linkRepository.findPagedLinksByUser(pageable, userId);
    }

    public Link createLink(LinkForm form) {
        Link newLink = new Link();

        newLink.setLinkType(LinkType.valueOf(form.getLinkType().toUpperCase()));
        newLink.setLink(form.getLink());
        newLink.setUser(userRepository.findById(form.getUserId()).get());

        linkRepository.save(newLink);

        return newLink;
    }

}
