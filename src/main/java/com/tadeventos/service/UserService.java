package com.tadeventos.service;

import com.tadeventos.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
