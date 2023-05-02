package com.montexbjeliseo.jwtimpldemo.repository;

import com.montexbjeliseo.jwtimpldemo.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author montexbjeliseo
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
    boolean existsByUsername(String username);
    
    Optional<User> findByUsername(String username);
}
