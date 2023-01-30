package com.ajudaqui.myappface.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajudaqui.myappface.model.ERoles;
import com.ajudaqui.myappface.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

	Optional<Roles> findByName(ERoles rolesUsers);

}
