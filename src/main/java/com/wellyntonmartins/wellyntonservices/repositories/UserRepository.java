package com.wellyntonmartins.wellyntonservices.repositories;

import com.wellyntonmartins.wellyntonservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
