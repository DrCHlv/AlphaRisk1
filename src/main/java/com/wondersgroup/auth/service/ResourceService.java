package com.wondersgroup.auth.service;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.util.List;
import java.util.Set;

import com.wondersgroup.auth.model.TBAuthResource;

public interface ResourceService {
    /**
     * 根据用户ID获取用户可以访问的资源
     * @param id 用户ID
     * @return 当前用户可以访问的资源集合
     */
    public Set<TBAuthResource> findCurrentUserResource(int id);

    /**
     * 根据资源Set,及其父子关系,组装为树形结构
     * @param roles 角色对应的Set
     * @return 树形结构的Set
     */
    public Set<TBAuthResource> loadTreeByResource(Set<TBAuthResource> resource);

    public List<TBAuthResource> findRootResources();

}