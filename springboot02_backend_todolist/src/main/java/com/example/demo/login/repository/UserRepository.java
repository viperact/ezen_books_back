package com.example.demo.login.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.login.dto.User;

@Repository
@Mapper
public interface UserRepository {
	//회원가입
	void saveUser(User user);
	
	//로그인
	User getUserAccount(String username);

}
