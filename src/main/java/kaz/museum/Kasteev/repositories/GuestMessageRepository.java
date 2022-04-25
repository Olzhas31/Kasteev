package kaz.museum.Kasteev.repositories;

import kaz.museum.Kasteev.domains.GuestMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestMessageRepository extends JpaRepository<GuestMessage, Long> {
}
