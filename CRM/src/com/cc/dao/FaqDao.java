package com.cc.dao;

import java.util.List;
import com.cc.model.Faq;

public interface FaqDao {

	List<Faq> getFaqInfo(String title,int offset,int showCount);
	
	int getTotal(String title);
	
	int addFaq(Faq faq);
	
	int modify(String title,String content,int id);
	
	int delete(int[] ids);
}
