package com.examen.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.examen.model.Role;
import com.examen.model.User;
import com.examen.repository.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userRepository.getByUserNameAndPassword(email, password);

		if (user == null) {
			throw new AuthenticationCredentialsNotFoundException("Nu e bune credentialele boss!");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		Role role = (Role)(user.getRoles().toArray()[0]);
		authorities.add(new SimpleGrantedAuthority(role.getName())); // description is a string

		return new UsernamePasswordAuthenticationToken(email, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}