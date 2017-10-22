package fr.spiritofphoenix.sop.auth.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.spiritofphoenix.sop.auth.persistence.entity.User;

/**
 * User repository
 * @author Meidi
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * Find a User by email
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

}
