package com.cc.dao;

import java.util.List;
import java.util.Map;

import com.cc.model.CustomerCarere;

public interface CustomerCareDao {
      List<Map>  getCustomerCare(String cname,int offset,int displayCount);
      int getCount(String cname);
}
