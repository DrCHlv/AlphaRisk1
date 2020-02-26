package com.wondersgroup.auth.dao.impl;

/**
 * Created by 319 on 2020/2/26.
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wondersgroup.auth.dao.UserDAO;
import com.wondersgroup.auth.model.TBDicUser;
import com.wondersgroup.common.util.HibernateUtil;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

    private HibernateTemplate hibernateTemplate;
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<TBDicUser> findUser(TBDicUser user) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TBDicUser.class);

        if(user.getId() > 0){
            detachedCriteria.add(Restrictions.eq("id", user.getId()));
        }
        if(user.getUserName() != null && user.getUserName().length() > 0){
            detachedCriteria.add(Restrictions.like("userName", user.getUserName() , MatchMode.ANYWHERE));
        }
//		if(user.getCreaterUser()>0){
//			detachedCriteria.add(Restrictions.eq("createUser", user.getCreaterUser()));
//		}
        if(user.getIsEffective() != null && user.getIsEffective().length() > 0){
            detachedCriteria.add(Restrictions.eq("isEffective", user.getIsEffective()));
        }
        detachedCriteria.addOrder(Order.asc("userName"));
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        s.beginTransaction();
        return detachedCriteria.getExecutableCriteria(s).list();
    }

    @Override
    public TBDicUser findUserByUsername(String username) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TBDicUser.class);
        if(username !=null && username.length()>0){
            detachedCriteria.add(Restrictions.eq("userName",username));
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        s.beginTransaction();
        return (TBDicUser) detachedCriteria.getExecutableCriteria(s).uniqueResult();
    }

    @Override
    public List<TBDicUser> findUsersByUsername(String username) {

        return null;
    }

    @Override
    public TBDicUser findUserByUserIDCard(String idCard) {
        TBDicUser user = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TBDicUser.class);
        detachedCriteria.add(Restrictions.eq("idcard", idCard));
        user = (TBDicUser) detachedCriteria.
                getExecutableCriteria(hibernateTemplate.getSessionFactory().getCurrentSession()).uniqueResult();
        return user;
    }

    @Override
    public TBDicUser findUserById(String id){
        return hibernateTemplate.get(TBDicUser.class, Integer.valueOf(id));
    }

    @Override
    public List<TBDicUser> findUsersByCrUser(TBDicUser cruser, final int firstRowNum, final int perPageRows) {
        final int cruserID = cruser.getId();
        final String iseffective = cruser.getIsEffective();
        StringBuffer hql = new StringBuffer("select id,username,password,idcard,saltnum,iseffective from("
                + "select ROW_NUMBER() over(order by id) rownum,id,username,password,idcard,saltnum,crdate,iseffective "
                + "from tb_dic_user where cruser=");
        hql.append(cruserID);
        hql.append(" and iseffective=");
        hql.append(iseffective);
        hql.append(") a ");
        hql.append("where rownum between ");
        hql.append(firstRowNum);
        hql.append(" and ");
        hql.append(firstRowNum+perPageRows-1);
        hql.append(" order by id");
        List<TBDicUser> users = jdbcTemplate.query(hql.toString(), new BeanPropertyRowMapper(TBDicUser.class));
        //调用RowMapper接口
//		users = jdbcTemplate.query(hql.toString(), params,//传入对应位置上的参数
//						new RowMapper<TBDicUser>(){
//							@Override
//							public TBDicUser mapRow(ResultSet rs, int rownum) throws SQLException {
//								TBDicUser user = new TBDicUser(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
//								System.out.println(rs.getInt(1));
//								return user;
//							}
//		});

        //调用processRow接口
//		users = jdbcTemplate.query(hql.toString(), new Object[]{cruserID, iseffective, firstRowNum, perPageRows},
//				new RowCallbackHandler() {//将结果集中的数据映射到List中
//            public void processRow(ResultSet rs) throws SQLException {
//                Forum forum = new Forum();
//                forum.setForumId(rs.getInt("forum_id"));
//                forum.setForumName(rs.getString("forum_name"));
//                forum.setForumDesc(rs.getString("forum_desc"));
//                forumList.add(forum);
//            }
//		});

        return users;
    }

    @Override
    public int findRowsNo(TBDicUser cruser) {

        return 0;
    }

    @Override
    public int findRowsNoOnCruser(TBDicUser cruser) {
        StringBuffer hql = new StringBuffer("select count(1) from TB_Dic_User where cruser=1");
        return jdbcTemplate.queryForInt(hql.toString());
    }

    //getters and setters
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

