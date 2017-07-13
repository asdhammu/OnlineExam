package edu.UTDallas.service;

public interface SecurityService {
	
    public String findLoggedInUsername();

    public void autologin(String username, String password);
}
