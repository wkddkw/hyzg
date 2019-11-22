package com.hyzg.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    // 1XXX 车源问题
    // 2XXX 货源问题
    // 3XXX 用户问题

    CAR_RESOURCE_SEND_ERROR(1000,"车源发布失败"),
    CAR_TYPE_IS_EMPTY(1001,"车辆类型为空"),
    CAR_RESOURCE_IS_EMPTY(1002,"车源信息为空"),
    CAR_RESOURCE_UPDATE_ERROR(1003,"车源信息更新失败"),
    CAR_RESOURCE_DELETE_ERROR(1004,"车源信息删除失败"),

    PRO_RESOURCE_SEND_ERROR(2000,"货源发布失败"),
    PRO_TYPE_IS_EMPTY(2001,"货物类型为空"),
    PRO_DETAIL_TYPE_IS_EMPTY(2002,"货物详情类为空"),
    PRO_RESOURCE_UPDATE_ERROR(2003,"货源信息更新失败"),
    PRO_RESOURCE_DELETE_ERROR(2004,"货源信息删除失败"),
    PRO_RESOURCE_IS_EMPTY(2005,"车源信息为空"),

    TRANS_TYPE_IS_EMPTY(4001,"线路类型为空"),
    UNIT_IS_EMPTY(4002,"单位为空"),
    PRICE_UNIT_IS_EMPTY(4003,"价格单位为空");


    private int code;
    private String msg;
}
