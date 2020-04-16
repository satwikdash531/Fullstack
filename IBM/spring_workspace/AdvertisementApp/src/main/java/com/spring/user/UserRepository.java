package com.spring.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
	List<UserEntity> findByUserName(String userName);
	List<UserEntity> findByUserId(long userId);
}
