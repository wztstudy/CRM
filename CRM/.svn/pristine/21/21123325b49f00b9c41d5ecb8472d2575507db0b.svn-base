package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.FaqDao;
import com.cc.dao.impl.FaqDaoImpl;
import com.cc.model.Faq;
import com.cc.service.FaqService;

public class FaqServiceImpl implements FaqService{

	FaqDao fd = new FaqDaoImpl();
	
	@Override
	public Map<String, Object> getFaqInfo(String title, int offset, int showCount) {
		List<Faq> list = fd.getFaqInfo(title, offset, showCount);
		Map<String, Object> map = new HashMap<>();
		int totalCount = fd.getTotal(title);
		int totalPage = totalCount%showCount==0 ? totalCount/showCount : totalCount/showCount + 1;
		map.put("totalPage", totalPage);
		map.put("faqInfo", list);
		return map;
	}

	@Override
	public String addFaq(Faq faq) {
		int row = fd.addFaq(faq);
		String tips = "";
		if(row == 1) {
			tips = "添加问题成功";
		}else {
			tips = "添加问题失败";
		}
		return tips;
	}

	@Override
	public String modifyFaq(String title, String content,int id) {
		int row = fd.modify(title, content, id);
		String tips = "";
		if(row == 1) {
			tips = "修改问题成功";
		}else {
			tips = "修改问题失败";
		}
		return tips;
	}

	@Override
	public String deleteFaq(int[] ids) {
		int row = fd.delete(ids);
		String tips = "";
		if(row >= 1) {
			tips = "删除问题成功";
		}else {
			tips = "删除问题失败";
		}
		return tips;
	}

	
}
