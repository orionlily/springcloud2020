package com.orion.cloud.order.feign.fee;

/**
 * @author Administrator
 * @date 2020/9/29
 */
public enum AppStatus implements BaseStatus{
    FIRST_APP(1),

    SECOND_APP(2);

    AppStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    private Integer code;
}
