package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.domain.TicketsKind;
import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.service.SecurityService;
import com.zs.helpdesk3.service.UserService;
import com.zs.helpdesk3.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("heading", "Create an account:");
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("heading", "Please correct account data:");
            return "registration";
        }

        boolean newUser = userForm.getId() == null;
        userService.save(userForm);
        if (newUser) {
            securityService.autologin(request, userForm.getUsername(), userForm.getPasswordConfirm());
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/editProfile1", method = RequestMethod.POST)

    public String editProfile(@RequestParam(value = "id") Long Id, Model model) {

        Optional<User> user = userService.findById(Id);
        if (user.isPresent()) {
            User profileEdited = user.get();
            model.addAttribute("userForm", profileEdited);
            return "registration";
        }
        return null;
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.PUT)
    public String editProfile(@RequestParam(value = "name") String userName, Model model) {

        Optional<User> user = Optional.ofNullable(userService.findByUsername(userName));
        if (user.isPresent()) {
            User profileEdited = user.get();
            profileEdited.setPassword(null);
            model.addAttribute("userForm", profileEdited);
            model.addAttribute("heading", "Edit profile data:");
            return "registration";
        }
        return null;
    }

}
