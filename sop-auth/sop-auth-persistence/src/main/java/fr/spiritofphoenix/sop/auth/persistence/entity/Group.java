package fr.spiritofphoenix.sop.auth.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Group
 * @author Meidi
 *
 */
@Entity
@Table(name = "TA_GROUPS")
public class Group {

	/**
	 * Group unique ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GROUP")
	private int id;

	/**
	 * Group name
	 */
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	/**
	 * Group users
	 */
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<User>();

	/**
	 * Group roles
	 */
	@OneToMany(mappedBy = "group")
	private List<GroupAuthorization> authorizations = new ArrayList<GroupAuthorization>();

	/**
	 * Implicit constructor
	 */
	public Group() {};

	/**
	 * Explicit constructor
	 * @param id
	 */
	public Group(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the authorizations
	 */
	public List<GroupAuthorization> getAuthorizations() {
		return authorizations;
	}

	/**
	 * @param authorizations the authorizations to set
	 */
	public void setAuthorizations(List<GroupAuthorization> authorizations) {
		this.authorizations = authorizations;
	}

}