package com.jhsite.practice.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.jhsite.practice.domain.LoginDTO;
import com.jhsite.practice.domain.UserVO;
import com.jhsite.practice.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	private final UserService userService;
	
	@Inject
	public UserLoginController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
		return "/user/login";
	}
	
	//로그인 처리
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception{
		
		UserVO userVO = userService.login(loginDTO);
		
		if(userVO == null || !BCrypt.checkpw(loginDTO.getUserPw(), userVO.getUserPw())) {
			return;
		}
		
		model.addAttribute("user",userVO);
	}
}
