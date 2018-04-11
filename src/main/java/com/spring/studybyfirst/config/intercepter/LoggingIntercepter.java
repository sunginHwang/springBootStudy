package com.spring.studybyfirst.config.intercepter;

        import lombok.extern.log4j.Log4j2;
        import org.springframework.stereotype.Component;
        import org.springframework.web.servlet.HandlerInterceptor;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

@Log4j2
public class LoggingIntercepter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("intercepter preHandler access");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("intercepter postHandler access");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("intercepter afterCompletion access");
    }
}
