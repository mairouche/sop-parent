package fr.spiritofphoenix.sop.auth.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Authorization
 * @author Meidi
 *
 */
@Entity
@Table(name = "TA_GROUPS_AUTHORIZATIONS")
public class GroupAuthorization {

	/**
	 * Authorization unique ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GROUP_AUTHORIZATION", unique = true, nullable = false)
	private long id;

	/**
	 * Group
	 */
	@ManyToOne
	@JoinColumn(name = "ID_GROUP")
	private Group group;

	/**
	 * ROLE
	 */
	@ManyToOne
	@JoinColumn(name = "ID_ROLE")
	private Role role;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
