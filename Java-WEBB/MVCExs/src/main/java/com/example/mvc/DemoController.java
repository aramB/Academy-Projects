package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/ok1")
	public ModelAndView helloo(){
		ModelAndView modelAndView = new ModelAndView("helloo");
		return modelAndView.addObject("name", "Aram");
	}

	@GetMapping("/ok")
	public ModelAndView hello(@RequestParam (/*name = "param", */required = false, defaultValue = "Human") String name){
		ModelAndView modelAndView = new ModelAndView("helloo");
		return modelAndView.addObject("name", name);
	}
}
