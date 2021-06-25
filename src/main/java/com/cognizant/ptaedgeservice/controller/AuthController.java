package com.cognizant.ptaedgeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }
    @RequestMapping(value = "/needsRole", method = RequestMethod.GET)
    public String authRoleGet(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you have the PTA Member role";
    }

    @RequestMapping(value = "/needsRole", method = RequestMethod.POST)
    public String authRolePost(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you have the ADMIN role";
    }



}
