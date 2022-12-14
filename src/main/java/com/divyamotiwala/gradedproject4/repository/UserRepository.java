package com.divyamotiwala.gradedproject4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyamotiwala.gradedproject4.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String userName);
	List<User> findAllByOrderByUserNameAsc();
	List<User> findAllByOrderByUserNameDesc();
}
