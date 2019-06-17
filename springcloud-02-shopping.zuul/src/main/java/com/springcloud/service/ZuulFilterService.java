package com.springcloud.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 实现路由的权限过滤控制 项目名称：springcloud-02-shopping.zuul 类名称：ZuulFilterService 类描述：
 * 创建人：admin 创建时间：2019年6月9日 上午11:48:28
 * 
 * @version
 *
 */
@Component
public class ZuulFilterService extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ZuulFilterService.class);

	@Override
	public String filterType() {
		// 前置路由，路由之前
		return "pre";
	}

	@Override
	public boolean shouldFilter() {
		// 判断是否要执行这个过滤器
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// 获取请求的路径
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// 如果请求是登录就放行
		if (servletPath.equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		// 获得请求得到accessToken
		String accessToken = request.getParameter("accessToken");
		// 当请求不成功
		if (accessToken == null) {
			// 设置服务不向下执行
			currentContext.setSendZuulResponse(false);
			// 设置权限不通过的返回码
			currentContext.setResponseStatusCode(401);
			// 设置客户端提示
			currentContext.setResponseBody("{\"result\":\"accessToken is empty\"}");
		}
		log.info("请求的路径" + request.getContextPath());
		log.info("请求的路径1" + request.getRequestURL());
		log.info("请求的参数" + request.getQueryString());
		log.info("ip" + request.getRemoteAddr() + "---" + request.getRemoteHost());
		return null;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		// 运行的优先级，数值越大，优先级越小
		return 0;
	}

}
