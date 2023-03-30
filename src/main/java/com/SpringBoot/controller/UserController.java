package com.SpringBoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoot.model.User;
import com.SpringBoot.service.userService;
import com.SpringBoot.service.userServiceImpl;

@Controller
public class UserController {

	@Autowired
	private User user;

	HttpSession session;

	@Autowired
	private userService ServiceObject;

	@GetMapping(value = { "/", "index" })
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {

		model.addAttribute("userData", new User());
		return "registerdemo";
	}

	@PostMapping("/SaveUser")
	public String insertNewUser(@ModelAttribute("user") User userObject, HttpServletRequest request) {

		session = request.getSession();
		User user = (User) session.getAttribute("SessionData");
		//System.out.println("user Object" + userObject);

		if(userObject.getImageBase64().length() == 0) {
			String imageBase64= (String) session.getAttribute("sessionImage");
			session.removeAttribute("sessionImage");
			userObject.setImageBase64(imageBase64);
		}
		ServiceObject.saveUser(userObject);
		if(user != null) {
			if(user.getId() == userObject.getId()) {
				user.setEmail(userObject.getEmail());
			}	
		}
		if(user != null) {
			if(user.getStatus() == 0) {
				return "redirect:/ViewProfile?viewProfile="+userObject.getEmail();
			}else{
				return "redirect:/ViewEmployee";
			}
		} if(user == null) {
			return "redirect:/";		
		}
		return "redirect:/";
	}
	@RequestMapping("/Logout")
	public String logout(HttpServletRequest request) {

		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";		
	}
	
	@RequestMapping("/admin_index")
	public String adminIndex(Model model) {
		model.addAttribute("userObj", new User());
		return "admin_index";
	}
	
	@RequestMapping(value = "/LoginController")
	public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {

		if (ServiceObject.userCheck(email, password)) {
			session = request.getSession();

			User sessionUser = ServiceObject.userGet(email);
			System.out.println(" session Data print : " + sessionUser);

			session.setAttribute("SessionData", sessionUser);
			if (sessionUser.getStatus() == 0) {
				return "redirect:ViewProfile?viewProfile="+email;
			} else {
				return "redirect:/admin_index";
			}
		} else {
			model.addAttribute("loginError", "Please enter Valid credentials.");
			return "index";
		}
	}
	
	@RequestMapping("/DeleteEmployee")
	public String delteEmployee(@RequestParam("id") int id) {
		System.out.println("deelte id"+id);
		ServiceObject.deleteById(id);
		return "ViewEmployee";
	}
	@GetMapping("/ViewProfile")
	public String viewProfile(@RequestParam("viewProfile") String email,Model model) {
		model.addAttribute("sessionUser",ServiceObject.userGet(email));
		return "viewProfile";
	}

	@GetMapping("/ViewEmployee")
	public String viewEmployee(Model model) {
		List<User> userDataList = ServiceObject.getAllEmployee();
		model.addAttribute("userDataList", userDataList);
		return "ViewEmployee";
	}
	@GetMapping("/EditProfile")
	public String editProfile(@RequestParam("email") String email,Model model,HttpServletRequest request) {
		user = ServiceObject.userGet(email);
		session=request.getSession();
		session.setAttribute("sessionImage", user.getImageBase64());
		model.addAttribute("userData", user);
		return "registerdemo";
	}

}
