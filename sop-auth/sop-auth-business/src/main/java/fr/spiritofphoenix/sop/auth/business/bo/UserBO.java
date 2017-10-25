package fr.spiritofphoenix.sop.auth.business.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * User Business Object
 * @author Meidi
 *
 */
public class UserBO implements Serializable {
	
	/**
	 * Object SUID
	 */
	private static final long serialVersionUID = 8261807944967820388L;

	/**
	 * User unique ID
	 */
	private long id;

	/**
	 * User name
	 */
	private String name;

	/**
	 * User surname
	 */
	private String surname;

	/**
	 * User email
	 */
	private String email;

	/**
	 * User password
	 */
	private String password;

	/**
	 * User birth date
	 */
	private Date birth;

	/**
	 * User phone number
	 */
	private String phone;

	/**
	 * User activation
	 */
	private boolean active = false;

	/**
	 * User legals acceptation
	 */
	private boolean legals = false;

	/**
	 * User avatar
	 */
	private String avatar;

	/**
	 * User group unique ID
	 */
	private int groupId;
	
	/**
	 * User groupName
	 */
	private String groupName;
	
	/**
	 * User access token
	 */
	private String accessToken;

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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the legals
	 */
	public boolean isLegals() {
		return legals;
	}

	/**
	 * @param legals the legals to set
	 */
	public void setLegals(boolean legals) {
		this.legals = legals;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
