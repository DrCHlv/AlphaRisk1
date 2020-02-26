package com.wondersgroup.auth.controller;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.auth.model.TBAuthResource;
import com.wondersgroup.auth.service.ResourceService;

@Controller
public class ResourceController {

    private ResourceService resourceService;

    //用户登录系统时，返回纵向菜单列表，即当前用户的权限列表
    //@RequestMapping("method=loginSuccess")
    @RequestMapping("resource.do")
    public ModelAndView findCurrentUserResource(){
        List<TBAuthResource> resources = resourceService.findRootResources();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Auth/navigation");
        mav.addObject("resource" , resources);
        return mav;
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
