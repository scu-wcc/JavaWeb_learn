package org.example.filter;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.JwtUtils;
import org.example.pojo.Result;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(value = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        //1.获取请求url
        String url = req.getRequestURI();
        log.info("请求路径：{}",url);

        if(url.contains("login")){
            //放行
            log.info("登录操作，放行......");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String jwt =  req.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            //令牌不存在
            log.info("令牌不存在");
            Result error = Result.error("NOT_LOGIN");
            //将error转成JSON格式
            String notLogin = JSONObject.toJSONString(error);
            //将JSON化的对象写入响应数据中
            res.getWriter().write(notLogin);
            return;
        }

        //检验令牌是否有效
        try{
            JwtUtils.parseJWT(jwt);

        }catch (Exception e){
            log.info("当前令牌不合法");
            Result error = Result.error("NOT_LOGIN");
            //将error转成JSON格式
            String notLogin = JSONObject.toJSONString(error);
            //将JSON化的对象写入响应数据中
            res.getWriter().write(notLogin);
            return;
        }

        log.info("令牌校验通过，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
