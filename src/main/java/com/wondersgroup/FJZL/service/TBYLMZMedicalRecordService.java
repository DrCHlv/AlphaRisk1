package com.wondersgroup.FJZL.service;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import com.wondersgroup.FJZL.model.TBYLMZMedicalRecord;
import com.wondersgroup.common.util.PageBean;

import java.text.ParseException;

public interface TBYLMZMedicalRecordService {

    /**
     * 根据查询条件，分页返回门诊就诊记录对象的分页包装集合
     * @param yljgdm 医疗机构代码
     * @param kh 卡号
     * @param kssj 门诊就诊时间段-开始时间
     * @param jssj 门诊就诊时间段-结束时间
     * @param page 分页对象
     * @return 门诊就诊记录对象的分页包装集合
     */
    public PageBean<TBYLMZMedicalRecord> pagingQueryMZJZJL(String yljgdm,String kh,String kssj,String jssj,PageBean page) throws ParseException;

}