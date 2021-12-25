package com.zhu.onemanager.controller.api;

import cn.hutool.core.lang.Console;
import com.zhu.onemanager.exception.AppException;
import com.zhu.onemanager.logic.AuthToken;
import com.zhu.onemanager.logic.AuthUrl;
import com.zhu.onemanager.logic.BaseMicrosoftService;
import com.zhu.onemanager.pojo.OnedriveConfig;
import com.zhu.onemanager.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class CallbackController {

    @Autowired
    private ServletContext context;
    @Autowired
    private BaseMicrosoftService baseMicrosoftService;
    @Autowired
    private AuthUrl authUrl;
    @Autowired
    private AuthToken authToken;
    @Autowired
    private OnedriveConfig onedriveConfig;

    @Value("${onedrive.scope}")
    private String scope;
    @Value("${onedrive.redirectUri}")
    private String redirectUri;
    @Value("${onedrive.clientId}")
    private String clientId;

    @Value("${onedrive.file.scope}")
    private String fileScope;
    @Value("${onedrive.file.redirectUri}")
    private String fileRedirectUri;
    @Value("${onedrive.file.clientId}")
    private String fileClientId;


    /**
    *
     * @Description: 
     * @param: request 
     * @return void
     * @author DnsLin
     * @date 2021/10/27 15:35
    */
    @GetMapping("/file/auth")
    public void authCallback(HttpServletRequest request, HttpServletResponse response,String code) throws IOException {
        if (request==null){
            Console.log("request为空！！！");
            throw new AppException(ResponseEnum.THE_CALLBACK_FAILED);
        }
//        String code = request.getParameter("code");
        String state = request.getParameter("state");
        ServletContext servletContext = context;
        servletContext.setAttribute("code",code);
        servletContext.setAttribute("state",state);

        authToken.getAccessToken(onedriveConfig);

        response.setContentType("text/html;charset=utf-8;");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>access_token</h2>"+
                "<textarea rows=\"1\" cols=\"1000\" disabled >"+
                onedriveConfig.getAccessToken() +
                "</textarea>"
        );
        writer.println("<h2>refresh_token</h2>"+
                "<textarea rows=\"1\" cols=\"1000\" disabled >"+
                onedriveConfig.getRefreshToken() +
                "</textarea>"
        );


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

        OnedriveConfig token = baseMicrosoftService.getOutlookToken(code);

        ServletContext servletContext = context;
        servletContext.setAttribute("code",code);
        servletContext.setAttribute("state",state);
        servletContext.setAttribute("accessToken",token.getAccessToken());
        servletContext.setAttribute("refreshToken",token.getRefreshToken());

        String directUrl = "redirect:https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=" + clientId +
                "&response_type=code&redirect_uri=" + redirectUri +
                "&scope=" + scope;
        ModelAndView  model = new ModelAndView(directUrl);
        return "";

    }
}
