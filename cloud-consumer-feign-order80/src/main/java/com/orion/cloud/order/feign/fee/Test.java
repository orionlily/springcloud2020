package com.orion.cloud.order.feign.fee;

import java.util.Set;

/**
 * @author Administrator
 * @date 2020/9/29
 */
public class Test{


    public static void main(String[] args) {
        String packageName = Test.class.getPackage().getName();

        Class clazz = BaseStatus.class;

        Set<Class<?>> classSet = ScanSupport.doScan(packageName);

        for (Class<?> cls : classSet) {
            boolean isEnum = cls.isEnum();
            boolean isAnImplOfBaseInterface = ClassUtil.isAnImplOfBaseInterface(cls, BASE_INTERFACE);

            if (isEnum && isAnImplOfBaseInterface) {

                Object[] enumConstants = cls.getEnumConstants();
                for (Object enumConstant : enumConstants) {
                    BaseResult status = (BaseResult) enumConstant;
                    CODE_TO_STATUS.put(status.getCode(), status);
                }
            }
        }

        log.info("状态码收集完成: [{}]", CODE_TO_STATUS);

    }

}
