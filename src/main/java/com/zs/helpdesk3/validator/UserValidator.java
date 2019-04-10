package com.zs.helpdesk3.validator;

import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//import sec_auth.model.User;
//import sec_auth.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username","The size of username must be from 6 to 32 symbols");

        }
        if (user.getId() == null) {
            if (userService.findByUsername(user.getUsername()) != null) {
                errors.rejectValue("username", "Duplicate.userForm.username");
            }
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password","zzz");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm","sss");
        }
    }
}
