package com.cc.Fiter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.model.Menu;
import com.cc.model.User;
import com.cc.service.MenuService;
import com.cc.service.impl.MenuServiceImpl;

public class LoginFilter implements Filter{

	String[] excludedPages;
	
	MenuService ms = new MenuServiceImpl();
	
	
	@Override
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		boolean isExcludedPage = false;
//		for (String page : excludedPages) {//判断是否在过滤url之外     
//			System.out.println(req.getRequestURI());
//			System.out.println(req.getContextPath()+page);
//			   
//		}     
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String path = req.getServletPath();
		System.out.println(req.getServletPath());
		if(path.equals("/login.html")) {
			chain.doFilter(request, response);
			return;
		}
		if (session == null || session.getAttribute("user") == null) { 
			((HttpServletResponse) response).setStatus(600);
			chain.doFilter(request, response);
		} else {
			String url = path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("."));
			System.out.println(url);
			if("main".equals(url)) {
				chain.doFilter(request, response);
			}
			User user = (User) session.getAttribute("user");
			Map<String, Object> map = ms.getMenu(user.getId());
			List<Menu> menus = (List<Menu>) map.get("menus");
			for(Menu ms : menus) {
				for(Menu m : ms.getChildMenu()) {
					String routeUrl = m.getUrl();
					String databaseUrl = routeUrl.replace("main.", "");
					System.out.println(routeUrl+"---"+databaseUrl);
					if(databaseUrl.equalsIgnoreCase(url)) {
						chain.doFilter(request, response);
					}
				}
			}
			((HttpServletResponse) response).setStatus(601);
			chain.doFilter(request, response);
		}   
		
//		String loginUrl = req.getContextPath() + "/login";
//		String initUrl = req.getContextPath() + "/";
//		System.out.println(path);
//		System.out.println(loginUrl);
//		System.out.println(initUrl);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
