package com.cc.dao;

import java.util.List;

import com.cc.model.Customerplan;

/**
 * 客户发展计划DAO层
 * @author 黄恒愉
 *
 */
public interface CustomerPlanDao {
	List<Customerplan> search(String username,Integer offset, Integer displyCount);
	 int getCount(String username,Integer offset,Integer displyCount);
	 int addPlan(String id, String planNum, String planTime);
	 int deletePlanCustomer(String[] custIDs);
}
