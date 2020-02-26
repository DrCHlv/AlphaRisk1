package com.wondersgroup.FJZL.service.impl;

import com.wondersgroup.FJZL.dao.TBYLMZMedicalRecordDAO;
import com.wondersgroup.FJZL.model.TBYLMZMedicalRecord;
import com.wondersgroup.FJZL.service.TBYLMZMedicalRecordService;
import com.wondersgroup.common.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
public class TBYLMZMedicalRecordServiceImpl implements TBYLMZMedicalRecordService{

    private TBYLMZMedicalRecordDAO tbYLMZMedicalRecordDAO;

    @Override
    public PageBean<TBYLMZMedicalRecord> pagingQueryMZJZJL(
            String yljgdm, String kh, String kssj, String jssj, PageBean page) {
        //调用DAO,获取满足条件的对象集合
        page.setList(tbYLMZMedicalRecordDAO.findMZJZJL(yljgdm, kh, kssj, jssj,
                page.getPageSize() * (page.getPageNo()-1) - 1, page.getPageSize()));
        //调用DAO,获取满足条件的对象总数
        page.setTotalRows(tbYLMZMedicalRecordDAO.findRowCount(yljgdm,kh,kssj,jssj));
        return page;
    }
    public TBYLMZMedicalRecordDAO getTbYLMZMedicalRecordDAO() {
        return tbYLMZMedicalRecordDAO;
    }
    @Autowired
    @Qualifier("tbYLMZMedicalRecordDAO")
    public void setTbYLMZMedicalRecordDAO(
            TBYLMZMedicalRecordDAO tbYLMZMedicalRecordDAO) {
        this.tbYLMZMedicalRecordDAO = tbYLMZMedicalRecordDAO;
    }
}
