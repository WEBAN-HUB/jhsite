package com.jhsite.practice.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhsite.practice.domain.LoginDTO;
import com.jhsite.practice.domain.UserVO;
import com.jhsite.practice.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Inject
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//회원 가입 처리
	@Override
	public void register(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDAO.register(userVO);
	}

	//로그인 처리
	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception{
		return userDAO.login(loginDTO);
	}
}
