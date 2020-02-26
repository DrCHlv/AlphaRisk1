package com.wondersgroup.FJZL.service;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;

import com.wondersgroup.FJZL.model.TBCisPrescriptionDetail;
import com.wondersgroup.common.util.PageBean;

public interface TBCisPrescriptionDetailService {
    /**
     * 分页查询门诊处方记录
     * @param kh 卡号
     * @param month 就诊月份 用于筛选记录
     * @param page 分页对象 用于传递分页的起始信息
     * @return 分页对象包装的门诊处方对象
     */
    public PageBean<TBCisPrescriptionDetail> pagingQueryOnMonthly(String kh,String month,PageBean page) throws ParseException;
}
