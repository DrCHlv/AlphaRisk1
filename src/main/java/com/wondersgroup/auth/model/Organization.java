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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
//@Table(name = "tb_dic_organization")
public class Organization {

//	private int id;
//	private String organizationName;
//	private int organizationLevel;
//	private TBDicUser createUser;
//	private Date createDate;
//	private String isEffective;
//	private Set<Department> departments = new HashSet<Department>();
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
//	@Column(name = "orgname")
//	public String getOrganizationName() {
//		return organizationName;
//	}
//
//	public void setOrganizationName(String organizationName) {
//		this.organizationName = organizationName;
//	}
//
//	@Column(name = "orglevel")
//	public int getOrganizationLevel() {
//		return organizationLevel;
//	}
//
//	public void setOrganizationLevel(int organizationLevel) {
//		this.organizationLevel = organizationLevel;
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
//	@OneToMany(mappedBy = "organization")
//	private Set<Department> getDepartments() {
//		return departments;
//	}
//
//	private void setDepartments(Set<Department> departments) {
//		this.departments = departments;
//	}

}