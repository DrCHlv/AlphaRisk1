package com.wondersgroup.FJZL.service.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wondersgroup.FJZL.dao.TBCisPrescriptionDetailDAO;
import com.wondersgroup.FJZL.model.TBCisPrescriptionDetail;
import com.wondersgroup.FJZL.service.TBCisPrescriptionDetailService;
import com.wondersgroup.common.util.PageBean;

@Service("tbCisPrescriptionDetailService")
public class TBCisPrescriptionDetailServiceImpl implements TBCisPrescriptionDetailService{

    private TBCisPrescriptionDetailDAO tbCisPrescriptionDetailDAO;

    @Override
    public PageBean<TBCisPrescriptionDetail> pagingQueryOnMonthly(String kh,String month,PageBean page) throws ParseException {
        page.setList(tbCisPrescriptionDetailDAO.queryByKHAndMonth(kh, month,
                page.getPageSize() * (page.getPageNo()-1) + 1,page.getPageSize()));
        page.setTotalRows(tbCisPrescriptionDetailDAO.findTotalRows(kh, month));
        return page;
    }

    public TBCisPrescriptionDetailDAO getTbCisPrescriptionDetailDAO() {
        return tbCisPrescriptionDetailDAO;
    }

    @Autowired
    @Qualifier("tbCisPrescriptionDetailDAO")
    public void setTbCisPrescriptionDetailDAO(
            TBCisPrescriptionDetailDAO tbCisPrescriptionDetailDAO) {
        this.tbCisPrescriptionDetailDAO = tbCisPrescriptionDetailDAO;
    }


}
