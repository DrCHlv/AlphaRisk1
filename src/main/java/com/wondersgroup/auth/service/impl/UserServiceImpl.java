package com.wondersgroup.auth.service.impl;

/**
 * Created by 319 on 2020/2/26.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.auth.dao.UserDAO;
import com.wondersgroup.auth.model.TBDicUser;
import com.wondersgroup.auth.service.UserService;
import com.wondersgroup.common.util.IDCardCheckUtil;
import com.wondersgroup.common.util.PageBean;

@Service("userService")
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Override
    @Transactional
    public TBDicUser findUserByUserMsg(String userMsg) {
        if(userMsg.length()>0){
            if(IDCardCheckUtil.isLegal(userMsg)){
                return this.userDAO.findUserByUserIDCard(userMsg);
            } else{
                return this.userDAO.findUserById(userMsg);
            }
        }
        return null;
    }

    @Override
    public PageBean<TBDicUser> pagingQueryOnCruser(TBDicUser user, PageBean page) {
        List<TBDicUser> users = userDAO.findUsersByCrUser(user,
                page.getPageSize()*(page.getPageNo()-1)+1, page.getPageSize());
        page.setList(users);
        if(page.getTotalRows() == 0){
            page.setTotalRows(userDAO.findRowsNoOnCruser(user));;
        }
        return page;
    }

    @Override
    public int countRowsOnCruser(TBDicUser user) {
        return user.getChild().size();
    }

    @Override
    public int countRows(TBDicUser user) {
        // TODO Auto-generated method stub
        return 0;
    }

    private UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    @Qualifier("userDAO")
    private void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
