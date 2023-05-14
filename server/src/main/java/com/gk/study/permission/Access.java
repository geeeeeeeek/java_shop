package com.gk.study.permission;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented     // 在生成javac时显示该注解的信息
@Inherited
public @interface Access {
    AccessLevel level() default AccessLevel.LOGIN; //默认为ALL
}
