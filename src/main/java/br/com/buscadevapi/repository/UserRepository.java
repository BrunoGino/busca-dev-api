package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    Page<User> findByFirstName(String firstName, Pageable pageable);
    User findByEmail(String email);
}
