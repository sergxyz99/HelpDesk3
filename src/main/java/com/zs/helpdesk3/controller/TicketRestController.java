package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.GlobalVar;
import com.zs.helpdesk3.service.CommonService;
import com.zs.helpdesk3.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CommonService commonService;
    @Autowired
    GlobalVar globalVar;


    @RequestMapping(value = "/edit_r/{Id}", method = RequestMethod.POST)
    public void editTicket(@PathVariable("Id") Long Id, Model model) {
        System.out.println("TicketController: editTicket: "+Id.toString());
    }
}
