package com.wondersgroup.auth.service;

import com.wondersgroup.auth.model.TBDicUser;
import com.wondersgroup.common.util.PageBean;

public interface UserService {
	/**
	 * 根据传入的用户信息,先判断是属于何种类型的用户信息,然后调用DAO查询用户
	 * 这里可能传入的信息只有:用户身份证或用户ID两种;鉴于数据库中int不能存储15、18位数字,这里根据数字长度判断类型
	 * 用于登陆系统时,根据用户的输入信息获取数据库中的用户信息
	 * @param userMsg
	 * @return
	 */
	public TBDicUser findUserByUserMsg(String userMsg);

	/**
	 * 根据当前登陆用户信息,查找其创建的用户及其子用户
	 *
	 * @param user 当前登陆用户
	 * @param page 分页对象
	 * @return 分页对象封装过的对象集合
	 */
	public PageBean<TBDicUser> pagingQueryOnCruser(TBDicUser user,PageBean page);

	/**
	 * 返回当前对象的子节点的个数
	 * @param user 父节点对象
	 * @return 子节点个数
	 */
	public int countRowsOnCruser(TBDicUser user);

	/**
	 * 根据参数中属性值,判断筛选的条件,返回数据库中满足相应条件的记录数
	 * 1.user.ID>0 返回对应ID的记录数
	 * 2.user.UserName非空 返回对应用户名的记录数
	 * 3.user.idcard非空 返回对应身份证号码的记录数
	 * 4.user.isEffective非空 返回对应属性的有效标志位的记录数
	 * @param user
	 * @return 满足条件的记录数量
	 */
	public int countRows(TBDicUser user);
}
