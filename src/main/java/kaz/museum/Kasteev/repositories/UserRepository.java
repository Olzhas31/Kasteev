package kaz.museum.Kasteev.repositories;

import kaz.museum.Kasteev.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    Optional<User> findByLogin(String login);

    boolean existsUserByLogin(String login);

}

