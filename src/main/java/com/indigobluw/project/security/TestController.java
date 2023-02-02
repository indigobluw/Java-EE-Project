package com.indigobluw.project.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") //krille skriver "rest" ist för test
public class TestController {
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
}
