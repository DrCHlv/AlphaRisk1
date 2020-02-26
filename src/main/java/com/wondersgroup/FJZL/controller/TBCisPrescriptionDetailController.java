package com.wondersgroup.FJZL.controller;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.FJZL.model.TBCisPrescriptionDetail;
import com.wondersgroup.FJZL.service.TBCisPrescriptionDetailService;
import com.wondersgroup.common.util.PageBean;

@Controller
@RequestMapping("/mzcf")
public class TBCisPrescriptionDetailController {

    private TBCisPrescriptionDetailService tbCisPrescriptionDetailService;

    @RequestMapping("/queryByMonth")
    public ModelAndView TBCisPrescriptionDetailList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("FJZL/TBCisPrescriptionDetailList");
        return mav;
    }

    @RequestMapping("/queryByMonths")
    public ModelAndView query(@RequestParam("kh")String kh,@RequestParam("month") String month,
                              @RequestParam("limit")String pageRows,@RequestParam("page") String pageNum){
        ModelAndView mav = new ModelAndView();
        String sysMsg = null;
        PageBean page = new PageBean<TBCisPrescriptionDetail>();
        if(!StringUtils.isEmpty(kh) && !StringUtils.isEmpty(month)){
            if(StringUtils.isEmpty(pageNum)){
                pageNum = "1";//未传入页数时，默认为首页
            }
            if(StringUtils.isEmpty(pageRows)){
                pageRows = "5";//未传入每页行数时，设置默认每页条数
            }
            page.setPageNo(Integer.valueOf(pageNum));
            page.setPageSize(Integer.valueOf(pageRows));

            try {
                page = tbCisPrescriptionDetailService.pagingQueryOnMonthly(kh, month, page);
            } catch (ParseException e) {
                sysMsg = "日期错误";
                e.printStackTrace();
            }
        }else{
            sysMsg = "卡号与就诊日期为必填项！";
        }
        mav.setViewName("");
        mav.addObject("page", page);
        mav.addObject("sysMsg", sysMsg);
        return mav;
    }

    public TBCisPrescriptionDetailService getTbCisPrescriptionDetailService() {
        return tbCisPrescriptionDetailService;
    }

    @Autowired
    @Qualifier("tbCisPrescriptionDetailService")
    public void setTbCisPrescriptionDetailService(
            TBCisPrescriptionDetailService tbCisPrescriptionDetailService) {
        this.tbCisPrescriptionDetailService = tbCisPrescriptionDetailService;
    }



}
