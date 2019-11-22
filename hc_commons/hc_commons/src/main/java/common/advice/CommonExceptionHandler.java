package common.advice;


import common.enums.ExceptionEnums;
import common.exception.HcException;
import common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(HcException.class)
    public ResponseEntity<ExceptionResult> handlerException(HcException e){
        ExceptionEnums exceptionEnums = e.getExceptionEnums();
        ExceptionResult exceptionResult = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(exceptionResult.getStatus()).body(exceptionResult);
    }
}
