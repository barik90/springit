package pl.evolution.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evolution.springit.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
