package com.ajudaqui.myappface.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajudaqui.myappface.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
