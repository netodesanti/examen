package com.examen.Examen1.repository;

import com.examen.Examen1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findAllByNickname(String nickname);
}
