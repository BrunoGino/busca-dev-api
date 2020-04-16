package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    public Page<Link> findAll(Pageable pageable);
    public Page<Link> findAllByUser(Pageable pageable, Long userId);

}
