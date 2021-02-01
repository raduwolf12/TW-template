package com.examen.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.examen.model.Role;
import com.examen.model.User;
import com.examen.repository.RoleRepository;
import com.examen.repository.UserRepository;

@Component
public class DatabasePopulator {

	@Lazy
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void populateDatabase() {
		if (this.roleRepository.count() == 0) {
		

		}
		if (this.userRepository.count() == 0) {

//			entityManager.getTransaction().begin();
			
			
//			Role admin = roleRepository.findById(1).get();
//			Role user =  roleRepository.findById(2).get();

//			entityManager.detach(admin);
//			entityManager.detach(user);
			Role admin = new Role();
			admin.setName("ADMIN");

			Role user = new Role();
			user.setName("USER");
			
			User adminUser = new User();
			adminUser.setUserName("admin");
			adminUser.setPassword("admin");
			adminUser.setTelefon("000000");
			Set<Role> roles = new HashSet<Role>();
			roles.add(admin);
			adminUser.setRoles(roles);
			
			userRepository.save(adminUser);
			roleRepository.save(admin);
			
//			entityManager.persist(adminUser);



			User userUser = new User();
			userUser.setUserName("user");
			userUser.setPassword("user");
			userUser.setTelefon("000000");
			Set<Role> roles1 = new HashSet<Role>();
			roles.add(user);
			userUser.setRoles(roles1);

			userRepository.save(userUser);
			roleRepository.save(user);

//			entityManager.persist(userUser);

//			entityManager.getTransaction().commit();
//			entityManager.close();
		}

//		if (this.userRepository.count() == 0) {
//			for (int counter = 0; counter < 10; counter++) {
//
//			}
//		}
	}

}
