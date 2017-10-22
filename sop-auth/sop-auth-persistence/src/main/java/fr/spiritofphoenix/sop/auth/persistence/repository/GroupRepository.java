package fr.spiritofphoenix.sop.auth.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.spiritofphoenix.sop.auth.persistence.entity.Group;

/**
 * Group repository
 * @author Meidi
 *
 */
public interface GroupRepository extends JpaRepository<Group, Integer>{

}
