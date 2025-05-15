package com.petmart.petmart.reposistory;

import com.petmart.petmart.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReposistory extends JpaRepository<Users, Integer> {
    List<Users> findByUsernameAndPassword(String username, String password);
}
