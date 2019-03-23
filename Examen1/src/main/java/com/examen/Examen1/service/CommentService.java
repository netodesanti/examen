package com.examen.Examen1.service;

import com.examen.Examen1.domain.Comment;
import com.examen.Examen1.domain.Likes;
import com.examen.Examen1.domain.Post;
import com.examen.Examen1.repository.CommentRepository;
import com.examen.Examen1.repository.LikesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(Comment comment) {

        commentRepository.save(comment);
    }

    public void updateComment(Comment comment, long id) {
        comment.setId(id);

        commentRepository.save(comment);
    }

    public List<Comment> findAllByPost(Post post) {
        return commentRepository.findAllByPost(post);
    }

}
