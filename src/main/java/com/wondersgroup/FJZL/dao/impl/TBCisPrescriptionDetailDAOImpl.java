package com.wondersgroup.FJZL.dao.impl;

/**
 * Created by WJW_DB_JX on 2020/2/26.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wondersgroup.FJZL.dao.TBCisPrescriptionDetailDAO;
import com.wondersgroup.FJZL.model.TBCisPrescriptionDetail;

@Repository("tbCisPrescriptionDetailDAO")
public class TBCisPrescriptionDetailDAOImpl implements TBCisPrescriptionDetailDAO{

    private HibernateTemplate hibernateTemplate;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TBCisPrescriptionDetail> queryByKHAndMonth(final String kh, final String month,final int firstRowNum, final int rowNum) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        calendar.setTime(sdf.parse(month));
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        final Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        final Date endDate = calendar.getTime();

        //final StringBuffer hql = new StringBuffer("from TBCisPrescriptionDetail ");
        //hql.append("where kh=? and kfrq between ? and ? ");
       // hql.append("order by kfrq desc,cyh,cfmxh");
        List<TBCisPrescriptionDetail> tbCisPrescriptionDetail = null;
                //= hibernateTemplate.execute(new HibernateCallback() {
       //     @Override
       //     public Object doInHibernate(Session session) throws HibernateException {
       //         Query query = session.createQuery(hql.toString());
       //         query.setString(0, kh);
       //         query.setTimestamp(1, startDate);
       //         query.setTimestamp(2, endDate);
       //         query.setFirstResult(firstRowNum);
       //         query.setMaxResults(rowNum);
       //         return query.list();
       //     }

        //});
        //System.out.println(tbCisPrescriptionDetail.size());
        return tbCisPrescriptionDetail;
    }

    @Override
    public int findTotalRows(String kh, String month) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        calendar.setTime(sdf.parse(month));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        final Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        final Date endDate = calendar.getTime();

        String hql = "select count(1) from TBCisPrescriptionDetail where kh=? and kfrq between ? and ?";

        return 0;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    @Qualifier("hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }



	/*
	@Override
	public List<TBCisPrescriptionDetail> query(String kh, String month) {
		StringBuffer queryStr = new StringBuffer("select "
				+ "CYH,CFMXH,YLJGDM,WSJGDM,JZLSH,CXBZ,KH,KLX,JZKSDM,KFYS,KFYSXM,KFYSSFZ,"
				+ "KFRQ,XMBM,XMBMYB,SCPH,YXQZ,XMMC,CFLX,JXDM,YPGG,YPYF,YPSL,YPDW,CFTS,"
				+ "YZZH,SYPCDM,SYPC,JL,DW,MCSL,MCDW,YF,YYTS,JYDM,SFPS,JCBW,BZ,MJ "
				+ "from TB_CIS_Prescription_Detail_V21_");
		queryStr.append(month);
		queryStr.append(" where kh='");
		queryStr.append(kh);
		queryStr.append("' order by kfrq desc;");
//		List<Map<String,Object>> a = jdbcTemplate.queryForList(queryStr.toString());
		return jdbcTemplate.query(queryStr.toString(), new BeanPropertyRowMapper(TBCisPrescriptionDetail.class));
	}
	 */

}
