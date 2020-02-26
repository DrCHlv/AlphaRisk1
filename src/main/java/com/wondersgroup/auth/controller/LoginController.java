package com.wondersgroup.auth.controller;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.auth.model.TBAuthResource;
import com.wondersgroup.auth.model.TBAuthRole;
import com.wondersgroup.auth.model.TBDicUser;
import com.wondersgroup.auth.service.ResourceService;
import com.wondersgroup.auth.service.UserService;
import com.wondersgroup.common.util.SessionUtil;

@Controller
public class LoginController {

    private UserService userService;
    private ResourceService resourceService;

    @RequestMapping("/login.do")
    public String login(TBDicUser user,HttpServletRequest request){
        String loginMsg = null;
        if(user.getUserName() != null && user.getPassWord() != null){
            UsernamePasswordToken toke = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
            Subject subject = SecurityUtils.getSubject();
            try{
                subject.login(toke);
//				return "forward:loginsuccess.do?userMsg="+user.getUserName();
                return "redirect:loginsuccess.do?userMsg="+user.getUserName();
            }
            catch(UnknownAccountException e){
                //设置登录返回的错误信息
                loginMsg="当前用户{"+user.getUserName()+"}未注册";
                e.printStackTrace();
            } catch(IncorrectCredentialsException e){
                loginMsg="密码错误";
                e.printStackTrace();
            } catch(Exception e){
                loginMsg="操作太快,请重新尝试";
                e.printStackTrace();
            }
        }
        request.setAttribute("loginMsg", loginMsg);
        return "Auth/login";
    }

    @RequestMapping("/loginsuccess.do")
    public ModelAndView loginSuccess(String userMsg){
        TBDicUser user = userService.findUserByUserMsg(userMsg);
        //在session中存放登陆用户信息
        HttpSession session = SessionUtil.getHttpSession();
        session.setAttribute("currentUser", user);

        //系统菜单整理成指定格式用于展示
        Set<TBAuthResource> resourcesSet = null;
        Set<TBAuthResource> resources = new HashSet<TBAuthResource>();
        Set<TBAuthRole> roleSet = user.getRoles();
        Iterator<TBAuthRole> roleIter = roleSet.iterator();
        while(roleIter.hasNext()){
            TBAuthRole role = roleIter.next();
            Set<TBAuthResource> role2Resourc = role.getResources();
            Iterator<TBAuthResource> role2ResourcIter = role2Resourc.iterator();
            while(role2ResourcIter.hasNext()){
                resources.add(role2ResourcIter.next());
            }
        }
        resourcesSet = resourceService.loadTreeByResource(resources);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Auth/navigation");
        mav.addObject("user" , user);
        mav.addObject("resource" , new ArrayList<TBAuthResource>(resourcesSet));
        return mav;
    }

//	@RequestMapping("/logout.do")
//	public void logout(String userMsg){
//
//	}

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    @Autowired
    @Qualifier("resourceService")
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
