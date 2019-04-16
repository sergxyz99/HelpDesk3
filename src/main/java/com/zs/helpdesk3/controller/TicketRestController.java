package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.GlobalVar;
import com.zs.helpdesk3.domain.Ticket;
import com.zs.helpdesk3.service.CommonService;
import com.zs.helpdesk3.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CommonService commonService;
    @Autowired
    GlobalVar globalVar;

    @RequestMapping(value = "/ticket/{Id}", method = RequestMethod.GET)
    public Ticket getTicketById(@PathVariable("Id") Long Id, Model model) {
        System.out.println(this);
        return this.ticketService.findById(Id);
    }
}
