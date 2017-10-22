package fr.spiritofphoenix.sop.auth.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role
 * @author Meidi
 *
 */
@Entity
@Table(name = "TA_ROLES")
public class Role {

	/**
	 * Role ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ROLE", nullable = false, unique = true)
	private int id;
	
	/**
	 * Role name
	 */
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	/**
	 * Role groups
	 */
	@OneToMany(mappedBy = "role")
	private List<GroupAuthorization> authorizations = new ArrayList<GroupAuthorization>();

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
