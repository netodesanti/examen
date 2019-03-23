package com.examen.Examen1.web;

import com.examen.Examen1.domain.Post;
import com.examen.Examen1.domain.Tag;
import com.examen.Examen1.service.PostService;
import com.examen.Examen1.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("find-by-user")
    public List<Post> findByUser(@RequestParam String nickname) {
        return postService.findByUser(nickname);
    }

    @GetMapping("find-liked/{userId}")
    public List<Post> findLiked(@PathVariable int userId) {
        return postService.findLiked(userId);
    }

}
