package pl.evolution.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evolution.springit.domain.Vote;

public interface VoteRepository  extends JpaRepository<Vote, Long> {

}
