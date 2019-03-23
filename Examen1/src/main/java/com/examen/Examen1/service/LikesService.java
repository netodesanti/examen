package com.examen.Examen1.service;

import com.examen.Examen1.domain.Likes;
import com.examen.Examen1.domain.Post;
import com.examen.Examen1.domain.User;
import com.examen.Examen1.repository.LikesRepository;
import com.examen.Examen1.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LikesService {
    private final LikesRepository likesRepository;

    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public void createLike(Likes likes) {

        likesRepository.save(likes);
    }

    public void removeLike(long postId, long userId) {

        Post post = new Post();
        post.setId(postId);

        User user = new User();
        user.setId(userId);

        Likes likes = likesRepository.findByPostAndUser(post, user);
        likesRepository.delete(likes);
    }
}
