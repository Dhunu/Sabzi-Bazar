package com.masai.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class User {
	
	private Integer userId;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	

}
