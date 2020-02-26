package com.wondersgroup.auth.service;

/**
 * Created by 319 on 2020/2/26.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wondersgroup.auth.model.TBAuthResource;
import com.wondersgroup.auth.model.TBAuthRole;
import com.wondersgroup.auth.model.TBDicUser;

public class ShiroRealm extends AuthorizingRealm{

    private UserService userService;

    /**
     * 为登录用户赋权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userMsg= (String)principals.getPrimaryPrincipal();
        TBDicUser user = userService.findUserByUserMsg(userMsg);

        //从user中获取角色与权限信息
        Set<TBAuthRole> roles = user.getRoles();
        Set<String> rolesStr = new HashSet<String>();
        Set<String> resourcesStr = new HashSet<String>();

        Iterator<TBAuthRole> roleIter = roles.iterator();
        while(roleIter.hasNext()){
            TBAuthRole role = (TBAuthRole)roleIter.next();
            rolesStr.add(role.getRoleName());
            Set<TBAuthResource> resources = role.getResources();
            Iterator<TBAuthResource> resourceIter = resources.iterator();
            while(resourceIter.hasNext()){
                resourcesStr.add(((TBAuthResource)resourceIter.next()).getResourceName());
            }
        }
        System.out.println("shiroRealm:授予权限时role="+rolesStr.size());
        System.out.println("shiroRealm:授予权限时resource="+resourcesStr.size());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //通过用户获取角色
        try{
            authorizationInfo.setRoles(rolesStr);
            authorizationInfo.setStringPermissions(resourcesStr);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }
    /**
     * 验证登录是否通过
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AuthenticationInfo authcInfo = null;
        String userMsg = (String)token.getPrincipal();
        try {
            TBDicUser user = userService.findUserByUserMsg(userMsg);
            if(user != null){
                authcInfo = new SimpleAuthenticationInfo(userMsg,user.getPassWord(),getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authcInfo;
    }

    //getters and setters
    public UserService getUserService() {
        return userService;
    }
    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}