package com.examen.Examen1.service;

import com.examen.Examen1.domain.Post;
import com.examen.Examen1.domain.Tag;
import com.examen.Examen1.repository.PostRepository;
import com.examen.Examen1.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {

        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findAll() {

        return postRepository.findAllByOrderByTimestampDesc();
    }

    @Transactional(readOnly = true)
    public List<Post> findByUser(String nickname) {

        return postRepository.findAllByUserNicknameOrderByTimestampDesc(nickname);
    }

    public List<Post> findLiked(int userId) {

        return postRepository.findPostsLiked(userId);
    }
}
