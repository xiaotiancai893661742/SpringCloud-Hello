package com.lyc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFileter  extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(MyFileter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String header = request.getHeader("1");
        if("1".equals(header)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("no no no  you have not userToken");
            ctx.setResponseStatusCode(401);
        }
        return null;
    }
}
