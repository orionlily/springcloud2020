package com.orion.cloud.order.feign.fee;

/**
 * @author Administrator
 * @date 2020/9/29
 */
public enum CommonStatus implements BaseStatus{

    FIRST_CM(1),

    SECOND_CM(2);

    CommonStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    private Integer code;
}
