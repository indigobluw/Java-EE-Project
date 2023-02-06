package com.indigobluw.project.security;

import com.indigobluw.project.user.UserModel;
import com.indigobluw.project.user.UserModelRepository;

import com.indigobluw.project.user.authorities.UserRoles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//När vi vill visa html filer använd controller. Rest controller returnerar json format
@Controller
public class TestController {

    private final UserModelRepository userModelRepository;
    private final AppPasswordConfig appPasswordConfig;

    @Autowired
    public TestController(UserModelRepository userModelRepository, AppPasswordConfig appPasswordConfig) {
        this.userModelRepository = userModelRepository;
        this.appPasswordConfig = appPasswordConfig;
    }

    @GetMapping("/register")
    public String displayRegisterUser(UserModel userModel) {
        return "register"; //register.html
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserModel userModel, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        String role = String.valueOf(userModel.getAuthorities().iterator().next());

        switch (role) {
            case "Admin" -> userModel.setAuthorities(UserRoles.ADMIN.getGrantedAuthorities());
            case "User" -> userModel.setAuthorities(UserRoles.USER.getGrantedAuthorities());
        }

        userModel.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(userModel.getPassword()));
        userModel.setAccountNonExpired(true);
        userModel.setAccountNonLocked(true);
        userModel.setCredentialsNonExpired(true);
        userModel.setEnabled(true);
        userModelRepository.save(userModel); //om allt gått bra spara användare
        //model.addAttribute("user", userModel); visa upp användare #10 1:13:18
        return "home"; //när man skapat inloggning ska man bli redirected till homepage
    }
}
