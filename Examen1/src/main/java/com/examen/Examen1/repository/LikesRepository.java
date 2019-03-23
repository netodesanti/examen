package com.examen.Examen1.repository;

import com.examen.Examen1.domain.Likes;
import com.examen.Examen1.domain.Post;
import com.examen.Examen1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Likes findByPostAndUser(Post post, User user);
}
