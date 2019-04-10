package com.zs.helpdesk3;

import com.zs.helpdesk3.domain.TicketsKind;
import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.repository.TicketsKindRepository;
import com.zs.helpdesk3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class Initializer implements CommandLineRunner {
@Autowired
    private final TicketsKindRepository ticketsKindRepository;

    Initializer(TicketsKindRepository ticketsKindRepository) {
        this.ticketsKindRepository = ticketsKindRepository;
    }
    @Autowired
    private UserService userService;
    @Override
    public void run(String... strings) {
        List<TicketsKind> ticketsKindList = new ArrayList<>();
        ticketsKindList.add(new TicketsKind("Request Type 1","Request Type 1 text"));
        ticketsKindList.add(new TicketsKind("Request Type 2","Request Type 2 text"));
        ticketsKindList.add(new TicketsKind("Request Type 3","Request Type 3 text"));
        ticketsKindList.add(new TicketsKind("Request Type 4","Request Type 4 text"));
        ticketsKindRepository.saveAll(ticketsKindList);

}}

