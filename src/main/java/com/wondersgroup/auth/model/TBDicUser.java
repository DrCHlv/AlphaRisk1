package com.wondersgroup.auth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_dic_user")
public class TBDicUser {
	private int id;
	private String userName;
	private String passWord;
	private String idcard;
	private int saltNum;
	private TBDicUser parent;
	private Set<TBDicUser> child = new HashSet<TBDicUser>();
	private Date createDate;
	private String isEffective;
//	private Set<Department> departments = new HashSet<Department>();
	private Set<TBAuthRole> roles = new HashSet<TBAuthRole>();
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "password")
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "idcard")
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	@Column(name = "saltnum")
	public int getSaltNum() {
		return saltNum;
	}
	public void setSaltNum(int saltNum) {
		this.saltNum = saltNum;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cruser")
	public TBDicUser getParent() {
		return parent;
	}
	public void setParent(TBDicUser parent) {
		this.parent = parent;
	}
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<TBDicUser> getChild() {
		return child;
	}
	public void setChild(Set<TBDicUser> child) {
		this.child = child;
	}

	@Column(name = "crdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "iseffective")
	public String getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	
//	@ManyToMany(mappedBy = "users")
//	private Set<Department> getDepartments() {
//		return departments;
//	}
//	
//	@SuppressWarnings("unused")
//	private void setDepartments(Set<Department> departments) {
//		this.departments = departments;
//	}
	
	@ManyToMany(mappedBy="users",fetch=FetchType.EAGER)
	public Set<TBAuthRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<TBAuthRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "TBDicUser [id=" + id + ", userName=" + userName + ", passWord="
				+ passWord + ", idcard=" + idcard + ", saltNum=" + saltNum
				+ ", parent=" + parent + ", child=" + child + ", createDate="
				+ createDate + ", isEffective=" + isEffective + ", roles="
				+ roles + "]";
	}
	
	//重写构造防范，方便使用的时候调用
	public TBDicUser() {
		super();
	}
	public TBDicUser(int id, String userName, String passWord, String idcard,
			int saltNum, String isEffective) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.idcard = idcard;
		this.saltNum = saltNum;
		this.isEffective = isEffective;
	}
	
	
	
}
