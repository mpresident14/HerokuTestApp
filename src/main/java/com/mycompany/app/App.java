package com.mycompany.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

import com.mycompany.login.LoginController;
import com.mycompany.login.LoginController.LoginResult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */

// @RestController simply returns the object and object data is directly written into HTTP response as JSON or XML.
// Equivalent to @Controller + @ResponseBody 
// @Controller gets the html page.
@Controller
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // @GetMapping is short for @RequestMapping(method = { RequestMethod.GET })
    // @ResponseBody indicates a method return value should be bound to the web response body i.e.
    // no view resolver is needed.
    @ResponseBody
    @GetMapping("/hello")
    String hello() {
        return "Hello, World!";
    }

    @GetMapping("/")
    String index() {
        return login();
    }
    
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login/user")
    ResponseEntity<LoginResult> loginUser(@RequestBody LoginController controller) {
        System.out.println("!RECEIVED!");
        return new ResponseEntity<>(controller.validateCredentials(), HttpStatus.OK);
    }
}
