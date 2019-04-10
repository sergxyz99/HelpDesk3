package com.zs.helpdesk3.domain;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TICKETS")

public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, name = "DATE_CREATED")
    private LocalDate dateCreated;
    @Column(nullable = false, name = "NAME")
    private String name;
    @Column(nullable = false, name = "TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TICKET_KIND")
    private TicketsKind ticketsKind;

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

/*    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }*/

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


    public Ticket() {
        this.setDateCreated(LocalDate.now());
        this.setStatus(Status.CREATED);
        this.setPriority(Priority.MEDIUM);
    }

    public static enum Status {
        CREATED("CR"),
        ASSIGNED("AS"),
        ACTIVE("AC"),
        CLOSED("CL");

        private final String name;

        Status(String name) {
            this.name = name;
        }
    }

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Status status;
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Priority priority;

    public static enum Priority {
        HIGH,
        MEDIUM,
        LOW;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TicketsKind getTicketsKind() {
        return ticketsKind;
    }

    public void setTicketsKind(TicketsKind ticketsKind) {
        this.ticketsKind = ticketsKind;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
