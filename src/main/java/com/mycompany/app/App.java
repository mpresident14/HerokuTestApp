package com.mycompany.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

    // @GetMapping short for @RequestMapping(method = { RequestMethod.GET })
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
}
