package com.test.part2.services;

import com.test.part2.persistence.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
