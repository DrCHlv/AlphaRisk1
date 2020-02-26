package com.wondersgroup.common.util;

/**
 * Created by 319 on 2020/2/26.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询使用
 * @author 319
 *
 */
public class PageBean<T> {
    /**
     * 当前页数
     */
    private int pageNo = 1;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 总行数
     */
    private int totalRows;
    /**
     * 每页行数
     */
    private int pageSize = 10;
    /**
     * 保存分页返回的对象集合
     */
    private List<T> list = new ArrayList();

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List getList() {
        if(list == null){
            list = new ArrayList();
        }
        return list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageBean(){
        super();
    }

    public PageBean(int pageNo, int pageSize, int totalRows) {
        super();
        this.pageNo = pageNo;
        this.totalRows = totalRows;
        this.pageSize = pageSize;
    }

}
