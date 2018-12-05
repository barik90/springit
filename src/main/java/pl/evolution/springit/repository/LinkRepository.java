package pl.evolution.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evolution.springit.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
