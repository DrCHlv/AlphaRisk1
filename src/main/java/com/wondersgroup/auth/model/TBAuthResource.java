package com.wondersgroup.auth.model;

/**
 * Created by 319 on 2020/2/26.
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_auth_resource")
public class TBAuthResource {
    private int id;
    private String resourceName;
    private String URL;
    private int reslevel;
    private TBAuthResource parent;
    private Set<TBAuthResource> child = new HashSet<TBAuthResource>();
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

    @Column(name = "resname")
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Column(name = "URL")
    public String getURL() {
        return URL;
    }
    public void setURL(String uRL) {
        URL = uRL;
    }

    @Column(name = "reslevel")
    public int getReslevel() {
        return reslevel;
    }
    public void setReslevel(int reslevel) {
        this.reslevel = reslevel;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    public TBAuthResource getParent() {
        return parent;
    }
    public void setParent(TBAuthResource parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<TBAuthResource> getChild() {
        return child;
    }
    public void setChild(Set<TBAuthResource> child) {
        this.child = child;
    }

    @ManyToMany
    @JoinTable(name="tb_auth_relation_resource2role",
            joinColumns={@JoinColumn(name="resid")},inverseJoinColumns={@JoinColumn(name="roleid")})
    public Set<TBAuthRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<TBAuthRole> roles) {
        this.roles = roles;
    }
}
