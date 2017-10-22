package fr.spiritofphoenix.sop.auth.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User
 * @author Meidi
 *
 */
@Entity
@Table(name="TA_USERS")
public class User {

	/**
	 * User unique ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_USER", nullable = false, unique = true)
	private long id;

	/**
	 * User name
	 */
	@Column(name = "NAME", nullable = true, length = 50)
	private String name = "";

	/**
	 * User surname
	 */
	@Column(name = "SURNAME", nullable = true, length = 50)
	private String surname = "";

	/**
	 * User email
	 */
	@Column(name = "EMAIL", nullable = false, length = 200)
	private String email;

	/**
	 * User password
	 */
	@Column(name = "PASSWORD", nullable = false, length = 16)
	private String password;

	/**
	 * User birth date
	 */
	@Column(name = "BIRTH_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birth;

	/**
	 * User phone number
	 */
	@Column(name = "PHONE", nullable = true, length = 10)
	private String phone;

	/**
	 * User validated
	 */
	@Column(name = "ACTIVE", nullable = false)
	private boolean active = false;

	/**
	 * Legals accepted
	 */
	@Column(name = "LEGALS", nullable = false)
	private boolean legals = false;

	/**
	 * User avatar
	 */
	@Column(name = "AVATAR", nullable = true, length = 250)
	private String avatar;

	/**
	 * User group
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GROUP")
	private Group group;
	
	/**
	 * User token
	 */
	@Column(name = "TOKEN", nullable = false, length = 250)
	private String token;

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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
