package com.wondersgroup.auth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_auth_role")
public class TBAuthRole {
	private int id;
	private String roleName;
	private TBDicUser cruser;
	private int isEffective;
	private Set<TBDicUser> users = new HashSet<TBDicUser>();
	private Set<TBAuthResource> resources = new HashSet<TBAuthResource>();
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="rolename")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@ManyToOne
	@JoinColumn(name="cruser")
	public TBDicUser getCruser() {
		return cruser;
	}
	public void setCruser(TBDicUser cruser) {
		this.cruser = cruser;
	}

	@Column(name="iseffective")
	public int getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(int isEffective) {
		this.isEffective = isEffective;
	}
	
	@ManyToMany
	@JoinTable(name="tb_auth_relation_role2user",
		joinColumns={@JoinColumn(name="roleid")},inverseJoinColumns={@JoinColumn(name="userid")})
	public Set<TBDicUser> getUsers() {
		return users;
	}
	public void setUsers(Set<TBDicUser> users) {
		this.users = users;
	}
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER)
	public Set<TBAuthResource> getResources() {
		return resources;
	}
	public void setResources(Set<TBAuthResource> resources) {
		this.resources = resources;
	}
	
}
