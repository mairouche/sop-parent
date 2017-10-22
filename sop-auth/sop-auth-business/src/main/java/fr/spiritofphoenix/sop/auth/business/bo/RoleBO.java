package fr.spiritofphoenix.sop.auth.business.bo;

import java.io.Serializable;

/**
 * Role Business Object
 * @author Meidi
 *
 */
public class RoleBO implements Serializable {
	
	/**
	 * Object SUID
	 */
	private static final long serialVersionUID = -6501809208230270370L;

	/**
	 * Role ID
	 */
	private int id;
	
	/**
	 * Role name
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
