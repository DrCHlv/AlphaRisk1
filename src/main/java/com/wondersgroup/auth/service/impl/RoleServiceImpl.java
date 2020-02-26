package com.wondersgroup.auth.service.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wondersgroup.auth.dao.RoleDAO;
import com.wondersgroup.auth.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    @Autowired
    @Qualifier("roleDAO")
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}