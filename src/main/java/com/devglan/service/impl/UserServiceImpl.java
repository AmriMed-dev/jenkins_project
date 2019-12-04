package com.devglan.service.impl;

import com.devglan.dao.UserDao;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			
			System.out.println("404 Error");
			throw new UsernameNotFoundException("Invalid username or password.");
			
		}
		System.out.println("200 Success");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
		
	}
	
	

	public boolean authentificate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("1234"))){
            System.out.println("bien s'authentifie");
            return true;
        }
        if((userName.equals("admin")) && (!userPassword.equals("1234"))){
            System.out.println("Invalid password");
            return false;
        }
        if((!userName.equals("admin")) && (userPassword.equals("1234"))){
            System.out.println("Invalid username");
            return false;
        }
        else{
          
            System.out.println("Invalid username or password");
        	return false;
        	//jacoco kuvritch
        }
	
       
    }

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	
//	private Collection getAuthority(User user) {
//		Collection authorities = new HashSet<>();
//		user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//		});
//		return authorities;
//	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public UserDto update(UserDto userDto) {
        User user = findById(userDto.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password", "username");
            userDao.save(user);
        }
        return userDto;
    }

    @Override
    public User save(UserDto user) {
	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
        return userDao.save(newUser);
    }
}
