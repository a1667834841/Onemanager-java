package com.zhu.onemanager.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 创建统一的返回格式
public class R {

    private String code;
    private String message;
    private Object data;

    public R(ResponseEnum responseEnum, Object data) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    public static R ok(Object data) {

        return new R(ResponseEnum.SUCCESS,data);
    }
}
