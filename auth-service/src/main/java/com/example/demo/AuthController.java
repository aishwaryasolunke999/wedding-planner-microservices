package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;
    
    @GetMapping("/test")
    public String test() {
        return "working";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        try {

            Optional<User> optionalUser =
                    repo.findByUsername(user.getUsername());

            System.out.println("Found User = " + optionalUser);

            if (optionalUser.isEmpty()) {
                return "User not found";
            }

            User dbUser = optionalUser.get();

            if (dbUser.getPassword().equals(user.getPassword())) {
                return jwtUtil.generateToken(user.getUsername());
            }

            return "Invalid password";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}