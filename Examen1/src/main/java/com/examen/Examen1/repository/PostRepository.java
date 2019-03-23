package com.examen.Examen1.repository;

import com.examen.Examen1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByTimestampDesc();

    List<Post> findAllByUserNicknameOrderByTimestampDesc(String nickname);

    @Query(value = "SELECT p.* FROM post AS p\n" +
            "INNER JOIN likes AS l ON p.id = l.post_id\n" +
            "INNER JOIN user as u ON l.user_id = u.id\n" +
            "WHERE u.id = :userId", nativeQuery = true)
    List<Post> findPostsLiked(int userId);
}
