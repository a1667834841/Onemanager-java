package com.dnslin.onemanager.exception;




import com.dnslin.onemanager.result.R;
import com.dnslin.onemanager.result.ResponseEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
*
 * @Description: controller 的增强类 专门在controller 抛出异常的时候增强
 * @param: null
 * @return * @return null
 * @author DnsLin
 * @date 2021/10/27 20:23
*/
@ControllerAdvice
public class ControllerExceptionAdvice {


    /**
    *
     * @Description: 如果抛出的是 AppException 的增强
     * @param: AppException controller抛出的异常
     * @param: request 
     * @return R
     * @author DnsLin
     * @date 2021/10/27 20:24
    */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public R appExceptionHandler(AppException ex, HttpServletRequest request){

       return new R(ex.getCode(),ex.getMessage(),null);
    }

    /**
     *  如果抛出的是Exception 的增强
     */
    /**
    *
     * @Description:
     * @param: Exception
     * @param: request
     * @return R
     * @author DnsLin
     * @date 2021/10/27 20:25
    */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exceptionHandler(Exception ex, HttpServletRequest request){

        ex.printStackTrace();
        return new R(ResponseEnum.SYSTEM_ERROR,null);
    }

}
