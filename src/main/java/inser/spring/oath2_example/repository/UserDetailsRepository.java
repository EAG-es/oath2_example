package inser.spring.oath2_example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import inser.spring.oath2_example.entity.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String name);

    boolean existsByUsername(String name);

}
