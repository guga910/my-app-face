package com.ajudaqui.myappface.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String password;
	private LocalDate creatdAt;
	    @ManyToMany
	    private Set<Roles> roles;
	    
	    public Users() {
			// TODO Auto-generated constructor stub
		}
	    
		public Users(String name, String password) {
			super();
			this.name = name;
			this.password = password;
			this.creatdAt= LocalDate.now();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String username) {
			this.name = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Set<Roles> getRoles() {
			return roles;
		}
		public void setRoles(Set<Roles> roles) {
			this.roles = roles;
		}

		public LocalDate getCreatdAt() {
			return creatdAt;
		}

		public void setCreatdAt(LocalDate creatdAt) {
			this.creatdAt = creatdAt;
		}
	    
	    

}
