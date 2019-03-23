package com.examen.Examen1.service;

import com.examen.Examen1.domain.User;
import com.examen.Examen1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findAllByNickname(String nickname) {
        return userRepository.findAllByNickname(nickname);
    }
}
