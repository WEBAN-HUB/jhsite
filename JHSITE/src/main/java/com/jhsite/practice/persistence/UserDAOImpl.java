package com.jhsite.practice.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhsite.practice.domain.LoginDTO;
import com.jhsite.practice.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String NAMESPACE = "com.jhsite.practice.mappers.user.UserMapper";

	private final SqlSession sqlSession;
	
	@Inject
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 회원가입처리
	@Override
	public void register(UserVO userVO) throws Exception {
		sqlSession.insert(NAMESPACE+".register", userVO);
	};

	//로그인 처리
	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".login",loginDTO);
	}
}
