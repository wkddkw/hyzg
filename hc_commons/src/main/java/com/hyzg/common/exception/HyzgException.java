package com.hyzg.common.exception;

import com.hyzg.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HyzgException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
