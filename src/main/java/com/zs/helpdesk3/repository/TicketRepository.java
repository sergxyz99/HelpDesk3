package com.zs.helpdesk3.repository;

import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByAuthor(User author);

    Ticket findById(long Id);

    void deleteById(long id);

    List<Ticket> findByAuthorAndDateCreatedBetween(User author, LocalDate date1, LocalDate date2);
}
