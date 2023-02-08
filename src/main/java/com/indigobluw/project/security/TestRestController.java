package com.indigobluw.project.security;

import com.indigobluw.project.user.UserModel;
import com.indigobluw.project.user.UserModelRepository;
import com.indigobluw.project.user.UserModelService;
import com.indigobluw.project.user.authorities.UserRoles;
import com.indigobluw.project.user.dataObjects.UserModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//kristoffer skriver "rest" ist för test.

public class TestRestController {

    private final AppPasswordConfig bcrypt;
    private final UserModelService userModelService;
    private final UserModelRepository userModelRepository; //- används endast med saveBenny

    @Autowired
    public TestRestController(AppPasswordConfig bcrypt, UserModelService userModelService,
                              UserModelRepository userModelRepository) { //kallar på AppPassConfig, lägger till constructor och autowired
        this.bcrypt = bcrypt;
        this.userModelService = userModelService;
        this.userModelRepository = userModelRepository; //- används endast med saveBenny
    }

    @GetMapping("/saveBenny")
    public UserModel saveUserBenny() {

        UserModel benny = new UserModel(
                "Benny",
                bcrypt.bCryptPasswordEncoder().encode("123456"),
                UserRoles.ADMIN.getGrantedAuthorities(),
                true,
                true,
                true,
                true
        );

        System.out.println(benny);

        return userModelRepository.save(benny); //return newResponseEntity<>(benny, Httpstatus.OK); står det i sliden lektion 9 slide 27
    }

    @PostMapping("/")

    @GetMapping("/password")
    public String testPassword() {
        System.out.println(bcrypt.bCryptPasswordEncoder().encode("123456"));
        return "";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String testAdminPermission() {
        return "Only admins can enter";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String testUserPermission() {
        return "Only users can enter";
    }

    @GetMapping("/unknown")
    @PreAuthorize("hasRole('ROLE_ADMIN') " + " && " +
            "hasAuthority('USER:READ') ")
    public String testUnknownPermission() {
        return "This should never work";
    }

    @GetMapping("/encode")
    public String testEncoding() {
        return bcrypt.bCryptPasswordEncoder().encode("password"); //lol
    }

    /*@GetMapping("/find/{username}")
    public UserModel findByUsername(@PathVariable String username) {

        System.out.println(userModelService.loadUserByUsername(username));

        return new UserModel(); //userModelService.loadUserByUsername(username) tog new UserModel bara för att få bort error
    }*/

    @GetMapping("/find/{username}")
    public UserModelDTO findByUsername(@PathVariable String username) {
        return new UserModelDTO(userModelService.loadUserByUsername(username));
    }

}
