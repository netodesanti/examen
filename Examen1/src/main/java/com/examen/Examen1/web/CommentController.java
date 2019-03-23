package com.examen.Examen1.web;

import com.examen.Examen1.domain.Comment;
import com.examen.Examen1.domain.Likes;
import com.examen.Examen1.domain.Post;
import com.examen.Examen1.service.CommentService;
import com.examen.Examen1.service.LikesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public void removeLike(@RequestBody Comment comment, @PathVariable long id) {
        commentService.updateComment(comment, id);
    }

    @GetMapping("/{id}")
    public List<Comment> findAllByPost(@PathVariable long id) {
        Post post = new Post();
        post.setId(id);
        return commentService.findAllByPost(post);
    }

}
