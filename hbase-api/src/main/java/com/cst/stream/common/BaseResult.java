package com.cst.stream.common;

import lombok.*;

/**
 * @author Johnney.chiu
 * create on 2017/12/12 15:15
 * @Description 结果数据
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResult<T> {

    private boolean success=false;

    private int code;

    private String description;

    private T data;


    public  static <T> BaseResult success(T data){
        return new BaseResult(true,CodeStatus.SUCCESS_CODE,"success", data);
    }
    public  static <T> BaseResult success(){
        return new BaseResult(true,CodeStatus.SUCCESS_CODE,"success", null);
    }
    public  static  BaseResult fail(int code,String description){
        return new BaseResult(false, code,description, null);
    }

}
