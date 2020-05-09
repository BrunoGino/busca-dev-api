package br.com.buscadevapi.repository;

import java.util.List;

import br.com.buscadevapi.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long>{

	List<Link> findAllByUserId(Long userId);
	
}
