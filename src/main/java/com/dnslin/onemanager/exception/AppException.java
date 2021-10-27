package com.dnslin.onemanager.exception;



import com.dnslin.onemanager.result.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  业务异常类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppException extends RuntimeException{

    private String code;
    private String message;

    public AppException(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
}
