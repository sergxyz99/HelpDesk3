package com.zs.helpdesk3.service;


import com.zs.helpdesk3.domain.TicketsKind;
import com.zs.helpdesk3.repository.TicketsKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService{
    @Autowired
    private TicketsKindRepository ticketsKindRepository;

    public List<TicketsKind> getAllTicketsKinds() {
        Map<String, String> countryMap = new HashMap<>();
        List<TicketsKind> ticketsKindList=new ArrayList<>();
        ticketsKindList= (List<TicketsKind>) ticketsKindRepository.findAll();
        return ticketsKindList;
    }
}
