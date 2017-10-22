package fr.spiritofphoenix.sop.auth.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.spiritofphoenix.sop.auth.persistence.entity.Role;

/**
 * Role repository
 * @author Meidi
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
