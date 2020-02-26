package com.wondersgroup.auth.service.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wondersgroup.auth.dao.ResourceDAO;
import com.wondersgroup.auth.model.TBAuthResource;
import com.wondersgroup.auth.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{
    private ResourceDAO resourceDAO;

    @Override
    public Set<TBAuthResource> findCurrentUserResource(int id) {
        return null;
    }


    @Override
    public Set<TBAuthResource> loadTreeByResource(Set<TBAuthResource> resources) {
        Iterator<TBAuthResource> sourIter = resources.iterator();
        List<TBAuthResource> lv1 = new ArrayList<TBAuthResource>();
        List<TBAuthResource> lv2 = new ArrayList<TBAuthResource>();
        List<TBAuthResource> lv3 = new ArrayList<TBAuthResource>();
        while(sourIter.hasNext()){
            TBAuthResource resource = sourIter.next();
            resource.setChild(new HashSet<TBAuthResource>());
            if(resource.getReslevel() == 1){
                lv1.add(resource);
            }

            if(resource.getReslevel() == 2){
                lv2.add(resource);
            }

            if(resource.getReslevel() == 3){
                lv3.add(resource);
            }
        }

        Iterator<TBAuthResource> it1 = lv1.iterator();
        while(it1.hasNext()){
            TBAuthResource res1 = it1.next();
            Iterator<TBAuthResource> it2 = lv2.iterator();
            while(it2.hasNext()){
                TBAuthResource res2 = it2.next();
                Iterator<TBAuthResource> it3 = lv3.iterator();
                if(res1.getId() == res2.getParent().getId()){
                    int i = lv1.indexOf(res1);
                    while(it3.hasNext()){
                        TBAuthResource res3 = it3.next();
                        if(res2.getId() == res3.getParent().getId()){
                            res2.getChild().add(res3);
                            it3.remove();
                        }
                    }
                    res1.getChild().add(res2);
                    lv1.set(i, res1);
                    it2.remove();
                }
            }
        }

        return new HashSet<TBAuthResource>(lv1);
    }


    @Override
    public List<TBAuthResource> findRootResources() {
        //这里暂定权限模块已经初始化完成角色的获取
        int[] roles = new int[1];
        roles[0]=1;
        return null;
    }


    public ResourceDAO getResourceDAO() {
        return resourceDAO;
    }

    @Autowired
    @Qualifier("resourceDAO")
    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }


}
