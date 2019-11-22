package common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    INVALID_USERNAME_PASSWORD(211,"用户名或密码错误"),
    INVALID_VERFIY_CODE(100,"验证码错误"),
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORE_NOT_FOUND(404,"商品不存在"),
    NOT_IS_FOUND(50000,"没有发现"),
    ERROR(2000,"失败");

    private int code;
    private String msg;
}