/*package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("第二个init 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc 拦截到了请求");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Abc 处理完了请求");

    }

    @Override
    public void destroy() {

        System.out.println("第二个destroy 销毁方法执行了");
    }
}*/
