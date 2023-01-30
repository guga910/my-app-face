package com.ajudaqui.myappface.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   @Enumerated(EnumType.STRING)
		private ERoles name;
	   
//	    private String name;
	    
//	    @ManyToMany(mappedBy = "roles")
//	    private Set<Users> users;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ERoles getName() {
			return name;
		}

		public void setName(ERoles name) {
			this.name = name;
		}

//		public Set<Users> getUsers() {
//			return users;
//		}
//
//		public void setUsers(Set<Users> users) {
//			this.users = users;
//		}

	    
	    
}
