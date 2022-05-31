package kaz.museum.Kasteev.repositories;

import kaz.museum.Kasteev.domains.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByDate(String date);
}
