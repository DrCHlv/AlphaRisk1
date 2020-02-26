package com.wondersgroup.auth.dao.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wondersgroup.auth.dao.RoleDAO;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO{

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    @Qualifier("hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}