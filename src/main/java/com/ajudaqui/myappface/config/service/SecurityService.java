package com.ajudaqui.myappface.config.service;

public interface SecurityService {
	 String findLoggedInUsername();

	    void autoLogin(String name, String password);

}
