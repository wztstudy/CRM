package com.cc.dao;

import java.util.List;

import com.cc.model.CustValueDataModel;

public interface CustomerValueDao {
	List<CustValueDataModel> getCustValue(String custName, Integer offset, Integer displyCount);
}
