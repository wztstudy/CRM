package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.CustomerPlanDao;
import com.cc.dao.impl.CustomerPlanDaoImpl;
import com.cc.model.Customerplan;
import com.cc.service.CustomerPlanService;

/**
 * 客户发展计划
 * @author 黄恒愉
 *
 */
public class CustomerPlanServiceImpl implements CustomerPlanService {
  private	CustomerPlanDao  cpd = new CustomerPlanDaoImpl();
	@Override
	public Map<String, Object> search(String username, Integer offset, Integer displyCount) {
		Map<String, Object> result = new HashMap<>();
		List<Customerplan> plans = cpd.search(username, offset, displyCount);
		int count = cpd.getCount(username, offset, displyCount);
		int total = count % displyCount == 0 ?  count / displyCount : count / displyCount +1;
		System.out.println("这是服务层"+count);
		result.put("plans", plans);
		result.put("count", count);
		result.put("total", total);
		return result;
	}
	@Override
	public boolean addPlan(String id, String planNum, String planTime) {
		return cpd.addPlan(id, planNum, planTime) > 0;
	}
	@Override
	public int deletePlanCustomer(String[] planIDs) {
		return cpd.deletePlanCustomer(planIDs) ;
	}

}
