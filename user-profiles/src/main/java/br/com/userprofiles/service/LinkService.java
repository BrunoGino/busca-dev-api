package br.com.userprofiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.userprofiles.form.LinkForm;
import br.com.userprofiles.model.Link;
import br.com.userprofiles.model.LinkType;
import br.com.userprofiles.repository.LinkRepository;
import br.com.userprofiles.repository.UserRepository;

@Service
public class LinkService {
	@Autowired
	private LinkRepository linkRepository;
	@Autowired
	private UserRepository userRepository;
	

	public Link createLink(LinkForm form) {
		Link newLink = new Link();

		newLink.setLinkType(LinkType.valueOf(form.getLinkType().toUpperCase()));
		newLink.setLink(form.getLink());
		newLink.setUser(userRepository.findById(form.getUserId()).get());

		linkRepository.save(newLink);

		return newLink;
	}

}
