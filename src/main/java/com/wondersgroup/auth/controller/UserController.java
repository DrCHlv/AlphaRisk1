package com.wondersgroup.auth.controller;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wondersgroup.auth.model.TBDicUser;
import com.wondersgroup.auth.service.UserService;
import com.wondersgroup.common.util.PageBean;
import com.wondersgroup.common.util.SessionUtil;

@Controller
@RequestMapping("/userManager")
public class UserController {

    private UserService userService;

    @RequestMapping("/user.do")
    //@RequestMapping(value="/user.do",method=RequestMethod.POST)
    //@RequestMapping("method=userQuery")
    public ModelAndView userList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Auth/userList");
        return mav;
    }
    @RequestMapping(value="/queryUser.do")
    public @ResponseBody String queryUser(@RequestParam("page") int pageNo, @RequestParam("limit") int pageSize, int totalRows){
        HttpSession session = SessionUtil.getHttpSession();
        TBDicUser currentUser = (TBDicUser)session.getAttribute("currentUser");
        PageBean<TBDicUser> page = new PageBean(pageNo, pageSize,totalRows);
        page = userService.pagingQueryOnCruser(currentUser, page);
        List<TBDicUser> users = page.getList();
        String userJson = null;
        try {
            userJson = "{\"code\":0,\"msg\":\"\",\"count\":" + page.getTotalRows() + ",\"data\":"
                    + new ObjectMapper().writeValueAsString(users) + "}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userJson;
    }
    public UserService getUserService() {
        return userService;
    }

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
