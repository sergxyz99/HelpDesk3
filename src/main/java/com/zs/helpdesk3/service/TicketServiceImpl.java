package com.zs.helpdesk3.service;


import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    List<Ticket> ticketsList = new ArrayList<>();

    @Override
    public List<Ticket> getAllTickets() {
        ticketsList = (List<Ticket>) ticketRepository.findAll();
        return ticketsList;
    }

    @Override
    public List<Ticket> findByAuthor(User author) {
        ticketsList = (List<Ticket>) ticketRepository.findByAuthor(author);
        return ticketsList;
    }

    @Override
    public Ticket findById(Long Id) {
        Ticket ticket = ticketRepository.findById(Id.longValue());
        return ticket;
    }

    @Override
    public void deleteById(Long Id) {
        ticketRepository.deleteById(Id.longValue());
    }

    @Override
    public List<Ticket> findByAuthorAndDateCreatedBetween(User author, LocalDate date1, LocalDate date2) {
        List<Ticket> ticketsList = ticketRepository.findByAuthorAndDateCreatedBetween(author, date1, date2);

        for (Ticket t : ticketsList
        ) {
            System.out.println(t.getName());
        }

        return ticketsList;
    }

}
