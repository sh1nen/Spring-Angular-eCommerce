package com.bookstore.controllers;

import com.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/token")
    public Map<String,String> token(HttpSession httpSession, HttpServletRequest request) {
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        System.out.println(remoteHost + " : " + portNumber);
        System.out.println(request.getRemoteAddr());
        return Collections.singletonMap("token", httpSession.getId());
    }

    @RequestMapping("/checkSession")
    public ResponseEntity checkSession() {
        return new ResponseEntity("Session Active !", HttpStatus.OK);
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public ResponseEntity logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Logout invoked !", HttpStatus.OK);
    }
}
