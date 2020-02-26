package com.wondersgroup.FJZL.dao;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;
import java.util.List;

import com.wondersgroup.FJZL.model.TBCisPrescriptionDetail;

public interface TBCisPrescriptionDetailDAO {

    /**
     * 根据传入的病人卡号信息与就诊查询的月份,查询病人的处方记录
     * @param kh 病人卡号
     * @param month 开方日期
     * @param firstRowNum 分页第一条的编码
     * @param rowNum 每页记录条数
     * @return 带有分页信息的门诊处方记录集合
     */
    public List<TBCisPrescriptionDetail> queryByKHAndMonth(String kh,String month,int firstRowNum, int rowNum) throws ParseException;

    /**
     * 根据传入的并人信息与就诊查询的月份,查询符合条件的记录条数
     * @param kh 病人卡号
     * @param month 开方日期
     * @return 处方条数总计
     */
    public int findTotalRows(String kh,String month) throws ParseException;
}
