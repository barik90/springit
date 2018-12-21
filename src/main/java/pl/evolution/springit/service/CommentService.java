package pl.evolution.springit.service;

import org.springframework.stereotype.Service;
import pl.evolution.springit.domain.Comment;
import pl.evolution.springit.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment){
       return commentRepository.save(comment);
    }
}
