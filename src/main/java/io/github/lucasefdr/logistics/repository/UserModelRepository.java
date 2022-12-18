package io.github.lucasefdr.logistics.repository;

import io.github.lucasefdr.logistics.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
