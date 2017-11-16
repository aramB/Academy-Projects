package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Cookies
{
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam String username,
						String password){
		if (username.equals("academy") && password.equals("123")){
			session.setAttribute("username", username);
			return "redirect:secret";
		}
		return "Login";
	}

	@GetMapping("/login")
	public ModelAndView start(){
		return new ModelAndView("Login");
	}

	@GetMapping("/secret")
	public String secret(HttpSession session){
		if (session.getAttribute("username") != null){
			return "Secret";
		}
		return "redirect:login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletResponse res, HttpSession session){
		session.invalidate();
		Cookie cookie = new Cookie("JSESSIONID", null);
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		return "redirect:login";
	}
}
