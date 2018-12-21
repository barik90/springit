package pl.evolution.springit.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.evolution.springit.domain.Link;
import pl.evolution.springit.domain.Vote;
import pl.evolution.springit.service.LinkService;
import pl.evolution.springit.service.VoteService;

import java.util.Optional;

@RestController
public class VoteController {

    private LinkService linkService;
    private VoteService voteService;

    public VoteController(LinkService linkService, VoteService voteService) {
        this.linkService = linkService;
        this.voteService = voteService;
    }

    //http://localhost:8080/vote/link/1/direction/-1/votecount/5
    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkID, @PathVariable short direction, @PathVariable int voteCount){
        Optional<Link> optionalLink = linkService.findById(linkID);
        if(optionalLink.isPresent()){
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteService.save(vote);

            int updatedVoteCount = voteCount + direction;
            link.setVoteCount(updatedVoteCount);
            linkService.save(link);
            return updatedVoteCount;
        }
        return voteCount;
    }
}
