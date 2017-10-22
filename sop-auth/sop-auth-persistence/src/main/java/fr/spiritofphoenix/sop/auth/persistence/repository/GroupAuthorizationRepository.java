package fr.spiritofphoenix.sop.auth.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.spiritofphoenix.sop.auth.persistence.entity.GroupAuthorization;

/**
 * Group Authorization repository
 * @author Meidi
 *
 */
public interface GroupAuthorizationRepository extends JpaRepository<GroupAuthorization, Long>{

}
