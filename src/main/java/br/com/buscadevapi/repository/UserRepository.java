package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
