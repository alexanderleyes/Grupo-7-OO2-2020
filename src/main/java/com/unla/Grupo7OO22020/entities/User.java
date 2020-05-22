package com.unla.Grupo7OO22020.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/*import src.main.java.com.unla.ghsicilianotfi.entities.Column;
import src.main.java.com.unla.ghsicilianotfi.entities.CreationTimestamp;
import src.main.java.com.unla.ghsicilianotfi.entities.Entity;
import src.main.java.com.unla.ghsicilianotfi.entities.GeneratedValue;
import src.main.java.com.unla.ghsicilianotfi.entities.HashSet;
import src.main.java.com.unla.ghsicilianotfi.entities.Id;
import src.main.java.com.unla.ghsicilianotfi.entities.LocalDateTime;
import src.main.java.com.unla.ghsicilianotfi.entities.OneToMany;
import src.main.java.com.unla.ghsicilianotfi.entities.Set;
import src.main.java.com.unla.ghsicilianotfi.entities.String;
import src.main.java.com.unla.ghsicilianotfi.entities.Table;
import src.main.java.com.unla.ghsicilianotfi.entities.UpdateTimestamp;
import src.main.java.com.unla.ghsicilianotfi.entities.UserRole;*/

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username", unique=true, nullable=false, length=45)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	public User() {}
	
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User(String username, String password, boolean enabled, Set<UserRole> userRoles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
