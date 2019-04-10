package com.zs.helpdesk3.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TICKET_KINDS")
public class TicketsKind {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false, name = "NAME")
    private String name;
    @Column(nullable = false, name = "TEXT")
    private String text;

    public TicketsKind() {
    }

    public TicketsKind(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
