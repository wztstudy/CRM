package com.cc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.CustomerCareDao;
import com.cc.dao.impl.CustomerCareDaoImpl;
import com.cc.model.CustomerCarere;
import com.cc.service.CustomerCareService;

public class CustomerCareServiceImpl implements CustomerCareService {

	@Override
	public Map<String, Object> getCustomerCare(String cname, int offset, int displyCount) {
		CustomerCareDao  ccd = new CustomerCareDaoImpl();
		Map<String, Object> data = new HashMap<>();
		List<Map> result = ccd.getCustomerCare(cname, offset, displyCount);
		List<CustomerCarere>  cares = new ArrayList<>();
		for(Map m : result) {
			CustomerCarere care = new CustomerCarere();
			care.setUname((String) m.get(1));
			care.setCname((String) m.get(2));
			care.setTitle((String) m.get(3));
			care.setContent((String) m.get(4));
			care.setRemindTime((Date) m.get(5));
			care.setCordTime((Date) m.get(6));
			cares.add(care);
		  }
		 int count = ccd.getCount(cname);
		 int total = count % displyCount == 0 ?  count / displyCount : count / displyCount +1;
		data.put("cares", cares);
		data.put("total", total);
		data.put("count", count);
		return data;
	}



}
