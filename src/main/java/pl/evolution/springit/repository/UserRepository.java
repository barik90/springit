package pl.evolution.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evolution.springit.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //optional zeby nie dawało błędu jak nie znajdzie
}
