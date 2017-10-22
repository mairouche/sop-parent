package fr.spiritofphoenix.sop.auth.business.bo;

import java.io.Serializable;

/**
 * Group Authorization Business Object
 * @author Meidi
 *
 */
public class GroupAuthorizationBO implements Serializable {

	/**
	 * Object SUID
	 */
	private static final long serialVersionUID = -3301232834302368699L;

	/**
	 * Authorization unique ID
	 */
	private long id;

	/**
	 * Group ID
	 */
	private int groupId;
	
	/**
	 * Group Name
	 */
	private String groupName;

	/**
	 * Role ID
	 */
	private int roleId;
	
	/**
	 * Role Name
	 */
	private String roleName;

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
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
