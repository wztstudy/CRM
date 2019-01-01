package com.cc.service.impl;

import java.util.List;

import com.cc.dao.CustomerValueDao;
import com.cc.dao.impl.CustomerValueDaoImpl;
import com.cc.model.CustValueDataModel;
import com.cc.service.CustomerValueService;

public class CustomerValueServiceImpl implements CustomerValueService {

	@Override
	public List<CustValueDataModel> getCustValue(String custName, Integer offset, Integer displyCount) {
		CustomerValueDao   cvd = new CustomerValueDaoImpl();
		List<CustValueDataModel>  result = cvd.getCustValue(custName, offset, displyCount);
		for(CustValueDataModel c : result) {
			c.setValue();
		}
		return result;
	}

}
