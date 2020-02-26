package com.wondersgroup.FJZL.dao;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;
import java.util.List;

import com.wondersgroup.FJZL.model.TBYLMZMedicalRecord;

public interface TBYLMZMedicalRecordDAO {

    /**
     * 查询满足条件的对象数
     * @param yljgdm 医疗机构代码
     * @param kh 就诊卡号
     * @param kssj 门诊时间范围-开始时间
     * @param jssj 门诊时间范围-结束时间
     * @return 对象数
     */
    public int findRowCount(String yljgdm,String kh,String kssj,String jssj) throws ParseException;

    /**
     * 查询满足条件且按照就诊日期倒叙排列后指定范围的对象
     * @param yljgdm 就诊医疗机构代码
     * @param kh 就诊卡号
     * @param kssj 门诊时间范围-开始时间
     * @param jssj 门诊时间范围-结束时间
     * @param firstRow 对象集首个的位置
     * @param rowCount 对象个数
     * @return 满足条件的对象集合
     */
    public List<TBYLMZMedicalRecord> findMZJZJL(String yljgdm,String kh,String kssj,String jssj,int firstRow,int rowCount);
}