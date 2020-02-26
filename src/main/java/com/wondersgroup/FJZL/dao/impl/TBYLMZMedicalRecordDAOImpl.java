package com.wondersgroup.FJZL.dao.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.wondersgroup.FJZL.dao.TBYLMZMedicalRecordDAO;
import com.wondersgroup.FJZL.model.TBYLMZMedicalRecord;

@Repository("tbYLMZMedicalRecordDAO")
public class TBYLMZMedicalRecordDAOImpl implements TBYLMZMedicalRecordDAO{

    private HibernateTemplate hibernateTemplate;
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findRowCount(String yljgdm, String kh, String kssj, String jssj) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        StringBuffer hql = new StringBuffer("select count(1) from TBYLMZMedicalRecord where 1=1 ");
        if(!StringUtils.isEmpty(yljgdm)){
            hql.append("and yljgdm=?");
        }
        if(!StringUtils.isEmpty(kh)){
            hql.append("and kh=?");
        }
        if(!StringUtils.isEmpty(kssj)){
            calendar.setTime(sdf.parse(kssj));
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            final Date startDate = calendar.getTime();
            hql.append("and kfrq>=?");
        }
        if(!StringUtils.isEmpty(jssj)){
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.HOUR, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            hql.append("and kfrq<=?");
        }

        hql.append("order by jzksrq desc,yljgdm,jzlsh");
        return 0;
    }

    @Override
    public List<TBYLMZMedicalRecord> findMZJZJL(String yljgdm, String kh,
                                                String kssj, String jssj, int firstRow, int rowCount) {
        StringBuffer hql = new StringBuffer("select YLJGDM,JZLSH,WSJGDM,CISID,KH,KLX,HZXM,"
                + "JZLX,BXLX,YBZHBZ,JZKSBM,JZKSMC,JZKSRQ,ZZYSGH,ZZYSXM,ZZYSSFZ,JZZDBM,BMLX,"
                + "JZZDSM,ZS,ZZMS,XGBZ,MJ from ("
                + "select ROW_NUMBER() over(order by jzksrq desc,yljgdm,jzlsh) rownum,"
                + "YLJGDM,JZLSH,WSJGDM,CISID,KH,KLX,HZXM,JZLX,BXLX,YBZHBZ,JZKSBM,JZKSMC,"
                + "JZKSRQ,ZZYSGH,ZZYSXM,ZZYSSFZ,JZZDBM,BMLX,JZZDSM,ZS,ZZMS,XGBZ,MJ "
                + "from TB_YL_MZ_Medical_Record where kh=? ");
        if(!StringUtils.isEmpty(yljgdm)){
            hql.append("and yljgdm='");
            hql.append(yljgdm);
            hql.append("' ");
        }
        if(!StringUtils.isEmpty(kssj)){
            hql.append("and kssj>=convert(datetime,'");
            hql.append(kssj);
            hql.append("',121) ");
        }
        if(!StringUtils.isEmpty(jssj)){
            hql.append("and jssj<=convert(datetime,dateadd(ss,-1,dateadd(dd,1,'");
            hql.append(jssj);
            hql.append("')),121) ");
        }
        hql.append(") o where rownum between ");
        hql.append(firstRow);
        hql.append(" and ");
        hql.append(firstRow+rowCount-1);
        return jdbcTemplate.query(hql.toString(),new BeanPropertyRowMapper(TBYLMZMedicalRecord.class));
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    @Qualifier("hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
