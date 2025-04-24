package org.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.JwtUtils;
import org.example.pojo.Result;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {


        String jwt =  req.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            //令牌不存在
            log.info("令牌不存在");
            Result error = Result.error("NOT_LOGIN");
            //将error转成JSON格式
            String notLogin = JSONObject.toJSONString(error);
            //将JSON化的对象写入响应数据中
            res.getWriter().write(notLogin);

            return false;
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
            return false;
        }

        log.info("令牌校验通过，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 执行了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 执行了");

    }
}
