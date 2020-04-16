package com.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(UserEntity user) {
		userRepository.save(user);
	}
	public String login(UserEntity user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		List<UserEntity> userList = userRepository.findByUserName(userName);
		if(userList==null || userList.size()==0)
		{
			return "{ \"result\": \"failed\", \"message\": \"Invalid user\" " + userName + "}";
		}
		else
		{
			UserEntity userEntity = userList.get(0);
			if(password.equals(userEntity.getPassword()))
			{
				String sessionId = new java.rmi.server.UID().toString().substring(0,10);
				userEntity.setSessionId(sessionId);
				userRepository.save(userEntity);
				return "{ \"result\": \"success\", \"message\": \"Login successful\", \"auth-token\":\"" + sessionId + "\"}";	
			}
			else
			{
				return "{ \"result\": \"failed\", \"message\": \"Invalid password\" }";
			}
		}
		
	}
	public UserEntity userInfo(long userId) {
		UserEntity userEntity = userRepository.findByUserId(Long.valueOf(userId)).get(0);
		return userEntity;
	}
	

	
	
}
