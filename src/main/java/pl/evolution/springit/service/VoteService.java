package pl.evolution.springit.service;

import org.springframework.stereotype.Service;
import pl.evolution.springit.domain.Vote;
import pl.evolution.springit.repository.VoteRepository;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote){
        return voteRepository.save(vote);
    }
}
