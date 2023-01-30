package com.ajudaqui.myappface.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajudaqui.myappface.api.repository.RolesRepository;
import com.ajudaqui.myappface.api.repository.UsersRepository;
import com.ajudaqui.myappface.config.service.SecurityServiceImpl;
import com.ajudaqui.myappface.model.ERoles;
import com.ajudaqui.myappface.model.Roles;
import com.ajudaqui.myappface.model.Users;
import com.ajudaqui.myappface.service.exception.MessageException;
import com.ajudaqui.myappface.service.request.Login;
import com.ajudaqui.myappface.service.request.UsersCreated;

@Service
public class UsersService {

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	public Users registered(UsersCreated usersCreated) {

		Optional<Users> checkRegistration = usersRepository.findByName(usersCreated.getName());
		if (checkRegistration.isPresent()) {
			throw new MessageException("Usuairo ja cadastrado.");
		}

		String passwordEncoder = encoder.encode(usersCreated.getPassword());
		
		System.err.println(assign_role().size());
		assign_role().forEach(r->{
			System.err.println(r.getName());
		});
		
		Users user = new Users(usersCreated.getName(), passwordEncoder);
		user.setRoles(assign_role());

		Users userSaved = usersRepository.save(user);
		return userSaved;

	}

	public Users findByName(String name) {
		Optional<Users> user = usersRepository.findByName(name);
		if (!user.isPresent()) {
			throw new MessageException("Usuairo não encontrado.");
		}
		return user.get();
	}

	public void login(Login login) {

		securityServiceImpl.autoLogin(login.getName(), login.getPassword());

	}

	// Função para atribuir o papel para um novo usuário cadastrado
	public Set<Roles> assign_role() {

		Set<Roles> roles = new HashSet<>();

		Roles user_role = rolesRepository.findByName(ERoles.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Erro: Type Roles não encontrado."));

		roles.add(user_role);

		return roles;
	}

}
