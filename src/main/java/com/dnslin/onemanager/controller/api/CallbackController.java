package com.dnslin.onemanager.controller.api;

import cn.hutool.core.lang.Console;
import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.logic.BaseMicrosoftService;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CallbackController {

    @Autowired
    private ServletContext context;
    @Autowired
    private BaseMicrosoftService baseMicrosoftService;

    @Value("${onedrive.scope}")
    private String scope;
    @Value("${onedrive.redirectUri}")
    private String redirectUri;
    @Value("${onedrive.clientId}")
    private String clientId;


    /**
    *
     * @Description: 
     * @param: request 
     * @return void
     * @author DnsLin
     * @date 2021/10/27 15:35
    */
    @GetMapping("/auth")
    public void authCallback(HttpServletRequest request, HttpServletResponse response,String code){
        if (request==null){
            Console.log("request为空！！！");
            throw new AppException(ResponseEnum.THE_CALLBACK_FAILED);
        }
//        String code = request.getParameter("code");
        String state = request.getParameter("state");
        ServletContext servletContext = context;
        servletContext.setAttribute("code",code);
        servletContext.setAttribute("state",state);
    }


    /**
     *
     * @Description: 续订e5
     * @param: request
     * @return void
     * @author DnsLin
     * @date 2021/10/27 15:35
     */
    @GetMapping("/outlook")
    public String outlookCallback(HttpServletRequest request, HttpServletResponse response, String code){
        if (request==null){
            Console.log("request为空！！！");
            throw new AppException(ResponseEnum.THE_CALLBACK_FAILED);
        }
//        String code = request.getParameter("code");
        String state = request.getParameter("state");

        Onedriveconfig token = baseMicrosoftService.getToken(code);

        ServletContext servletContext = context;
        servletContext.setAttribute("code",code);
        servletContext.setAttribute("state",state);
        servletContext.setAttribute("accessToken",token.getAccesstoken());
        servletContext.setAttribute("refreshToken",token.getRefreshtoken());

        String directUrl = "redirect:https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=" + clientId +
                "&response_type=code&redirect_uri=" + redirectUri +
                "&scope=" + scope;
        ModelAndView  model = new ModelAndView(directUrl);
        return "";

    }
}
