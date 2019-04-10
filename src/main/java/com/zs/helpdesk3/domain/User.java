package com.zs.helpdesk3.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    protected Long id;
    @NotBlank(message = "User may not be blank")
    private String username;
    @NotBlank(message = "1st Name may not be blank")
    @Column(nullable = false, name = "FNAME")
    private String firstName;
    @NotBlank(message = "2nd Name may not be blank")
    @Column(nullable = false, name = "SNAME")
    private String secondName;
    @NotBlank(message = "2nd Name may not be blank")
    @Column(nullable = false, name = "EMAIL")
    private String email;
    @Column(nullable = false, name = "REG_DATE")
    private LocalDate regDate= LocalDate.now();
    @NotBlank(message = "Password may not be blank")
    @Column(nullable = false)
    private String password;
//    @NotBlank(message = "Password confirmed may not be blank")
    @Transient
    private String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(@NotBlank(message = "1st Name may not be blank") String firstName,
                @NotBlank(message = "2nd Name may not be blank") String secondName) {
        this.username = firstName+"_"+secondName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = this.username+"@gmail.com";
        this.password = this.username+"pass";
        this.passwordConfirm = this.password;
    }

    public User() {
    }
}
