package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String demo() {
	    return "Hello World!";
    }

    @GetMapping("/customer")
    public Customer customerObject(){
	    Customer customer = new Customer(23, "Aram", "Hemma",
                58333, "Linköping", "aaaa@yahoo.com");
	    return customer;
    }

    @GetMapping("/user")
    public String hello(@RequestParam String name, @RequestParam String upcase){
        if (upcase.toLowerCase().equals("y")){
            return "Hello " + name.toUpperCase();
        }
        return "Hello " + name.toLowerCase();
    }

    @GetMapping("/st3")
    public String task3(@RequestParam int a){
        return "Du skrev " + a;
    }
}
