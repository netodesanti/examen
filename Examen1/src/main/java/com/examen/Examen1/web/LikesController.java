package com.examen.Examen1.web;

import com.examen.Examen1.domain.Likes;
import com.examen.Examen1.service.LikesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@CrossOrigin
public class LikesController {

    private final LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping
    public void createLike(@RequestBody Likes like) {
        likesService.createLike(like);
    }

    @DeleteMapping("/{postId}/{userId}")
    public void removeLike(@PathVariable long postId, @PathVariable long userId) { likesService.removeLike(postId, userId);}

}
