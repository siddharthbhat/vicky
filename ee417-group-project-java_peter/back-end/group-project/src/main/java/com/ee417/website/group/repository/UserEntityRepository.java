package com.ee417.website.group.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ee417.website.group.entity.UserEntity;
import com.ee417.website.group.models.RoleName;

/**
 * @author Peter Staunton
 * @date 07/04/24
 * @category repository
 * Provides interface for accesing user entities in the db
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUsersByRoleName(RoleName name); // lists all users in db based on role
    Optional<UserEntity> findUserByEmail(String email); // finds user in db based on email address
    Optional<UserEntity> findUserById(Long id); // finds user in db based on user id
    Optional<UserEntity> findUserByUsername(String name); 
}