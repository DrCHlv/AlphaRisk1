package com.wondersgroup.auth.dao;

import java.util.List;

import com.wondersgroup.auth.model.TBDicUser;

public interface UserDAO {
	public List<TBDicUser> findUser(TBDicUser user);

	public TBDicUser findUserById(String id);

	/**
	 * 根据用户名，精确查找用户
	 * @param username
	 * @return
	 */
	public TBDicUser findUserByUsername(String username);

	/**
	 * 根据用户名，模糊查询用户
	 * @param username
	 * @return
	 */
	public List<TBDicUser> findUsersByUsername(String username);

	/**
	 * 根据用户身份证信息获取用户;
	 * @param idCard 身份证号
	 * @return 根据用户身份证查询出来的对象
	 */
	public TBDicUser findUserByUserIDCard(String idCard);
	/**
	 * 查询指定创建者创建的用户
	 * @param cruser 创建者
	 * @param firstRowNum 开始行数
	 * @param perPageRows 每页行数
	 * @return 用户信息的List
	 */
	public List<TBDicUser> findUsersByCrUser(TBDicUser cruser,int firstRowNum,int perPageRows);


	public int findRowsNo(TBDicUser cruser);
	/**
	 * 根据创建者的信息,查询子节点的数量
	 * @param cruser 父节点
	 * @return 子节点的数量
	 */
	public int findRowsNoOnCruser(TBDicUser cruser);
}
