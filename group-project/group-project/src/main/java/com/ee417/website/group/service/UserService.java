package com.ee417.website.group.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ee417.website.group.entity.RoleEntity;
import com.ee417.website.group.entity.UserEntity;
import com.ee417.website.group.mapper.UserMapper;
import com.ee417.website.group.models.RoleName;
import com.ee417.website.group.models.User;
import com.ee417.website.group.repository.RoleEntityRepository;
import com.ee417.website.group.repository.UserEntityRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Service
public class UserService {
	@Autowired
	private final UserEntityRepository userRepository;	
	@Autowired
	private final RoleEntityRepository roleRepository;	
	@Autowired
	private final UserMapper userMapper;
	
    public UserService(UserEntityRepository userRepository, UserMapper mapper, RoleEntityRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = mapper;
        this.roleRepository = roleRepository;
    }
    
    // Returns list of users based on role name
    public List<User> listUsersByRole(RoleName roleName) {
        List<UserEntity> entitiesByRolesName = userRepository.findUsersByRoleName(roleName);
        return userMapper.mapList(entitiesByRolesName);
    }
	
	// Returns list of users saved in the db
	public List<User> listUsers(){
		List<UserEntity> all = userRepository.findAll();
		return userMapper.mapList(all);
	}
	
	private boolean usernameExists(String username) {
        return userRepository.findUserByUsername(username).isPresent();
    }
	
    public User addUser(@Valid @NotNull User user) {
    	// checks for existing username
        if (usernameExists(user.getUsername())) {
            throw new DataIntegrityViolationException("Username already exists");
        }
        UserEntity userEntity = userMapper.toEntity(user); // converts to entity for db

        // Fetch the GUEST role from the database
        RoleEntity guestRole = roleRepository.findRoleByName(RoleName.GUEST)
        		.orElseThrow(() -> new RuntimeException("GUEST role not found")); // Handle the case where the role is not found

        userEntity.setRole(guestRole); // Set the single role directly        
//        userEntity.setPassword(encoder.encode(user.getPassword())); // encodes incoming user's password
        UserEntity savedEntity = userRepository.save(userEntity); // Save the UserEntity
 
        return userMapper.entityToDto(savedEntity); // Map back to User model
    }

}
