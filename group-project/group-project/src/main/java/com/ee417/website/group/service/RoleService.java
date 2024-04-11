package com.ee417.website.group.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ee417.website.group.mapper.RoleMapper;
import com.ee417.website.group.models.Role;
import com.ee417.website.group.repository.RoleEntityRepository;

// Copying example from lectures
@Service
public class RoleService {
    private final RoleEntityRepository roleEntityRepository;
    private final RoleMapper mapper;

    public RoleService(RoleEntityRepository roleEntityRepository, RoleMapper mapper) {
        this.roleEntityRepository = roleEntityRepository;
        this.mapper = mapper;
    }
    
    // Returns a list of roles
    public List<Role> listRoles(){
        return mapper.mapList(roleEntityRepository.findAll());
    }
}