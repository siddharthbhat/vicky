package com.ee417.website.group.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ee417.website.group.entity.RoleEntity;
import com.ee417.website.group.models.RoleName;

/**
 * @author Peter Staunton
 * @date 07/04/24
 * @category repository
 * Provides interface for accesing user role entities in the db
 */
@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
	Optional<RoleEntity> findRoleByName(RoleName roleName);
}
