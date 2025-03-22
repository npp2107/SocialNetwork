package npp.socialnetwork.profileserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Swagger!";
    }
}