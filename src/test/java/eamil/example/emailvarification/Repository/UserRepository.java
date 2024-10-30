package eamil.example.emailvarification.Repository;

import eamil.example.emailvarification.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {
    Optional<UserEntity> findByEmail(String email);
}
