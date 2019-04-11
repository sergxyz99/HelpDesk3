package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.service.SecurityService;
import com.zs.helpdesk3.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    SecurityService securityService;

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomeWithDates(@RequestParam(value = "startdate", required = false) String startDateString,
                                   @RequestParam(value = "enddate", required = false) String endDateString, Model model) {

        List<Ticket> ticketsList = new ArrayList<>();
        if (null != startDateString) {
            ticketsList = this.ticketService.findByAuthorAndDateCreatedBetween(securityService.getCurrentUser(), LocalDate.parse(startDateString, dateTimeFormatter),
                    LocalDate.parse(endDateString, dateTimeFormatter));
        } else {
            ticketsList = this.ticketService.findByAuthor(securityService.getCurrentUser());
        }
        model.addAttribute("tickets", ticketsList);
        return "welcome";
    }
}
