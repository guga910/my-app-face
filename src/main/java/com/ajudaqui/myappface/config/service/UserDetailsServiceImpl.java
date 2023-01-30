package com.ajudaqui.myappface.config.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajudaqui.myappface.api.repository.UsersRepository;
import com.ajudaqui.myappface.model.Roles;
import com.ajudaqui.myappface.model.Users;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
//	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = usersRepository.findByName(username);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(username);
		}

		Set<GrantedAuthority> grantedAuthority = new HashSet<>();

		for (Roles role : user.get().getRoles()) {
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName().name()));
		}

		return new User(user.get().getName(), user.get().getPassword(), grantedAuthority);
	}

}
