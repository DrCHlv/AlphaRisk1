package com.wondersgroup.auth.model;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "tb_dic_department")
public class Department {
//	private int id;
//	private String departmentName;
//	private int departmentLevel;
//	private TBDicUser createUser;
//	private Date createDate;
//	private String isEffective;
//	private Organization organization;
//	private Set<TBDicUser> users = new HashSet<TBDicUser>();
//
//	@Id
//	@GeneratedValue
//	@Column(name = "id")
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	@Column(name = "depname")
//	public String getDepartmentName() {
//		return departmentName;
//	}
//
//	public void setDepartmentName(String departmentName) {
//		this.departmentName = departmentName;
//	}
//
//	@Column(name = "deplevel")
//	public int getDepartmentLevel() {
//		return departmentLevel;
//	}
//
//	public void setDepartmentLevel(int departmentLevel) {
//		this.departmentLevel = departmentLevel;
//	}
//
//	@OneToOne
//	@JoinColumn(name="cruser")
//	public TBDicUser getCreateUser() {
//		return createUser;
//	}
//
//	public void setCreateUser(TBDicUser createUser) {
//		this.createUser = createUser;
//	}
//
//	@Column(name = "crdate")
//	@Temporal(TemporalType.DATE)
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	@Column(name = "iseffective")
//	public String getIsEffective() {
//		return isEffective;
//	}
//
//	public void setIsEffective(String isEffective) {
//		this.isEffective = isEffective;
//	}
//
//	@ManyToOne
//	@JoinColumn(name="orgid")
//	private Organization getOrganization() {
//		return organization;
//	}
//
//	@SuppressWarnings("unused")
//	private void setOrganization(Organization organization) {
//		this.organization = organization;
//	}
//
//	@ManyToMany
//	@JoinTable(name="tb_dic_relation_department2user",
//		joinColumns={@JoinColumn(name="departmentid")},inverseJoinColumns={@JoinColumn(name="userid")})
//	private Set<TBDicUser> getUsers() {
//		return users;
//	}
//
//	@SuppressWarnings("unused")
//	private void setUsers(Set<TBDicUser> users) {
//		this.users = users;
//	}
}