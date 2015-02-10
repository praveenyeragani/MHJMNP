package org.milkandpaper.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "users"/*, catalog = "spring_social_db"*/)
public class Users {

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "firstname", /*unique = true,*/ nullable = false, length = 45)
	private String firstname;
	
	@Column(name = "lastname", /*unique = true,*/ nullable = false, length = 45)
	private String lastname;
	
	@Column(name = "email", /*unique = true,*/ nullable = false, length = 45)
	private String email;
	
	@Column(name = "phoneno", /*unique = true,*/ nullable = false, length = 45)
	private Integer phoneno;
	
	@Column(name = "blockname", /*unique = true,*/ nullable = false, length = 45)
	private String blockName;
	
	

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	@Column(name = "floorno", /*unique = true,*/ nullable = false, length = 45)
	private Integer floorno;
	
	@Column(name = "flotno", /*unique = true,*/ nullable = false, length = 45)
	private Integer flotno;
	
	@Column(name = "username", /*unique = true,*/ nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled", nullable = false,columnDefinition = "boolean default false")
	private Boolean enabled=false;
	
	@Column(name = "isApproved", nullable = false,columnDefinition = "boolean default false")
	private Boolean isApproved=false;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "login_First_Time", nullable = false,columnDefinition = "default yes")
	private String loginFirstTime="yes";
	
	
//	public boolean isRegistered() {
//		return isRegistered;
//	}
//
//	public void setRegistered(boolean isRegistered) {
//		this.isRegistered = isRegistered;
//	}

	public String getLoginFirstTime() {
		return loginFirstTime;
	}

	public void setLoginFirstTime(String loginFirstTime) {
		this.loginFirstTime = loginFirstTime;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}

	public Integer getFloorno() {
		return floorno;
	}

	public void setFloorno(Integer floorno) {
		this.floorno = floorno;
	}

	public Integer getFlotno() {
		return flotno;
	}

	public void setFlotno(Integer flotno) {
		this.flotno = flotno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
