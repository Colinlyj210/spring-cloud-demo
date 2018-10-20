package com.darcy.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的优先级
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.error(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String password = request.getParameter("password");
        if(password == null) {
            log.error("password is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("password is empty");
            }catch (Exception e){

            }
        }else{
            if(!password.equals("abc")){
                ctx.setSendZuulResponse(false);
                ctx.setResponseBody("error");
            }else{
                log.info("ok");
            }
        }
        return null;
    }
}
