package com.zs.helpdesk3.service;


import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
    void save(Ticket ticket);

    List<Ticket> getAllTickets();

    List<Ticket> findByAuthor(User author);
    Ticket findById(Long Id);
    void deleteById(Long Id);
    List<Ticket> findByAuthorAndDateCreatedBetween(User author, LocalDate date1, LocalDate date2);

}
