package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examen.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(nativeQuery = true, value = "select * from users where users.user_name = ? and users.password = ?")
	User getByUserNameAndPassword(String name,String password);
//	@Query("SELECT u FROM User u WHERE u.username = :username")
//    public User getUserByUsername(@Param("username") String username);
}
