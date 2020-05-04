package br.com.userprofiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.userprofiles.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long>{

	List<Link> findAllByUserId(Long userId);
	
}
