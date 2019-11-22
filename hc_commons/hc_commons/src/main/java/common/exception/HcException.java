package common.exception;


import common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HcException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
