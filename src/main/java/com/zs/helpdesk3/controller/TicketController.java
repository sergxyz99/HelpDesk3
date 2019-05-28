package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.GlobalVar;
import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.domain.TicketsKind;
import com.zs.helpdesk3.service.CommonService;
import com.zs.helpdesk3.service.SecurityService;
import com.zs.helpdesk3.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/ticket")
public class TicketController {
    private LocalDate dateCreatedEditedTicket;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private TicketService ticketService;
    @Autowired
    private CommonService commonService;
//    @Autowired
//    GlobalVar globalVar;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newTicket(Model model) {
        Ticket ticket = new Ticket();
        fillTicketsData(model, "Fill data for the new ticket");
        model.addAttribute("ticketAttr", ticket);
        return "ticket";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processNewTicket(@ModelAttribute("ticketAttr") Ticket ticketAttr, BindingResult bindingResult, Model model) {
        ticketAttr.setAuthor(securityService.getCurrentUser());
        if (ticketAttr.getId() != null) {
            ticketAttr.setDateCreated(dateCreatedEditedTicket);
        }

        ticketService.save(ticketAttr);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTicket(@RequestParam(value = "id") Long Id, Model model) {
        ticketService.deleteById(Id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editTicket(@RequestParam(value = "id") Long Id, Model model) {
        Ticket ticket = ticketService.findById(Id);
        fillTicketsData(model, "Edit data for this ticket");
        dateCreatedEditedTicket = ticket.getDateCreated();
        model.addAttribute("ticketAttr", ticket);
        return "ticket";
    }

    private Model fillTicketsData(Model model, String heading){
        List<TicketsKind> ticketsKindList = commonService.getAllTicketsKinds();
        model.addAttribute("kindList", ticketsKindList);
        model.addAttribute("priorityList", new ArrayList<>(Arrays.asList(Ticket.Priority.values())));
        model.addAttribute("heading", heading);
        return model;
    }

}


