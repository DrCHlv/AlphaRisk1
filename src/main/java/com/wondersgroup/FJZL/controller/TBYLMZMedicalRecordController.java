package com.wondersgroup.FJZL.controller;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Medical")
public class TBYLMZMedicalRecordController {

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView pageInit(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("FJZL/TBYLMZMedicalRecordList");
        return mav;
    }

    @RequestMapping("")
    @ResponseBody
    public String querys(@RequestParam("org") String yljgdm,@RequestParam("card") String kh,
                         @RequestParam("startDate") String kssj,@RequestParam("endDate") String jssj,
                         @RequestParam("page") int pageNo,@RequestParam("limit") int pageSize,@RequestParam("rows") int rowCount){

        return "";
    }
}
