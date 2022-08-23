package vn.edu.uit.group5redis.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.uit.group5redis.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById (UUID uuid);
}
