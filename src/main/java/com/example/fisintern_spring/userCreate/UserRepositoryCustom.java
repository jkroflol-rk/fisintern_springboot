package com.example.fisintern_spring.userCreate;

import java.util.List;
import java.util.Set;

public interface UserRepositoryCustom {
    List<User> findUserByEmails(Set<String> emails);
}
