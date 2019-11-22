package com.hyzg.common.pojo;


import com.hyzg.common.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult  {
    private int status;
    private String msg;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums){
        this.status=exceptionEnums.getCode();
        this.msg=exceptionEnums.getMsg();
        this.timestamp=System.currentTimeMillis();
    }
}
