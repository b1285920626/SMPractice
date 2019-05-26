package com.pang.SMPractice.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//核心控制器
public class DispatcherServlet extends GenericServlet {

    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /*
         * url示例： /staff/add.do            /login.do
         */
//        获取url
        String path = request.getServletPath().substring(1);
        String beanName;
        String methodName;

//        找到beanName和methodName
        int index = path.indexOf('/');
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            methodName = path.substring(index + 1, path.indexOf(".do"));
        } else {
            beanName = "selfController";
            methodName = path.substring(0, path.indexOf(".do"));
        }

//        根据beanName和methodName从IOC容器里取出方法和类执行
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");//放在初始化里
        Object object = applicationContext.getBean(beanName);
        try {
            Method method = object.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(object, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
