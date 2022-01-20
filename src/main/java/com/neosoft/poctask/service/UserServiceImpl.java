package com.neosoft.poctask.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.poctask.model.Role;
import com.neosoft.poctask.model.User;
import com.neosoft.poctask.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserServiceI {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
	
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
		
	}
	
	public User SaveUser(User u)
	{
		User newUser = new User();
		
		
	    newUser.setUsername(u.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(u.getPassword()));
	    newUser.setRoles(null);
	    
		
        return userDao.save(newUser);
	}
	}


