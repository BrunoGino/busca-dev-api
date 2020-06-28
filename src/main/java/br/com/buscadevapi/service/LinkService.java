package br.com.buscadevapi.service;

import br.com.buscadevapi.controller.form.LinkForm;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.model.LinkType;
import br.com.buscadevapi.repository.LinkRepository;
import br.com.buscadevapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private UserRepository userRepository;


    public Page<Link> getLinksByUser(Pageable pageable, String userId) {
        return linkRepository.findPagedLinksByUser(pageable, userId);
    }

    public Link createLink(LinkForm form) {
        if (!linkExists(form)) {
            return saveNewLink(form);
        }
        throw new DataIntegrityViolationException("Object already exists in database: " + form.toString());
    }

    public Link updateLink(Long linkId, LinkForm linkForm) {
        Optional<Link> optionalLink = linkRepository.findById(linkId);
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            link.setLink(linkForm.getLink());
            link.setLinkType(LinkType.valueOf(linkForm.getLinkType()));

            return linkRepository.save(link);
        }
        throw new DataIntegrityViolationException("Object doesn't exists in database: " + linkForm.toString());
    }

    public boolean deleteLink(Long linkId) {
        Optional<Link> optionalLink = linkRepository.findById(linkId);
        if (optionalLink.isPresent()) {
            linkRepository.delete(optionalLink.get());
            return true;
        } else {
            return false;
        }
    }

    private boolean linkExists(LinkForm form) {
        return linkRepository.findIfLinkExists(form.getLink(), form.getLinkType(), form.getUserId());
    }

    private Link saveNewLink(LinkForm form) {
        Link newLink = new Link();
        newLink.setLinkType(LinkType.valueOf(form.getLinkType().toUpperCase()));
        newLink.setLink(form.getLink().trim());
        newLink.setUser(userRepository.findById(form.getUserId()).get());
        return linkRepository.save(newLink);
    }

}
