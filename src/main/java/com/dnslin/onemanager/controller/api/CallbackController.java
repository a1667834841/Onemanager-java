package com.dnslin.onemanager.controller.api;

import cn.hutool.core.lang.Console;
import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.result.ResponseEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CallbackController extends HttpServlet {
    /**
    *
     * @Description: 
     * @param: request 
     * @return void
     * @author DnsLin
     * @date 2021/10/27 15:35
    */
    @GetMapping("/auth")
    public void authCallback(HttpServletRequest request){
        if (request==null){
            Console.log("request为空！！！");
            throw new AppException(ResponseEnum.THE_CALLBACK_FAILED);
        }
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        ServletContext servletContext = this.getServletConfig().getServletContext();
        servletContext.setAttribute("code",code);
        servletContext.setAttribute("state",state);
    }
}
