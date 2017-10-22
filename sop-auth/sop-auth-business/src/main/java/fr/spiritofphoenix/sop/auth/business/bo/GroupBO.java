package fr.spiritofphoenix.sop.auth.business.bo;

import java.io.Serializable;

/**
 * Group Business Object
 * @author Meidi
 *
 */
public class GroupBO implements Serializable {

	/**
	 * Object SUID
	 */
	private static final long serialVersionUID = -7145161201997427256L;

	/**
	 * Group unique ID
	 */
	private int id;

	/**
	 * Group name
	 */
	private String name;

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
	
}
