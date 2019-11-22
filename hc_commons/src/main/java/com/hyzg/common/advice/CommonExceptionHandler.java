package com.hyzg.common.advice;


import com.hyzg.common.enums.ExceptionEnums;
import com.hyzg.common.exception.HyzgException;
import com.hyzg.common.pojo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(HyzgException.class)
    public ResponseEntity<ExceptionResult> handleException(HyzgException e){
        ExceptionEnums exceptionEnums = e.getExceptionEnums();
        ExceptionResult result = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
