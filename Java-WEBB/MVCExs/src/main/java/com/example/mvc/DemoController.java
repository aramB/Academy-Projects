package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController
{
	@GetMapping("/")
	public ModelAndView hellooo(){
		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}

	@GetMapping("/ok")
	public ModelAndView helloo(){
		ModelAndView modelAndView = new ModelAndView("helloo");
		return modelAndView.addObject("name", "Aram");
	}

	@GetMapping("/hello3")
	public ModelAndView hello(@RequestParam (/*name = "param", */required = false, defaultValue = "Human") String name){
		ModelAndView modelAndView = new ModelAndView("helloo");
		return modelAndView.addObject("name", name);
	}

	@GetMapping("/hello4/{name}")
	public ModelAndView hello4(@PathVariable String name){
		ModelAndView modelAndView = new ModelAndView("helloo");
		return modelAndView.addObject("name", name);
	}

	@GetMapping("/hello5/{name}")
	public ModelAndView hello5(@PathVariable String name){
		ModelAndView modelAndView = new ModelAndView("hello5");
		User user = new User();
		user.setUsername(name);
		return modelAndView.addObject("user", user);
	}
}
